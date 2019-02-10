package ru.innopolis.dao;

import java.util.List;

public interface InterfaceSubjectDAO {
    List<Subject> getAllSubjects();

    Subject getSubjectById(int id);

    boolean updateSubject(Subject subject);

    int createSubject(String description);

    boolean deleteSubjectById(int id);
}
