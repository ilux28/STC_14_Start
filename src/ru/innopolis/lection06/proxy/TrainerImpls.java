package ru.innopolis.lection06.proxy;

public class TrainerImpls implements Trainer {
    @Override
    public int eat(String something) {
        System.out.println("ем " + something);
        return 2;
    }

    @Override
    public String talk() {
        System.out.println("говорю");
        return "говорю";
    }

    @Override
    public void teach() {
        System.out.println("учу");
    }
}
