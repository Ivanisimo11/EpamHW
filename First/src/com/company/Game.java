package com.company;

import java.util.Scanner;

public class Game {
    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("min: ");
        int min = scanner.nextInt();
        System.out.print("max: ");
        int max = scanner.nextInt();
        System.out.print("PLAY!\n\n");
        int hiddenNumber = rand(min, max);
        int counter = 0;
        while (true) {
            System.out.println("Число находиться в диапазоне " + min + " - " + max);
            int scan = scanner.nextInt();
            while (scan > max || scan < min) {
                System.out.println("Введите число в укзаном вами диапазоне");
                scan = scanner.nextInt();
            }
            counter++;
            if (scan == hiddenNumber) {
                System.out.println(counter + " попыток потрачено");
                break;
            } else if (scan < hiddenNumber) {
                System.out.println("загаданное число больше");
                min = scan;
            } else {
                System.out.println("загаданное число меньше");
                max = scan;
            }
        }

    }

    private int rand(int min, int max) {
        return (int) ((Math.random() * ((max - min) + 1)) + min);
    }

    private int rand() {
        return rand(0, Integer.MAX_VALUE);
    }
}
