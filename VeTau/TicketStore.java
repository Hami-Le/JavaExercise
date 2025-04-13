
package vetau;
import java.util.ArrayList;

public class TicketStore {
    private int capacity;
    private ArrayList<Integer> tickets = new ArrayList<>();

    public TicketStore(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void addTicket(int ticket) throws InterruptedException {
        while (tickets.size() >= capacity) { 
            wait();
        }
        System.out.println("------------------------------------");
        System.out.println("Vé tàu được thêm vào hệ thống");
        tickets.add(ticket);
        System.out.println("Số lượng vé còn lại: " + tickets.size());
        notifyAll(); 
    }

    public synchronized void buyTicket() throws InterruptedException {
        while (tickets.size() == 0) { 
            wait();
        }
        System.out.println("------------------------------------");
        System.out.println("Hành khách đã mua một vé");
        tickets.remove(0);
        System.out.println("Số lượng vé còn lại: " + tickets.size());
        notifyAll(); 
    }

    public int getSize() {
        return this.tickets.size();
    }

    public int getCapacity() {
        return capacity;
    }
}
