package banhmi;

public class Consumer extends Thread {
    private Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while (true) {
            try {
                store.removeProduct();
                Thread.sleep((long) (Math.random() * 3000)); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
