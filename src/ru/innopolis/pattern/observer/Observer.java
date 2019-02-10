package ru.innopolis.pattern.observer;

public interface Observer {
    void objectCreated(Object obj);
    void objectModified(Object obj);
}