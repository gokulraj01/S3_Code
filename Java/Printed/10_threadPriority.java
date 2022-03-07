import java.util.*;
class MyThread extends Thread{
    MyThread(int pri){
        this.setPriority(pri);
    }
    public void run(){
        System.out.printf("I am %s running with Priority %d\n", this.getName(), this.getPriority());
    }
}


class ThreadPriority{
    public static void main(String[] args) {
        MyThread t1 = new MyThread(3);
        MyThread t2 = new MyThread(2);
        
        t1.start();
        t2.start();
    }
}
