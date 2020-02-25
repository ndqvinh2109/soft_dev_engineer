package com.se.algorithm.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithDistinctK {

    public static int solution(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();

        int windowStart = 0;
        int subCount = 0;

        for(int windowEnd = 0; windowEnd < A.length; windowEnd++) {

            if(!map.containsKey(A[windowEnd])) {
                map.put(A[windowEnd], 1);
            } else {
                map.put(A[windowEnd], map.get(A[windowEnd]) + 1);
            }

            while(map.size() > K) {
                map.put(A[windowStart], map.get(A[windowStart]) - 1);
                if(map.get(A[windowStart]) == 0) {
                    map.remove(A[windowStart]);
                }
                windowStart++;
            }
            int tempCount = windowStart;

            while(windowEnd - tempCount + 1 >= K && map.size() == K) {
                tempCount ++;
                subCount++;
            }

        }
        return subCount;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2,2,1,2,2};

        int subCount = solution(arr, 2);

        System.out.println(subCount);
    }

}
