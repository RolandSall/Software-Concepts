package com.rolandsall.testingdemov2.services;

import com.rolandsall.testingdemov2.enums.Gender;
import com.rolandsall.testingdemov2.exceptions.BadRequestException;
import com.rolandsall.testingdemov2.exceptions.StudentNotFoundException;
import com.rolandsall.testingdemov2.models.Student;
import com.rolandsall.testingdemov2.repos.IStudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private IStudentRepository studentRepository;
    private IStudentService studentService;

    @BeforeEach
    void setUp() {
        studentService = new StudentService(studentRepository);
    }

    @Test
    void getAllStudents() {
        // arrange
        // action
        studentService.getAllStudents();
        // assert
        verify(studentRepository).findAll();
    }

    @Test
    void addStudent_calls_dao_save_with_correct_parameters() {
        // arrange
        Student student = Student.builder()
                .name("Roland")
                .email("roland@gmail.com")
                .gender(Gender.MALE)
                .build();

        // action
        studentService.addStudent(student);

        // assert
        ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);
        verify(studentRepository).save(studentArgumentCaptor.capture());
        Student capturedStudent = studentArgumentCaptor.getValue();
        assertThat(capturedStudent).isEqualTo(student);

    }

    @Test
    void addStudent_throws_BadRequestException_when_email_is_taken() {
        // arrange
        Student student = Student.builder()
                .name("Roland")
                .email("roland@gmail.com")
                .gender(Gender.MALE)
                .build();

        given(studentRepository.selectExistsEmail(anyString())).willReturn(true);

        // action & assert
        assertThatThrownBy(() -> studentService.addStudent(student))
                .isInstanceOf(BadRequestException.class)
                .hasMessageContaining("This email is " + student.getEmail() + " invalid");

        verify(studentRepository, never()).save(any());

    }

    @Test
    void deleteStudent_throws_StudentNotFoundException_when_id_does_not_match_any_student() {
        // arrange
        long userId = 55;

        given(studentRepository.existsById(anyLong())).willReturn(false);

        // action && assert

        assertThatThrownBy(
                () -> studentService.deleteStudent(userId))
                .isInstanceOf(StudentNotFoundException.class)
                .hasMessageContaining("Student does not exists: " + userId);

        verify(studentRepository, never()).deleteById(anyLong());

    }

    @Test
    void deleteStudent_calls_dao_deleteById_with_correct_parameter() {
        // arrange
        long userId = 55;

        //  action
        given(studentRepository.existsById(userId)).willReturn(true);
        studentService.deleteStudent(userId);

        // assert
        ArgumentCaptor<Long> studentArgumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(studentRepository).deleteById(studentArgumentCaptor.capture());

        Long capturedLong = studentArgumentCaptor.getValue();
        assertThat(capturedLong).isEqualTo(userId);

    }


}