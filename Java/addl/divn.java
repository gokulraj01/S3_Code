import java.util.Scanner;

class Divn{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.println("Performs a/b and returns quotient and remainder");
        System.out.print("Enter divident (a): ");
        int a = s.nextInt();
        System.out.print("Enter divisor (b): ");
        int b = s.nextInt();
        s.close();
        System.out.println("Quotient: "+((int)a/b));
        System.out.println("Remainder: "+(a%b));
    }
}
