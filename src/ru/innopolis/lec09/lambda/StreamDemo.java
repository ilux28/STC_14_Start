package ru.innopolis.lec09.lambda;

import java.util.Arrays;
import java.util.Collection;

public class StreamDemo {
    public static void main(String[] args) {
        Collection<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6);

        int sum = 0;
        for (Integer integer : ints) {
            if (integer % 2 == 1) {
                sum += integer;
            }

        }
        System.out.println("sum = " + sum);
        //stream api
        int sum2 = ints.stream()
                .filter(o -> o % 2 == 1)
                .reduce((o1, o2) -> o1 + 02)
                .orElse(0);
        System.out.println("sum = " + sum2);
    }
}
