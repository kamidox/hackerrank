package com.sfox.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by kamidox on 15-3-20.
 * Copyright ${PROJECT_NAME}
 */
public class SwapNotesAlgo {

    public static interface Visitor {
        public void visit(BinTreeNode note);
    }

    private static class BinTreeNode {
        // index of parent; start from 0.
        int parent;
        // 0: for left index, 1: for right index; start from 1.
        int[] child;
        int value;
        int depth;

        BinTreeNode(int v) {
            this.child = new int[2];
            this.value = v;
            this.parent = 1;
            this.depth = 0;
        }
    }

    private static class BinTree {
        BinTreeNode[] nodes;

        BinTree(int N) {
            this.nodes = new BinTreeNode[N];
            for (int i = 0; i < N; i++) {
                this.nodes[i] = new BinTreeNode(i + 1);
            }
        }

        void swap(int h) {
            for (int i = 0; i < nodes.length; i++) {
                if (nodes[i].depth % h == 0) {
                    int temp = nodes[i].child[0];
                    nodes[i].child[0] = nodes[i].child[1];
                    nodes[i].child[1] = temp;
                }
            }
            traversal(nodes, 0, new Visitor() {
                boolean needSpace = false;

                @Override
                public void visit(BinTreeNode note) {
                    if (!needSpace) {
                        needSpace = true;
                    } else {
                        System.out.print(' ');
                    }
                    System.out.print(note.value);
                }
            });
            System.out.print('\n');
        }

        static void traversal(BinTreeNode tree[], int root, Visitor visitor) {
            if (tree[root].child[0] != -1) {
                traversal(tree, tree[root].child[0] - 1, visitor);
            }
            visitor.visit(tree[root]);
            if (tree[root].child[1] != -1) {
                traversal(tree, tree[root].child[1] - 1, visitor);
            }
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int N = Integer.parseInt(br.readLine());
            BinTree tree = new BinTree(N);

            for (int i = 0; i < N; i ++) {
                String[] str = br.readLine().split(" ");
                tree.nodes[i].depth = tree.nodes[tree.nodes[i].parent - 1].depth + 1;
                for (int k = 0; k < 2; k ++) {
                    tree.nodes[i].child[k] = Integer.parseInt(str[k]);
                    if (tree.nodes[i].child[k] != -1) {
                        tree.nodes[tree.nodes[i].child[k] - 1].parent = i + 1;
                    }
                }
            }

            int T = Integer.parseInt(br.readLine());
            Queue<Integer> K = new LinkedList<Integer>();
            for (int i = 0; i < T; i ++) {
                K.add(Integer.parseInt(br.readLine()));
            }

            for (int i = 0; i < T; i ++) {
                tree.swap(K.poll());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
