package ru.innopolis.lection06.proxy;

import java.lang.reflect.Proxy;

public class ProxyDemo {
    public static void main(String[] args) {
        Trainer trainer = new TrainerImpls();
        trainer.eat("Курицу");
        trainer.talk();
        trainer.teach();

        System.out.println("Создание супер тренера:");
        TrainerMan handle = new TrainerMan(trainer);

        Trainer man = (Trainer) Proxy.newProxyInstance(
                ProxyDemo.class.getClassLoader(),
                new Class[] {Trainer.class},
                handle
        );
        System.out.println("ссъедено" + man.eat("грушу"));
        System.out.println("Сказано: " + man.talk());
        man.teach();
    }
}
