import java.util.Scanner;

public class Kadans {
    public static void main(String[] args) {
        
        Scanner scanner= new Scanner(System.in);

        System.out.print("Enter the size of an integer array:\t");
        int arraysize=scanner.nextInt();
        System.out.println("Enter "+arraysize+" elements below:\n");
        int[] array=new int[arraysize];
        for (int i = 0; i < arraysize; i++) {
            array[i]=scanner.nextInt();
        }
        int max_so_far=Integer.MIN_VALUE;
        int max_ending_here=0;

        for(int i=1;i<arraysize;i++){

            max_ending_here=max_ending_here+array[i];
            if (max_so_far<max_ending_here) {
                max_so_far=max_ending_here;
            }
            if (max_ending_here<0) {
                max_ending_here=0;
            }
            System.out.println("Maximum Contigious array so far is "+max_so_far);
        }

    }
    
}