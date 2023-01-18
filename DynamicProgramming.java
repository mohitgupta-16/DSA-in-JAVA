// <-----------------(0-1) KnapSack Problem------------------>

// import java.util.*;
// import java.lang.*;
// import java.io.*;

// public class Main {
// public static void main(String[] args) throws Exception {
// // your code here
// int val[] = { 15, 14, 10, 45, 30 };
// int wt[] = { 2, 5, 1, 3, 4 };
// int n = 5;
// int W = 7;

// // System.out.println(knapSackR(val, wt, W, n));

// // int dp[][] = new int[n + 1][W + 1];
// // // initalize all values with -1
// // for (int i = 0; i < n + 1; i++) {
// // for (int j = 0; j < W + 1; j++) {
// // dp[i][j] = -1;
// // }
// // }
// // System.out.println(knapsackMemo(val, wt, W, n, dp));

// System.out.println(knapsackTab(val, wt, W, n));

// }

// // recursive
// static int knapSackR(int val[], int wt[], int W, int n) {
// // base case
// // when number of items are 0 or weight of knapsack becomes 0
// // then no profit value possible so return 0
// if (n == 0 || W == 0) {
// return 0;
// }

// // now we have to check if current weight of item is valid for knapsack
// if (wt[n - 1] <= W) {
// // when valid we have choice
// // either to choose this item to get max profit or not

// // case 1 when we include the item and find for n-1 item
// int profit1 = knapSackR(val, wt, W - wt[n - 1], n - 1) + val[n - 1];
// // case 2 when we exclude the item
// int profit2 = knapSackR(val, wt, W, n - 1);
// // we have to return the maximum of profit of both cases
// return Math.max(profit1, profit2);
// }
// // when not valid we have no other option than excluding it
// else {
// return knapSackR(val, wt, W, n - 1);
// }
// }

// // memoization
// static int knapsackMemo(int val[], int wt[], int W, int n, int[][] dp) {
// // base case
// if (n == 0 || W == 0) {
// return 0;
// }

// if (dp[n][W] != -1) {
// return dp[n][W];
// }

// if (wt[n - 1] <= W) {
// int profit1 = knapsackMemo(val, wt, W - wt[n - 1], n - 1, dp) + val[n - 1];
// int profit2 = knapsackMemo(val, wt, W, n - 1, dp);
// dp[n][W] = Math.max(profit1, profit2);
// return dp[n][W];
// }
// // else case
// dp[n][W] = knapsackMemo(val, wt, W, n - 1, dp);
// return dp[n][W];
// }

// // tabulation
// static int knapsackTab(int val[], int wt[], int W, int n) {
// // create table
// int dp[][] = new int[n + 1][W + 1];

// // dp[i][j] meaning
// // i -> i number of items
// // j -> knapsack weight

// // initalize it with base case
// // when we have knapsack weight = 0 (j=0) return 0 profit
// // when we have item number = 0 (i=0) return 0 profit
// // if(i == 0 || j == 0){
// // dp[i][j] = 0;
// // }

// // fill table from bottom to up problems
// for (int i = 1; i < n + 1; i++) {
// for (int j = 1; j < W + 1; j++) {
// if (wt[i - 1] <= j) {
// dp[i][j] = Math.max(dp[i - 1][j - wt[i - 1]] + val[i - 1], dp[i - 1][j]);
// } else {
// dp[i][j] = dp[i - 1][j];
// }
// }
// }

// return dp[n][W];
// }
// }

// <--------------------Unbounded KnapSack----------------------->

// import java.util.*;
// import java.lang.*;
// import java.io.*;

// public class Main {
// public static void main(String[] args) throws Exception {
// // your code here
// int val[] = { 15, 14, 10, 45, 30 };
// int wt[] = { 2, 5, 1, 3, 4 };
// int n = 5;
// int W = 7;

// // System.out.println(unboundedKnapSackR(val, wt, W, n));

// // int dp[][] = new int[n + 1][W + 1];
// // // initalize all values with -1
// // for (int i = 0; i < n + 1; i++) {
// // for (int j = 0; j < W + 1; j++) {
// // dp[i][j] = -1;
// // }
// // }
// // System.out.println(unboundedKnapsackMemo(val, wt, W, n, dp));

// System.out.println(unboundedKnapsackTab(val, wt, W, n));

