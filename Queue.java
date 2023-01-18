// import java.util.*;
// import java.lang.*;
// import java.io.*;

// public class Main {
// public static void main(String[] args) throws Exception {
// // your code here
// Scanner sc = new Scanner(System.in);
// // QueueUsingLL queue = new QueueUsingLL();
// // queue.enqueue(1);
// // queue.enqueue(2);
// // queue.enqueue(3);
// // queue.enqueue(4);
// // System.out.println(queue.dequeue());
// // System.out.println(queue.dequeue());
// // queue.enqueue(0);
// // System.out.println(queue.dequeue());
// // System.out.println(queue.dequeue());
// // System.out.println(queue.size());

// QueueUsingCircularArray queue = new QueueUsingCircularArray(5);
// queue.enqueue(10);
// queue.enqueue(20);
// queue.enqueue(30);
// queue.enqueue(40);
// queue.enqueue(50);
// System.out.println(queue.isFull());
// System.out.println(queue.dequeue());
// System.out.println(queue.dequeue());
// System.out.println(queue.dequeue());
// System.out.println(queue.dequeue());
// System.out.println(queue.isFull());
// System.out.println(queue.dequeue());
// System.out.println(queue.isEmpty());

// // System.out.println(queue.getFront());

// queue.enqueue(10);
// queue.enqueue(20);
// queue.enqueue(30);
// queue.enqueue(40);
// queue.enqueue(50);
// System.out.println(queue.isFull());
// System.out.println(queue.dequeue());
// System.out.println(queue.dequeue());
// System.out.println(queue.dequeue());
// System.out.println(queue.dequeue());
// System.out.println(queue.isFull());
// System.out.println(queue.dequeue());
// System.out.println(queue.isEmpty());
// // System.out.println(queue.getFront());

// }
// }

// class Node {
// int data;
// Node next;

// Node(int data) {
// this.data = data;
// }
// }

// class QueueUsingLL {

// Node front;
// Node rear;
// private int size = 0;

// // insetion at end
// void enqueue(int element) {
// Node n = new Node(element);
// size++;
// if (front == null) {
// front = n;
// rear = n;
// return;
// }
// rear.next = n;
// rear = n;
// }

// // deletion at head
// int dequeue() throws Exception {
// if (front == null) {
// throw new Exception("'Queue is Empty'");
// }
// int element = front.data;
// front = front.next;
// size--;
// return element;
// }

// int size() {
// return size;
// }

// boolean isEmpty() {
// return front == null;
// }

// int getFront() throws Exception {
// if (front == null) {
// throw new Exception("'Queue is Empty'");
// }
// return front.data;
// }
// }

// class QueueUsingArray {
// private int front = -1;
// int rear = -1;
// private int arr[];
// int capacity;
// private int size = 0;

// QueueUsingArray(int length) {
// arr = new int[length];
// this.capacity = length;
// }

// void enqueue(int element) throws Exception {
// if (rear == capacity - 1) {
// throw new Exception("'Overflow'");
// }
// if (front == -1) {
// front++;
// arr[front] = element;
// }
// rear++;
// arr[rear] = element;
// size++;
// }

// // dequeue operation taking linear time
// int dequeue() throws Exception {
// if (size == 0) {
// throw new Exception("'UnderFlow'");
// }
// int element = arr[front]; // front always 0
// for (int i = 0; i < rear; i++) {
// arr[i] = arr[i + 1];
// }
// rear--;
// size--;
// return element;
// }

// boolean isEmpty() {
// return size == 0;
// }

// boolean isFull() {
// return size == capacity;
// }

// int getFront() throws Exception {
// if (front == -1) {
// throw new Exception("'Queue is Empty'");
// }
// return arr[front];
// }

// int size() {
// return size;
// }
// }

// class QueueUsingCircularArray {
// private int front;
// private int rear;
// private int arr[];
// private int capacity;
// private int size;

// QueueUsingCircularArray(int capacity) {
// front = -1;
// rear = -1;
// this.capacity = capacity;
// arr = new int[capacity];
// size = 0;
// }

// void enqueue(int element) throws Exception {
// if (size == capacity) {
// throw new Exception("'Queue is Full");
// }
// if (front == -1) {
// front++;
// }
// rear = (rear + 1) % capacity;
// arr[rear] = element;
// size++;
// }

// int dequeue() throws Exception {
// if (size == 0) {
// throw new Exception("'Queue is Empty");
// }
// int element = arr[front];
// if (front == rear) {
// size = 0;
// front = rear = -1;
// return element;
// }
// // front = (front + 1) % capacity;
// front++;
// size--;
// return element;
// }

// boolean isFull() {
// // return (rear+1) == front;
// return size == capacity;
// }

// boolean isEmpty() {
// return size == 0;
// }

// int getFront() throws Exception {
// if (size == 0) {
// throw new Exception("'Queue is Empty");
// }
// return arr[front];
// }

// int size() {
// return size;
// }
// }

// ------------------------------->>>>>>>>>>>>>>>

// import java.util.*;
// import java.lang.*;
// import java.io.*;

// public class Main {
// public static void main(String[] args) throws Exception {
// // your code here
// Scanner sc = new Scanner(System.in);
// QueueUsingTwoStack queue = new QueueUsingTwoStack();
// queue.enqueue(10);
// queue.enqueue(20);
// queue.enqueue(30);
// queue.enqueue(40);
// System.out.println(queue.size());
// System.out.println(queue.dequeue());
// System.out.println(queue.dequeue());
// System.out.println(queue.dequeue());
// System.out.println(queue.dequeue());
// System.out.println(queue.size());

// }
// }

// class QueueUsingTwoStack {
// Stack<Integer> st1;
// Stack<Integer> st2;
// int size;

// QueueUsingTwoStack() {
// st1 = new Stack<>();
// st2 = new Stack<>();
// size = 0;
// }

// void enqueue(int element) {
// st1.push(element);
// size++;
// }

// int dequeue() throws Exception {
// if (st1.isEmpty()) {
// throw new Exception("'Queue is Empty;");
// }
// while (!st1.isEmpty()) {
// size--;
// st2.push(st1.pop());
// }
// int element = st2.pop();
// while (!st2.isEmpty()) {
// size++;
// st1.push(st2.pop());
// }
// return element;
// }

// int size() {
// return size;
// }
// }