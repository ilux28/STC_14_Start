package ru.innopolis.pattern.observer;

import java.util.ArrayList;
import java.util.Iterator;

public class Observers<T extends Observer> extends ArrayList<T> {
    public void notyfyObjectCreated(Object obj) {
        for (Iterator<T> iter = (Iterator<T>) iterator(); iter.hasNext();)
            iter.next().objectCreated(obj);
    }
    public void notifyObjectModified(Object obj) {
        for (Iterator<T> iter = (Iterator<T>) iterator(); iter.hasNext();)
            iter.next().objectModified(obj);
    }
}
