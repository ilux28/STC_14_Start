package ru.innopolis.sorted;

/**
 * This class with method by sorted booble
 * @author Ilya Pribytkov
 * @version 1.0
 */
public class SortBooble implements Sort{
    public Integer[] sort(Integer [] mass) {
        boolean isSorted = false;
        Integer buff;
        while(!isSorted) {
            for (int i = 0; i < mass.length - 1; i++) {
                if(mass[i] > mass[i + 1]) {
                    isSorted = false;
                    buff = mass[i];
                    mass[i] = mass[i + 1];
                    mass[i + 1] = buff;
                }
            }
        }
        return mass;
    }
}
