
//! Problem 2 — Strings: Longest Substring Without Repeating Characters
//? Given a string, find the length of the longest substring without repeating characters.

// Examples:
// - "abcabcbb" → 3 ("abc")
// - "bbbbb" → 1 ("b")
// - "pwwkew" → 3 ("wke")

// This is a sliding window problem. Just need to increase the window size until i get a character which is already present in my window
import java.util.*;

public class LongestSubstring{

    public static int longestSubstring(String line){
        int maxwindowsize = 0;
        if(line == null || line.length() == 0){
            return 0;
        }
        if(line.length() == 1){
            return 1;
        }
        Set<Character> window = new HashSet<>();
        int left = 0;
        int right = 0;
        window.add(line.charAt(0));
        while(left <= right && right < line.length()-1){
            maxwindowsize = Math.max(maxwindowsize, right-left+1);
            if(window.contains(line.charAt(right+1))){
                while(window.contains(line.charAt(right+1))){
                    window.remove(line.charAt(left));
                    left++;
                }
                // left = right;
                right++;
                window.add(line.charAt(right));
            }else{
                window.add(line.charAt(right+1));
                right++;
            }
        }
        return maxwindowsize;
    }

    public static void main(String[] Args){
        String example1 = "abcabcbb";
        String example2 = "bbbbbbbbb";
        String example3 = "pwwkew";

        System.out.println("Longest SubString of " + example1 + " is " + longestSubstring(example1));
        System.out.println("Longest SubString of " + example2 + " is " + longestSubstring(example2));
        System.out.println("Longest SubString of " + example3 + " is " + longestSubstring(example3));

    }
}