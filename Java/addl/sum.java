package addl;
import java.util.Scanner;

class Sum{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number 1: ");
        int a = s.nextInt();
        System.out.print("Enter number 2: ");
        int b = s.nextInt();
        s.close();
        System.out.println("Sum is: "+(a+b));
    }
}