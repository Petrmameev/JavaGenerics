import java.util.Arrays;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void addTicket(Ticket ticketForAdd) {
        repository.addTickets(ticketForAdd);
    }

    public void removeTicketById(int id) {
        repository.removeById(id);
    }

    public Ticket[] getTicket() {
        Ticket[] all = repository.getTicket();
        return all;
    }

    public Ticket[] searchBy(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.getTicket()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getFrom().contains(from)) {
            return ticket.getTo().contains(to);
        }
        return false;
    }

}

