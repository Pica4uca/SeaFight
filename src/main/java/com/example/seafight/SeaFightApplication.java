package com.example.seafight;

import com.example.seafight.Model.BattleShip;
import com.example.seafight.Model.Board;
import com.example.seafight.Model.Player;

import java.util.ArrayList;
import java.util.List;


public class SeaFightApplication extends Board {

    public static void main(String[] args) {

        Player player1 = new Player();
        Player player2 = new Player();
        player1.greetings();
        player2.greetings();
     //   player1.setStartPlayGround(player1.getPlayGround());
     //   player2.setStartPlayGround(player1.getPlayGround());
        List<BattleShip> ships = new ArrayList<>();
        player1.newBattleShip();
        player1.showPlayGround();
        player1.saveInFile();
        player1.readFile();
        player1.shoot();




    }

}
