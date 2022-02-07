/** @author Gokul Raj | 235 | R3A | CSE
 * 
 * AIM
 * A program to implement integer Binary Search
 * 
 * QUESTION
 * Implement a Java program to use Binary Search Algorithm for Strings
*/
import java.util.Scanner;

class BinarySearch{
    static String input(Scanner s){
        String op = "";
        while(op.length() == 0)
            op = s.nextLine();
        return op;
    }

    static int binarySearch(String list[], String key){
        int start = 0, end = list.length-1, mid;
        while(start <= end){
            mid = (start+end)/2;
            int comp = key.compareTo(list[mid]);
            if(comp == 0)
                return mid;
            else if(comp > 0)
                start = mid+1;
            else
                end = mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Number of Elements: ");
        int n = s.nextInt();
        String list[] = new String[n];
        for(int i=0; i<n; i++){
            System.out.print("Element "+(i+1)+": ");
            list[i] = input(s);
        }
        System.out.print("Key to search: ");
        String k = input(s);
        s.close();
        int result = binarySearch(list, k);
        if(result > -1)
            System.out.println("Found at "+(result+1));
        else
            System.out.println("Not Found...");
    }
}