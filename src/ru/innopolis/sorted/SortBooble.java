package ru.innopolis.sorted;

/**
 * This class with method by sorted booble
 * @author Ilya Pribytkov
 * @version 1.0
 */
public class SortBooble implements Sort{
    public Integer[] sort(Integer [] mass) {

        Integer buff;
        for (int j = mass.length - 1; j >= 1; j--) {
            for (int i = 0; i < mass.length - 1; i++) {
                if(mass[i] > mass[i + 1]) {
                    buff = mass[i];
                    mass[i] = mass[i + 1];
                    mass[i + 1] = buff;
                }
            }
        }
        return mass;
    }
}