package dao.impl;

import dao.TicketDAO;
import dao.storage.TicketStorage;
import model.Event;
import model.Ticket;
import model.User;
import model.impl.TicketImpl;

import java.util.List;
import java.util.stream.Collectors;

public class TicketDAOImpl implements TicketDAO {
    private final TicketStorage ticketStorage;

    public TicketDAOImpl(TicketStorage ticketStorage) {
        this.ticketStorage = ticketStorage;
    }

    @Override
    public Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category) {
        long id = ticketStorage.getTicketStorage().lastKey() + 1;
        Ticket ticket = new TicketImpl(id, userId, eventId, category, place);

        return ticketStorage.getTicketStorage().put(id, ticket);
    }

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return ticketStorage.getTicketStorage().values().stream()
                .filter(ticket -> ticket.getUserId() == user.getId())
                .skip((long) (pageNum - 1) * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return ticketStorage.getTicketStorage().values().stream()
                .filter(ticket -> ticket.getEventId() == event.getId())
                .skip((long) (pageNum - 1) * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
    }

    @Override
    public boolean cancelTicket(long ticketId) {
        return ticketStorage.getTicketStorage().remove(ticketId) != null;
    }
}
