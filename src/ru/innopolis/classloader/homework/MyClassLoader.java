package ru.innopolis.classloader.homework;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader {

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if ("ru.innopolis.classloader.homework.ClassLoaded".equals(name)) {
            return findClass(name);
        }
        return super.loadClass(name);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("find class starts work: " + name);
        if ("ru.innopolis.classloader.homework.ClassLoaded".equals(name)) {
            try {
                byte[] bytes = Files.readAllBytes(Paths.get("ru.innopolis.classloader.homework.ClassLoaded.class"));
                return defineClass(name, bytes, 0, bytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return super.findClass(name);
    }
}
