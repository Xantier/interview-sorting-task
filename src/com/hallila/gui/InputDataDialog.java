package com.hallila.gui;

import com.hallila.middleware.SorterDispatcher;
import com.hallila.pojo.Student;
import com.hallila.sorter.SorterEnum;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class InputDataDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonChooseFile;
    private JButton buttonCancel;
    private JRadioButton mergeRadio;
    private JRadioButton bubbleRadio;
    private JRadioButton heapRadio;
    private JLabel indicatorLabel;
    private JTable dataTable;
    private JLabel timeLabel;

    public InputDataDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonChooseFile);

        buttonChooseFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onFileChooseAction();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onFileChooseAction() {
        JFileChooser chooser = new JFileChooser();
        int val = chooser.showOpenDialog(contentPane);
        if (val == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            SorterDispatcher dispatcher = null;
            if(mergeRadio.isSelected()){
                dispatcher = new SorterDispatcher(file, SorterEnum.MERGE);
            }else if(bubbleRadio.isSelected()){
                dispatcher = new SorterDispatcher(file, SorterEnum.BUBBLE);
            }else if(heapRadio.isSelected()){
                dispatcher = new SorterDispatcher(file, SorterEnum.HEAP);
            }
            if(dispatcher!= null){
                try {
                    dispatcher.setGui(this);
                    dispatcher.execute();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            indicatorLabel.setText("Doing stuff");
        }
    }

    private void onCancel() {
        dispose();
        System.exit(0);
    }

    public void showData(Map<String, Object> results){
        indicatorLabel.setText("Rows parsed: " + results.get("size"));
        timeLabel.setText("Duration: " + results.get("duration") + " nanoseconds");
        List<Student> students = (List<Student>) results.get("data");
        DefaultTableModel tableModel = createTableModel(students);
        dataTable.setModel(tableModel);
    }

    private DefaultTableModel createTableModel(List<Student> students) {
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Student");
        columnNames.add("Grade");
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        for (Student student : students) {
            Vector<Object> vector = new Vector<Object>();
            vector.add(student.getName());
            vector.add(student.getGrade());
            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames);
    }


    public static void main(String[] args) {
        InputDataDialog dialog = new InputDataDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
