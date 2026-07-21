// Given an array arr[], the task is to reverse the array. Reversing an array means rearranging the elements such that the first element becomes the last, the second element becomes second last and so on.

// Input: arr[] = {1, 4, 3, 2, 6, 5}  
// Output: {5, 6, 2, 3, 4, 1}
// Explanation: The first element 1 moves to last position, the second element 4 moves to second-last and so on.

// Input: arr[] = {4, 5, 1, 2} 
// Output: {2, 1, 5, 4}
// Explanation: The first element 4 moves to last position, the second element 5 moves to second last and so on.

class Thirteen{
    public int[] reverse(int[] arr){
        int temp=0;
        for(int i=0;i<arr.length/2;i++){
            temp = arr[i];
            arr[i] = arr[arr.length - 1 -i];
            arr[arr.length-1-i] = temp;
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] inp1 = {1,4,3,2,6,5};
        Thirteen rev_fun = new Thirteen();
        inp1 = rev_fun.reverse(inp1);

        for (int i = 0; i < inp1.length; i++) {
            System.out.println(inp1[i]);
        }
    }
}