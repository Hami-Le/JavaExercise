
package vetau;

public class TicketSeller extends Thread {
    private TicketStore ticketStore;

    public TicketSeller(TicketStore ticketStore) {
        this.ticketStore = ticketStore;
    }

    @Override
    public void run() {
        int ticketNumber = 1;
        while (true) {
            try {
                ticketStore.addTicket(ticketNumber++);
                Thread.sleep((long) (Math.random() * 2000)); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
