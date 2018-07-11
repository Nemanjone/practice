package nemanja.springframework.services;

import nemanja.springframework.domain.Event;

public interface EventService {

	    Iterable<Event> listAllEvents();

	    Event getEventById(Integer id);

	    Event saveEvent(Event event);

	    void deleteEvent(Integer id);
}
