package com.example.snakeandladder.model;

public class Ladder {
    int startPoint;
    int endPoint;

    public Ladder(int startPoint, int endPoint) {
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
