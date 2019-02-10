package ru.innopolis.pattern.abstractfactory;

public abstract class SquadromFactory {
    public abstract Mage createMage();
    public abstract Archer createArcher();
    public abstract Warrior createWarrior();
}
