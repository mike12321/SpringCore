package model.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import model.Event;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class EventImpl implements Event {
    long id;

    String title;

    Date date;

    public EventImpl(long id) {
        this.id = id;
    }
}
