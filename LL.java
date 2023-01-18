// import java.util.*;
// import java.lang.*;
// import java.io.*;

// public class LL {

// static void printLL(Node head) {
// Node cur = head;
// while (cur != null) {
// System.out.print(cur.data + " ");
// cur = cur.next;
// }
// System.out.println("null");
// }

// static Node insertNode(int data, int position, Node head) {
// Node newNode = new Node(data);
// if (position == 0) {
// newNode.next = head;
// head = newNode;
// return head;
// }
// Node cur = head;
// for (int i = 0; i < position - 1; i++) {
// cur = cur.next;
// if (cur == null) {
// return head;
// }
// }
// newNode.next = cur.next;
// cur.next = newNode;
// return head;
// }

// static Node deleteNode(int position, Node head) {
// if (head == null) {
// return head;
// }
// if (position == 0) {
// head = head.next;
// return head;
// }
// Node cur = head;
// for (int i = 0; i < position - 1; i++) {
// cur = cur.next;
// }
// cur.next = cur.next.next;
// return head;
// }

// static Node deleteNode2(int element, Node head) {
// if (head == null) {
// return null;
// }
// if (head.data == element) {
// head = head.next;
// return head;
// }
// Node cur = head;
// while (cur.next != null && cur.next.data != element) {
// cur = cur.next;
// }
// if (cur.next == null) {
// return head;
// }
// cur.next = cur.next.next;
// return head;
// }

// static int findMiddleNode(Node head) {
// if (head == null) {
// return 0;
// }

// Node cur = head;
// int length = 0;
// while (cur != null) {
// cur = cur.next;
// length++;
// }
// Node temp = head;
// for (int i = 0; i < length / 2; i++) {
// temp = temp.next;
// }
// return temp.data;
// }

// static int findMiddleNode2(Node head) {
// if (head == null) {
// return 0;
// }
// Node slow = head;
// Node fast = head.next;

// while (fast != null && fast.next != null) {
// fast = fast.next.next;
// slow = slow.next;
// }
// return slow.data;
// }

// public static void main(String[] args) {
// Node n1 = new Node(10);
// Node n2 = new Node(20);
// Node n3 = new Node(30);
// Node n4 = new Node(40);
// Node n5 = new Node(50);
// Node n6 = new Node(60);

// Node head = n1;
// n1.next = n2;
// n2.next = n3;
// n3.next = n4;
// n4.next = n5;
// n5.next = n6;

// // Node head1 = new Node();
// // printLL(head1);
// head = insertNode(100, 0, head);
// printLL(head);
// head = deleteNode(0, head);
// head = deleteNode2(20, head);
// printLL(head);
// // System.out.println(findMiddleNode(head));
// // System.out.println(findMiddleNode2(head));
// }
// }

// class Node {
// int data;
// Node next;

// Node(int data) {
// this.data = data;
// }

// public Node() {
// }
// }

// // <<<<<<<<<<<<<<<<<-------------------------------------->>>>>>>

// // 4->5->6

// // 4<-5<-6 //reversing the linked list

// // int carry = 0;

// // Node curr = head;
// // Node l2 = null;
// // int flag = 1;
// // while(curr != null){
// // int val = curr.data + carry + flag;
// // l2.insert(val%10);
// // carry = val/10;
// // flag = 0;
// // }

// // if(carry >=1){
// // l2.insert(1);
// // }

// // 1<-0<-0<-0
// // 4<-5<-7

// // 4->5->7 //reversing again;
// // 1->0->0->0

// // 9->9->9

// // 0<-0<-0

// // carry = 1;

// // Scanner sc = new Scanner(System.in)

// // int x = sc.nextInt();
// // Node l1 = null;

// // public ListNode reverseList(ListNode head){
// // ListNode current=head;
// // ListNode previous=null;
// // while(current!=null){
// // ListNode temp=current.next;
// // current.next=previous;
// // previous=current;
// // current=temp;
// // }
// // return previous;
// // }
// import java.io.*;
// import java.util.*;

