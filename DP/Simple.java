import java.util.Scanner;
class Simple{

    static void printWithOutMinus(int n, int i){
        if(n==i){
            System.out.println("Reached the base case:");
            return;
        }
        printWithOutMinus(n, i+1);
        System.out.println(">>" + i);
    }
    
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number to start the decreasing series: ");
        int n = sc.nextInt();

        printWithOutMinus(n, 0);
        sc.close();
    }
}