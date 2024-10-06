package com.example.snakeandladder.model;

public class Cell {
    int cellNumber;
    Snake snake;
    Ladder ladder;

    public Cell(int cellNumber, Snake snake, Ladder ladder) {
        this.cellNumber = cellNumber;
        this.snake = snake;
        this.ladder = ladder;
    }

    public int getCellNumber() {
        return cellNumber;
    }

    public Snake getSnake() {
        return snake;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
