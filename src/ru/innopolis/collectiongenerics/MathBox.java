package ru.innopolis.collectiongenerics;

/**
 * Класс MathBox который на вход конструктора получает
 * массив Integer  и сортирует его в зависимости от sort *
 * @author Ilya Pribytkov
 * @version 1.0
 */
import java.util.*;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MathBox<T extends Number> extends ObjectBox {
    private SortedSet<T> setMass = new TreeSet<>();
    /**
     * Конструктор получает на вход массив чисел
     * @param mass - массив чисел
     */
    public MathBox(T [] mass) {
        this.hash = new Random().nextInt(1000) + Objects.hashCode(mass);
        for (T i : mass) {
            setMass.add(i);
        }
    }
    /**
     * Суммирует все элементы коллекции
     * @return sum - возвращает результат
     */
    public Double summator() {
        Double sum = 0d;
        for (T mass : setMass) {
            sum += mass.doubleValue();
        }
        return sum;
    }
    public SortedSet<Double> spliter(int num) {
        SortedSet<Double> splitSet = new TreeSet<>();
        Iterator<T> iter = setMass.iterator();
        while (iter.hasNext()) {
            splitSet.add(iter.next().doubleValue() / num);
        }
        return splitSet;
    }
    @Override
    public int hashCode() {
        return setMass.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MathBox mathBox = (MathBox) obj;
        if (setMass.equals(mathBox.setMass)) return true;
        if (setMass.size() != mathBox.setMass.size()) return false;

        Iterator iterFirst = setMass.iterator();
        Iterator iterSecond = mathBox.setMass.iterator();

        while (iterFirst.hasNext()) {
            if (iterFirst.next() != iterSecond.next()) return false;
        }
        return true;
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Object obj : setMass)
            str.append(obj).append(", ");
        return str.toString();
    }
    public SortedSet<T> delete(T num) {
        if (setMass.contains(num))
            setMass.remove(num);
        return setMass;
    }
}