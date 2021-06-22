package ru.cetelem.com.patterns;

public class ChainOfResponsibilityFirst {


    public static void main(String[] args) {
        SimpleNotifier simpleNotifier = new SimpleNotifier(1);
        SmsNotifier smsNotifier = new SmsNotifier(2);
        UrgentNotifier urgentNotifier = new UrgentNotifier(3);

        simpleNotifier.setNotifier(smsNotifier);
        smsNotifier.setNotifier(urgentNotifier);

        simpleNotifier.notifyManager("it's disaster", 4);
    }


}

abstract class Notifier{

    private int priority;
    private Notifier notifier;

    public Notifier(int priority) {
        this.priority = priority;
    }

    public void setNotifier(Notifier notifier) {
        this.notifier = notifier;
    }

    public void notifyManager(String message, int level){
        if (level >= priority){
            System.out.println(message);
        }
        if (notifier != null){
            writeMessage(message);
            notifier.notifyManager(message, level);
        }
    }

    abstract void writeMessage(String message);
}

class SimpleNotifier extends Notifier{

    public SimpleNotifier(int priority) {
        super(priority);
    }

    @Override
    void writeMessage(String message) {
        System.out.println("Notifying using simple report: " + message);
    }
}

class SmsNotifier extends Notifier{

    public SmsNotifier(int priority) {
        super(priority);
    }

    @Override
    void writeMessage(String message) {
        System.out.println("Notifying using sms: " + message);
    }
}

class UrgentNotifier extends Notifier{

    public UrgentNotifier(int priority) {
        super(priority);
    }

    @Override
    void writeMessage(String message) {
        System.out.println("Notifying using call: " + message);
    }
}