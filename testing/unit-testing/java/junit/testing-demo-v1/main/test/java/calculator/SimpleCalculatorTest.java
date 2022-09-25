package calculator;

import calculator.SimpleCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleCalculatorTest {


    @Test
    void add_function_add_two_numbers_correctly(){

        // Arrange
        var calculator = new SimpleCalculator();

        // Action
        var result_test_1 =calculator.add(2, 2);
        var result_test_2 =calculator.add(3, 2);

        // Assert
        assertEquals(4,result_test_1);
        assertEquals(5,result_test_2);

    }

}