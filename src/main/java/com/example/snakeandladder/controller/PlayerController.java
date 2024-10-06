package com.example.snakeandladder.controller;

import com.example.snakeandladder.model.Board;
import com.example.snakeandladder.model.Cell;
import com.example.snakeandladder.model.Player;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
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
            System.out.println("Oh its a snake cell ! ");
//            log.info("{} Sliding down from {} to {}",player.getName(),player.getCurrentIndex(),newPosition);
        }else if(cell.getLadder()!=null)
        {
            newPosition=player.getCurrentIndex()+cell.getLadder().getEndPoint();
            System.out.println("Congrats its a ladder cell ");
//            log.info("{} Climbing up from {} to {}",player.getName(), player.getCurrentIndex(),newPosition);
        }
        System.out.println(player.getName()+" is moving from " + player.getCurrentIndex()+ " to "+ newPosition);
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
