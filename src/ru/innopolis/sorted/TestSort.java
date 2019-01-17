package ru.innopolis.sorted;

/**
 *
 */
public class TestSort {
    public static void main(String[] args) {
        Integer [] arr = {45, 67, 89, 6, 56, 78, 9};
        SortBooble booble = new SortBooble();
        Integer [] arra = booble.sort(arr);
        for (Integer i : arra)
            System.out.println(i);
    }
}
