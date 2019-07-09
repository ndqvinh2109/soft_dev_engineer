package com.se.algorithm.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {

    // Longest Substring with K Distinct Characters
    public static int findLength(String str, int k) {
        // TODO: Write your code here

        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        int windowStart = 0;
        int maxLength = 0;
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd ++) {

            if(!characterIntegerMap.containsKey(str.charAt(windowEnd))) {
                characterIntegerMap.put(str.charAt(windowEnd), 1);
            } else {
                characterIntegerMap.put(str.charAt(windowEnd), characterIntegerMap.get(str.charAt(windowEnd)) + 1);
            }

            while(characterIntegerMap.size() > k) {
                characterIntegerMap.put(str.charAt(windowStart), characterIntegerMap.get(str.charAt(windowStart)) - 1);
                if(characterIntegerMap.get(str.charAt(windowStart)) == 0) {
                    characterIntegerMap.remove(str.charAt(windowStart));
                }
                windowStart ++;
            }

            maxLength = Math.max(maxLength, windowEnd-windowStart+1);


        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
    }
}
