package banhmi;

import java.util.ArrayList;

public class Store {
    private int capacity;
    private ArrayList<Integer> products = new ArrayList<>();
    
    public Store(int capacity) {
        this.capacity = capacity;
    }
    
    public synchronized void addProduct(int product) throws InterruptedException {
        while (products.size() >= capacity) { 
            wait();
        }
        System.out.println("------------------------------------");
        System.out.println("Bánh mì được thêm vào tiệm bánh");
        products.add(product);
        System.out.println("Số lượng tồn kho: " + products.size());
        notifyAll(); 
    }
    
    public synchronized void removeProduct() throws InterruptedException {
        while (products.size() == 0) {  
            wait();
        }
        System.out.println("------------------------------------");
        System.out.println("Bánh mì đã được mua");
        products.remove(0);
        System.out.println("Số lượng tồn kho: " + products.size());
        notifyAll(); 
    }
    
    public int getSize(){
        return this.products.size();
    }
    
    public int getCapacity() {
        return capacity;
    }
}
