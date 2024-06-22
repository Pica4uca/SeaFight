package com.example.seafight.Model;


import com.example.seafight.Model.Ship;

import java.util.Arrays;
import java.util.Scanner;

public class Board extends BattleShip {
    private final int cout = 17;
    String[][] playGround = new String[cout][cout]; //установка массива поля


    public void shoot() {
        System.out.println("Введите x для атаки");
        Scanner inputx = new Scanner(System.in);
        System.out.println("Введите y для атаки");
        Scanner inputy = new Scanner(System.in);
        int i = inputx.nextInt();
        int j = inputy.nextInt();
        dot=playGround[i][j];
        if (dot == "#") {
            System.out.println("Попадание!");
        }
        else if (dot == "*") {
            System.out.println("Это околокорабельная область");
        }
        else {
            System.out.println("Промах!");
        }
    }

    public void coordinateUpdate(String playGround[][]){
        for (int y = 0; y < playGround.length; y++) {
            playGround[y][0] = String.valueOf(y);
        }
        int y = 1;
        for (char c = 'a'; c < 'q'; c++) {
            playGround[0][y] = String.valueOf(c);
            y++;

        }
    }

    public void setStartPlayGround(String[][] playGround) { //пустое поле

        for (int y = 0; y < playGround.length; y++) {
            playGround[y][0] = String.valueOf(y);
        }
        int y = 1;
        for (char c = 'a'; c < 'q'; c++) {
            playGround[0][y] = String.valueOf(c);
            y++;

        }

        for (int i = 1; i < playGround.length; i++) {
            for (int j = 1; j < playGround[i].length; j++) {
                playGround[i][j] = "_";
            }
        }
        this.playGround = playGround;
    }

    public void cliping() //визуальное разделение полей
    {
        System.out.println("");
        for (int i = 0; i < 100; i++) {
            System.out.print("=");
        }
        System.out.println("");
    }

    public void showPlayGround() {  //показать поле

        for (int i = 0; i < playGround.length; i++) {
            for (int j = 0; j < playGround[i].length; j++) {

                System.out.format("%5s", playGround[i][j] + " ");
            }
            System.out.println("");

        }
        cliping();
    }

    public void attack(int i, int j) {

    }

    public void out() {

    }


    public void menu() {
        System.out.println("Выберите режим игры:");
        System.out.println("1-Одиночный");
        System.out.println("2-Совместный");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();


        switch (num) {
            case 1:
                //    setStartPlayGround(game.playGround);
                System.out.println("В разработке");
                break;
            case 2:
                System.out.println("В разработке");
                break;
        }
    }


}


