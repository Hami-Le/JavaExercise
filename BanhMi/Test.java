package banhmi;

public class Test {

    public static void main(String[] args) {
        Store store = new Store(20);       
        Producer p1 = new Producer(store);      
        Consumer c1 = new Consumer(store);

        p1.start();
        c1.start();

    }
    
}
