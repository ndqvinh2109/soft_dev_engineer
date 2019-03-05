package com.se.concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Permutation {

    static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    static String getPermutation(int n, int k) {

        List<Integer> v = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

        StringBuilder result = new StringBuilder();
        findPermutation(v, k, result);
        return result.toString();
    }

    private static void findPermutation(List<Integer> v, int k, StringBuilder result) {
        if (v.isEmpty()) return;

        int n = v.size();
        int count = factorial(n - 1);
        int selected = (k - 1) / count;
        result.append(v.get(selected));
        v.remove(selected);

        k = k - (count * selected);

        findPermutation(v, k, result);
    }

    public static void main(String[] args) {
        for (int i = 1; i <= factorial(4); i++) {
            System.out.println(i + " " + getPermutation(4, i).toString());
        }
    }

}
