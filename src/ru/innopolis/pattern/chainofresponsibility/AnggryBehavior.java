package ru.innopolis.pattern.chainofresponsibility;

public class AnggryBehavior extends DefaultBehavior implements IBehavior{

    public AnggryBehavior(Unit unit) {
        super(unit);
    }

    @Override
    public int handle(int distance, int power) {
        System.out.println("AngryBehavior::handle()");
        if ((distance / 2 < unit.getAttackDistance()) && (power / 5 < unit.getPower())) {
            return DefaultBehavior.ATTACK;
        }
        return super.handle(distance, power);
    }
}
