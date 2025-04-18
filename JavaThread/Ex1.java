package Ex1;

class TaskA {

    private int count = 0;

    public synchronized void increment() { 
        count++;                          
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
