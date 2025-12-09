package com.devcalc.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    void add_shouldReturnSum() {
        assertEquals(15.0, calculatorService.add(10.0, 5.0));
    }

    @Test
    void subtract_shouldReturnDifference() {
        assertEquals(5.0, calculatorService.subtract(10.0, 5.0));
    }

    @Test
    void multiply_shouldReturnProduct() {
        assertEquals(50.0, calculatorService.multiply(10.0, 5.0));
    }

    @Test
    void divide_shouldReturnQuotient() {
        assertEquals(2.0, calculatorService.divide(10.0, 5.0));
    }

    @Test
    void divide_byZeroShouldThrowException() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> calculatorService.divide(10.0, 0.0));
        assertTrue(ex.getMessage().contains("Division by zero"));
    }
}
