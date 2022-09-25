package gpaCalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LAUGPACalculatorTest {
    
    
    IGPACalculator calculator;

    public LAUGPACalculatorTest() {
        this.calculator = new LAUGPACalculator();
    }

    @Test
    void calculate_function_returns_grade_of_d() {

        // arrange

        // action
        var grade = calculator.calculate(59);

        // assert
        assertEquals('F', grade);
    }

    @Test
    void calculate_function_returns_grade_of_C() {

        // arrange

        // action
        var grade = calculator.calculate(69);

        // assert
        assertEquals('D', grade);
    }

    @Test
    void calculate_function_throwIllegalArgumentException_given_negative_value(){

        // action & assert
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(-1);
        });

        assertEquals("negative value received", illegalArgumentException.getMessage());
    }

}