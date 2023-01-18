// import java.util.*;
// import java.lang.*;
// import java.io.*;

// public class Stack {
// public static void main(String[] args) throws Exception {
// // your code here
// Scanner sc = new Scanner(System.in);
// // int n = sc.nextInt();
// // StackUsingArray stack = new StackUsingArray(3);
// StackUsingLL stack = new StackUsingLL();
// stack.push(1);
// stack.push(2);
// stack.push(3);
// System.out.println(stack.size());
// stack.display();
// System.out.println(stack.pop());
// System.out.println(stack.pop());
// System.out.println(stack.pop());
// // stack.display();
// // System.out.println(stack.isEmpty());
// // System.out.println(stack.isFull());
// }
// }

// class StackUsingArray {
// int top;
// int arr[];
// int size;

// StackUsingArray(int size) {
// this.size = size;
// arr = new int[size];
// top = -1;
// }

// void push(int element) {
// if (top == (size - 1)) {
// System.out.println("Stack Overflow");
// return;
// }
// top++;
// arr[top] = element;
// }

// int pop() throws Exception {
// if (top == -1) {
// throw new Exception("'Stack Underflow'");
// }
// return arr[top--];
// }

// int peek() throws Exception {
// if (top == -1) {
// throw new Exception("'Stack Empty'");
// }
// return arr[top];
// }

// void display() {
// for (int i = top; i >= 0; i--) {
// System.out.print(arr[i] + " ");
// }
// System.out.println();
// }

// boolean isEmpty() {
// if (top == -1) {
// return true;
// }
// return false;
// }

// boolean isFull() {
// if (top == size - 1) {
// return true;
// }
// return false;
// }

// }

// class StackUsingLL {
// Node top;
// int size = 0;

// int size() {
// return size;
// }

// // insertion at head
// void push(int element) {
// Node n = new Node(element);
// size++;
// n.next = top;
// top = n;
// }

// // deletion at head
// int pop() throws Exception {
// if (top == null) {
// throw new Exception("'Stack Underflow");
// }
// int popped = top.data;
// top = top.next;
// size--;
// return popped;
// }

// void display() {
// Node temp = top;
// while (temp != null) {
// System.out.print(temp.data + " ");
// temp = temp.next;
// }
// System.out.println();
// }

// int peek() throws Exception {
// if (size == 0) {
// throw new Exception("'Stack Empty'");
// }
// return top.data;
// }
// }

// class Node {
// int data;
// Node next;

// Node(int data) {
// this.data = data;
// }
// }

// ----------------------->

// import java.util.*;
// import java.lang.*;
// import java.io.*;

// public class Main {
// // previous smaller element
// static void previousSmaller(int arr[], int n) {
// ArrayDeque<Integer> st = new ArrayDeque<>();
// int ans[] = new int[n];
// Arrays.fill(ans, -1);
// for (int i = 0; i < n; i++) {
// while (!st.isEmpty() && st.peek() >= arr[i]) {
// st.pop();
// }
// if (!st.isEmpty()) {
// ans[i] = st.peek();
// }
// st.push(arr[i]);
// }

// for (int i = 0; i < n; i++) {
// System.out.print(ans[i] + " ");
// }
// System.out.println();
// }

// // previous greater element
// static void previousGreater(int arr[], int n) {
// ArrayDeque<Integer> st = new ArrayDeque<>();
// int ans[] = new int[n];
// Arrays.fill(ans, -1);
// for (int i = 0; i < n; i++) {
// while (!st.isEmpty() && st.peek() <= arr[i]) {
// st.pop();
// }
// if (!st.isEmpty()) {
// ans[i] = st.peek();
// }
// st.push(arr[i]);
// }

// for (int i = 0; i < n; i++) {
// System.out.print(ans[i] + " ");
// }
// System.out.println();
// }

// // next smaller element
// static void nextSmaller(int arr[], int n) {
// ArrayDeque<Integer> st = new ArrayDeque<>();
// int ans[] = new int[n];
// Arrays.fill(ans, -1);
// for (int i = n - 1; i >= 0; i--) {
// while (!st.isEmpty() && st.peek() >= arr[i]) {
// st.pop();
// }
// if (!st.isEmpty()) {
// ans[i] = st.peek();
// }
// st.push(arr[i]);
// }

// for (int i = 0; i < n; i++) {
// System.out.print(ans[i] + " ");
// }
// System.out.println();
// }

// // next greater element
// static void nextGreater(int arr[], int n) {
// ArrayDeque<Integer> st = new ArrayDeque<>();
// int ans[] = new int[n];
// Arrays.fill(ans, -1);
// for (int i = n - 1; i >= 0; i--) {
// while (!st.isEmpty() && st.peek() <= arr[i]) {
// st.pop();
// }
// if (!st.isEmpty()) {
// ans[i] = st.peek();
// }
// st.push(arr[i]);
// }

// for (int i = 0; i < n; i++) {
// System.out.print(ans[i] + " ");
// }
// System.out.println();
// }

// public static void main(String[] args) throws java.lang.Exception {
// // your code here
// Scanner sc = new Scanner(System.in);
// int n = sc.nextInt();
// int arr[] = new int[n];
// for (int i = 0; i < n; i++) {
// arr[i] = sc.nextInt();
// }
// previousSmaller(arr, n);
// previousGreater(arr, n);
// nextSmaller(arr, n);
// nextGreater(arr, n);
// }
// }

