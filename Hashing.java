// import java.util.*;
// import java.lang.*;
// import java.io.*;

// public class Main {
// static boolean containsDuplicates(int arr[], int n) {
// // <---------Brute Force Approach---------->
// // sort the array & run a loop & check if adjacent element is equal or not
// // TC - O(nlogn) SC - O(1)
// // Arrays.sort(arr);
// // for (int i = 0; i < n - 1; i++) {
// // if (arr[i] == arr[i + 1]) {
// // return true;
// // }
// // }
// // return false;

// // <----------Optimised Approach----------->
// // create a set & add all elements in set & compare size of array & set
// // TC - O(n) SC - O(n)
// Set<Integer> set = new HashSet<>();
// for (int i : arr) {
// set.add(i);
// }
// return set.size() != arr.length;
// }

// public static void main(String[] args) throws java.lang.Exception {
// // your code here
// Scanner sc = new Scanner(System.in);
// int n = sc.nextInt();
// int arr[] = new int[n];
// for (int i = 0; i < n; i++) {
// arr[i] = sc.nextInt();
// }
// System.out.println(containsDuplicates(arr, n));
// }
// }

// --------------------

// public class Main {
// public static void main(String[] args) throws java.lang.Exception {
// // your code here
// Scanner sc = new Scanner(System.in);
// int sSize = sc.nextInt();
// String s = sc.next();
// int pSize = sc.nextInt();
// String p = sc.next();

// List<Integer> ans = findAllAnagrams(s, p, sSize, pSize);
// for (int i : ans) {
// System.out.print(i + " ");
// }
// }

// static List<Integer> findAllAnagrams(String s, String p, int slen, int plen)
// {
// // creating ans list to return ans indicies
// List<Integer> ans = new ArrayList<>();
// // if length of string p is greater than string s then ans dont exist
// if (p.length() > s.length()) {
// return ans;
// }
// // creating freq array for both string's characters upto string p length
// // beacuse we have to search anagrams for string p in string s
// int pfreqency[] = new int[26];
// for (int i = 0; i < plen; i++) {
// pfreqency[p.charAt(i) - 'a']++;
// }
// int sfreqency[] = new int[26];
// for (int i = 0; i < plen; i++) {
// sfreqency[s.charAt(i) - 'a']++;
// }
// // now traversing in string s in plen window to search matching anagrams
// if (Arrays.equals(sfreqency, pfreqency)) {// when we get anagram at 0 idx
// ans.add(0);
// }
// for (int i = plen; i < slen; i++) {
// // incrementing from new window
// sfreqency[s.charAt(i) - 'a']++;
// // decrementing from prev window
// sfreqency[s.charAt(i - plen) - 'a']--;
// if (Arrays.equals(sfreqency, pfreqency)) {
// ans.add(i - plen + 1);
// }
// }
// return ans;
// }
// }

// <--------------- Pair sum divisible by K------>

// public class Main {
// static int findPairDivisbileByK(int arr[], int n, int k) {
// // <---------brute force approach------>
// // int count = 0;
// // for (int i = 0; i < n; i++) {
// // for (int j = i + 1; j < n; j++) {
// // if ((arr[i] + arr[j]) % k == 0) {
// // count++;
// // }
// // }
// // }
// // return count;

// // <------------Optimised Approach--------->
// int count = 0;
// Map<Integer, Integer> map = new HashMap<>();
// for (int i : arr) {
// int remainder = i % k;
// if (remainder != 0) {
// count += map.getOrDefault(k - remainder, 0);
// } else {
// count += map.getOrDefault(0, 0);
// }
// map.put(remainder, map.getOrDefault(remainder, 0) + 1);
// }
// return count;
// }

// public static void main(String[] args) throws java.lang.Exception {
// // your code here
// Scanner sc = new Scanner(System.in);
// int n = sc.nextInt();
// int k = sc.nextInt();
// int arr[] = new int[n];
// for (int i = 0; i < n; i++) {
// arr[i] = sc.nextInt();
// }
// System.out.println(findPairDivisbileByK(arr, n, k));
// }
// }

