import java.lang.*;
public class ThirtySeven {
    static class DQueNode{
        int val;
        DQueNode next;
        DQueNode prev;
    }

    static class deque{
        private DQueNode head;
        private DQueNode tail;

        public deque(){
            head = tail = null;
        }

        boolean isEmpty(){
            if(head == null){
                return true;
            }
            return false;
        }

        int size(){
            if(!isEmpty()){
                DQueNode temp = head;
                int len =0;
                while(temp!=null){
                    temp = temp.next;
                    len++;
                }
                return len;
            }
            return 0;
        }

        void insert_first(int element){
            DQueNode temp = new DQueNode();
            temp.val = element;

            if(head == null){
                head = tail = temp;
                temp.next = temp.prev = null;
            }
            else{
                temp.next = head;
                head.prev = temp;
                temp.prev = null;
                head = temp;
            }
        }

        void insert_last(int element){
            DQueNode temp = new DQueNode();
            temp.val=element;

            if(tail == null){
                tail = head = temp;
                temp.next = temp.prev = null;
            }
            else{
                tail.next = temp;
                temp.prev = tail;
                temp.next = null;
                tail = temp;
            }
        }

        void remove_first(){
            if(!isEmpty()){
                if(head == tail){
                    head = tail = null;
                }
                else{

                    head = head.next;
                    head.prev = null;
                }
            }
            else{
                System.out.println("No elements to remove: Underflow");
            }
        }

        void remove_last()
        {

            // If list is not empty
            if (!isEmpty()) {
                tail = tail.prev;
                if (tail != null) {
                    tail.next = null;
                }
                return;
            }
            System.out.print("List is Empty");
        }

        void display(){
            DQueNode temp = new DQueNode();
            temp = head;
            while(temp != null){
                System.out.print(temp.val + " ");
                temp=temp.next;
            }
            System.out.println("=================");
        }
    }


        static class Stack{
            deque d = new deque();
            public void push(int element){
                d.insert_last(element);
            }
            public void pop(){
                d.remove_last();
            }
            public int size(){return d.size();}
            public void display() { d.display();}
        }

        static class Queue{
            deque d = new deque();
            public void enqueue(int element){
                d.insert_last(element);
            }
            public void dequeue(){
                d.remove_first();
            }
            public void display(){
                d.display();
            }
            public int size(){
                return d.size();
            }
        }

        //Driver Codeeeeee
        public static void main(String[] args) {
            Stack stk = new Stack();

        // push 7 and 8 at top of stack
        stk.push(7);
        stk.push(8);
        System.out.print("Stack: ");
        stk.display();

        // For new line
        System.out.println();

        // pop an element
        stk.pop();
        System.out.print("Stack: ");
        stk.display();

        // For new line
        System.out.println();

        // Object of Queue
        Queue que = new Queue();

        // Insert 12 and 13 in queue
        que.enqueue(12);
        que.enqueue(13);
        System.out.print("Queue: ");
        que.display();

        // New line
        System.out.println();

        // Delete an element from queue
        que.dequeue();
                System.out.print("Queue: ");

        que.dequeue();
                System.out.print("Queue: ");

        que.dequeue();
        System.out.print("Queue: ");
        que.display();

        // New line
        System.out.println();
        System.out.println("Size of stack is "
                           + stk.size());
        System.out.println("Size of queue is "
                           + que.size());
        }

    }

