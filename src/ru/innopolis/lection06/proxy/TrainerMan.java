package ru.innopolis.lection06.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TrainerMan implements InvocationHandler {
    private final Trainer trainer;

    public TrainerMan(Trainer trainer) {
        this.trainer = trainer;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Судовольствием ");
        if ("talk".equals(method.getName())) {
            System.out.println("кричу");
            return "Крик";
        }
        return null;
    }
}
