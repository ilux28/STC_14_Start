package ru.innopolis.pattern.chainofresponsibility;

public class CarefulBehavior extends DefaultBehavior implements IBehavior {

    public CarefulBehavior(Unit unit) {
        super(unit);
    }

    public int handle(int distance, int power) {
        System.out.println("CarefulBehavior::handle()");
        if (power < unit.getPower()) {
            if (distance < unit.getAttackDistance()) {
                return DefaultBehavior.ATTACK;
            } else {
                return DefaultBehavior.WAIT;
            }
        } else if ((distance + 2 < unit.getAttackDistance()) & power > unit.getPower()) {
            return DefaultBehavior.RUN;
        }
        return super.handle(distance, power);
    }

}
