package com.example.snakeandladder.controller;

import com.example.snakeandladder.model.Board;
import com.example.snakeandladder.model.Dice;
import com.example.snakeandladder.model.Player;

import java.util.List;

public class GameController {
    BoardController boardController;

    DiceController diceController;

    PlayerController playerController;

    public GameController(BoardController boardController,DiceController diceController,PlayerController playerController)
    {
        this.boardController=boardController;
        this.diceController=diceController;
        this.playerController=playerController;
    }

    int currentPlayerIndex;
    public void start(int startingPlayer) {
        this.currentPlayerIndex=startingPlayer;
    }
    public Player getCurrentPlayer()
    {
        currentPlayerIndex = (currentPlayerIndex + 1) % playerController.numberOfPlayer();
        Player currentPlayer = playerController.getPlayer(currentPlayerIndex);
        return currentPlayer;
    }
    public Player getStartingPlayer()
    {
        Player currentPlayer = playerController.getPlayer(currentPlayerIndex);
        return currentPlayer;
    }
    public void takeTurn(Player player) {

        int diceRoll = diceController.roll();
        Board board=boardController.getBoard();
        playerController.move(player,diceRoll, board);
    }

    public boolean checkWinner(Player player) {
        return player.getCurrentIndex() == 100;
    }
}
