package com.example.snakeandladder.controller;

import com.example.snakeandladder.model.Board;
import com.example.snakeandladder.model.Cell;
import com.example.snakeandladder.model.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerController {
   private List<Player> players;

   public PlayerController(List<Player> players)
   {
       this.players=players;
   }
    void move(Player player,int diceValue, Board board)
    {
        int newPosition=player.getCurrentIndex()+diceValue;
        if(newPosition>board.getCells().size())
        {
            return;
        }
        Cell cell=board.getCells().get(newPosition-1);
        if(cell.getSnake()!=null)
        {
            newPosition=player.getCurrentIndex()-cell.getSnake().getEndPoint();
        }else if(cell.getLadder()!=null)
        {
            newPosition=player.getCurrentIndex()+cell.getLadder().getEndPoint();
        }
        player.setCurrentIndex(newPosition);
    }


    public Player getPlayer(int currrentPlayer) {
        return players.get(currrentPlayer);
    }

    public int numberOfPlayer()
    {
        return players.size();
    }
}