// <----------------------------->
// --------->Subarray sum divisible by k--------------->

// public class Main {
// static int subarraysDivByK(int a[], int n, int k) {
// // <---------Brute Force Approach--------->
// // int count = 0;
// // for (int i = 0; i < n; i++) {
// // int sum = 0;
// // for (int j = i; j < n; j++) {
// // sum += a[j];
// // if (sum % k == 0) {
// // count++;
// // }
// // }
// // }
// // return count;

// // <-----------Optmized Approach---------->
// // k size beacuse there can be 0 to k-1 posssible remainders
// int map[] = new int[k];
// map[0] = 1;// if remainder is zero then we have to increae the count
// int count = 0;
// int sum = 0;
// for (int e : a) {
// sum += e;
// int remainder = sum % k;
// // if remainder is negative then its complementary positve will be
// remainder+k
// if (remainder < 0) {
// remainder += k;
// }
// count += map[remainder];
// map[remainder]++;
// }
// return count;
// }

// public static void main(String[] args) throws java.lang.Exception {
// // your code here
// Scanner sc = new Scanner(System.in);
// int n = sc.nextInt();
// int k = sc.nextInt();
// int a[] = new int[n];
// for (int i = 0; i < n; i++) {
// a[i] = sc.nextInt();
// }
// System.out.println(subarraysDivByK(a, n, k));
// }
// }

// <---------Count pairs with given Sum------->

// public class Main {
// static int countPairsWithSumK(int arr[], int n, int k) {
// // <---------Brute Force Appraoch----->
// // Consider all possible pairs and check their sums
// // for (int i = 0; i < n; i++)
// // for (int j = i + 1; j < n; j++)
// // if (arr[i] + arr[j] == sum)
// // count++;
// // return count;

// // <---------Optimized Appraoch------>
// Map<Integer, Integer> map = new HashMap<>();
// int count = 0;
// for (int e : arr) {
// if (map.containsKey(k - e)) {
// count += map.get(k - e);
// }
// map.put(e, map.getOrDefault(e, 0) + 1);
// }
// return count;
// }

// public static void main(String[] args) throws java.lang.Exception {
// // your code here
// Scanner sc = new Scanner(System.in);
// int n = sc.nextInt();
// int arr[] = new int[n];
// for (int i = 0; i < n; i++) {
// arr[i] = sc.nextInt();
// }
// int k = sc.nextInt();
// System.out.println(countPairsWithSumK(arr, n, k));
// }
// }

// <-------------Count distinct pairs with difference k------->

// public class Main {
// static int countPairsWithDiffK(int arr[], int n, int k) {
// // <---------Brute Force Appraoch----->
// // Consider all possible pairs and check their sums
// // int count = 0;
// // for (int i = 0; i < n; i++)
// // for (int j = i + 1; j < n; j++)
// // if (arr[i] - arr[j] == k || arr[j] - arr[i] == k)
// // count++;
// // return count;

// // <---------Optimized Appraoch------>
// Map<Integer, Integer> map = new HashMap<>();
// int count = 0;
// for (int e : arr) {
// map.put(e, map.getOrDefault(e, 0) + 1);
// }
// for (int e : map.keySet()) {
// // we can check for either e+k or e-k
// // for k == 0 map.get(e) > 1 coz if 1 then it will count all
// if ((k > 0 && map.containsKey(e + k)) || (k == 0 && map.get(e) > 1)) {
// count++;
// }
// }
// return count;
// }

// public static void main(String[] args) throws java.lang.Exception {
// // your code here
// Scanner sc = new Scanner(System.in);
// int n = sc.nextInt();
// int k = sc.nextInt();
// int arr[] = new int[n];
// for (int i = 0; i < n; i++) {
// arr[i] = sc.nextInt();
// }
// System.out.println(countPairsWithDiffK(arr, n, k));
// }
// }

