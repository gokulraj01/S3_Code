import java.util.Scanner;

class ShapeArea{
    double area(double r){
        return Math.PI*r*r;
    }

    double area(double l, double b){
        return l*b;
    }

    double area(double a, double b, double c){
        double s = (a+b+c)/2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        ShapeArea calc = new ShapeArea();

        System.out.println("Area Calculator\n---------------");
        System.out.println("1: Circle\t2: Rectangle\t3: Triangle");
        System.out.print("Option: ");
        int opt = sc.nextInt();

        double s1, s2, s3, res = 0;
        switch(opt){
            case 1:
                System.out.print("Enter Radius: ");
                s1 = sc.nextDouble();
                res = calc.area(s1);
                break;
            case 2:
                System.out.print("Enter Length: ");
                s1 = sc.nextDouble();
                System.out.print("Enter Breadth: ");
                s2 = sc.nextDouble();
                res = calc.area(s1, s2);
                break;
            case 3:
                System.out.print("Enter Side1: ");
                s1 = sc.nextDouble();
                System.out.print("Enter Side2: ");
                s2 = sc.nextDouble();
                System.out.print("Enter Side3: ");
                s3 = sc.nextDouble();
                res = calc.area(s1, s2, s3);
                break;
        }
        sc.close();
        System.out.println("Area is: "+res);
    }
}