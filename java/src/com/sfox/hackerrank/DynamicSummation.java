package com.sfox.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by kamidox on 15-3-21.
 * Copyright java
 */
public class DynamicSummation {

    public static interface Visitor {
        public void visit(Vertex v);
    }

    static class Vertex {
        int value = 0;

        int parent = -1;
        ArrayList<Integer> children = new ArrayList<Integer>();
    }

    static class Tree {
        Vertex[] vertexes;
        int[][] edges;

        // result for Report Operation
        long sum;
        Queue<Integer> queue = new LinkedList<Integer>();

        Tree(int N) {
            vertexes = new Vertex[N];
            for (int i = 0; i < N; i ++) {
                vertexes[i] = new Vertex();
            }
            edges = new int[N-1][2];
        }

        private void traverse(int t, Visitor visitor) {
            queue.clear();
            Integer n = t;
            do {
                visitor.visit(vertexes[n - 1]);
                for (int k : vertexes[n - 1].children) {
                    if (vertexes[k - 1].parent == n) {
                        queue.offer(k);
                    }
                }
                n = queue.poll();
            } while (n != null);
        }

        private void createTreeFromRoot(int r) {
            for (int i = 0; i < vertexes.length; i ++) {
                vertexes[i].parent = -1;
            }
            vertexes[r-1].parent = 0;   // ROOT node's parent set to zero

            queue.clear();
            Integer n = r;
            do {
                for (int i : vertexes[n-1].children) {
                    if (vertexes[i-1].parent == -1) {
                        vertexes[i-1].parent = n;
                        queue.offer(i);
                    }
                }
                n = queue.poll();
            } while (n != null);
        }

        public void update(int r, int t, long a, long b) {
            final double value = Math.pow(a, b) + Math.pow(a+1, b) + Math.pow(b+1, a);

            createTreeFromRoot(r);
            traverse(t, new Visitor() {
                @Override
                public void visit(Vertex v) {
                    v.value += value;
                }
            });
        }

        public void report(int r, int t, final int m) {
            sum = 0;
            createTreeFromRoot(r);
            traverse(t, new Visitor() {
                @Override
                public void visit(Vertex v) {
                    sum += v.value;
                }
            });
            System.out.println(sum % m);
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int N = Integer.parseInt(br.readLine());
            Tree tree = new Tree(N);

            for (int i = 0; i < N - 1; i ++) {
                String[] str = br.readLine().split(" ");
                tree.edges[i][0] = Integer.parseInt(str[0]);
                tree.edges[i][1] = Integer.parseInt(str[1]);
                tree.vertexes[tree.edges[i][0] - 1].children.add(tree.edges[i][1]);
                tree.vertexes[tree.edges[i][1] - 1].children.add(tree.edges[i][0]);
            }

            int Q = Integer.parseInt(br.readLine());
            for (int i = 0; i < Q; i ++) {
                String[] str = br.readLine().split(" ");
                if (str[0].equals("U")) {
                    tree.update(Integer.parseInt(str[1]),
                            Integer.parseInt(str[2]),
                            Long.parseLong(str[3]),
                            Long.parseLong(str[4]));
                } else if (str[0].equals("R")) {
                    tree.report(Integer.parseInt(str[1]),
                            Integer.parseInt(str[2]),
                            Integer.parseInt(str[3]));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
