package ru.innopolis.pattern.chainofresponsibility;

public class TestApp {
    public static void main(String[] args) {
        Unit unit = new Unit(5, 10);
        unit.setBehavior(
                new CarefulBehavior(unit).addBehavior(
                        new AttackBehavior(unit).addBehavior(
                                new DefaultBehavior(unit)
                        )
                )
        );
        System.out.println(DefaultBehavior.getCode(unit.processSituation(1,1)));
        System.out.println(DefaultBehavior.getCode(unit.processSituation(5,10)));
        System.out.println(DefaultBehavior.getCode(unit.processSituation(20,5)));
        unit.setBehavior(
                new AnggryBehavior(unit).addBehavior(
                        new CarefulBehavior(unit).addBehavior(
                                new DefaultBehavior(unit)
                        )
                )
        );
        System.out.println(DefaultBehavior.getCode(unit.processSituation(1,1)));
        System.out.println(DefaultBehavior.getCode(unit.processSituation(7,10)));
        System.out.println(DefaultBehavior.getCode(unit.processSituation(20,5)));
    }
}