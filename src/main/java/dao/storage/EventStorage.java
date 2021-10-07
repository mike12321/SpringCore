package dao.storage;

import model.Event;

import java.util.Map;
public class EventStorage {
    Map<Long, Event> eventStorage;

    public Map<Long, Event> getEventStorage() {
        return eventStorage;
    }

    String path;

    public void setEventStorage(Map<Long, Event> eventStorage) {
        this.eventStorage = eventStorage;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }


}
