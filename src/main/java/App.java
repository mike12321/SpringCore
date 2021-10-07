import dao.EventDAO;
import dao.storage.EventStorage;
import dao.storage.TicketStorage;
import facade.BookingFacade;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "app.xml"
        );

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        EventStorage eventStorage = context.getBean("eventStorage", EventStorage.class);

        TicketStorage ticketStorage = context.getBean("ticketStorage", TicketStorage.class);

        BookingFacade bookingFacade = context.getBean("bookingFacade", BookingFacade.class);

        EventDAO eventDao = context.getBean("eventDAO", EventDAO.class);

        bookingFacade.getEventById(1);

        try {
            bookingFacade.getEventsForDay(simpleDateFormat.parse("2021-10-29"), 1, 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        bookingFacade.getEventsByTitle("Event1", 1, 2);

        bookingFacade.getUserByEmail("john@email.com");

        context.close();
    }
}
