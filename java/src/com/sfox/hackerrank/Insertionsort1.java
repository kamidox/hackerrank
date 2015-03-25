package com.sfox.hackerrank;

import java.util.Scanner;

/**
 * Created by kamidox on 15-3-25.
 * Copyright java
 */
public class Insertionsort1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int ar[] = new int[s];
        for (int i = 0; i < s; i ++) {
            ar[i] = scanner.nextInt();
        }

        insertionSort(ar);
    }

    public static void insertionSort(int[] ar) {
        int V = ar[ar.length - 1];
        for (int i = ar.length - 1; i >= 0; i --) {
            if (i-1 >= 0 && ar[i-1] > V) {
                ar[i] = ar[i-1];
                print(ar);
            } else {
                ar[i] = V;
                print(ar);
                break;
            }
        }
    }

    private static void print(int[] ar) {
        for (int i = 0; i < ar.length; i ++) {
            System.out.print(ar[i]);
            if (i == ar.length - 1) {
                System.out.print("\n");
            } else {
                System.out.print(" ");
            }
        }
    }
}
