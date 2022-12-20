package org.example;

import org.example.util.PasswordUtil;
import org.junit.Test;

import static org.example.util.PasswordUtil.SecurityLevel.*;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordUtilTest {

    @Test
    public void weakWhenHasLessThan8Letters(){
        PasswordUtil.SecurityLevel securityLevel = PasswordUtil.assesPassword("3a!2Q");
        assertEquals(securityLevel, WEAK);
    }

    @Test
    public void weakWhenHasOnlyLetters(){
        PasswordUtil.SecurityLevel securityLevel = PasswordUtil.assesPassword("abcdefrgthu");
        assertEquals(securityLevel, WEAK);
    }


    @Test
    public void mediumWhenHasLettersAndNumbers(){
        PasswordUtil.SecurityLevel securityLevel = PasswordUtil.assesPassword("abcdefrgth78u");
        assertEquals(securityLevel, MEDIUM);
    }

    @Test
    public void mediumWhenHasLettersAndNumbersAndSymbols(){
        PasswordUtil.SecurityLevel securityLevel = PasswordUtil.assesPassword("abcdefrgth78u!!!");
        assertEquals(securityLevel, STRONG);
    }








}