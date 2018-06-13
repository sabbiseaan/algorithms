package com.activeio.search.avl_tree;


public class CLI {
    public static void main(String[] args) {
        AVLTree<String> tree = new AVLTree<>();
        tree.insert(10, "Zehn");
        tree.insert(13, "Dreizehn");
        tree.insert(15, "Fünfzehn");

        int i  = 0;
        int key = 10;

        while (i < 10000) {
            key = (int) (1 + Math.random() * 100000);
            tree.insert(key, "A");

            i++;
        }

        System.out.println();
        System.out.println(tree.search(13));
        System.out.println(tree.search(key));
    }
}
