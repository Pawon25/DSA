import java.util.Scanner;

public class SumOfN {
    
    public static void RecurSum(int i, int sum){
        if(i < 1){
            System.out.println("Sum of integers is" + sum);
            return;
        }
        RecurSum(i-1, sum+i);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number:");
        int n = sc.nextInt();

        RecurSum(n, 0);
        sc.close();
    }
}
