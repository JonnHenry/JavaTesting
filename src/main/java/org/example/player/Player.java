package org.example.player;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    private Dice dice;
    private int minNumberToWin;

    public boolean play(){
        int diceNumber = dice.roll();
        return diceNumber>minNumberToWin;
    }
}
