package com.example.seafight.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BattleShip extends cell {
    int lenght;
    public static int[]  populationShip= {0,6,5,4,3,2,1};


    private List<cell> cells = new ArrayList<>();

    public void ship(List<cell> cells){
        this.cells = cells;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public void minusShip(int lenght){
        int i = populationShip[lenght]- 1;
    }


}

