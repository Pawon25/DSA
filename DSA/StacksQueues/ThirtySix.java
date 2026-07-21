// Implement two Stacks in an Array
// Last Updated : 26 Apr, 2025
// Create a data structure twoStacks that represent two stacks. Implementation of twoStacks should use only one array, i.e., both stacks should use the same array for storing elements. 

// Following functions must be supported by twoStacks.

// push1(int x) --> pushes x to first stack 
// push2(int x) --> pushes x to second stack
// pop1() --> pops an element from first stack and return the popped element 
// pop2() --> pops an element from second stack and return the popped element


// lets implement 1 stack from an array

class ThirtySix{
    static int[] stackArr = new int[10];
    static int top1=-1;
    static int top2=stackArr.length;

    public static void stack1push(int val){
        if(top1 + 1 >= top2){
            System.out.println("No space left in an array. Stack overflow");
        }else{
            top1++;
            stackArr[top1] = val;
            System.out.println("Inserted "+ val+ " at " + top1 + " in array");
        }
    }

    public static void stack1pop(){
        if(top1 == -1){
            System.out.println("No elements left in an array for stack 2. Stack underflow");
        }else{
            System.out.println("Deleted "+ stackArr[top1]+ " at " + top1 + "in array");
            stackArr[top1]=0;
            top1--;
        }
    }


    //for stack two
    
        public static void stack2push(int val){
        if(top1 + 1 >= top2){
            System.out.println("No space left in an array. Stack overflow");
        }else{
            top2--;
            stackArr[top2] = val;
            System.out.println("Inserted "+ val+ " at " + top2 + " in array");
        }
    }

    public static void stack2pop(){
        if(top2 == stackArr.length){
            System.out.println("No elements left in an array for stack 1. Stack underflow");
        }else{
            System.out.println("Deleted "+ stackArr[top2]+ " at " + top2 + "in array");
            stackArr[top2]=0;
            top2--;
        }
    }

    


    public static void printStacks(){
        System.out.println("===================");
        System.out.println("Stack 1 (top1 = " + top1 + "):");
        for (int i = 0; i <= top1; i++) {
            System.out.print(stackArr[i] + " ");
        }
        System.out.println("\nStack 2 (top2 = " + top2 + "):");
        for (int i = stackArr.length - 1; i >= top2; i--) {
            System.out.print(stackArr[i] + " ");
        }
        System.out.println("\n===================");
    }


    public static void main(String[] args) {
        
        stack1push(10);
        printStacks();
        stack2push(15);
        printStacks();
        stack1pop();
        printStacks();

        stack2push(20);
        printStacks();
        stack2pop();
        printStacks();
        
    }
}