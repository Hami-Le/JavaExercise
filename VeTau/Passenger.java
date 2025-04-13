
package vetau;

public class Passenger extends Thread {
    private TicketStore ticketStore;

    public Passenger(TicketStore ticketStore) {
        this.ticketStore = ticketStore;
    }

    @Override
    public void run() {
        while (true) {
            try {
                ticketStore.buyTicket();
                Thread.sleep((long) (Math.random() * 3000)); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
