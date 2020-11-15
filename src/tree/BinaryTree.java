package tree;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinaryTree {

    static class Node {

        String name;
        Node leftChild, rightChild;

        Node(String name) {
            this.name = name;
            leftChild = rightChild = null;
        }

        public String toString() {
            return name;
        }
    }

    Node root;

    void addNode(String name) {
        if (root == null) {
            root = new Node(name);
        }
        Node focusNode = root;

        while (true) {
            if (name.compareTo(focusNode.name) < 0) {
                if (focusNode.leftChild != null) {
                    focusNode = focusNode.leftChild;
                } else {
                    focusNode.leftChild = new Node(name);
                    return;
                }
            } else if (name.compareTo(focusNode.name) > 0) {
                if (focusNode.rightChild != null) {
                    focusNode = focusNode.rightChild;
                } else {
                    focusNode.rightChild = new Node(name);
                    return;
                }
            } else return;
        }
    }

    void inOrderTraversal(Node focusNode) {
        if (focusNode != null){
            inOrderTraversal(focusNode.leftChild);
            System.out.print(focusNode.name + " ");
            inOrderTraversal(focusNode.rightChild);
        }
    }

    void preOrderTraversal(Node focusNode) {
        if (focusNode != null) {
            System.out.print(focusNode.name + " ");
            preOrderTraversal(focusNode.leftChild);
            preOrderTraversal(focusNode.rightChild);
        }
    }

    void postOrderTraversal(Node focusNode) {
        if (focusNode != null) {
            postOrderTraversal(focusNode.leftChild);
            postOrderTraversal(focusNode.rightChild);
            System.out.print(focusNode.name + " ");
        }
    }

    public static void main(String[] args) throws Exception {

        List<String> states = new ArrayList<>();

        Scanner sc = new Scanner(new FileReader("states_usa.txt"));
        while (sc.hasNextLine()) {
          states.add(sc.nextLine());
        }

        sc.close();

        BinaryTree tree = new BinaryTree();
        for (String state : states) {
            tree.addNode(state);
        }
        System.out.println("\nIN-ORDER TRAVERSAL:\n");
        tree.inOrderTraversal(tree.root);
        System.out.println();

        System.out.println("\nPRE-ORDER TRAVERSAL:\n");
        tree.preOrderTraversal(tree.root);
        System.out.println();

        System.out.println("\nPOST-ORDER TRAVERSAL:\n");
        tree.postOrderTraversal(tree.root);
        System.out.println();
    }
}
