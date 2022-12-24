package org.example.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilTTest {

    private String testString;
    private StringUtilT stringUtilT;

    @BeforeEach
    void setup(){
        stringUtilT = new StringUtilT();
    }


    @Test
    void stringIsNotEmpty() {
        testString = "Loasdlfkja";
        assertFalse(stringUtilT.isEmpty(testString));
    }

    @Test
    void stringIsEmpty() {
        testString = "";
        assertTrue(stringUtilT.isEmpty(testString));
    }

    @Test
    void stringIsEmptyNull() {
        testString = null;
        assertTrue(stringUtilT.isEmpty(testString));
    }

    @Test
    void stringIsEmptyWithSpaces() {
        testString = " ";
        assertTrue(stringUtilT.isEmpty(testString));
    }
}