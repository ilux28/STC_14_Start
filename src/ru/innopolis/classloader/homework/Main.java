package ru.innopolis.classloader.homework;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String classFile = "./src/ru/innopolis/classloader/homework/ClassLoaded";
        String loadFile = "ru.innopolis.classloader.homework.ClassLoaded";
        ClassCompiller compille = new ClassCompiller();
        int comp = compille.compiller(classFile + ".java");
        if (comp == 0) {
            ClassLoader c1 = new MyClassLoader();
            Class<?> kindClass = c1.loadClass(loadFile);
            ClassLoaded classLoaded = (ClassLoaded) kindClass.newInstance();
            classLoaded.writing();
        } else {
            System.out.println("Error about compile");
        }
        /*
        ClassWriter classWriter = new ClassWriter();
        classWriter.doWrite();
        */

    }
}
