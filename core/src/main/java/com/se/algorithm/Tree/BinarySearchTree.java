package com.se.algorithm.Tree;

public class BinarySearchTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public boolean add(int value) {

        if (root == null) {
            root = new Node(value);
            return true;
        }

        Node currentNode = root;

        while (currentNode != null) {
            Node leftChild = currentNode.getLeftChild();
            Node rightChild = currentNode.getRightChild();

            if (currentNode.getData() > value) {
                if (leftChild == null) {
                    leftChild = new Node(value);
                    currentNode.setLeftChild(leftChild);
                    return true;
                }
                currentNode = leftChild;
            } else {
                if (rightChild == null) {
                    rightChild = new Node(value);
                    currentNode.setRightChild(rightChild);
                    return true;
                }
                currentNode = rightChild;
            }
        }


        return false;
    }

    public Node recursive_insert(Node currentNode, int value) {

        if (currentNode == null) {
            return new Node(value);
        }

        if (currentNode.getData() > value) {
            currentNode.setLeftChild(recursive_insert(currentNode.getLeftChild(), value));
        } else if (currentNode.getData() < value) {
            currentNode.setRightChild(recursive_insert(currentNode.getRightChild(), value));
        } else {
            return currentNode;
        }

        return currentNode;
    }

    public boolean add_recursive(int value) {
        root = recursive_insert(this.root, value);
        return true;
    }

    public void printTree(Node current) {
        if (current == null) return;

        System.out.print(current.getData() + ",");
        printTree(current.getLeftChild());
        printTree(current.getRightChild());

    }

    public Node search(int value) {

        if(root == null) return null;

        Node currentNode = this.root;

        while(currentNode != null) {
            if(currentNode.getData() == value) {
                return currentNode;
            }

            if(currentNode.getData() > value) {
                currentNode = currentNode.getLeftChild();
            } else {
                currentNode = currentNode.getRightChild();
            }
        }

        return null;
    }

    public boolean delete(Node currentNode, int value) {

        if(root == null) {
            return false;
        }

        Node parent = null;
        while(currentNode != null && currentNode.getData() != value) {
            parent = currentNode;
            if(currentNode.getData() > value) {
                currentNode = currentNode.getLeftChild();
            } else {
                currentNode = currentNode.getRightChild();
            }
        }

        if(currentNode == null) {
            return false;
        } else if(currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {

            if(root.getData() == currentNode.getData()) {
                setRoot(null);
                return true;
            } else if(currentNode.getData() < parent.getData()) {
                parent.setLeftChild(null);
                return true;
            } else {
                parent.setRightChild(null);
                return true;
            }
        }



        return false;
    }

    public static void main(String args[]) {
        BinarySearchTree bsT = new BinarySearchTree();

        bsT.add(6);
        bsT.add(4);
        bsT.add(9);
        bsT.add(5);
        bsT.add(2);
        bsT.add(8);
        bsT.add(12);
        bsT.add(10);
        bsT.add(14);

        bsT.printTree(bsT.getRoot());
    }
}