// }

// // recursive
// static int unboundedKnapSackR(int val[], int wt[], int W, int n) {
// // base case
// // when number of items are 0 or weight of knapsack becomes 0
// // then no profit value possible so return 0
// if (n == 0 || W == 0) {
// return 0;
// }

// // now we have to check if current weight of item is valid for knapsack
// if (wt[n - 1] <= W) {
// // when valid we have choice
// // either to choose this item to get max profit or not

// // case 1 when we include the item and find for n-1 item
// int profit1 = unboundedKnapSackR(val, wt, W - wt[n - 1], n) + val[n - 1];
// // case 2 when we exclude the item
// int profit2 = unboundedKnapSackR(val, wt, W, n - 1);
// // we have to return the maximum of profit of both cases
// return Math.max(profit1, profit2);
// }
// // when not valid we have no other option than excluding it
// else {
// return unboundedKnapSackR(val, wt, W, n - 1);
// }
// }

// // memoization
// static int unboundedKnapsackMemo(int val[], int wt[], int W, int n, int[][]
// dp) {
// // base case
// if (n == 0 || W == 0) {
// return 0;
// }

// if (dp[n][W] != -1) {
// return dp[n][W];
// }

// if (wt[n - 1] <= W) {
// int profit1 = unboundedKnapsackMemo(val, wt, W - wt[n - 1], n, dp) + val[n -
// 1];
// int profit2 = unboundedKnapsackMemo(val, wt, W, n - 1, dp);
// dp[n][W] = Math.max(profit1, profit2);
// return dp[n][W];
// }
// // else case
// dp[n][W] = unboundedKnapsackMemo(val, wt, W, n - 1, dp);
// return dp[n][W];
// }

// // tabulation
// static int unboundedKnapsackTab(int val[], int wt[], int W, int n) {
// // create table
// int dp[][] = new int[n + 1][W + 1];

// // dp[i][j] meaning
// // i -> i number of items
// // j -> knapsack weight

// // initalize it with base case
// // when we have knapsack weight = 0 (j=0) return 0 profit
// // when we have item number = 0 (i=0) return 0 profit
// // if(i == 0 || j == 0){
// // dp[i][j] = 0;
// // }

// // fill table from bottom to up problems
// for (int i = 1; i < n + 1; i++) {
// for (int j = 1; j < W + 1; j++) {
// if (wt[i - 1] <= j) {
// dp[i][j] = Math.max(dp[i][j - wt[i - 1]] + val[i - 1], dp[i - 1][j]);
// } else {
// dp[i][j] = dp[i - 1][j];
// }
// }
// }

// return dp[n][W];
// }
// }

// <------------------Subset Sum------------------------------>

// import java.util.*;
// import java.lang.*;
// import java.io.*;

// public class Main {
// public static void main(String[] args) throws Exception {
// // your code here
// int n = 6;
// int arr[] = { 3, 34, 4, 12, 5, 2 };
// int sum = 9;

// // System.out.println(isSubsetSumR(arr, n, sum));

// // for memoziation we have to declare Boolean type 2d array
// // Boolean dp[][] = new Boolean[n + 1][sum + 1];
// // for (int i = 0; i < n + 1; i++) {
// // for (int j = 0; j < sum + 1; j++) {
// // if (i == 0) {
// // dp[i][j] = false;
// // }
// // if (j == 0) {
// // dp[i][j] = true;
// // }
// // }
// // }
// // System.out.println(isSubsetSumMemo(arr, n, sum, dp));

// System.out.println(isSubsetSumTab(arr, n, sum));
// }

// // recursive
// static boolean isSubsetSumR(int arr[], int n, int sum) {
// // base case
// // when sum is 0 then all n values can form subset so return true
// if (sum == 0) {
// return true;
// }
// // when sum > 0 and n (values) is 0 then return false
// if (n == 0) {
// return false;
// }

// if (arr[n - 1] <= sum && isSubsetSumR(arr, n - 1, sum - arr[n - 1])) {
// return true;
// } else {
// return isSubsetSumR(arr, n - 1, sum);
// }
// }

// // memoization
// static Boolean isSubsetSumMemo(int arr[], int n, int sum, Boolean[][] dp) {
// if (sum == 0) {
// return true;
// }
// if (n == 0) {
// return false;
// }
// if (dp[n][sum] != null) {
// return dp[n][sum];
// }

