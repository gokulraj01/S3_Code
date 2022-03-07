/*
    Author: Gokul Raj, 235, R3A, CSE
    Program 4: Java program to check whether a given number
               is prime or not
*/
import java.util.Scanner;
class Prime {
    static boolean prime(int n){
        int r = (int) Math.sqrt(n);
        if(n < 2)
            return false;
        for(int i=2; i<=r; i++){
            if(n%i == 0)
                return false;
        }
        return true;
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = s.nextInt();
        s.close();

        if(prime(n))
            System.out.println(n+" is prime");
        else
            System.out.println(n+" is NOT prime");
    }
}
