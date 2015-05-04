package com.hallila.middleware;

import com.hallila.fileio.FileParser;
import com.hallila.gui.InputDataDialog;
import com.hallila.pojo.Student;
import com.hallila.sorter.Sorter;
import com.hallila.sorter.SorterCreator;
import com.hallila.sorter.SorterEnum;

import javax.swing.*;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Created by jussi on 08/05/14.
 */
public class SorterDispatcher extends SwingWorker {

    private File file;
    private SorterEnum enumerable;
    private SorterDispatcher worker;
    private InputDataDialog gui;

    public SorterDispatcher(File file, SorterEnum enumerable){
        this.file = file;
        this.enumerable = enumerable;
        worker = this;
    }

    /**
     *
     * @return ArrayList of Student objects as an object. Needs casting.
     * @throws Exception
     */
    @Override
    protected Map<String, Object> doInBackground() throws Exception {
        Map<String, Object> returnable = new HashMap<String, Object>();
        Sorter sorter = SorterCreator.newSorter(enumerable);
        FileParser parser = new FileParser(file);
        List<Student> studentList = parser.parseFile();
        long startTime = System.nanoTime();
        List<Student> students = sorter.sort(studentList);
        long duration = System.nanoTime() - startTime;
        returnable.put("data", students);
        returnable.put("duration", duration);
        returnable.put("size", studentList.size());
        return returnable;
    }

    @Override
    protected void done() {
        try {
            Map<String, Object> result = (Map<String, Object>) worker.get();
            gui.showData(result);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setGui(InputDataDialog gui) {
        this.gui = gui;
    }
}