// <-------------Longest Subarray of sum K------------------->

// public class Main {
// static int longestSubArraySumK(int arr[], int n, int k) {
// // <------Brute force--------->
// // int maxlen = 0;
// // for (int i = 0; i < n; i++) {
// // int sum = 0;
// // int curlen = 0;
// // for (int j = i; j < n; j++) {
// // sum += arr[j];
// // if (sum == k) {
// // curlen = j - i + 1;
// // maxlen = Math.max(maxlen, curlen);
// // }
// // }
// // }
// // return maxlen;

// // <-------Optimized approach--------->
// // int maxlen = 0;
// // Map<Integer, Integer> map = new HashMap<>();
// // int sum = 0;
// // for (int i = 0; i < n; i++) {
// // sum += arr[i];
// // if (sum == k) {
// // maxlen = Math.max(maxlen, i + 1);
// // }
// // if (map.containsKey(sum - k)) {
// // maxlen = Math.max(maxlen, i - map.get(sum - k));
// // }
// // if (!map.containsKey(sum)) {
// // map.put(sum, i);
// // }
// // }
// // return maxlen;

// // <------Sliding window for +ve--------->
// int maxlen = 0;
// int start = 0;
// int end = 0;
// int sum = 0;
// while (end < n) {
// sum += arr[end];
// if (sum > k) {
// while (sum > k) {
// sum -= arr[start];
// start++;
// }
// if (sum == k) {
// maxlen = Math.max(maxlen, end - start + 1);
// }
// } else {
// maxlen = Math.max(maxlen, end - start + 1);
// }
// end++;
// }
// return maxlen;
// }

// public static void main(String[] args) throws java.lang.Exception {
// // your code here
// Scanner sc = new Scanner(System.in);
// int n = sc.nextInt();
// int k = sc.nextInt();
// int arr[] = new int[n];
// for (int i = 0; i < n; i++) {
// arr[i] = sc.nextInt();
// }
// System.out.println(longestSubArraySumK(arr, n, k));
// }
// }
// --------------------------------->>>>>>>>>
// import java.util.*;
// import java.io.*;

// class Solution {
// public List<List<Integer>> fourSum(int[] nums, int target) {
// int n = nums.length;
// List<List<Integer>> ans = new ArrayList<>();
// Arrays.sort(nums);
// for (int i = 0; i < n - 3; i++) {
// for (int j = i; j < n - 2; j++) {
// int key = target - nums[i] - nums[j];
// int k = j + 1;
// int l = n - 1;
// while (k < l) {
// if (nums[k] + nums[l] < key) {
// k++;
// } else if (nums[k] + nums[l] > key) {
// l--;
// } else { // nums[k] + nums[l] == key
// List<Integer> list = new ArrayList<>();
// list.add(nums[i]);
// list.add(nums[j]);
// list.add(nums[k]);
// list.add(nums[l]);
// ans.add(list);
// while (k < l && nums[k] == nums[k + 1])
// k++;
// while (k < l && nums[l] == nums[l - 1])
// l--;
// k++;
// l--;
// }
// }
// while (j + 1 < n && nums[j] == nums[j + 1])
// j++;
// }
// while (i + 1 < n && nums[i] == nums[i + 1])
// i++;
// }
// return ans;
// }

// }

// public class Main {
// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);
// int n;
// n = sc.nextInt();
// int[] nums = new int[n];
// for (int i = 0; i < n; i++)
// nums[i] = sc.nextInt();
// int k = sc.nextInt();
// Solution Obj = new Solution();
// List<List<Integer>> res = Obj.fourSum(nums, k);
// for (int i = 0; i < res.size(); i++) {
// for (int j = 0; j < 4; j++) {
// System.out.print(res.get(i).get(j) + " ");
// }
// System.out.println("");
// }
// sc.close();
// }
// }