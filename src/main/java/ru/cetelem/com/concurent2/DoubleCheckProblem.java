package ru.cetelem.com.concurent2;

public class DoubleCheckProblem {

    private static volatile DoubleCheckProblem instance;
    public static DoubleCheckProblem getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckProblem.class) {
                if (instance == null) {
                    instance = new DoubleCheckProblem();
                }
            }
        }
        return instance;
    }


}
