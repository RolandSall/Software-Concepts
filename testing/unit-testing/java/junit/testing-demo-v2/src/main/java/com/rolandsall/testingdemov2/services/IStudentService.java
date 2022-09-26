package com.rolandsall.testingdemov2.services;

import com.rolandsall.testingdemov2.models.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAllStudents();

    void addStudent(Student student);

    void deleteStudent(Long studentId);
}