// if (arr[n - 1] <= sum && isSubsetSumMemo(arr, n - 1, sum - arr[n - 1], dp) ==
// true) {
// dp[n][sum] = true;
// } else {
// dp[n][sum] = isSubsetSumMemo(arr, n - 1, sum, dp);
// }
// return dp[n][sum];
// }

// // tabulation
// static boolean isSubsetSumTab(int arr[], int n, int sum) {
// // create table
// boolean dp[][] = new boolean[n + 1][sum + 1];
// // dp[i][j] meaning
// // i -> i number of values
// // j -> j is target sum

// // initailse base cases
// for (int i = 0; i < n + 1; i++) {
// for (int j = 0; j < sum + 1; j++) {
// if (i == 0) {
// dp[i][j] = false;
// }
// if (j == 0) {
// dp[i][j] = true;
// }
// }
// }

// // fill tabele from bottom to top
// for (int i = 1; i < n + 1; i++) {
// for (int j = 1; j < sum + 1; j++) {
// if (arr[i - 1] <= j && dp[i - 1][j - arr[i - 1]] == true) {
// dp[i][j] = true;
// } else {
// dp[i][j] = dp[i - 1][j];
// }
// }
// }
// return dp[n][sum];
// }
// }

// <-------------------Equal sum subset partition--------------->

// import java.io.*;
// import java.util.*;

// public class Main {
// public static void main(String[] args) {
// // int arr[] = { 1, 4, 2, 5 };
// int arr[] = { 1, 3, 4, 2, 7 };

// System.out.println(twoEqualSubsets(arr));
// }

// static boolean twoEqualSubsets(int[] nums) {
// int n = nums.length;
// int sum = 0;
// for (int e : nums) {
// sum += e;
// }
// // when sum is odd
// // we cannot do partiton
// if (sum % 2 != 0) {
// return false;
// }
// // if we found sum/2 we can also find another sum/2
// sum /= 2;
// boolean dp[][] = new boolean[n + 1][sum + 1];
// // dp[i][j] meaning
// // i -> i number of elements of nums array
// // j -> target sum for i no of elements

// // base case
// // when sum = 0 we can find subset
// // when n = 0 we cannot find any subset with sum > 0
// for (int i = 0; i < n + 1; i++) {
// for (int j = 0; j < sum + 1; j++) {
// if (i == 0) {
// dp[i][j] = false;
// }
// if (j == 0) {
// dp[i][j] = true;
// }
// }
// }

// // fill table with smaller problems to big problems
// for (int i = 1; i < n + 1; i++) {
// for (int j = 1; j < sum + 1; j++) {
// // we check if cuurent element is contendor for being
// // in subset for sum = j
// if (nums[i - 1] <= j) {
// dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
// } else {
// dp[i][j] = dp[i - 1][j];
// }
// }
// }

// return dp[n][sum];
// }
// }

// <-----------------3. Longest Common Subsequence---------------->

// import java.util.*;
// import java.lang.*;
// import java.io.*;

// public class Main {
// public static void main(String[] args) throws Exception {
// // your code here
// Scanner sc = new Scanner(System.in);
// String str1 = "abcde";
// int n = str1.length();
// String str2 = "ace";
// int m = str2.length();
// // System.out.println(longestCommonSubsequenceR(str1, 5, str2, 3));

// // int dp[][] = new int[n + 1][m + 1];
// // for (int i = 0; i < n + 1; i++) {
// // for (int j = 0; j < m + 1; j++) {
// // dp[i][j] = -1;
// // }
// // }
// // System.out.println(longestCommonSubsequenceMemo(str1, n, str2, m, dp));

// System.out.println(longestCommonSubsequenceTab(str1, n, str2, m));
// }

// // Recursive Approach (Exponential Time Complexity)
// static int longestCommonSubsequenceR(String s1, int n, String s2, int m) {
// // base case
// // when size of any of string is equal to zero
// // then no possible common characters so return 0;
// if (n == 0 || m == 0) {
// return 0;
// }
// if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
// // when char for n len and char for m len in s1 and s2 are equal
// // it means we have found 1 common character so +1 and
// // find for n-1 len and m-1 len in s1 and s2
// return 1 + longestCommonSubsequenceR(s1, n - 1, s2, m - 1);
// } else {
// // if not equal we have choice
// // either find for n-1 in s1 and m for s2
// // or find for n in s1 and m-1 for s2
// // and return max of them
// int ans1 = longestCommonSubsequenceR(s1, n - 1, s2, m);
// int ans2 = longestCommonSubsequenceR(s1, n, s2, m - 1);
// return Math.max(ans1, ans2);
// }
// }

