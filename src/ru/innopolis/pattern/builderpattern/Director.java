package ru.innopolis.pattern.builderpattern;

class Director {
    private ComputerBuilder computerBuilder;

    void setComputerBuilder(ComputerBuilder computerBuilder) {
        this.computerBuilder = computerBuilder;
    }

    Computer getComputer() {
        return computerBuilder.getComputer();
    }

    void constructComputer() {
        computerBuilder.createNewComputer();
        computerBuilder.buildSystemBlock();
        computerBuilder.buildDisplay();
        computerBuilder.buildManipulators();
    }
}