package com.sfox.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class JimAndTheSkycrapers {

    static long validPath(long[] A, int i, int j) {
        if (A[i] != A[j]) {
            return 0;
        }

        for (int k = i; k < j; k ++) {
            if (A[k] > A[i]) {
                return 0;
            }
        }
        return 1;
    }

    static long validPathCount(long[] A) {
        long count = 0;
        long N = A.length;
        for (int i = 0; i < N; i ++) {
            for (int j = i + 1; j < N; j ++) {
                count += validPath(A, i, j);
            }
        }

        return 2 * count;
    }

    static long validPathCount_V2(long[] A) {
        long count = 0;
        Stack<Integer> S = new Stack<Integer>();
        Map<Long, Integer> M = new HashMap<Long, Integer>();
        long N = A.length;
        for (int i = 0; i < N; i ++) {
            if (S.size() == 0 || A[i] < A[S.peek()]) {
                S.push(i);
                if (!M.containsKey(A[i])) {
                    M.put(A[i], 0);
                }
                M.put(A[i], M.get(A[i]) + 1);
            } else if (A[i] == A[S.peek()]) {
                if (!M.containsKey(A[i])) {
                    M.put(A[i], 0);
                }
                count += M.get(A[i]);

                M.put(A[i], M.get(A[i]) + 1);
                S.push(i);
            } else if (A[i] > A[S.peek()]) {
                int k = S.pop();
                M.put(A[k], M.get(A[k]) - 1);
                i -= 1;
            }
        }
        return count * 2;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int N = Integer.parseInt(br.readLine());
            long[] A = new long[N];
            String[] SA = br.readLine().split(" ");
            for ( int i = 0; i < SA.length; i ++) {
                A[i] = Long.parseLong(SA[i]);
            }

            System.out.println(validPathCount_V2(A));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}