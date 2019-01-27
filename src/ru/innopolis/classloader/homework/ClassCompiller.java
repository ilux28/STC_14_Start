package ru.innopolis.classloader.homework;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 * @author Ilya Pribytkov
 * @version 1.0
 * This class compiled java class in byte-code
 */

public class ClassCompiller {
    /**
     * This method is compiled java class from file in byte-code
     * @param file - place at java-class
     * @return int = 0 if compile is a not error else when = 1
     */
    public int compiller(String file) {
        JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
        String javacOps = file;
        return javac.run(null,null, null, javacOps);
    }
}
