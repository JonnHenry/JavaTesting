package org.example.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilTest {

    @BeforeEach
    void setup(){

    }

    /*
        All years divisible by 400 ARE Leap years (1600, 2000, 2400)
        All years divisible by 100 but not by 400 are NOT leap years (1700, 1800, 1900),
        All years divisible by 4 but not by 100 ARE 1eap years (1996, 2004, 2008),
        All years not divisible by 4 are NOT Leap years (2017, 2018, 2019)
     */
    @Test
    void isLeapYearDivisibleBy400() {
        assertEquals(DateUtil.isLeapYear(1600), true);
        assertEquals(DateUtil.isLeapYear(2000), true);
        assertEquals(DateUtil.isLeapYear(2400), true);
    }

    @Test
    void isNotLeapYearDivisibleBy100ButNotBy400() {
        assertEquals(DateUtil.isLeapYear(1700), false);
        assertEquals(DateUtil.isLeapYear(1800), false);
        assertEquals(DateUtil.isLeapYear(1900), false);
    }

    @Test
    void isLeapYearDivisibleBy4ButNotBy100() {
        assertEquals(DateUtil.isLeapYear(1996), true);
        assertEquals(DateUtil.isLeapYear(2004), true);
        assertEquals(DateUtil.isLeapYear(2008), true);
    }

    @Test
    void isNotLeapYearNotDivisibleBy4() {
        assertEquals(DateUtil.isLeapYear(2017), false);
        assertEquals(DateUtil.isLeapYear(2018), false);
        assertEquals(DateUtil.isLeapYear(2019), false);
    }
}