// // Memoization
// static int longestCommonSubsequenceMemo(String s1, int n, String s2, int m,
// int dp[][]) {
// if (n == 0 || m == 0) {
// return 0;
// }
// if (dp[n][m] != -1) {
// return dp[n][m];
// }
// if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
// dp[n][m] = 1 + longestCommonSubsequenceMemo(s1, n - 1, s2, m - 1, dp);
// } else {
// int ans1 = longestCommonSubsequenceMemo(s1, n - 1, s2, m, dp);
// int ans2 = longestCommonSubsequenceMemo(s1, n, s2, m - 1, dp);
// dp[n][m] = Math.max(ans1, ans2);
// }
// return dp[n][m];
// }

// // Tabulation
// static int longestCommonSubsequenceTab(String s1, int n, String s2, int m) {
// int dp[][] = new int[n + 1][m + 1];
// for (int i = 1; i < n + 1; i++) {
// for (int j = 1; j < m + 1; j++) {
// if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
// dp[i][j] = 1 + dp[i - 1][j - 1];
// } else {
// dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
// }
// }
// }
// return dp[n][m];
// }
// }

// <--------------Longest Common Substring---------------->

// import java.util.*;
// import java.lang.*;
// import java.io.*;

// public class Main {
// public static void main(String[] args) throws Exception {
// // your code here
// Scanner sc = new Scanner(System.in);
// String str1 = "abcde";
// int n = str1.length();
// String str2 = "abgce";
// int m = str2.length();
// System.out.println(longestCommonSubstringR(str1, 5, str2, 3, 0));

// int dp[][] = new int[n + 1][m + 1];
// for (int i = 0; i < n + 1; i++) {
// for (int j = 0; j < m + 1; j++) {
// dp[i][j] = -1;
// }
// }

// System.out.println(longestCommonSubstringTab(str1, n, str2, m));

// System.out.println(longestCommonSubstring(str1, n, str2, m));
// }

// // Recursive Approach (Exponential Time Complexity)
// static int longestCommonSubstringR(String s1, int n, String s2, int m, int
// count) {
// // base case
// // when size of any of string is equal to zero
// // then no possible common characters so return 0;
// if (n == 0 || m == 0) {
// return count;
// }

// // when equal increase the count by 1
// if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
// count = longestCommonSubstringR(s1, n - 1, s2, m - 1, count + 1);
// }

// // when not equal reset count to 0 and search for both cases and return max
// // count
// count = Math.max(count, Math.max(longestCommonSubstringR(s1, n, s2, m - 1,
// 0),
// longestCommonSubstringR(s1, n - 1, s2, m, 0)));
// return count;
// }

// // Tabulation
// static int longestCommonSubstringTab(String s1, int n, String s2, int m) {
// int dp[][] = new int[n + 1][m + 1];
// for (int i = 1; i < n + 1; i++) {
// for (int j = 1; j < m + 1; j++) {
// if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
// dp[i][j] = 1 + dp[i - 1][j - 1];
// } else {
// dp[i][j] = 0;
// }
// }
// }
// int ans = 0;
// for (int i = 1; i < n + 1; i++) {
// for (int j = 1; j < m + 1; j++) {
// ans = Math.max(ans, dp[i][j]);
// }
// }
// return ans;
// }

// // space optimized without dp
// static int longestCommonSubstring(String s1, int n, String s2, int m) {
// if (n == 0 || m == 0) {
// return 0;
// }
// int maxlen = 0;

// for (int i = 0; i < s1.length(); i++) {
// for (int j = i + 1; j < s1.length() + 1; j++) {
// if (s2.contains(s1.substring(i, j))) {
// maxlen = Math.max(maxlen, j - i);
// }
// }
// }
// return maxlen;
// }
// }

// <--------------------Print Longest Common Subsequence--------------->

// import java.util.*;
// import java.lang.*;
// import java.io.*;

