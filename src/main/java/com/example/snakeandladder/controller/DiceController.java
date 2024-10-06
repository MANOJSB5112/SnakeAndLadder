package com.example.snakeandladder.controller;

import com.example.snakeandladder.model.Dice;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DiceController {
    Dice dice;

    public DiceController(Dice dice)
    {
        this.dice=dice;
    }

    int roll()
    {
        int diceValue= dice.getMinValue() + (int) (Math.random() * (dice.getMaxValue() - dice.getMinValue() + 1));
        log.info("Dice value is {} ",diceValue);
        return diceValue;

    }
}