// class Node {
// int data;
// Node next;

// Node(int data) {
// this.data = data;
// next = null;
// }
// }

// class LinkedList {
// Node head;

// void add(int data) {
// Node new_node = new Node(data);
// if (head == null) {
// head = new_node;
// return;
// }
// Node current = head;
// while (current.next != null) {
// current = current.next;
// }
// current.next = new_node;
// }
// }

// public class LL {

// public static Node merge(Node list1, Node list2) {
// // list1 and list2 are the heads of respective LLs

// if (list1 == null)
// return list2;
// else if (list2 == null)
// return list1;

// // I want to assign the head correctly
// Node head;
// if (list1.data < list2.data) {
// head = list1;
// list1 = list1.next;
// } else { // if(list2.data <= list1.data)
// head = list2;
// list2 = list2.next;
// }
// Node temp = head; // it is going to point to the last inserted node in merged
// LL

// while (list1 != null && list2 != null) {
// // Which node to insert next
// if (list1.data < list2.data) {
// temp.next = list1;
// list1 = list1.next;
// temp = temp.next;
// } else {
// temp.next = list2;
// list2 = list2.next;
// temp = temp.next;
// }
// }

// if (list1 == null) {
// temp.next = list2;
// }
// if (list2 == null) {
// temp.next = list1;
// }
// return head;

// }

// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);
// int n = sc.nextInt();
// LinkedList l1 = new LinkedList();

// for (int i = 0; i < n; i++) {
// int x = sc.nextInt();
// l1.add(x);
// }

// int m = sc.nextInt();
// LinkedList l2 = new LinkedList();

// for (int i = 0; i < m; i++) {
// int x = sc.nextInt();
// l2.add(x);
// }

// Node head = merge(l1.head, l2.head);
// Node temp = head;
// while (temp != null) {
// System.out.print(temp.data + " ");
// temp = temp.next;
// }

// }
// }

// import java.util.*;
// import java.lang.*;
// import java.io.*;

// class LinkList {
// Node head;
// Node tail;

// void insertAtLast(int data) {
// Node newNode = new Node(data);
// if (head == null) {
// head = newNode;
// tail = newNode;
// return;
// }
// tail.next = newNode;
// tail = newNode;
// }
// }

// public class Main {

// static boolean compareLL(Node head1, Node head2) {
// if (head1 == null && head2 != null) {
// return false;
// }
// if (head2 == null && head1 != null) {
// return false;
// }
// if (head1 == null && head2 == null) {
// return true;
// }

// Node temp1 = head1, temp2 = head2;
// while (temp1 != null && temp2 != null) {
// if (temp1.data != temp2.data) {
// return false;
// }
// temp1 = temp1.next;
// temp2 = temp2.next;
// }
// return true;
// }

// static boolean compareLL2(Node head1, Node head2) {
// if (head1 == null && head2 == null) {
// return true;
// } else {
// if (head1.data != head2.data) {
// return false;
// }
// }
// return compareLL2(head1.next, head2.next);
// }

// public static void main(String[] args) throws java.lang.Exception {
// // your code here
// Scanner sc = new Scanner(System.in);
// int n = sc.nextInt();
// int m = sc.nextInt();
// LinkList l1 = new LinkList();
// for (int i = 0; i < n; i++) {
// l1.insertAtLast(sc.nextInt());
// }
// LinkList l2 = new LinkList();
// for (int i = 0; i < m; i++) {
// l2.insertAtLast(sc.nextInt());
// }
// if (n != m || l1.head.data != l2.head.data) {
// System.out.println(0);
// return;
// }
// if (compareLL2(l1.head, l2.head)) {
// System.out.println(1);
// } else {
// System.out.println(0);
// }
// }
// }

// class Node {
// int data;
// Node next;

// Node(int data) {
// this.data = data;
// }
// }
