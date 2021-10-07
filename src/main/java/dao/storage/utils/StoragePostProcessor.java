package dao.storage.utils;

import dao.storage.EventStorage;
import dao.storage.TicketStorage;
import model.Event;
import model.Ticket;
import model.impl.EventImpl;
import model.impl.TicketImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

public class StoragePostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof EventStorage) {
            Map<Long, Event> events = ((EventStorage) bean).getEventStorage();

            try {
                List<String> lines = Files.readAllLines(Paths.get(((EventStorage) bean).getPath()));
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Event temp = null;

                for (String line : lines) {
                    String value = line.split(":")[1].trim();
                    if (line.startsWith("id:")) {
                        long id = Long.parseLong(value);
                        temp = new EventImpl(id);
                        events.put(id, temp);
                    } else if (line.startsWith("title:")) {
                        temp.setTitle(value);
                    } else if (line.startsWith("date:")) {
                        temp.setDate(simpleDateFormat.parse(value));
                    }
                }
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }

        if (bean instanceof TicketStorage) {
            Map<Long, Ticket> tickets = ((TicketStorage) bean).getTicketStorage();

            try {
                List<String> lines = Files.readAllLines(Paths.get(((TicketStorage) bean).getPath()));
                Ticket temp = null;

                for (String line : lines) {
                    String value = line.split(":")[1].trim();
                    if (line.startsWith("id:")) {
                        long id = Long.parseLong(value);
                        temp = new TicketImpl(id);
                        tickets.put(id, temp);
                    } else if (line.startsWith("eventId:")) {
                        temp.setEventId(Long.parseLong(value));
                    } else if (line.startsWith("userId:")) {
                        temp.setUserId(Long.parseLong(value));
                    } else if (line.startsWith("category:")) {
                        temp.setCategory(Enum.valueOf(Ticket.Category.class, value));
                    } else if (line.startsWith("place:")) {
                        temp.setPlace(Integer.parseInt(value));
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return bean;
    }

}