// public class Main {
// public static void main(String[] args) throws Exception {
// // your code here
// String s1 = "abcdl";
// String s2 = "cdssls";

// int n = s1.length();
// int m = s2.length();

// int dp[][] = new int[n + 1][m + 1];
// for (int i = 1; i < n + 1; i++) {
// for (int j = 1; j < m + 1; j++) {
// if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
// dp[i][j] = 1 + dp[i - 1][j - 1];
// } else {
// dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
// }
// }
// }

// int i = n, j = m;
// // String ans = "";
// StringBuilder ans = new StringBuilder();
// while (i > 0 && j > 0) {
// if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
// // ans = s1.charAt(i - 1) + ans;
// ans.append(s1.charAt(i - 1));
// i--;
// j--;
// } else if (dp[i - 1][j] > dp[i][j - 1]) {
// i--;
// } else {
// j--;
// }
// }

// System.out.println(ans.reverse().toString());

// }
// }

// <------------------Shortest Common Supersequence----------------->

// import java.util.*;
// import java.lang.*;
// import java.io.*;

// public class Main {
// public static void main(String[] args) throws Exception {
// // your code here
// String s1 = "AGGTAB";
// String s2 = "GXTXATB";
// int n = s1.length();
// int m = s2.length();

// System.out.println(shortestCommonSupersequence(s1, s2, n, m));

// }

// public static int shortestCommonSupersequence(String X, String Y, int m, int
// n) {
// int dp[][] = new int[m + 1][n + 1];
// for (int i = 1; i < m + 1; i++) {
// for (int j = 1; j < n + 1; j++) {
// if (X.charAt(i - 1) == Y.charAt(j - 1)) {
// dp[i][j] = 1 + dp[i - 1][j - 1];
// } else {
// dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
// }
// }
// }

// // take lcs and subtract it from the addition of lengths of both strings

// return (m + n) - dp[m][n];
// }
// }

// <-----------------Print Shortest Common Supersequence------------------>

// import java.util.*;
// import java.lang.*;
// import java.io.*;

// public class Main {
// public static void main(String[] args) throws Exception {
// // your code here
// String s1 = "AGGTAB";
// String s2 = "GXTXATB";
// int n = s1.length();
// int m = s2.length();

// System.out.println(printShortestCommonSuperSequence(s1, n, s2, m));

// }

// static String printShortestCommonSuperSequence(String str1, int m, String
// str2, int n) {

// int[][] dp = new int[m + 1][n + 1];

// for (int i = 0; i <= m; i++) {
// for (int j = 0; j <= n; j++) {
// if (i == 0)
// dp[i][j] = j;
// else if (j == 0)
// dp[i][j] = i;
// else if (str1.charAt(i - 1) == str2.charAt(j - 1))
// dp[i][j] = 1 + dp[i - 1][j - 1];
// else
// dp[i][j] = 1 + Math.min(dp[i - 1][j],
// dp[i][j - 1]);
// }
// }

// int l = dp[m][n]; // Length of the ShortestSuperSequence
// char[] arr = new char[l];
// int i = m, j = n;
// while (i > 0 && j > 0) {
// /*
// * If current character in str1 and str2 are same, then
// * current character is part of shortest supersequence
// */
// if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
// arr[--l] = str1.charAt(i - 1);
// i--;
// j--;
// } else if (dp[i - 1][j] < dp[i][j - 1]) {
// arr[--l] = str1.charAt(i - 1);
// i--;
// } else {
// arr[--l] = str2.charAt(j - 1);
// j--;
// }
// }
// while (i > 0) {
// arr[--l] = str1.charAt(i - 1);
// i--;
// }
// while (j > 0) {
// arr[--l] = str2.charAt(j - 1);
// j--;
// }
// return new String(arr);
// }
// }

// <------------------Longest Increasing Subsequence---------------------->

// import java.util.*;
// import java.lang.*;
// import java.io.*;

// public class Main {
// public static void main(String[] args) throws Exception {
// // your code here
// int a[] = { 50, 3, 10, 7, 40, 80 };
// Set<Integer> set = new HashSet<>();
// for (int i : a) {
// set.add(i);
// }
// int b[] = new int[set.size()];
// int idx = 0;
// for (int num : set) {
// b[idx++] = num;
// }
// Arrays.sort(b);

