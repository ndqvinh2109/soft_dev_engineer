package com.se.algorithm;

import java.util.*;
import java.util.stream.Collectors;

public class DBSTest {

    public static List<String> missingWords(String s, String t) {
        // Write your code here
        List<String> result = new ArrayList<>();
        String[] s1 = s.split("\\s");
        String[] s2 = t.split("\\s");

        Map<String, Integer> maps = new HashMap<>();

        for (String c2 : s2) {
            Integer count = maps.get(c2);
            if (count == null) {
                maps.put(c2, 1);
            } else {
                maps.put(c2, count + 1);
            }
        }

        for (String c1 : s1) {
            Integer count = maps.get(c1);
            if (count == null || count == 0) {
                result.add(c1);
            } else {
                maps.put(c1, count - 1);
            }
        }

        return result;
    }

    public static int solution(int X, int Y, int D) {
        // write your code in Java SE 8
        int total = X;
        int count = 0;
        int A[];



        while(total < Y) {
            total += D;
            count ++;
        }

        return count;

    }

    public int solution2(int[] A) {
        // write your code in Java SE 8
        int total = 1;
        int totalNext = 1;

        for (int i = 0; i < A.length; i++) {
            totalNext += 1;
            total += totalNext;
        }

        List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
        Integer sum = list.stream().reduce(0, Integer::sum);

        int minus = total - sum;

        return minus;
    }

    public static int solution3(int[] A) {
        // write your code in Java SE 8

        int length = A.length;
        int index = 0;
        int firstSum = 0;
        int secondSum = 0;

        int[] array = new int[length -1];

        for(int i = 0; i < length; i++) {
            if(index == length - 1) break;
            int t = 0;
            while(t <= index) {
                firstSum += A[t];
                t++;
            }

            index++;
            int j = index;

            while (j < length) {
                secondSum += A[j];
                j++;
            }


            int minus = Math.abs(firstSum - secondSum);

            array[i] = minus;
            firstSum = 0;
            secondSum = 0;

        }

        for(int a: array) {
            System.out.println(a);
        }


        int min = Arrays.stream(array).min().getAsInt();

        return min;
    }


    public static int solution4(int[] A) {
        // write your code in Java SE 8

        // write your code in Java SE 8
        int total = 0;

        for (int i = 1; i <= A.length; i++) {

            total += i;

        }

        List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
        Integer sum = list.stream().reduce(0, Integer::sum);

        int minus = total - sum;


        return minus == 0 ? 1: 0;

    }


    public static void reArrange(int[] arr) {

        int[] result = new int[arr.length];
        int index = 0;

        for(int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }

        for(int i = 0; i< arr.length; i++) {
            if(arr[i] < 0) {
                arr[index] = result[i];
                index++;
            }
        }

        for(int i = 0; i < arr.length; i++) {
            if(result[i] >= 0) {
                arr[index] = result[i];
                index++;
            }

        }
        //Write - Your - Code
    }


    public static void main(String[] args) {
        String s = "I am using am HackerRank to improve programming";
        String t = "am using";

       // missingWords(s,t);

        //System.out.println(missingWords(s,t));

        //System.out.println(solution(10,85,30));

        //int[] arr = new int[] {4, 1, 3, 2};

        //System.out.println(solution4(arr));

        int[] arr = new int[] {10,-1,20,4,5,-9,-6};
        reArrange(arr);
        //System.out.println(arr[0]);


    }

}
