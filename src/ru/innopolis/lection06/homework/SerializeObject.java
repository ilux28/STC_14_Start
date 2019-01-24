package ru.innopolis.lection06.homework;

import java.io.FileNotFoundException;

public interface SerializeObject {
    void serialize(Object obj) throws IllegalAccessException;
    Object deSerialize(String file) throws FileNotFoundException;

}
