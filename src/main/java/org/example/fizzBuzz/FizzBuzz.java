package org.example.fizzBuzz;

public class FizzBuzz {
    public String getResult(int number) {
        if (number%3==0){
            return "Fizz";
        }else if (number%5==0){
            return "Buzz";
        }else if(number%5==0&&number%3==0){
            return "FizzBuzz";
        }
        return String.valueOf(number);

    }
}
