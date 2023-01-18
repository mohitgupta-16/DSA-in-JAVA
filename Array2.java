import java.util.Arrays;

public class Array2 {

    static void leadersInArray(int a[]) {
        int n = a.length;
        int temp[] = new int[n];
        int j = 0;
        temp[0] = a[n - 1];
        int maxVal = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] >= maxVal) {
                maxVal = a[i];
                // System.out.print(a[i] + " ");
                temp[j++] = a[i];
            }
        }

        for (j = j - 1; j >= 0; j--) {
            System.out.print(temp[j] + " ");
        }
    }

    static int maxSumSubarray(int a[]) {
        int n = a.length;
        int ans = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = 0; i < n; i++) {
            currSum += a[i];
            if (currSum > ans) {
                ans = currSum;
            }
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return ans;
    }

    static int minSumSubarray(int a[]) {
        int n = a.length;
        int ans = Integer.MAX_VALUE;
        int currSum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (currSum > 0) {
                currSum = a[i];
            } else {
                currSum += a[i];
            }

            if (ans > currSum) {
                ans = currSum;
            }
        }
        return ans;
    }

    static void printMaxSumSubarray(int a[]) {
        int n = a.length;
        int ans = Integer.MIN_VALUE;
        int currSum = 0;
        int start = 0;
        int end = 0;
        int ansStart = 0;

        for (int i = 0; i < n; i++) {
            currSum += a[i];
            if (currSum < 0) {
                currSum = 0;
                ansStart = i;
            }

            if (ans < currSum) {
                ans = currSum;
                start = ansStart + 1;
                end = i;
            }
        }

        for (int i = start; i <= end; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static void printMinSumSubarray(int a[]) {
        int n = a.length;
        int ans = Integer.MAX_VALUE;
        int currSum = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int ansStart = 0;

        for (int i = 0; i < n; i++) {
            if (currSum > 0) {
                currSum = a[i];
                ansStart = i;
            } else {
                currSum += a[i];
            }

            if (ans > currSum) {
                ans = currSum;
                start = ansStart;
                end = i;
            }
        }
        for (int i = start; i <= end; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static int maxWaterContainer(int a[]) {
        int n = a.length;
        if (n == 1) {
            return 0;
        }
        int l = 0;
        int r = n - 1;
        int area = 0;
        int maxArea = Integer.MIN_VALUE;

        while (l < r) {
            int height = Math.min(a[l], a[r]);
            int width = r - l;

            area = height * width;
            maxArea = Math.max(area, maxArea);

            if (a[l] < a[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }

    static int maxWaterTrapped(int a[]) {
        int n = a.length;
        int l[] = new int[n];
        int r[] = new int[n];
        int ans = 0;

        l[0] = a[0];
        for (int i = 1; i < n; i++) {
            l[i] = Math.max(a[i], l[i - 1]);
        }
        r[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            r[i] = Math.max(a[i], r[i + 1]);
        }

        for (int i = 0; i < n; i++) {
            ans += Math.min(l[i], r[i]) - a[i];
        }

        return ans;
    }

    static int maxWaterTrapped2(int a[]) {
        int n = a.length;
        int start = 0;
        int end = n - 1;
        int leftMax = 0;
        int rightMax = 0;
        int ans = 0;

        while (start <= end) {
            if (a[start] < a[end]) {
                if (a[start] > leftMax) {
                    leftMax = a[start];
                } else {
                    ans += leftMax - a[start];
                }
                start++;
            } else {
                if (a[end] > rightMax) {
                    rightMax = a[end];
                } else {
                    ans += rightMax - a[end];
                }
                end--;
            }
        }
        return ans;
    }

    static void printFrequencyOfElementsInArray(int a[]) {
        int n = a.length;
        boolean temp[] = new boolean[n];
        Arrays.fill(temp, false);
        for (int i = 0; i < n; i++) {
            if (temp[i] == true) {
                continue;
            }
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (a[i] == a[j]) {
                    temp[j] = true;
                    count++;
                }
            }
            System.out.println(a[i] + ": " + count + " times");
        }
    }

    static int lenghtOfConsecutiveOnes(int a[]) {
        int n = a.length;
        int ans = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 1) {
                count++;
            } else {
                ans = Math.max(count, ans);
                count = 0;
            }
        }
        ans = Math.max(count, ans);
        return ans;
    }

    static void moveZerosToEnd(int a[]) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] != 0) {
                a[count++] = a[i];
            }
        }

        while (count < n) {
            a[count++] = 0;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static void pushZerosToEnd(int a[]) {
        int n = a.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] != 0) {
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
                j++;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 16, 17, 4, 3, 5, 2 };

        // // leaders in an array
        leadersInArray(arr);

        // int arr[] = { 6, -7, 4, -2, 1, 5, -4 };

        // // maximum sum subarray (kadane's algo)
        // System.out.println(maxSumSubarray(arr));

        // // print max sum subarray
        // printMaxSumSubarray(arr);

        // // minimum sum subarray
        // System.out.println(minSumSubarray(arr));

        // // print min sum subarray
        // printMinSumSubarray(arr);

        // // max water container
        // int arr[] = { 1, 8, 6, 2, 4, 5, 8, 3, 7 };
        // System.out.println(maxWaterContainer(arr));

        // // max water trapped
        // int ar[] = { 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        // System.out.println(maxWaterTrapped(arr));
        // System.out.println(maxWaterTrapped2(ar));

        // // count frequency of elements in an array
        // int arr[] = { 10, 20, 20, 10, 10, 20, 5, 20 };
        // printFrequencyOfElementsInArray(arr);

        // // longest length of consecutive ones
        // int arr[] = { 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1 };
        // System.out.println(lenghtOfConsecutiveOnes(arr));

        // // move all zeros to end of array
        // int arr[] = { 8, 0, 1, 3, 0, 0, 5 };
        // int n = arr.length;
        // for (int i = 0; i < n; i++) {
        // System.out.print(arr[i] + " ");
        // }
        // System.out.println();
        // moveZerosToEnd(arr);
        // pushZerosToEnd(arr);

        //
    }
}
