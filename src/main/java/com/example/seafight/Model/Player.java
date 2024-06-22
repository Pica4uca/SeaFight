package com.example.seafight.Model;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Player extends Board {
    private String name;

    public void greetings() {
        System.out.println("Введите имя");
        Scanner scanner = new Scanner(System.in);
        setName(String.valueOf(scanner));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void newBattleShip() {
        System.out.println("Укажите длинну корабля");
        Scanner scanner0 = (new Scanner(System.in));
        lenght = scanner0.nextInt();

        System.out.println("Укажите координаты для установки " + lenght + " палубного корабля");
        System.out.println("Укажите  x");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();                  //первая точка нового корабля по х
        System.out.println("Укажите  y");
        Scanner scanner2 = new Scanner(System.in);
        int y = scanner2.nextInt();                 //первая точка нового корабля по y
        playGround[x][y] = "#";                     //запись точки в String [][] playground

        lenght--;
        if (lenght > 0) {
            navShip(lenght, x, y);
        }
        coordinateUpdate(playGround);

        saveInFile();

    }

    public void saveInFile() {  //Сохраняет в файл актуальное поле
        String[][] input;
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Board1.txt"))) {
            for (int i = 0; i < playGround.length; i++) {
                for (int j = 0; j < playGround[i].length; j++) {
                    String arrayToStr = playGround[i][j];

                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readFile() { //достает из файла актуальное поле
        String[][] input;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Board1.txt"))) {
            for (int i = 0; i < playGround.length; i++) {
                for (int j = 0; j < playGround[i].length; j++) {
                    System.out.format("%5s", playGround[i][j] + " ");
                }
                System.out.println();
            }
            cliping();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String[][] navShip(int length, int x, int y) {
        System.out.println("Доступное продолжение корабля:");
        System.out.println("1-Вверх");
        System.out.println("2-Вниз");
        System.out.println("3-Лево");
        System.out.println("4-Право");
        int length2 = length;
        int x2=x;
        int y2=y;
        Scanner scan = new Scanner(System.in);
        int com = scan.nextInt();
        placeAroudShip(x,y);
        for (int len = lenght; len > 0; lenght--)  //len- локальная переманная для цикла, это продолжение от нач.точки
        {
            switch (com) {
                case 1:
                    playGround[x - 1][y] = "#";
                    placeAroudShip(x - 1, y);
                    x--;
                    break;

                case 2:
                    playGround[x + 1][y] = "#";
                    placeAroudShip(x + 1, y);
                    x++;
                    break;

                case 3:
                    playGround[x][y - 1] = "#";
                    placeAroudShip(x, y - 1);
                    y--;
                    break;

                case 4:
                    playGround[x][y + 1] = "#";
                    placeAroudShip(x, y + 1);
                    y++;
                    break;
            }
            len--;
        }
        for (int len1 = length2; len1 > 0; length2--)  //len- локальная переманная для цикла, это продолжение от нач.точки
        {playGround[x2][y2]="#";
            switch (com) {
                case 1:
                    playGround[x2 - 1][y2] = "#";
                    x2--;
                    break;

                case 2:
                    playGround[x2 + 1][y2] = "#";
                    x2++;
                    break;

                case 3:
                    playGround[x2][y2 - 1] = "#";
                    y2--;
                    break;

                case 4:
                    playGround[x2][y2 + 1] = "#";
                    y2++;
                    break;
            }
            len1--;
        }
        return playGround;
    }

    public void placeAroudShip(int x, int y)
    {
        playGround[x+1][y] = "*";
        playGround[x-1][y] = "*";
        playGround[x][y+1] = "*";
        playGround[x][y-1] = "*";
        playGround[x-1][y-1] = "*";
        playGround[x+1][y-1] = "*";
        playGround[x+1][y+1] = "*";
        playGround[x-1][y+1] = "*";

    }
}





