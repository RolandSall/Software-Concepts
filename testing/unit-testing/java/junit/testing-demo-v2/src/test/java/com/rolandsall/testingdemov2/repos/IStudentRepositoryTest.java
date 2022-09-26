package com.rolandsall.testingdemov2.repos;

import com.rolandsall.testingdemov2.enums.Gender;
import com.rolandsall.testingdemov2.models.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class IStudentRepositoryTest {

    @Autowired
    private  IStudentRepository studentRepository;


    @AfterEach
    void tearDown() {
        studentRepository.deleteAll();
    }


    @Test
    void selectExistsEmail_should_return_true_if_email_exist(){
        // arrange
        Student student = Student.builder()
                .name("Roland")
                .email("roland@gmail.com")
                .gender(Gender.MALE)
                .build();

        studentRepository.save(student);

        // action
        boolean exist = studentRepository.selectExistsEmail("roland@gmail.com");

        // assert
        assertTrue(exist);

    }

    @Test
    void selectExistsEmail_should_return_false_if_email_exist(){
        // arrange

        // action
        boolean exist = studentRepository.selectExistsEmail("roland@gmail.com");

        // assert
        assertFalse(exist);

    }

}