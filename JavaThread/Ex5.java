package Ex5;
import java.util.logging.Level;
import java.util.logging.Logger;

class Value {
    static volatile boolean flag = false;
}

class Thread1 extends Thread {

    public void run() {
        System.out.println("Luồng Thread1 đang đọc giá trị biến flag...");
        while (!Value.flag) {
        }
        System.out.println("Luồng Thread1 phát hiện flag đã thay đổi!");
    }
}

class Thread2 extends Thread {

    public void run() {
        try {
            Thread.sleep(3000); 
        } catch (InterruptedException ex) {
        }
        Value.flag = true; 
        System.out.println("Luồng Thread2 đã thay đổi giá trị flag");
    }
}

public class Ex5 {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();

        t1.start();
        t2.start();
    }

}
