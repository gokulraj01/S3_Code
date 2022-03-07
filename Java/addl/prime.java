import java.util.Scanner;

class Prime {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n, r;
        System.out.print("Enter a number: ");
        n = s.nextInt();
        s.close();
        r = (int) Math.sqrt(n);

        boolean flag = true;
        for(int i=2; i<=r; i++){
            if(n%i == 0){
                flag = false;
                break;
            }
        }
        if(flag)
            System.out.println(n+" is prime");
        else
            System.out.println(n+" is NOT prime");
    }
}
