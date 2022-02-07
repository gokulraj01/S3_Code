/** @author Gokul Raj | 235 | R3A | CSE
 * 
 * AIM
 * A program to implement Linear Search
 * 
 * QUESTION
 * Implement a Java program to use Linear Search Algorithm for Strings
*/
import java.util.Scanner;

class LinearSearch{
    static String input(Scanner s){
        String op = "";
        while(op.length() == 0)
            op = s.nextLine();
        return op;
    }

    static int linearSearch(String list[], String key){
        for(int i=0; i<list.length; i++){
            if(key.equals(list[i]))
                return i+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Number of Elements: ");
        int n = s.nextInt();
        String list[] = new String[n];
        int i;
        for(i=0; i<n; i++){
            System.out.print("Element "+(i+1)+": ");
            list[i] = input(s);
        }
        System.out.print("Key to search: ");
        String k = input(s);
        s.close();
        int result = linearSearch(list, k);
        if(result > -1)
            System.out.println("Found at "+result);
        else
            System.out.println("Not Found...");
    }
}