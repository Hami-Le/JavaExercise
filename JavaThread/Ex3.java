package Ex3;

class Thread1 extends Thread {
    public void run() {
        while (true) {
            System.out.println("Luồng ưu tiên cao");
        }
    }
}

class Thread2 extends Thread {
    public void run() {
        while (true) {
            System.out.println("Luồng ưu tiên thấp");
        }
    }
}

public class Ex3 {
    public static void main(String[] args) {
        Thread1 highPrio = new Thread1();
        Thread2 lowPrio = new Thread2();

        highPrio.setPriority(Thread.MAX_PRIORITY);
        lowPrio.setPriority(Thread.MIN_PRIORITY);

        highPrio.start();
        lowPrio.start();
    }

}
