package ru.innopolis.dao;

import java.io.Serializable;
import java.util.Objects;

public class Course implements Serializable {
    private String name;
    private int person_id;
    private int subject_id;

    public Course() {

    }


    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return person_id == course.person_id &&
                subject_id == course.subject_id &&
                Objects.equals(name, course.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, person_id, subject_id);
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", person_id=" + person_id +
                ", subject_id=" + subject_id +
                '}';
    }
}