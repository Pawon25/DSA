// 20. Valid Parentheses

// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Every close bracket has a corresponding open bracket of the same type.
 
// Input: s = "()"
// Output: true

// Input: s = "()[]{}"
// Output: true

// Input: s = "(]"
// Output: false

// Input: s = "([])"
// Output: true

// Input: s = "([)]"
// Output: false

// Constraints:

// 1 <= s.length <= 104
// s consists of parentheses only '()[]{}'.
import java.util.*;
public class TwentyFour{
    public static char[] sliceString(String s){
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            System.out.println(charArr[i]);
        }
        return charArr;
    }

    public static boolean checkGoodParenth(char[] chArr){
        ArrayList<Character> trace = new ArrayList<>();
        for (int i = 0; i < chArr.length; i++) {
            if(chArr[i] == '(' ||
                chArr[i] == '[' ||
                    chArr[i] == '{'){
                        trace.add(chArr[i]);
            }else{
                if(chArr[i]==')' && trace.get(trace.size()-1)=='('){
                    trace.remove(trace.size()-1);
                }else if (chArr[i]==']' && trace.get(trace.size()-1)=='[') {
                    trace.removeLast();
                }else if(chArr[i]=='}' && trace.get(trace.size()-1)=='{'){
                    trace.removeLast();
                }else{
                    return false;
                }
            }
        }
        return trace.size()==0?true:false;
    }
    
    public static void main(String[] args) {
        String s = "([)]";
        System.out.println(checkGoodParenth(sliceString(s)));
    }
}