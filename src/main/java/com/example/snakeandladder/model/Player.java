package com.example.snakeandladder.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    int playerNumber;
    String name;
    int currentIndex;

    public Player(int playerNumber, String name, int currentIndex) {
        this.playerNumber = playerNumber;
        this.name = name;
        this.currentIndex = currentIndex;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public String getName() {
        return name;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

}
