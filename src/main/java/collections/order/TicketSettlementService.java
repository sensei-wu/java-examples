package collections.order;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.*;
import java.util.logging.Logger;

public class TicketSettlementService {

    private Logger LOG = Logger.getLogger(TicketSettlementService.class.getName());

    private static Set<Ticket> normalQueue = Collections.synchronizedSet(new LinkedHashSet<>());

    synchronized void assignForSettlement(Set<Ticket> tickets) {
        normalQueue.addAll(tickets);
        LOG.info(String.format("Number of tickets added: %d, queue size: %d", tickets.size(), normalQueue.size()));
    }

    private void settle(Ticket ticket) {
        if(ticket == null) {
            return;
        }

        try {
            TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(10));
            LOG.info("Processed ticket: " + ticket.getTicketId() + ", thread: " + Thread.currentThread().getName());
            normalQueue.remove(ticket);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void startProcess() {
        LOG.info(String.format("Starting settlement process, queue size: %d, worker: %s", normalQueue.size(), Thread.currentThread().getName()));
        settle(getNextTicketFromQueue());
    }

    private synchronized Ticket getNextTicketFromQueue() {
        LOG.info("Getting next ticket");
        if(normalQueue.size() == 0) {
            return null;
        } else {
            return normalQueue.iterator().next();
        }
    }
}
