import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TicketManagerTest {

    Ticket ticket1 = new Ticket(4, 444, "AAQ", "ULK", 44);
    Ticket ticket2 = new Ticket(2, 222, "AAQ", "IKU", 22);
    Ticket ticket3 = new Ticket(5, 555, "IKU", "AAQ", 55);
    Ticket ticket4 = new Ticket(1, 111, "ULK", "IKU", 11);
    Ticket ticket5 = new Ticket(3, 333, "ULK", "DME", 33);
    Ticket ticket6 = new Ticket(6, 666, "AAQ", "IKU", 66);

    @Test
    public void shouldFindTicketByTwoAirportsAndSort() {
        TicketManager manager = new TicketManager(new TicketRepository());
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);

        Ticket[] expected = {ticket2, ticket6};
        Ticket[] actual = manager.searchBy("AAQ", "IKU");
        Arrays.sort(actual);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindTicketsIfEmptyRepository() {
        TicketManager manager = new TicketManager(new TicketRepository());
        Ticket[] expected = {};
        Ticket[] actual = manager.searchBy("AAQ", "ULK");
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldNotFindNonExistentTickets() {
        TicketManager manager = new TicketManager(new TicketRepository());
        manager.addTicket(ticket1);
        Ticket[] expected = {};
        Ticket[] actual = manager.searchBy("AAQ", "IKU");
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindFromOneTicket() {
        TicketManager manager = new TicketManager(new TicketRepository());
        manager.addTicket(ticket5);
        Ticket[] expected = {ticket5};
        Ticket[] actual = manager.searchBy("ULK", "DME");
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldRemoveTicketById(){
        TicketManager manager = new TicketManager(new TicketRepository());
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);
        manager.removeTicketById(5);
        Ticket[] expected = {ticket1, ticket2, ticket4, ticket5, ticket6};
        Ticket[] actual = manager.getTicket();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldTryToRemoveTicketFromRepositoryIfIdNotHave(){
        TicketManager manager = new TicketManager(new TicketRepository());
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        Assertions.assertThrows(NotFoundException.class, () ->{
            manager.removeTicketById(6);
        });
    }


}
