package com.example.javatests.fizzbuzz;

import org.junit.Test;

import static com.example.javatests.fizzbuzz.FizzBuzz.fizzBuzz;
import static org.junit.Assert.*;

public class FizzBuzzShould {
    @Test
    public void returnFizzWhenNumberIsDivisibleBy3() {
        assertEquals("Fizz", fizzBuzz(3));
        assertEquals("Fizz", fizzBuzz(6));
    }

    @Test
    public void returnBuzzWhenNumberIsDivisibleBy5() {
        assertEquals("Buzz", fizzBuzz(5));
        assertEquals("Buzz", fizzBuzz(10));
    }

    @Test
    public void returnFizzBuzzWhenNumberIsDivisibleBy3And5() {
        assertEquals("FizzBuzz", fizzBuzz(15));
        assertEquals("FizzBuzz", fizzBuzz(30));
    }

    @Test
    public void returnNumberAsStringWhenNumberIsNotDivisibleBy3Or5() {
        assertEquals("2", fizzBuzz(2));
        assertEquals("16", fizzBuzz(16));
    }
}