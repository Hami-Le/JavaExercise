/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex5;
import java.util.logging.Level;
import java.util.logging.Logger;

class Value {
    static volatile boolean flag = false; // sửa lỗi -> Dùng volatile
}

class Thread1 extends Thread {

    public void run() {
        System.out.println("Luồng Thread1 đang đọc giá trị biến flag...");
        while (!Value.flag) {
            // Vòng lặp chờ flag thay đổi
        }
        System.out.println("Luồng Thread1 phát hiện flag đã thay đổi!");
    }
}

class Thread2 extends Thread {

    public void run() {
        try {
            Thread.sleep(3000); // Chờ 3 giây trước khi thay đổi flag
        } catch (InterruptedException ex) {
        }
        Value.flag = true; // thay đổi giá trị flag
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