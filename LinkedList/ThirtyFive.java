// Remove Duplicates from an Unsorted Linked List
// Given an unsorted linked list containing n nodes, the task is to remove duplicate nodes while preserving the original order.

// Input: 12 -> 11 -> 12 -> 21 -> 41 -> 43 -> 21 
// Output: 12 -> 11 -> 21 -> 41 -> 43 
// Explanation: The second occurrence of 12 (the one after 11) and the second occurrence of 21 (the one at the end) are removed, resulting in a linked list that maintains the order of their first appearances.

// Input: 1 -> 2 -> 3 -> 2 -> 4
// Output: 1 -> 2 -> 3 -> 4
// Explanation: Similarly, the second occurrence of 2 is removed, ensuring that each number appears only once while maintaining the order of their first appearances.

import java.util.*;

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}

class ThirtyFive{
    public ListNode removeDuplicates(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        Set<Integer> seen = new HashSet<>();
        ListNode current = head;
        ListNode prev = null;

        while(current != null){
            if(seen.contains(current.val)){
                prev.next = current.next;
            }else{
                seen.add(current.val);
                prev = current;
            }   
            current = current.next;             
        }
        return head;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(12);
        head.next = new ListNode(11);
        head.next.next = new ListNode(12);
        head.next.next.next = new ListNode(21);
        head.next.next.next.next = new ListNode(41);
        head.next.next.next.next.next = new ListNode(43);
        head.next.next.next.next.next.next = new ListNode(21);

        ThirtyFive solution = new ThirtyFive();
        ListNode result = solution.removeDuplicates(head);

        while(result != null){
            System.out.print(result.val + " ");
            result = result.next;
        }

    }
}