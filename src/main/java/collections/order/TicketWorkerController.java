package collections.order;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Submits work to the service at schedule interval, limited to max. 3 workers in parallel
 */
public class TicketWorkerController implements Runnable {

    private final TicketSettlementService ticketSettlementService;
    private final ScheduledExecutorService executorService;

    public TicketWorkerController(TicketSettlementService ticketSettlementService) {
        this.ticketSettlementService = ticketSettlementService;
        this.executorService = Executors.newScheduledThreadPool(3);
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            this.executorService.scheduleAtFixedRate(ticketSettlementService::startProcess, 0, 1, TimeUnit.SECONDS);
        }
    }
}
