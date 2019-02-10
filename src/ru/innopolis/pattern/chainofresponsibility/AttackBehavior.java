package ru.innopolis.pattern.chainofresponsibility;

public class AttackBehavior extends DefaultBehavior implements IBehavior {

    public AttackBehavior(Unit unit) {
        super(unit);
    }
    public int handle(int distance, int power) {
        System.out.println("CarefulBehavior::handle()");
        if (distance < unit.getAttackDistance() && (power <unit.getPower())) {
            return DefaultBehavior.ATTACK;
        }
        return super.handle(distance, power);
    }
}