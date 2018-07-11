package nemanja.springframework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nemanja.springframework.domain.Event;
import nemanja.springframework.repositories.EventRepository;

@Service
public class EventServiceImpl implements EventService {
	
	private EventRepository eventRepository;
	
	@Autowired
	public void setEventRepository(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	@Override
	public Iterable<Event> listAllEvents() {
		return eventRepository.findAll();
	}

	
	@Override
	public Event getEventById(Integer id) {
		return eventRepository.findOne(id);
		}

	@Override
	public Event saveEvent(Event event) {
		return eventRepository.save(event);
	}

	@Override
	public  void  deleteEvent(Integer id) {
		eventRepository.delete(id);
	}
	
}