// int dp[][] = new int[a.length + 1][b.length + 1];
// for (int i = 1; i < a.length + 1; i++) {
// for (int j = 1; j < b.length + 1; j++) {
// if (a[i - 1] == b[j - 1]) {
// dp[i][j] = 1 + dp[i - 1][j - 1];
// } else {
// dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
// }
// }
// }

// // System.out.println(dp[a.length][b.length]);

// // space optimized
// int Dp[] = new int[a.length];
// Arrays.fill(Dp, 1);

// int ans = 1;
// for (int i = 0; i < a.length; i++) {
// for (int j = 0; j < i; j++) {
// if (a[i] > a[j]) {
// Dp[i] = Math.max(Dp[i], 1 + Dp[j]);
// ans = Math.max(ans, Dp[i]);
// }
// }
// }

// System.err.println(ans);

// }
// }

// <---------------------Edit Distance---------------------------->

// import java.util.*;
// import java.lang.*;
// import java.io.*;

// public class Main {
// public static void main(String[] args) throws Exception {
// // your code here
// String s1 = "intention";
// String s2 = "execution";
// int n = s1.length();
// int m = s2.length();

// System.out.println(editDistanceR(s1, n, s2, m));
// System.out.println(editDistanceTab(s1, n, s2, m));

// }

// // Recursive
// static int editDistanceR(String s1, int n, String s2, int m) {
// if (m == 0) {
// return n;
// }

// if (n == 0) {
// return m;
// }

// if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
// return editDistanceR(s1, n - 1, s2, m - 1);
// } else {
// // when differnet there are three choices

// // 1. add
// int ans1 = editDistanceR(s1, n, s2, m - 1) + 1;
// // 2. delete
// int ans2 = editDistanceR(s1, n - 1, s2, m) + 1;
// // 3. replace
// int ans3 = editDistanceR(s1, n - 1, s2, m - 1) + 1;

// // take minimum of all three

// return Math.min(Math.min(ans1, ans2), ans3);
// }
// }

// // Tabulation
// static int editDistanceTab(String s1, int n, String s2, int m) {

// // create table
// int dp[][] = new int[n + 1][m + 1];
// // meaning
// // i -> length of s1
// // j -> length of s2
// // dp[i][j] means minimum no operations to convert s1 to s2

// // initialise the table

// for (int i = 0; i < n + 1; i++) {
// for (int j = 0; j < m + 1; j++) {
// // when len of s1 is 0
// // we need min operations equal to length of s2 (for adding)
// if (i == 0) {
// dp[i][j] = j;
// }
// // when len of s2 is 0
// // we need min operations equal to length of s1 (for deleting)
// if (j == 0) {
// dp[i][j] = i;
// }
// }
// }

// for (int i = 1; i < n + 1; i++) {
// for (int j = 1; j < m + 1; j++) {
// if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
// dp[i][j] = dp[i - 1][j - 1];
// } else {
// // add
// int ans1 = dp[i][j - 1] + 1;
// // delete
// int ans2 = dp[i - 1][j] + 1;
// // replace
// int ans3 = dp[i - 1][j - 1] + 1;
// dp[i][j] = Math.min(Math.min(ans1, ans2), ans3);
// }
// }
// }

// return dp[n][m];
// }
// }

// <--------------Longest Palindromice Subsequence------------------->

// import java.util.*;
// import java.lang.*;
// import java.io.*;

// public class Main {
// public static void main(String[] args) throws Exception {
// // your code here
// String s = "bbabcbcab";
// int n = s.length();

// // here we have 1 string in input
// // in question we have to find lps
// // in output we have to return int
// // so it matches with lcs 2/3

// // but here in input there is only 1 string

// // we will take second string to be the reverse of given string

// // LPS(a) == LCS(a,reverse(s))

// String t = new StringBuilder(s).reverse().toString();

// System.out.println(longestPalindromiceSubseqenceUsingLCS(s, t, n));
// }

// static int longestPalindromiceSubseqenceUsingLCS(String s, String t, int n) {
// int dp[][] = new int[n + 1][n + 1];

// for (int i = 1; i < n + 1; i++) {
// for (int j = 1; j < n + 1; j++) {
// if (s.charAt(i - 1) == t.charAt(j - 1)) {
// dp[i][j] = 1 + dp[i - 1][j - 1];
// } else {
// dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
// }
// }
// }

