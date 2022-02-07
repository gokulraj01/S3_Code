/** @author Gokul Raj | 235 | R3A | CSE
 * 
 * AIM
 * Displaying Thread Priority values
 * 
 * QUESTION
 * Write a Java program that displays thread priorities.
*/

// Init a Thread
class MyThread extends Thread{
    public void run(){
        System.out.printf("I am %s running with Priority %d\n", this.getName(), this.getPriority());
    }
}

// Main class
class ThreadPriority{
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        // start both threads
        t1.start();
        t2.start();
    }
}