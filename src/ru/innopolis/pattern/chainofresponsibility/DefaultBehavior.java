package ru.innopolis.pattern.chainofresponsibility;

public class DefaultBehavior implements IBehavior {
    static public int WAIT = 0;
    static public int ATTACK = 1;
    static public int RUN = 2;
    protected DefaultBehavior behavior;
    protected Unit unit;

    public DefaultBehavior(Unit unit) {
        this.unit = unit;
    }

    @Override
    public int handle(int distance, int power) {
        if (behavior != null) {
            return behavior.handle(distance, power);
        } else {
            System.out.println("DefaultBehavior::handle()");
            return DefaultBehavior.WAIT;
        }
    }
    public DefaultBehavior addBehavior(DefaultBehavior behavior) {
        this.behavior = behavior;
        return this;
    }
    static public String getCode(int option) {
        switch(option) {
            case 1:
                return "attack!!!";
            case 2:
                return "run!";
            default:
                return "waiting...";
        }
    }
}
