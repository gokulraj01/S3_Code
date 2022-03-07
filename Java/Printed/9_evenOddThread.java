/** @author Gokul Raj | 235 | R3A | CSE
 * 
 * AIM
 * A program to demonstrate multi threading
 * 
 * PROGRAM 9
 * Write a Java program to create two threads to display odd and even numbers between 1-100
*/

// Thread to display even numbers
class Even extends Thread{
    public void run(){
        for(int i=0; i<=100; i+=2)
            System.out.println("Even: "+i);
    }
}

// Thread to display odd numbers
class Odd extends Thread{
    public void run(){
        for(int i=1; i<=100; i+=2)
            System.out.println("Odd: "+i);
    }
}

// Main class
class EvenOdd{
    public static void main(String[] args) {
        Even t1 = new Even();
        Odd t2 = new Odd();
        // Start both threads
        t1.start();
        t2.start();
    }
}
