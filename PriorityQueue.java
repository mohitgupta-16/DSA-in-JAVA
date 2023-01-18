// import java.util.*;
// import java.lang.*;
// import java.io.*;

// class Main {
// public static void main(String[] args) throws Exception {
// // your code here
// Scanner sc = new Scanner(System.in);
// PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());
// pq.add(new Student("A", 7));
// pq.add(new Student("B", 3));
// pq.add(new Student("C", 2));
// pq.add(new Student("D", 17));
// pq.add(new Student("E", 10));

// while (!pq.isEmpty()) {
// System.out.println(pq.peek().name + " -> " + pq.peek().rank);
// pq.remove();
// }
// }
// }

// class Student implements Comparable<Student> {
// String name;
// int rank;

// Student(String name, int rank) {
// this.name = name;
// this.rank = rank;
// }

// public int compareTo(Student s) {
// return this.rank - s.rank;
// }
// }

// Heap Implementation
// import java.util.*;
// import java.lang.*;
// import java.io.*;

// public class Main {
// public static void main(String[] args) throws Exception {
// // your code here
// Scanner sc = new Scanner(System.in);
// Heap hp = new Heap();
// hp.add(3);
// hp.add(4);
// hp.add(1);
// hp.add(5);
// // hp.print();
// // hp.delete();
// // hp.print();
// while (!hp.isEmpty()) {
// System.out.println(hp.peek());
// hp.delete();
// }
// }
// }

// class Heap {
// ArrayList<Integer> heap = new ArrayList<>();
// int size;

// Heap() {
// size = 0;
// }

// int peek() {
// return heap.get(0);
// }

// void add(int element) {
// /*
// * 1. Add to the heap
// * 2. Fix the heap
// * if(child < parent) for min heap
// * swap (child, parent)
// */
// heap.add(element);
// int childIndex = size;
// // logn coz we are traversing through levels(we are going towards parents)
// while (childIndex != 0 && heap.get(childIndex) <
// heap.get(parent(childIndex))) {
// swap(childIndex, parent(childIndex));
// childIndex = parent(childIndex); // update the childIndex
// }
// size++;
// }

// // O(log n) as we are traversing levels from top to bottom
// void delete() {
// /*
// * 1. Swap rootIndex and lastIndex
// * 2. remove element at lastIndex
// * 3. fix the heap by using heapify function for root
// */
// if (size == 0) {
// return;
// }
// if (size == 1) {
// heap.remove(size - 1);
// size--;
// return;
// }

// swap(0, size - 1);
// heap.remove(size - 1);
// size--;
// heapify(0); // we will always call heapify for 0th index as we swap 0th and
// lastIndex
// }

// boolean isEmpty() {
// return size == 0;
// }

// int parent(int index) {
// return (index - 1) / 2;
// }

// void heapify(int index) {
// /*
// * 1. compare index, left(index), right(index) to get minimum
// * 2. swap(index, minindex)
// * 3. again heapify for minIndex
// */
// int minIndex = index;
// int leftIndex = 2 * index + 1;
// int rightIndex = 2 * index + 2;

// if (leftIndex < size && heap.get(leftIndex) < heap.get(minIndex)) {
// minIndex = leftIndex;
// }

// if (rightIndex < size && heap.get(rightIndex) < heap.get(minIndex)) {
// minIndex = rightIndex;
// }

// // if we minindex is not change then we will do nothing
// if (minIndex != index) {
// swap(minIndex, index);
// heapify(minIndex);
// }
// }

// void swap(int childIndex, int parentIndex) {
// int temp = heap.get(childIndex);
// heap.set(childIndex, heap.get(parentIndex));
// heap.set(parentIndex, temp);
// }

// void print() {
// System.out.println(heap);
// // for (int i : heap) {
// // System.out.print(i + " ");
// // }
// }
// }

// -----------------Heap Sort-------------------------------->
// import java.util.*;
// import java.lang.*;
// import java.io.*;

// public class Main {
// public static void main(String[] args) throws Exception {
// // your code here
// Scanner sc = new Scanner(System.in);
// int n = sc.nextInt();
// int arr[] = new int[n];
// for (int i = 0; i < n; i++) {
// arr[i] = sc.nextInt();
// }
// heapSort(arr, n);
// for (int i = 0; i < arr.length; i++) {
// System.out.print(arr[i] + " ");
// }
// }

// static void heapSort(int a[], int n) {
// /*
// * 1. Build maxheap for ascending and minheap for descending
// * 2. Push the root to the last and heapify upto n-1 and repeat
// */

// // we will start from non leaf nodes or the last level that is completely
// filled
// // n/2 will give us that level
// for (int i = n / 2; i >= 0; i--) {
// heapify(a, i, n);
// }

// for (int i = n - 1; i > 0; i--) {
// swap(a, 0, i);
// heapify(a, 0, i);
// }
// }

// static void heapify(int a[], int index, int size) {
// int maxIndex = index;
// int left = 2 * index + 1;
// int right = 2 * index + 2;

// if (left < size && a[left] > a[maxIndex]) {
// maxIndex = left;
// }

// if (right < size && a[right] > a[maxIndex]) {
// maxIndex = right;
// }

// if (maxIndex != index) {
// swap(a, maxIndex, index);
// heapify(a, maxIndex, size);
// }
// }

// static void swap(int a[], int i, int j) {
// int temp = a[i];
// a[i] = a[j];
// a[j] = temp;
// }
// }