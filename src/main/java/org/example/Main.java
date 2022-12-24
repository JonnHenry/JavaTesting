package org.example;


import org.apache.commons.lang3.StringUtils;

public class Main {

    public static String repeat(String string, int times) {
        if(times<0){
            throw new IllegalArgumentException("Negative times not allow");
        }
        String result ="";

        for (int i = 0; i < times; i++) {
            result +=string;
        }
        return result;
    }
    public static void main(String[] args) {

    }


}