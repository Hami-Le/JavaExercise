/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex1;

class TaskA {

    private int count = 0;

    public synchronized void increment() { // một luồng có thể thực thi phương thức này tại một thời điểm.
        count++;                          // Điều này giúp tránh xung đột khi hai luồng cùng tăng count đồng thời.
    }

    public int getCount() {
        return count;
    }
}

public class Ex1 {

    public static void main(String[] args) throws InterruptedException {
        TaskA counter = new TaskA();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Giá trị cuối cùng: " + counter.getCount());
    }

}
