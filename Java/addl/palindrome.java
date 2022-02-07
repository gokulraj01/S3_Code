import java.util.Scanner;

class Palindrome{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();
        sc.close();
        boolean palin = true;
        int len = s.length();
        for(int i=0; i<len/2; i++){
            if(s.charAt(i) != s.charAt(len-i-1)){
                palin = false;
                break;
            }
        }
        if(palin)
            System.out.println("Palindrome!!");
        else
            System.out.println("Not Palindrome");
    }
}