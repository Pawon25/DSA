// Given only a pointer/reference to a node to be deleted in a singly linked list, how do you delete it?
// Given a pointer to a node to be deleted, delete the node. Note that we don’t have a pointer to the head node.

// Input: list = 10 -> 20 -> 4 -> 30, delNode = 20
// Output: 10 -> 4 -> 30
// Explanation: Node with value 20 is deleted.

// Input: list = 1 -> 2, delNode = 1
// Output: 2
// Explanation: Node with value 1 is deleted.

// A simple solution is to traverse the linked list until you find the node you want to delete. But this solution requires a pointer to the head node, which contradicts the problem statement. The idea is to copy the data from the next node into the given node and then deleting the next node.

// Lets first define a linked list class


public class ThirtyFour {
    public static void DeleteMiddleNode(LinkedNode todelete){
        // Lets go till a;
            if(todelete == null || todelete.next == null){
                return;
            }
            todelete.val = todelete.next.val;
            todelete.next = todelete.next.next;
    }
    public static void main(String[] args) {
        LinkedNode list1 = new LinkedNode(10);
        list1.next = new LinkedNode(20);
        list1.next.next = new LinkedNode(4);
        list1.next.next.next = new LinkedNode(30);
        DeleteMiddleNode(list1.next.next.next);
        while (list1.next != null) {
            System.out.print(list1.val + "=>");
            list1 = list1.next;
            if(list1.next == null){
                System.out.println(list1.val);
            }
        }
    }
}
// it is ok to fail in last node since they have given in the question that the delete node is middle one