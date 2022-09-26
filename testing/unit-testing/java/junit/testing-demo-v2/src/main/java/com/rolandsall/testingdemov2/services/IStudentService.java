package com.rolandsall.testingdemov2.services;

import com.rolandsall.testingdemov2.models.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IStudentService {
    List<Student> getAllStudents();

    void addStudent(Student student);

    void deleteStudent(Long studentId);
}
