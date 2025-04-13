/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex4;

import java.util.logging.Level;
import java.util.logging.Logger;

class Thread1 extends Thread {

    public void run() {
        while (!Thread.currentThread().isInterrupted()) { // Kiểm tra tín hiệu gián đoạn
            System.out.println("Luồng đang chạy...");
            try {
                Thread.sleep(500); // Tạm dừng để tránh CPU chạy 100%
            } catch (InterruptedException e) {
                System.out.println("Luồng bị gián đoạn!");
                break; // Thoát khỏi vòng lặp
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
