package com.se.algorithm.SlidingWindow;

public class MaxSumSubArrayOfSizeK {

    //Maximum Sum Subarray of Size K
    // Time: O(n), Space: O(1)
    public static int findMaxSumSubArray(int k, int[] arr) {
        int sum = 0;
        int windowStart = 0;
        int max = Integer.MIN_VALUE;

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            sum += arr[windowEnd];

            if (windowEnd >= k - 1) {
                if(max < sum) {
                    max = sum;
                }
                sum -= arr[windowStart];
                windowStart++;
            }
        }
        // TODO: Write your code here
        return max;
    }

    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
    }
}
