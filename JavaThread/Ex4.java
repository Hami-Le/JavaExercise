package Ex4;

import java.util.logging.Level;
import java.util.logging.Logger;

class Thread1 extends Thread {

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Luồng đang chạy...");
            try {
                Thread.sleep(500); 
            } catch (InterruptedException e) {
                System.out.println("Luồng bị gián đoạn!");
                break; 
            }
        }
        System.out.println("Luồng đã dừng.");
    }
}

public class Ex4 {

    public static void main(String[] args) {
        Thread1 t1 = new Thread1();

        t1.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        t1.interrupt();
    }

}
