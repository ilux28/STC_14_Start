package ru.innopolis.lection06.homework;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Serialization implements SerializeObject {
    @Override
    public void serialize(Object obj) throws IllegalAccessException {
        String objHeader = "<class name=\"" + obj.getClass().getName() + "\">";
        String objClose = "</class>";
        StringBuilder str;
        try (FileWriter writer = new FileWriter(obj.getClass().getName() + ".xml", false)) {
            writer.write(objHeader);
            writer.append('\n');
            for (Field field : obj.getClass().getDeclaredFields()) {
                String name = field.getName();
                field.setAccessible(true);
                String value = String.valueOf(field.get(obj));
                writer.append("<" + name + ">");
                writer.append(value);
                writer.append("</" + name + ">");
                writer.append('\n');
            }
            writer.append(objClose);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object deSerialize(String file) throws IOException {
        Object obj = new Object();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String str;
            int i = 0;
            Field[] fields = new Field[0];
            Pattern pattern = Pattern.compile("[<>]");
            String className = br.readLine().split("\"")[1];
            Class<?> clazz = Class.forName(className);
            obj = clazz.newInstance();
            fields = obj.getClass().getDeclaredFields();
            while ((str = br.readLine()) != null && fields.length != i) {
                String[] strMass = pattern.split(str);
                String name = fields[i].getName();
                fields[i].setAccessible(true);
                String value = strMass[2];
                System.out.println("value: " + value);
                String type = fields[i].getType().toString();
                if (type.equals("int")) {
                    fields[i].set(obj, Integer.valueOf(value));
                } else if (type.equals("boolean")) {
                    fields[i].set(obj, Boolean.valueOf(value));
                } else if (type.equals("double")) {
                    fields[i].set(obj, Double.valueOf(value));
                } else if (type.equals("float")) {
                    fields[i].set(obj, Float.valueOf(value));
                } else if (type.equals("class java.lang.String")) {
                    fields[i].set(obj, value);
                } else if (type.equals("long")) {
                    fields[i].set(obj, Long.valueOf(value));
                } else if (type.equals("short")) {
                    fields[i].set(obj, Short.valueOf(value));
                }
                i++;
            }
        } catch (IOException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }
}