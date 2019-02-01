package ru.innopolis.lec14;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private static Logger LOGGER = LoggerFactory.getLogger(CalculatorTest.class);
   private Calculator calc;
   @BeforeEach
    void setUp() {
    calc = new Calculator();
   }
   @Test
    void sum() {
       assertEquals(7, calc.sum(3, 4), "3 + 4 = 7");
       assertEquals(-1, calc.sum(3, -4), "3 + (-4) = -1");

       LOGGER.info("sum");
   }
   @Test
    void devide() throws DivideByZeroException {
       assertEquals(1, calc.divade(2, 2), "4 / 2 = 2");
       assertEquals(1, calc.divade(3, 2), "3 / 2 = 1");
       assertThrows(DivideByZeroException.class, () -> calc.divade(1, 0), "devide by zero is prohibited");
       LOGGER.info("divide ");
   }
}