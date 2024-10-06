package com.example.snakeandladder.model;

public class Snake {
    int startPoint;
    int endPoint;

    public Snake(int startPoint, int endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public int getStartPoint() {
        return startPoint;
    }

    public int getEndPoint() {
        return endPoint;
    }
}
