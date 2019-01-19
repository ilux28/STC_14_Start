package ru.innopolis.collectiongenerics;

/**
 * Класс хранилище ObjectBox
 * @author Ilya Pribytkov
 * @version 1.0
 */

import java.util.*;

public class ObjectBox<T> {
    protected int hash;
    private Set<T> box;

    /**
     * Конструктор без параметров
     */
    public ObjectBox() {
        this.hash = new Random().nextInt(1000);
        this.box = new HashSet<>();
    }
    /**
     * Конструктор с параметром
     * @param objects массив объектов
     */

    public ObjectBox(T[] objects) {
        this.box = new HashSet<>();
        this.hash = new Random().nextInt(1000) + Objects.hashCode(objects);
        Collections.addAll(this.box, objects);
    }
    /**
     * Добавление елемента в коллекцию
     * @param elem
     */
    public void addObject(T elem) {
        box.add(elem);
    }
    /**
     * Удаление елемента из коллекции
     * @param elem
     * @return возвращает булево значение
     * согласно тому был ли найден и удален елемент
     */
    public boolean deleteObject(T elem) {
        return this.box.remove(elem);
    }
     /**
     * @return выводит содержимое коллеции в строку
     */
    public String dump() {
        StringBuilder str = new StringBuilder();
        for (Object obj : this.box) {
            str.append(obj.toString() + ", ");
        }
        return str.toString();
    }

    /**
     *
     * @return возвращает хеш-код объекта
     */
    @Override
    public int hashCode() {
        return this.hash;
    }

    /**
     * проверка равенства двух объектов
     * @param obj объект для сравнения
     * @return возвращает результат сравнения true/false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return Objects.equals(this.box, (ObjectBox)obj);
    }
    /**
     * @return возвращает строковое представление объекта
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() + dump();
    }
}