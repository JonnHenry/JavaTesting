package org.example.player;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dice {

    private int slides;

    public int roll(){
        return new Random().nextInt(slides)+1;
    }

}
