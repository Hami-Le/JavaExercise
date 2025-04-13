package banhmi;

public class Producer extends Thread {
    private Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            try {
                store.addProduct(i++);
                Thread.sleep((long) (Math.random() * 2000)); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
