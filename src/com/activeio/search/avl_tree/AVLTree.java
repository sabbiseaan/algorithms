package com.activeio.search.avl_tree;

class AVLTree<T> {
    Node root;

    private int height(Node n) {
        if (n == null) {
            return 0;
        }

        return n.height;
    }

    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    private Node rightRotate(Node y) {
        Node x = y.left;

        // do not balance if there is no left node
        if (x == null) {
            return y;
        }

        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;

        // do not balance if there is no right node
        if (y == null) {
            return y;
        }

        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        //  Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    private int getBalance(Node n) {
        if (n == null) {
            return 0;
        }

        return height(n.left) - height(n.right);
    }

    private Node add(Node node, int key, T value) {
        if (node == null) {
            return (new Node(key, value));
        }

        if (key < node.key) {
            node.left = add(node.left, key, value);
        } else if (key > node.key) {
            node.right = add(node.right, key, value);
        } else {
            // duplicate keys not allowed
            return node;
        }

        node.height = 1 + max(height(node.left), height(node.right));

        int balance = getBalance(node);

        // left left case
        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }

        // right right case
        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }

        // left right case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);

            return rightRotate(node);
        }

        // right left case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);

            return leftRotate(node);
        }

        return node;
    }

    void insert(int key, T value) {
        root = add(root, key, value);
    }

    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    T search(int key) {
        return search(root, key);
    }

    private T search(Node n, int key) {
        if (n == null) {
            // not found
            throw new IndexOutOfBoundsException("Could not find key");
        }

        if (key < n.key) {
            return search(n.left, key);
        } else if (key > n.key) {
            return search(n.right, key);
        }

        return n.value;
    }

    private class Node {
        int key;
        int height;
        T value;

        Node left;
        Node right;

        Node(int d, T value) {
            this.value = value;
            key = d;
            height = 1;
        }
    }
}
