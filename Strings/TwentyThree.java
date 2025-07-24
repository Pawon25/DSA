// Given a string s, the task is to identify all characters that appear more than once and print each as a list containing the character and its count.

// Input: s = "geeksforgeeks"
// Output: ['e', 4], ['g', 2], ['k', 2], ['s', 2]
// Explanation: Characters e, g, k, and s appear more than once. Their counts are shown in order of first occurrence.

// Input: s = "programming"
// Output: ['r', 2], ['g', 2], ['m', 2]
// Explanation: Only r, g, and m are duplicates. Output lists them with their counts.

// Input: s = "mississippi"
// Output: ['i', 4], ['s', 4], ['p', 2]
// Explanation: Characters i, s, and p have multiple occurrences. The output reflects that with count and order preserved.

// Table of Content

// [Approach - 1] Using Sorting - O(n*log(n)) Time and O(1) Space
// [Approach - 2] Using Hashing - O(n) Time and O(k) Space

import java.util.*;

public class TwentyThree {
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(findDuplicates(s));
    }

    public static List<List<Object>> findDuplicates(String s) {
        // Use LinkedHashMap to maintain insertion order
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        
        // Step 1: Count frequency of each character
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        // Step 2: Collect characters with count > 1
        List<List<Object>> result = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() > 1) {
                List<Object> pair = new ArrayList<>();
                pair.add(entry.getKey());
                pair.add(entry.getValue());
                result.add(pair);
            }
        }
        
        return result;
    }
}