package ru.innopolis.collection;

/** Класс MathBox который на вход конструктора получает
 * массив Integer  и сортирует его в зависимости от sort *
 * @author Ilya Pribytkov
 * @version 1.0
 */

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MathBox {
    private SortedSet<Integer> setMass = new TreeSet<>();
    public MathBox(Integer [] mass) {
        for (Integer i : mass) {
            setMass.add(i);
        }
    }
    public Integer summator() {
        Integer sum = 0;
        Iterator<Integer> iter = setMass.iterator();
        while (iter.hasNext()) {
            sum =+ iter.next();
        }
        return sum;
    }
    public SortedSet<Integer> spliter(int num) {
        SortedSet<Integer> splitSet = new TreeSet<>();
        Iterator<Integer> iter = setMass.iterator();
        while (iter.hasNext()) {
            splitSet.add(iter.next() / num);
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
    public SortedSet<Integer> delet(Integer num) {
        if (setMass.contains(num))
            setMass.remove(num);
        return setMass;
    }
}
