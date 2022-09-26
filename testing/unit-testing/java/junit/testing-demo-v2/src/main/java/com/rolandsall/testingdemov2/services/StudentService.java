package com.rolandsall.testingdemov2.services;

import com.rolandsall.testingdemov2.exceptions.BadRequestException;
import com.rolandsall.testingdemov2.exceptions.StudentNotFoundException;
import com.rolandsall.testingdemov2.models.Student;
import com.rolandsall.testingdemov2.repos.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    private final IStudentRepository studentRepository;

    @Autowired
    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        Boolean existsEmail = studentRepository
                .selectExistsEmail(student.getEmail());
        if (existsEmail) {
            throw new BadRequestException(
                    "This email is " + student.getEmail() + " invalid");
        }

        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        if(!studentRepository.existsById(studentId)) {
            throw new StudentNotFoundException(
                    "Student does not exists: " + studentId);
        }
        studentRepository.deleteById(studentId);
    }
}
