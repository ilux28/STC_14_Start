package ru.innopolis.classloader;

public class MyClassLoader extends ClassLoader{
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //if ("ru.innopolis.classloader.")
        return null;
    }
}
