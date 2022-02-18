/*
    Author: Gokul Raj, 235, R3A, CSE
    Program 6: Java program to demonstrate class inheritance
*/
import java.util.Scanner;

class Employee {
    String name, address;
    int age, phone, salary;
    
    Employee(String n, int a, String add, int p, int s){
        name = n;
        age = a;
        address = add;
        phone = p;
        salary = s;
    }
    
    void printSalary(){
        System.out.println("Salary is: "+salary);
    }
}

class Officer extends Employee {
    String dept, spz;
    
    Officer(String n, int a, String add, int p, String d, String s, int sal){
        super(n,a,add,p,sal);
        dept = d;
        spz = s;
    }
    
    void showData(){
        System.out.println("Officer Info");
        System.out.println("------------");
        System.out.println("Name: "+this.name);
        System.out.println("Age: "+this.age);
        System.out.println("Address: "+this.address);
        System.out.println("Phone: "+this.phone);
        System.out.println("Department: "+this.dept);
        System.out.println("Specialization: "+this.spz);
        System.out.println("Salary: "+this.salary);
        System.out.println();
    }
}

class Manager extends Employee {
    String dept, spz;
    
    Manager(String n, int a, String add, int p, String d, String s, int sal){
        super(n,a,add,p,sal);
        dept = d;
        spz = s;
    }
    
    void showData(){
        System.out.println("Manager Info");
        System.out.println("------------");
        System.out.println("Name: "+this.name);
        System.out.println("Age: "+this.age);
        System.out.println("Address: "+this.address);
        System.out.println("Phone: "+this.phone);
        System.out.println("Department: "+this.dept);
        System.out.println("Specialization: "+this.spz);
        System.out.println("Salary: "+this.salary);
        System.out.println();
    }
}

class EmpData{
    static String input(Scanner sc){
        String inp = "";
        while(inp.length() == 0)
            inp = sc.nextLine();
        return inp;
    }

    public static void main(String args[]){
        String name, address, dept, spz;
        int age, phone, salary;
        
        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter Officer Details");
        System.out.print("Name: ");
        name = input(s);
        System.out.print("Age: ");
        age = s.nextInt();
        System.out.print("Address: ");
        address = input(s);
        System.out.print("Phone: ");
        phone = s.nextInt();
        System.out.print("Department: ");
        dept = input(s);
        System.out.print("Specialization: ");
        spz = input(s);
        System.out.print("Salary: ");
        salary = s.nextInt();
        Officer off1 = new Officer(name, age, address, phone, dept, spz, salary);
        
        System.out.println("Enter Manager Details");
        System.out.print("Name: ");
        name = input(s);
        System.out.print("Age: ");
        age = s.nextInt();
        System.out.print("Address: ");
        address = input(s);
        System.out.print("Phone: ");
        phone = s.nextInt();
        System.out.print("Department: ");
        dept = input(s);
        System.out.print("Specialization: ");
        spz = input(s);
        System.out.print("Salary: ");
        salary = s.nextInt();
        Manager man1 = new Manager(name, age, address, phone, dept, spz, salary);
        
        s.close();
        System.out.println();
        off1.showData();
        man1.showData();
    }
}
