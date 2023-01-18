// import java.util.*;
// import java.lang.*;
// import java.io.*;

// public class Main {
// public static void main(String[] args) throws Exception {
// // your code here
// BinaryTree bt = new BinaryTree();
// Node root = bt.buildTree();
// bt.inorder(root);
// System.out.println();
// bt.preorder(root);
// System.out.println();
// bt.postorder(root);
// System.out.println();
// System.out.println(bt.heightOfBinaryTree(root));
// bt.printNodesAtKDistance(root, 2);
// System.out.println();
// System.out.println(bt.sizeOfBinaryTree(root));
// }
// }

// class BinaryTree {
// Scanner sc;
// Node root;

// public BinaryTree() {
// sc = new Scanner(System.in);
// }

// Node buildTree() {
// int data = sc.nextInt();
// if (data == -1) {
// return null;
// }
// Node node = new Node(data);
// node.left = buildTree();
// node.right = buildTree();
// return node;
// }

// void inorder(Node root) {
// if (root == null) {
// return;
// }
// inorder(root.left);
// System.out.print(root.data + " ");
// inorder(root.right);
// }

// void preorder(Node root) {
// if (root == null) {
// return;
// }
// System.out.print(root.data + " ");
// preorder(root.left);
// preorder(root.right);
// }

// void postorder(Node root) {
// if (root == null) {
// return;
// }
// postorder(root.left);
// postorder(root.right);
// System.out.print(root.data + " ");
// }

// int heightOfBinaryTree(Node root) {
// if (root == null) {
// return 0;
// }
// int leftHeight = heightOfBinaryTree(root.left);
// int rightHeight = heightOfBinaryTree(root.right);
// return Math.max(leftHeight, rightHeight) + 1;
// }

// void printNodesAtKDistance(Node root, int k) {
// if (root == null) {
// return;
// }
// if (k == 0) {
// System.out.print(root.data + " ");
// }
// printNodesAtKDistance(root.left, k - 1);
// printNodesAtKDistance(root.right, k - 1);
// }

// int sizeOfBinaryTree(Node root) {
// if (root == null) {
// return 0;
// }
// return sizeOfBinaryTree(root.left) + sizeOfBinaryTree(root.right) + 1;
// }
// }

// class Node {
// int data;
// Node left;
// Node right;

// Node(int data) {
// this.data = data;
// }
// }

/*
 * Types of Binary Trees
 * 1. Full Binary Tree
 * - Either has 0 or 2 children
 * 2. Complete Binary Tree
 * - All levels should be completely filled except last level
 * - The last level has all nodes on left as possible
 * 3. Perfect Binary Tree
 * - All leaf nodes should be on same level
 * 4. Balanced Binary Tree
 * - Height should be at max log(No. of nodes)
 * 5. Degenerate Tree
 * - Basically LinkedList all nodes have at max 1 child
 */