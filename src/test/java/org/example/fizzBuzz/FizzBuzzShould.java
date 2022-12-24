package org.example.fizzBuzz;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzShould {

    @Test
    public void numberIsDivisorTo3(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertThat(fizzBuzz.getResult(6), is("Fizz"));
    }

    @Test
    public void numberIsDivisorTo5(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertThat(fizzBuzz.getResult(25), is("Buzz"));
    }

    @Test
    public void numberIsDivisorTo5And3(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertThat(fizzBuzz.getResult(15), is("FizzBuzz"));
    }

    @Test
    public void numberIsDiferentTo5And3(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        Integer numberToCompare = 4;
        assertThat(fizzBuzz.getResult(numberToCompare), is(numberToCompare));
    }

}