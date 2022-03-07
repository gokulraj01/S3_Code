// Author: Gokul Raj, 235, R3A, CSE
import java.util.Scanner;

// Program to display sum of two numbers
class Sum{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        
        // Input number 1
        System.out.print("Enter number 1: ");
        int a = s.nextInt();
        
        // Inputr number 2
        System.out.print("Enter number 2: ");
        int b = s.nextInt();
        s.close();
        
        // Display sum
        System.out.println("Sum is: "+(a+b));
    }
}
