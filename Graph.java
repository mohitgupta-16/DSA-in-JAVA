// import java.util.*;

// public class Main {

// static void createGraph(ArrayList<Edge> Graph[], int V) {

// // create list at every source node to sore its all neighbours(destinations)
// for (int i = 0; i < V; i++) {
// Graph[i] = new ArrayList<>();
// }

// // 0 vertex
// Graph[0].add(new Edge(0, 1, 1));
// Graph[0].add(new Edge(0, 2, 1));

// // 1 vertex
// Graph[1].add(new Edge(1, 0, 1));
// Graph[1].add(new Edge(1, 3, 1));

// // 2 vertex
// Graph[2].add(new Edge(2, 0, 1));
// Graph[2].add(new Edge(2, 4, 1));

// // 3 vertex
// Graph[3].add(new Edge(3, 1, 1));
// Graph[3].add(new Edge(3, 4, 1));
// Graph[3].add(new Edge(3, 5, 1));

// // 4 vertex
// Graph[4].add(new Edge(4, 2, 1));
// Graph[4].add(new Edge(4, 3, 1));
// Graph[4].add(new Edge(4, 5, 1));

// // 5 vertex
// Graph[5].add(new Edge(5, 3, 1));
// Graph[5].add(new Edge(5, 4, 1));
// Graph[5].add(new Edge(5, 6, 1));

// // 6 vertex
// Graph[6].add(new Edge(6, 5, 1));

// }

// static void breadthFirstSearch(ArrayList<Edge> Graph[], int V) {
// Queue<Integer> q = new LinkedList<>();

// // bool array to check if we have visited the current node or not
// boolean visited[] = new boolean[V];

// // add first source
// q.add(0);

// while (!q.isEmpty()) {
// // remove from front in queue
// int cur = q.remove();

// // check if it is already traversed or not
// if (!visited[cur]) {
// System.out.print(cur + " ");
// visited[cur] = true; // mark it visited

// // add all destinations(neighbours) of current node
// for (int i = 0; i < Graph[cur].size(); i++) {
// Edge e = Graph[cur].get(i);
// q.add(e.destination);
// }
// }
// }

// // time complexity will be O(V+E) V: No of nodes, E: No of edges

// }

// static boolean visited[] = new boolean[10001];

// static void depthFirstSearch(ArrayList<Edge> Graph[], int current, int V) {
// // base case when we traversed all nodes
// if (current == V) {
// return;
// }
// // first print current node
// System.out.print(current + " ");
// // and mark it visited
// visited[current] = true;

// // now reach to the 1st neighbour of current node
// for (int i = 0; i < Graph[current].size(); i++) {
// Edge e = Graph[current].get(i);
// // check if neighbour is visted or not and if not then visit it otherwise go
// to
// // next neighbour
// if (!visited[e.destination]) {
// depthFirstSearch(Graph, e.destination, V);
// }
// }

// // time complexity will be O(V+E) V: No of nodes, E: No of edges

// }

// public static void main(String[] args) throws Exception {
// // your code here

// int V = 7;
// // Graph is Array of type ArrayList
// ArrayList<Edge> Graph[] = new ArrayList[V];
// createGraph(Graph, V);

// breadthFirstSearch(Graph, V);
// System.out.println();
// depthFirstSearch(Graph, 0, V);

// }

// static class Edge {
// int source;
// int destination;
// int weight;

// Edge(int source, int destination, int weight) {
// this.source = source;
// this.destination = destination;
// this.weight = weight;
// }
// }
// }

// <------------------------------------------>

// import java.util.*;

// public class Main {
// public static void main(String[] args) throws Exception {
// // your code here
// int V = 5;
// GraphUsingMatrix graph = new GraphUsingMatrix(V);
// // GraphUsingAdjacencyList graph = new GraphUsingAdjacencyList(V);
// graph.addEdge(0, 1);
// graph.addEdge(0, 2);
// graph.addEdge(0, 3);
// graph.addEdge(2, 4);

// // List<Integer> list = graph.bfs();
// List<Integer> list = graph.dfs();

// System.out.println(list);

// }
// }

// class GraphUsingMatrix {
// int graph[][];
// int V;

// public GraphUsingMatrix(int V) {
// this.V = V;
// graph = new int[V][V];
// }

// public void addEdge(int source, int destination) {
// /*
// * 1. for undirected graph we have to do for vice versa
// * 2. but for directed graph we have to do for one of them
// */
// graph[source][destination] = 1;
// graph[destination][source] = 1;
// }

// public List<Integer> bfs() {
// List<Integer> list = new ArrayList<>();

// boolean visited[] = new boolean[V];

// Queue<Integer> q = new LinkedList<>();
// q.add(0);

// while (!q.isEmpty()) {
// int cur = q.poll();

// if (!visited[cur]) {
// visited[cur] = true;
// list.add(cur);
// for (int i = 0; i < graph[cur].length; i++) {
// if (graph[cur][i] == 1) {
// q.offer(i);
// }
// }
// }
// }

// return list;
// }

// public List<Integer> dfs() {
// List<Integer> list = new ArrayList<>();
// boolean visted[] = new boolean[V];

// dfsutil(0, visted, list);

// return list;
// }

// private void dfsutil(int current, boolean visted[], List<Integer> list) {
// if (current == V) {
// return;
// }
// visted[current] = true;
// list.add(current);

// for (int i = 0; i < graph[current].length; i++) {
// if (!visted[i] && graph[current][i] == 1) {
// dfsutil(i, visted, list);
// }
// }
// }
// }

// class GraphUsingAdjacencyList {
// ArrayList<ArrayList<Integer>> graph;
// int V;

// GraphUsingAdjacencyList(int V) {
// graph = new ArrayList<>();
// this.V = V;
// for (int i = 0; i < V; i++) {
// graph.add(new ArrayList<>());
// }
// }

// public void addEdge(int source, int destination) {
// graph.get(source).add(destination);
// graph.get(destination).add(source);
// }

// public List<Integer> bfs() {
// List<Integer> list = new ArrayList<>();
// boolean visted[] = new boolean[V];

// Queue<Integer> q = new LinkedList<>();
// q.offer(0);

// while (!q.isEmpty()) {
// int cur = q.poll();
// if (!visted[cur]) {
// visted[cur] = true;
// list.add(cur);
// for (int i = 0; i < graph.get(cur).size(); i++) {
// q.offer(graph.get(cur).get(i));
// }
// }
// }

// return list;
// }

// public List<Integer> dfs() {
// List<Integer> list = new ArrayList<>();
// boolean visited[] = new boolean[V];

// dfsutil(list, 0, visited);

// return list;
// }

// private void dfsutil(List<Integer> list, int current, boolean visted[]) {
// if (current == V) {
// return;
// }
// visted[current] = true;
// list.add(current);

// for (int i = 0; i < graph.get(current).size(); i++) {
// if (!visted[graph.get(current).get(i)]) {
// dfsutil(list, graph.get(current).get(i), visted);
// }
// }
// }

// }
