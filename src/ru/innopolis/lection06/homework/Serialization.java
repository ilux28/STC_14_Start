package ru.innopolis.lection06.homework;

import java.io.*;
import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class Serialization implements SerializeObject {
    @Override
    public void serialize(Object obj) throws IllegalAccessException {

        String typeObjHeader = "<cassName>" + obj.getClass().getCanonicalName() + "</className>";
        StringBuilder str;
        try (FileWriter writer = new FileWriter(obj.getClass().getName() + ".xml", false))
        {
            writer.write(typeObjHeader);
            writer.append('\n');

            for (Field declaredField : obj.getClass().getDeclaredFields()) {
                String name = declaredField.getName();
                declaredField.setAccessible(true);
                String value = declaredField.get(obj).toString();
                writer.append("<" + name + ">");
                writer.append(value);
                writer.append("</" + name + ">");
                writer.append('\n');
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Object deSerialize(String file) throws FileNotFoundException {
        Object obj = new Object();
        Pattern pattern = Pattern.compile("[<>]");
        try (BufferedReader br = new BufferedReader( new FileReader(file))) {
            String s;
            int i = 0;
            obj.getClass().getDeclaredFields();
            while((s = br.readLine()) != null) {
                String[] arrLine = pattern.split(s);
                if (i == 0) {
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
