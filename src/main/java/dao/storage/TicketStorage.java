package dao.storage;

import model.Ticket;

import java.util.TreeMap;
public class TicketStorage {
    TreeMap<Long, Ticket> ticketStorage;
    private String path;

    public void setTicketStorage(TreeMap<Long, Ticket> ticketStorage) {
        this.ticketStorage = ticketStorage;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public TreeMap<Long, Ticket> getTicketStorage() {
        return ticketStorage;
    }

    public String getPath() {
        return path;
    }
}
