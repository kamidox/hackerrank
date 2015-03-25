package com.sfox.hackerrank;

import java.util.Scanner;

/**
 * Created by kamidox on 15-3-25.
 * Copyright java
 */
public class Insertionsort2 {

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
        for (int k = 1; k < ar.length; k ++) {
            int V = ar[k];
            for (int i = k; i >= 0; i--) {
                if (i - 1 >= 0 && ar[i - 1] > V) {
                    ar[i] = ar[i - 1];
                } else {
                    ar[i] = V;
                    break;
                }
            }
            print(ar);
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
