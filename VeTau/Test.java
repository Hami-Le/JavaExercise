
package vetau;

public class Test {
public static void main(String[] args) {
        TicketStore ticketStore = new TicketStore(30); 
        TicketSeller ticketSeller = new TicketSeller(ticketStore);
        Passenger passenger = new Passenger(ticketStore);

        ticketSeller.start();
        passenger.start();
    }
    
}