// return dp[n][n];
// }
// }

// <-----------Longest Repeating Subsequence---------->

// import java.util.*;
// import java.lang.*;
// import java.io.*;

// public class Main {
// public static void main(String[] args) throws Exception {
// // your code here
// String s = "aabbecdd";
// int n = s.length();

// int dp[][] = new int[n + 1][n + 1];

// for (int i = 1; i < n + 1; i++) {
// for (int j = 1; j < n + 1; j++) {
// just ignore when i == j
// if (s.charAt(i - 1) == s.charAt(j - 1) && i != j) {
// dp[i][j] = 1 + dp[i - 1][j - 1];
// } else {
// dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
// }
// }
// }

// for (int i = 0; i < n + 1; i++) {
// for (int j = 0; j < n + 1; j++) {
// System.out.print(dp[i][j] + " ");
// }
// System.out.println();
// }

// System.out.println(dp[n][n]);
// }
// }

// <------------------WildCard Matching------------------->

// import java.util.*;
// import java.lang.*;
// import java.io.*;

// public class Main {
// public static void main(String[] args) throws Exception {
// // your code here
// String s = "absdcs";
// String p = "??**";
// int n = s.length();
// int m = p.length();

// System.out.println(wildcardMatching(s, p, n, m));
// }

// static boolean wildcardMatching(String s, String p, int n, int m) {
// // create a table
// boolean dp[][] = new boolean[n + 1][m + 1];
// // meaning of dp[i][j]
// // i -> length of string s
// // j -> length of string p
// // dp[i][j] depicts if we can match string p to string s or not

// // intialize
// for (int i = 0; i < n + 1; i++) {
// for (int j = 0; j < m + 1; j++) {
// // when string p is empty we cannot match it with string s
// if (j == 0) {
// dp[i][j] = false;
// }
// // when string s is empty we have two cases
// // case 1 that j-1 char in string p is *
// // and we have to check for string p for length j - 1
// // case 2 when j-1 char in string p is not * then false
// if (i == 0 && j == 0) {
// dp[i][j] = true;
// } else if (i == 0) {
// if (p.charAt(j - 1) == '*') {
// dp[i][j] = dp[i][j - 1];
// } else {
// dp[i][j] = false;
// }
// }

// }
// }

// for (int i = 1; i < n + 1; i++) {
// for (int j = 1; j < m + 1; j++) {
// // now here we have '3' cases
// // case 1 when s.charAt(i-1) == p.charAt(j-1)
// // in this case we have found same pattern
// // so we will check for i-1 in string s and j-1 in string p lengths
// // case 2 when different means here also '3' cases
// // case 2.1 when p.charAt(j-1) == '?'
// // in this case we can consider ? to match the string
// // so we will check for i-1 in string s and j-1 in string p lengths
// // case 2.2 when p.charAt(j-1) == '*', here we have '2' cases
// // case 2.2.1 when we consider * to be empty
// // then we will search for i and j-1 lengths
// // case 2.2.2 when we use it so we keep it as we can use it further
// // then we will search for i-1 and j lengths
// // case 2.3 when p.charAt(j-1) is some character
// // so here we we set dp[i][j] = false

// if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
// dp[i][j] = dp[i - 1][j - 1];
// } else {
// if (p.charAt(j - 1) == '*') {
// dp[i][j] = dp[i - 1][j] | dp[i][j - 1];
// } else {
// dp[i][j] = false;
// }
// }
// }
// }

// return dp[n][m];
// }

// }

// <----------------Matrix Chain Multiplication----------------->

// import java.util.*;

// public class Main {
// public static void main(String[] args) throws Exception {
// /*
// * Matrix Chain Multiplication
// * arr[] = 1,2,3,4,3 Cost of multiplication:- a x b , b x d = a x b x d
// * Matrices: A1- 1x2, A2- 2x3, A3- 3x4, A4- 4x3
// * We have to find the order of multiplication of matrices
// * We have to search for k in i to j
// * i = 1 :- start point, j = n-1 :- end point
// * Loop for k is from i to k and k+1 to j
// * Possible values for k are k = i to k = j-1
// * Matrices Partition: A1 | A2 A3 A4; A1 A2 | A3 A4; A1 A2 A3 | A4
// * Matrices Partition: A1 |k| A2 A3 A4; A1 A2 |k| A3 A4; A1 A2 A3 |k| A4
// * We have to find the minimum cost in all partitions cost's
// */

