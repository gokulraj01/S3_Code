// Author: Gokul Raj, 235, R3A, CSE
import java.util.Scanner;

// Check vowels consonants in a sentence
class VowelCons {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = s.nextLine().toUpperCase();
        s.close();

        int vow = 0, con = 0, spc = 0, oth = 0;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
                vow++;
            else if(c >= 'A' && c <= 'Z')
                con++;
            else if(c == ' ')
                spc++;
            else
                oth++;
        }

        System.out.println("Vowels: "+vow);
        System.out.println("Consonants: "+con);
        System.out.println("Spaces: "+spc);
        System.out.println("Other Charecters: "+oth);
    }
}
