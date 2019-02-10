package ru.innopolis.pattern.builderpattern;

abstract class ComputerBuilder {
    protected Computer computer;

    public Computer getComputer() {
        return this.computer;
    }

    public void createNewComputer() {
        computer = new Computer();
    }

    public abstract void buildSystemBlock();

    public abstract void buildDisplay();

    public abstract void buildManipulators();
}
