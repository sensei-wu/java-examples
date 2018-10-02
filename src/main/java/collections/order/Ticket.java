package collections.order;

import java.util.Date;

public class Ticket {
    private long ticketId;
    private Date assignTs;

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public Date getAssignTs() {
        return assignTs;
    }

    public void setAssignTs(Date assignTs) {
        this.assignTs = assignTs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (ticketId != ticket.ticketId) return false;
        return assignTs != null ? assignTs.equals(ticket.assignTs) : ticket.assignTs == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (ticketId ^ (ticketId >>> 32));
        result = 31 * result + (assignTs != null ? assignTs.hashCode() : 0);
        return result;
    }
}
