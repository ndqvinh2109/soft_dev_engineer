package com.se.algorithm.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {

    // Longest Substring with K Distinct Characters
    public static int findLength(String str, int k) {
        // TODO: Write your code here
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        int startWindow = 0;
        int maxLength = 0;

        for(int endWindow = 0; endWindow < str.length(); endWindow++) {
            char endChar = str.charAt(endWindow);
            characterIntegerMap.put(endChar, characterIntegerMap.getOrDefault(endChar, 0) + 1);

            while(characterIntegerMap.size() > k) {
                char starChar = str.charAt(startWindow);
                characterIntegerMap.put(starChar, characterIntegerMap.get(starChar) - 1);
                if(characterIntegerMap.get(starChar) == 0) {
                    characterIntegerMap.remove(starChar);
                }
                startWindow ++;
            }
            maxLength = Math.max(maxLength, endWindow - startWindow + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
    }
}
