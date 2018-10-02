package collections.order;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Entry point -- schedules and coordinates other threads
 */
public class TicketSettlementApplication {

    public static void main(String[] args) {
        TicketSettlementService ticketSettlementService = new TicketSettlementService();

        ExecutorService coordinatorService = Executors.newFixedThreadPool(2);

        TicketWorkerController ticketWorkerController = new TicketWorkerController(ticketSettlementService);
        coordinatorService.submit(ticketWorkerController);

        TicketAssigner ticketAssigner = new TicketAssigner(ticketSettlementService);
        coordinatorService.submit(ticketAssigner);
    }
}
