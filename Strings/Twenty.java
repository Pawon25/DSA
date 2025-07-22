// You are given a string s, consisting of lowercase alphabets. Your task is to remove consecutive duplicate characters from the string. 


// Input: s = "aabb"
// Output:  "ab" 
// Explanation: 
// The character 'a' at index 2 is the same as 'a' at index 1, so it is removed.
// Similarly, the character 'b' at index 4 is the same as 'b' at index 3, so it is removed.
// The final string is "ab".

// Input:s = "aabaa"
// Output: "aba"
// The character 'a' at index 2 is the same as 'a' at index 1, so it is removed.
// The character 'a' at index 5 is the same as 'a' at index 4, so it is removed.
// The final string is "aba".

// Input: s = "abcddcba"
// Output: "abcdcba"
// Explanation: 
// The character 'd' at index 5 is the same as 'd' at index 4, so it is removed.
// No other consecutive duplicates exist.
// The final string is "abcdcba".
// Constraints:
// 1 ≤ n ≤ 106
// All characters in the string are lowercase English alphabets.

// Expected Complexities
// Time Complexity: O(n)
// Auxiliary Space: O(n)

import java.util.*;
public class Twenty {
    public static String removeConsecutiveDuplicates(String s){
        if(s.length()==0) return "";
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(!stack.isEmpty() && stack.peek()==c){
                continue;
            }
            else{
                stack.push(c);
            }
        }       
        StringBuilder result = new StringBuilder();
        for(char c: stack){
            result.append(c);
        }
        return result.toString();
    }
    public static void main(String[] args) {
        System.out.println(removeConsecutiveDuplicates("aabb"));
        System.out.println(removeConsecutiveDuplicates("aabaa"));
        System.out.println(removeConsecutiveDuplicates("abcddcba"));
    }
}
