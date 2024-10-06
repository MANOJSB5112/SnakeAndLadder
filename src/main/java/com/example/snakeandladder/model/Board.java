package com.example.snakeandladder.model;

import java.util.ArrayList;
import java.util.List;

public class Board {


    List<Cell> cells;

    public Board(){
        cells=new ArrayList<>();
    }

    public List<Cell> getCells() {
        return cells;
    }
}
