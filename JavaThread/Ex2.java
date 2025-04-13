package Ex2;

import java.util.logging.Level;
import java.util.logging.Logger;

class Resource{
    static final Object r1 = new Object();
    static final Object r2 = new Object();
}
        
class Thread1 extends Thread{
    public void run() {
        synchronized (Resource.r1) {
            System.out.println("Thread1 đã khóa r1");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }

            synchronized (Resource.r2) {
                System.out.println("Thread1 đã khóa r2");
            }
        }
    }    
}

class Thread2 extends Thread{
    public void run() {
        synchronized (Resource.r1) { 
            System.out.println("Thread2 đã khóa r1");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }

            synchronized (Resource.r2) {
                System.out.println("Thread2 đã khóa r2");
            }
        }
    }    
}

public class Ex2 {

    public static void main(String[] args) {
        Thread t1 = new Thread1();
        Thread t2 = new Thread2();
        
        t1.start();
        t2.start();
    }
    
}

