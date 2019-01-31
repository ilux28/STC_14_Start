package ru.innopolis.lec09.lambda;

import java.util.function.BiFunction;
import java.util.function.Consumer;


public class LambdaCalc {

    public void multiple(int start, int finish, int value,
                         BiFunction<Integer, Integer, Double> op,
                         Consumer<Double> media) {
        for (int index = start; index != finish; index++) {
            media.accept(op.apply(value, index));
        }
    }
    public static void main(String[] args) {
        LambdaCalc calc = new LambdaCalc();
        calc.multiple(
                0, 10, 2,
                MathUtil::div,
                /*
                (value, index) -> {
                    double result = value * index;
                    //System.out.println("Multiple %s * %s = %n", value, index, result);
                    return result;
                },
                */
                result -> System.out.println(result)
        );
    }
}