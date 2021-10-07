package model.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import model.Ticket;

import java.util.Date;

@AllArgsConstructor
@Setter
@Getter
public class TicketImpl implements Ticket {
    long id;

    long eventId;

    long userId;

    Category category;

    int place;

    public TicketImpl(long id) {
        this.id = id;
    }
}