// int arr[] = { 1, 2, 3, 4, 3 };
// int n = arr.length;

// int dp[][] = new int[n][n];
// for (int i = 0; i < n; i++) {
// Arrays.fill(dp[i], -1);
// }

// System.out.println(MatrixChainMultiplicationMemo(arr, 1, n - 1, dp));
// }

// static int MatrixChainMultiplicationR(int arr[], int i, int j) {

// // base case when single matrix is there
// if (i == j) {
// return 0;
// }

// int ans = Integer.MAX_VALUE;
// for (int k = i; k <= j - 1; k++) {

// // cost for multiplcating matrices in i to k
// int cost1 = MatrixChainMultiplicationR(arr, i, k);

// // cost for multiplcating matrices in k+1 to j
// int cost2 = MatrixChainMultiplicationR(arr, k + 1, j);

// // row of first matrix and col of sencond matrix
// int cost3 = arr[i - 1] * arr[k] * arr[j];

// // addition of all costs to multiply all matrices
// int finalCost = cost1 + cost2 + cost3;

// // storing minimum cost in all partitions
// ans = Math.min(ans, finalCost);
// }

// return ans;
// }

// // Memoization
// static int MatrixChainMultiplicationMemo(int arr[], int i, int j, int dp[][])
// {
// // base case when single matrix is there
// if (i == j) {
// return 0;
// }

// // answer is already stored
// if (dp[i][j] != -1) {
// return dp[i][j];
// }

// int ans = Integer.MAX_VALUE;
// for (int k = i; k <= j - 1; k++) {

// // cost for multiplcating matrices in i to k
// int cost1 = MatrixChainMultiplicationMemo(arr, i, k, dp);

// // cost for multiplcating matrices in k+1 to j
// int cost2 = MatrixChainMultiplicationMemo(arr, k + 1, j, dp);

// // row of first matrix and col of sencond matrix
// int cost3 = arr[i - 1] * arr[k] * arr[j];

// // addition of all costs to multiply all matrices
// int finalCost = cost1 + cost2 + cost3;

// // storing minimum cost in all partitions
// ans = Math.min(ans, finalCost);
// }

// return dp[i][j] = ans;
// }
// }

// <------------------Palindrome Partitioning----------------->

// import java.util.*;

// public class Main {
// public static void main(String[] args) throws Exception {
// String s = "ababbbabbababa";
// int n = s.length();

// int dp[][] = new int[n][n];
// for (int i = 0; i < n; i++) {
// Arrays.fill(dp[i], -1);
// }

// // System.out.println(palindromePartitioningR(s, 0, n - 1));

// System.out.println(palindromePartitioningMemo(s, 0, n - 1, dp));
// }

// static int palindromePartitioningR(String s, int i, int j) {
// // base case for empty string and string of length one
// if (i == j || isPalindrome(s, i, j)) {
// return 0;
// }

// int partitions = Integer.MAX_VALUE;
// for (int k = i; k <= j - 1; k++) {
// int cost1 = palindromePartitioningR(s, i, k);
// int cost2 = palindromePartitioningR(s, k + 1, j);
// int totalcost = 1 + cost1 + cost2;

// partitions = Math.min(partitions, totalcost);
// }

// return partitions;
// }

// // Memoization
// static int palindromePartitioningMemo(String s, int i, int j, int[][] dp) {
// // base case for empty string and string of length one
// if (i == j || isPalindrome(s, i, j)) {
// return 0;
// }

// if (dp[i][j] != -1) {
// return dp[i][j];
// }

// int partitions = Integer.MAX_VALUE;
// for (int k = i; k <= j - 1; k++) {
// int cost1 = palindromePartitioningMemo(s, i, k, dp);
// int cost2 = palindromePartitioningMemo(s, k + 1, j, dp);
// int totalcost = 1 + cost1 + cost2;

// partitions = Math.min(partitions, totalcost);
// }

// return dp[i][j] = partitions;
// }

// static boolean isPalindrome(String s, int i, int j) {
// while (i < j) {
// if (s.charAt(i) != s.charAt(j)) {
// return false;
// }
// i++;
// j--;
// }
// return true;
// }
// }
