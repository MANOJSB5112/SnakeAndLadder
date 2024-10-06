package com.example.snakeandladder.controller;

import com.example.snakeandladder.model.Dice;

public class DiceController {
    Dice dice;

    public DiceController(Dice dice)
    {
        this.dice=dice;
    }

    int roll()
    {
        return dice.getMinValue() + (int) (Math.random() * (dice.getMaxValue() - dice.getMinValue() + 1));
    }
}