/// Expression Evaluation----------->>>>>>>>>>
// import java.util.*;
// import java.lang.*;
// import java.io.*;

// public class Main {

// static int precedence(char c) {
// switch (c) {
// case '+':
// case '-':
// return 1;
// case '*':
// case '/':
// return 2;
// case '^':
// return 3;
// }
// return -1;
// }

// static String infixToPostfix(String s) {
// StringBuilder ans = new StringBuilder();
// Stack<Character> st = new Stack<>();
// for (int i = 0; i < s.length(); i++) {
// char c = s.charAt(i);
// if (c == '(') {
// st.push(c);
// } else if (c == ')') {
// while (!st.isEmpty() && st.peek() != '(') {
// ans.append(st.pop());
// }
// st.pop();
// } else if (c == '+' || c == '-' || c == '/' || c == '*' || c == '^') {
// while (!st.isEmpty() && precedence(c) <= precedence(st.peek())) {
// ans.append(st.pop());
// }
// st.push(c);
// } else {
// ans.append(c);
// }
// }
// while (!st.isEmpty()) {
// ans.append(st.pop());
// }
// return ans.toString();
// }

// static String infixToPrefix(String s) {
// StringBuilder ans = new StringBuilder();
// Stack<Character> st = new Stack<>();
// for (int i = s.length() - 1; i >= 0; i--) {
// char c = s.charAt(i);
// if (c == ')') {
// st.push(c);
// } else if (c == '(') {
// while (!st.isEmpty() && st.peek() != ')') {
// ans.append(st.pop());
// }
// st.pop();
// } else if (c == '+' || c == '-' || c == '/' || c == '*' || c == '^') {
// while (!st.isEmpty() && precedence(c) < precedence(st.peek())) {
// ans.append(st.pop());
// }
// st.push(c);
// } else {
// ans.append(c);
// }
// }
// while (!st.isEmpty()) {
// ans.append(st.pop());
// }
// return ans.reverse().toString();
// }

// static int evaluatePostfix(String s) {
// Stack<Integer> st = new Stack<>();
// for (int i = 0; i < s.length(); i++) {
// char c = s.charAt(i);
// if (Character.isDigit(c)) {
// st.push(c - '0');
// } else {
// int second = st.pop();
// int first = st.pop();
// st.push(calculate(first, second, c));
// }
// }
// return st.pop();
// }

// static int evaluatePrefix(String s) {
// Stack<Integer> st = new Stack<>();
// for (int i = s.length() - 1; i >= 0; i--) {
// char c = s.charAt(i);
// if (Character.isDigit(c)) {
// st.push(c - '0');
// } else {
// int first = st.pop();
// int second = st.pop();
// st.push(calculate(first, second, c));
// }
// }
// return st.pop();
// }

// static int calculate(int first, int second, char operator) {
// switch (operator) {
// case '+':
// return first + second;
// case '-':
// return first - second;
// case '*':
// return first * second;
// case '/':
// return first / second;
// case '^':
// return (int) Math.pow(first, second);
// }
// return -1;
// }

// static String postfixToInfix(String s) {
// Stack<String> st = new Stack<>();
// for (int i = 0; i < s.length(); i++) {
// char c = s.charAt(i);
// if (c == '+' || c == '-' || c == '/' || c == '*' || c == '^') {
// String op2 = st.pop();
// String op1 = st.pop();
// st.push("(" + op1 + c + op2 + ")");
// } else {
// st.push(c + "");
// }
// }
// return st.pop();
// }

// static String prefixToInfix(String s) {
// Stack<String> st = new Stack<>();
// for (int i = s.length() - 1; i >= 0; i--) {
// char c = s.charAt(i);
// if (c == '+' || c == '-' || c == '/' || c == '*' || c == '^') {
// String op1 = st.pop();
// String op2 = st.pop();
// st.push("(" + op1 + c + op2 + ")");
// } else {
// st.push(c + "");
// }
// }
// return st.pop();
// }

// static String postfixToPrefix(String s) {
// Stack<String> st = new Stack<>();
// for (int i = 0; i < s.length(); i++) {
// char c = s.charAt(i);
// if (c == '+' || c == '-' || c == '/' || c == '*' || c == '^') {
// String op2 = st.pop();
// String op1 = st.pop();
// st.push(c + op1 + op2);
// } else {
// st.push(c + "");
// }
// }
// return st.pop();
// }

// static String prefixToPostfix(String s) {
// Stack<String> st = new Stack<>();
// for (int i = s.length() - 1; i >= 0; i--) {
// char c = s.charAt(i);
// if (c == '+' || c == '-' || c == '/' || c == '*' || c == '^') {
// String op1 = st.pop();
// String op2 = st.pop();
// st.push(op1 + op2 + c);
// } else {
// st.push(c + "");
// }
// }
// return st.pop();
// }

// public static void main(String[] args) throws java.lang.Exception {
// // your code here
// Scanner sc = new Scanner(System.in);
// String s = sc.next();
// // System.out.println(infixToPostfix(s));
// // System.out.println(postfixToInfix(infixToPostfix(s)));
// // System.out.println(evaluatePostfix(infixToPostfix(s)));
// // System.out.println(infixToPrefix(s));
// // System.out.println(evaluatePrefix(infixToPrefix(s)));
// // System.out.println(prefixToInfix(infixToPrefix(s)));

// System.out.println(postfixToPrefix(infixToPostfix(s)));
// System.out.println(prefixToPostfix(infixToPrefix(s)));
// }
// }