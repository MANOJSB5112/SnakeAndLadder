package com.example.snakeandladder.controller;

import com.example.snakeandladder.model.Board;
import com.example.snakeandladder.model.Cell;
import com.example.snakeandladder.model.Ladder;
import com.example.snakeandladder.model.Snake;

public class BoardController {
    Board board;
   public BoardController(Board board)
    {
        this.board=board;
    }

    void initializeBoard(int size)
    {
        for(int i=1;i<=size;i++) {
            Cell cell;

            // Example logic for placing specific snakes
            if (i == 14) {  // Snake starting at cell 14
                cell = new Cell(i, new Snake(i, 7), null);  // Snake goes from 14 to 7
            } else if (i == 33) {  // Snake starting at cell 33
                cell = new Cell(i, new Snake(i, 9), null);  // Snake goes from 33 to 9
            }

            // Example logic for placing specific ladders
            else if (i == 3) {  // Ladder starting at cell 3
                cell = new Cell(i, null, new Ladder(i, 22));  // Ladder goes from 3 to 22
            } else if (i == 17) {  // Ladder starting at cell 17
                cell = new Cell(i, null, new Ladder(i, 34));  // Ladder goes from 17 to 34
            }

            // Normal cell with no snake or ladder
            else {
                cell = new Cell(i, null, null);
            }

            // Add the cell to the board (you would need a List<Cell> or similar in Board)
            board.getCells().add(cell);  // Assuming `board` has a method to add cells
        }
    }

    public Board getBoard() {
        return board;
    }
}
