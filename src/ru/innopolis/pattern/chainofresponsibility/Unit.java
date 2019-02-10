package ru.innopolis.pattern.chainofresponsibility;

public class Unit {

    int power;
    int attackDistance;
    private DefaultBehavior behavior;

    public Unit(int power, int attackDistance) {
        this.power = power;
        this.attackDistance = attackDistance;
    }
    public DefaultBehavior getBehavior() {
        return behavior;
    }

    public void setBehavior(DefaultBehavior behavior) {
        this.behavior = behavior;
    }

    public int getPower() {
        return power;
    }

    public int getAttackDistance() {
        return attackDistance;
    }
    public int processSituation(int distance, int power) {
        return behavior.handle(distance, power);
    }
}