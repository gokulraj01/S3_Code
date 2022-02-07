/** @author Gokul Raj | 235 | R3A | CSE
 * 
 * AIM
 * A program to demonstrate interface inheritance
 * 
 * QUESTION
 * Implement a Java program to collect employee data in interface
 * with functions to show details and calculate salary.
*/
import java.util.Scanner;

interface EmpData{
    void setDetails(String name, String desig, int age, int exp);
    void showDetails();
}

interface Salary{
    double ta = 0.1, da = 0.2, tax = 0.18;
    void setBaseSalary(double basic);
    double getSalary();
}

class Manager implements EmpData, Salary{
    private String name, designation;
    private int age, experience;
    private double salary;
    @Override
    public void setBaseSalary(double basic) {
        salary = basic*(1+ta+da-tax);
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public void setDetails(String name, String desig, int age, int exp) {
        this.name = name;    
        this.designation = desig;
        this.age = age;
        this.experience = exp;
    }

    @Override
    public void showDetails() {
        System.out.println("Manager Details");
        System.out.printf("Name: %s\nAge: %d\nDesignation: %s\nExperience: %d\nSalary: %f\n", name, age, designation, experience, salary);
    }
}

class EmpDetail {
    public static void main(String[] args) {
        Manager man = new Manager();
        Scanner s = new Scanner(System.in);

        System.out.println("Enter Employee Details");
        System.out.print("Name: ");
        String n = s.nextLine();
        System.out.print("Age: ");
        int a = s.nextInt();
        System.out.print("Designation: ");
        s.next();
        String d = s.nextLine();
        System.out.print("Experience: ");
        int e = s.nextInt();
        man.setDetails(n, d, a, e);

        System.out.print("Base Salary: ");
        double b = s.nextDouble();
        man.setBaseSalary(b);
        System.out.println("Total Salary: "+man.getSalary());

        man.showDetails();
        s.close();
    }
}
