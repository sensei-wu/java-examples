package collections.order;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * A simulator which assigns random number of tickets to the settlement service at regular intervals
 */
public class TicketAssigner implements Runnable{

    private AtomicLong ticketIdCounter = new AtomicLong(0);

    private final TicketSettlementService ticketSettlementService;
    private final ScheduledExecutorService executorService;

    public TicketAssigner(TicketSettlementService ticketSettlementService) {
        this.ticketSettlementService = ticketSettlementService;
        this.executorService = Executors.newScheduledThreadPool(1);
    }

    @Override
    public void run() {
        executorService.scheduleAtFixedRate(() -> ticketSettlementService.assignForSettlement(generateTickets(ThreadLocalRandom.current().nextInt(10000))), 0, 10, TimeUnit.SECONDS);

    }

    private Set<Ticket> generateTickets(int number) {
        Set<Ticket> tickets = new LinkedHashSet<>();
        for (int i = 0; i < number; i++) {
            Ticket ticket = new Ticket();
            ticket.setTicketId(ticketIdCounter.incrementAndGet());
            ticket.setAssignTs(new Date());
            tickets.add(ticket);
        }
        return tickets;
    }
}
