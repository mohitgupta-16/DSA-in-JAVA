public class Array1 {

    public static int delete(int a[], int key) {
        int i = 0;
        int n = a.length;
        for (i = 0; i < n; i++) {
            if (a[i] == key) {
                break;
            }
        }
        if (i == n)
            return n;
        for (int j = i; j < n - 1; j++) {
            a[j] = a[j + 1];
        }
        return n - 1;
    }

    public static int largestElement(int a[]) {
        int n = a.length;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (a[i] > maxVal) {
                maxVal = a[i];
            }
        }
        return maxVal;
    }

    public static int secondLargestElement(int a[]) {
        if (a.length < 2) {
            return -1;
        }

        int largest = 0;
        int secondLargest = -1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[largest]) {
                secondLargest = largest;
                largest = i;
            } else if (a[i] < a[largest]) {
                if (secondLargest == -1 || a[i] > a[secondLargest]) {
                    secondLargest = i;
                }
            }
        }

        return a[secondLargest];
    }

    public static int thirdLargestElement(int a[]) {
        if (a.length < 3)
            return -1;

        int largest = 1;
        int secondLargest = -1;
        int thirdLargest = -1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[largest]) {
                secondLargest = largest;
                largest = i;
            } else if (a[i] < a[largest]) {
                if (secondLargest == -1 || a[i] > a[secondLargest]) {
                    secondLargest = i;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] < a[secondLargest]) {
                if (thirdLargest == -1 || a[i] > a[thirdLargest]) {
                    thirdLargest = i;
                }
            }
        }
        return a[thirdLargest];
    }

    public int smallestElement(int a[]) {
        int n = a.length;
        if (n == 1)
            return a[0];

        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (a[i] < minVal) {
                minVal = a[i];
            }
        }
        return minVal;
    }

    public static boolean checkSorted(int a[]) {
        int n = a.length;
        if (n == 1)
            return true;

        for (int i = 0; i < n - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void reverse(int a[]) {
        int n = a.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = temp;
        }
    }

    public static void replaceWithRightGreatest(int a[]) {
        int n = a.length;
        int rightMax = a[n - 1];
        a[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            int temp = a[i];
            a[i] = rightMax;

            if (temp > rightMax) {
                rightMax = temp;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 5, 1, 9 };
        // int key = 1;

        // // search for key
        // int idx = -1;
        // for (int i = 0; i < arr.length; i++) {
        // if (arr[i] == key) {
        // idx = i;
        // break;
        // }
        // }
        // if (idx == -1) {
        // System.out.println("Not Found");
        // } else {
        // System.out.println("Key is found at index: " + idx);
        // }

        // // delete an element from an array
        // int size = delete(arr, key);
        // System.out.println(size);

        // // largest element in an array
        // System.out.println(largestElement(arr));

        // // second largest element
        // System.out.println(secondLargestElement(arr));

        // // third largest element
        // System.out.println(thirdLargestElement(arr));

        // // smallest element in an array
        // System.out.println(smallestElement(arr));

        // // // check array is sorted
        // System.out.println(checkSorted(arr));

        // // reverse the array
        // reverse(arr);
        // int n = arr.length;
        // for (int i = 0; i < n; i++) {
        // System.out.print(arr[i] + " ");
        // }

        // replace every element with its right greatest element
        replaceWithRightGreatest(arr);
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
