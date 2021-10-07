package service.impl;

import dao.EventDAO;
import dao.impl.EventDAOImpl;
import model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.EventService;

import java.util.Date;
import java.util.List;

public class EventServiceImpl implements EventService {
    @Autowired
    private EventDAO eventDAO;

    @Override
    public Event getEventById(long id) {
        return eventDAO.getEvent(id);
    }

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return eventDAO.getEventsByTitle(title, pageSize, pageNum);
    }

    @Override
    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return eventDAO.getEventsForDay(day, pageSize, pageNum);
    }

    @Override
    public Event createEvent(Event event) {
        return eventDAO.createEvent(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventDAO.updateEvent(event);
    }

    @Override
    public boolean deleteEvent(long eventId) {
        return eventDAO.deleteEvent(eventId);
    }

    public void setEventDAO(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }
}
