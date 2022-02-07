/*
    Author: Gokul Raj, 235, R3A, CSE
    Write a Java Program to reverse a given string.
*/
import java.util.Scanner;

class StringRev {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = s.nextLine();
        s.close();
        String rev_str = "";
        for(int i=str.length()-1; i>=0; i--)
            rev_str += str.charAt(i);
        System.out.println("Reverse is: "+rev_str);
    }
}