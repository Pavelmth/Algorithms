package ru.pavel.algorithms;

import java.util.NoSuchElementException;

public class MyTreeMap<T extends Comparable<T>, V> {
    private class Node {
        T key;
        V value;
        Node left;
        Node right;
        int size;
        int height;
        boolean isBalanced;

        public Node(T key, V value, int size, int height, boolean isBalanced) {
            this.key = key;
            this.value = value;
            this.size = size;
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    private Node root = null;

    public boolean isEmpty() {
        return root == null;
    }

    public boolean isBalanced() {
        return root.isBalanced;
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if(node == null) {
            return 0;
        } else {
            return node.size;
        }
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.height;
        }
    }

    public V get(T key) {
        return get(root, key);
    }

    private V get(Node node, T key) {
        if (key == null) {
            throw new IllegalArgumentException("Where can't be key with null");
        }
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node.value;
        }
        if (cmp < 0) {
            return get(node.left, key);
        } else {
            return get(node.right, key);
        }
    }

    public boolean contains(T key) {
        return get(key) != null;
    }

    public void put(T key, V value) {
        root = put(root, key, value);
    }

    private Node put(Node node, T key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Where can't be key with null");
        }
        if (node == null) {
            return new Node(key, value, 1, 0, true);
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            node.value = value;
        } else if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else {
            node.right = put(node.right, key, value);
        }
        node.size = size(node.left) + size(node.right) + 1;

        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        if (node.left == null && node.right == null) {
            node.height = 0;
        } else if (height(node.right) >= height(node.left) || node.left == null) {
            node.height = height(node.right) + 1;
        } else if (height(node.right) <= height(node.left) || node.right == null){
            node.height = height(node.left) + 1;
        }

        if (!node.isBalanced) {
            node.isBalanced = false;
        } else if (node.left == null && node.right == null) {
            node.isBalanced = true;
        } else if (node.left == null && node.right.height > 1) {
            node.isBalanced = false;
        } else if (node.right == null && node.left.height > 1) {
            node.isBalanced = false;
        } else if (node.left != null && node.right != null) {
            if ((Math.abs(node.left.height - node.right.height) > 1)) {
                node.isBalanced = false;
            }
        }

        return node;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        } else {
            return min(node.left);
        }
    }

    public V min() {
        return min(root).value;
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        } else {
            return max(node.right);
        }
    }

    public V max() {
        return max(root).value;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            return node.right;
        } else {
            node.left = removeMin(node.left);
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void removeMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Tree is empty");
        }
        root = removeMin(root);
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            return node.left;
        } else {
            node.right = removeMax(node.right);
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void removeMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Tree is empty");
        }
        root = removeMax(root);
    }

    public void remove(T key) {
        root = remove(root, key);
    }

    private Node remove(Node node, T key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = remove(node.left, key);
        } else if (cmp > 0) {
            node.right = remove(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            Node tmp = node;
            node = max(node.left);
            node.left = removeMax(tmp.left);
            node.right = tmp.right;
        }
        node.size = size(node.left) + size(node.right) + 1;

        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        if (node.left == null && node.right == null) {
            node.height = 0;
        } else if (height(node.right) >= height(node.left) || node.left == null) {
            node.height = height(node.right) + 1;
        } else if (height(node.right) <= height(node.left) || node.right == null){
            node.height = height(node.left) + 1;
        }

        if (!node.isBalanced) {
            node.isBalanced = false;
        } else if (node.left == null && node.right == null) {
            node.isBalanced = true;
        } else if (node.left == null && node.right.height > 1) {
            node.isBalanced = false;
        } else if (node.right == null && node.left.height > 1) {
            node.isBalanced = false;
        } else if (node.left != null && node.right != null) {
            if ((Math.abs(node.left.height - node.right.height) > 1)) {
                node.isBalanced = false;
            }
        }

        return node;
    }
}
