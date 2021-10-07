package dao.impl;

import dao.EventDAO;
import dao.storage.EventStorage;
import model.Event;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventDAOImpl implements EventDAO {
    private final EventStorage eventStorage;

    public EventDAOImpl(EventStorage eventStorage) {
        this.eventStorage = eventStorage;
    }

    @Override
    public Event getEvent(long id) {
        return eventStorage.getEventStorage().get(id);
    }

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return eventStorage.getEventStorage().values().stream()
                .filter(event -> event.getTitle().equals(title))
                .skip((long) (pageNum - 1) * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
    }

    @Override
    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return eventStorage.getEventStorage().values().stream()
                .filter(event -> event.getDate().equals(day))
                .skip((long) (pageNum - 1) * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
    }

    @Override
    public Event createEvent(Event event) {
        return eventStorage.getEventStorage().put(event.getId(), event);
    }

    @Override
    public Event updateEvent(Event event) {
        return createEvent(event);
    }

    @Override
    public boolean deleteEvent(long eventId) {
        return eventStorage.getEventStorage().remove(eventId) != null;
    }
}
