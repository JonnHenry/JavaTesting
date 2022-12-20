package org.example.player;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void looseWhenDiceNumberIsTooLow() {
       Dice dice =  Mockito.mock(Dice.class);
       Mockito.when(dice.roll()).thenReturn(2);
       Player player = new Player(dice,3);
        assertFalse(player.play());
    }


    @Test
    void looseWhenDiceNumberIsBig() {
        Dice dice =  Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(4);
        Player player = new Player(dice,3);
        assertTrue(player.play());
    }
}