package ru.innopolis.pattern.observer;

public class Subject {
    Observers observers = new Observers();
    private Object filed;
    public void setFiled(Object o) {
        filed = o;
        observers.notifyObjectModified(this);
    }
}
