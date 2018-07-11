package nemanja.springframework;

import nemanja.springframework.RepositoryConfiguration;
import nemanja.springframework.domain.Event;
import nemanja.springframework.repositories.EventRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.awt.Font;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {RepositoryConfiguration.class})

public class EventRepositoryTest {

	private EventRepository eventRepository;

	@Autowired
	public void setEventRepository(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	@Test
	public void testSaveEvent(){
		//setup event
		Event event = new Event();
		event.setEventName("Java Conference");
		event.setCreatedBy("Nemanja Balaban");
		event.setStartingDate("24.8.2018.");
		event.setStartingTime("16.00");
		event.setPlace("Gecko office");

		//save event, verify has name value after save
		assertNull(event.getEventName()); //null before save
		eventRepository.save(event);
		assertNotNull(event.getEventName()); //not null after save

		//fetch from DB
		Event fetchedEvent = eventRepository.findOne(event.getId());

		//should not be null
		assertNotNull(fetchedEvent);

		//should equal
		assertEquals(event.getId(), fetchedEvent.getId());
		assertEquals(event.getEventName(), fetchedEvent.getEventName());

		//update name and save
		fetchedEvent.setEventName("Java Cool Conference");
		eventRepository.save(fetchedEvent);

		//get from DB, should be updated
		Event fetchedUpdatedEvent = eventRepository.findOne(fetchedEvent.getId());
		assertEquals(fetchedEvent.getEventName(), fetchedUpdatedEvent.getEventName());

		//verify count of events in DB
		long eventCount = eventRepository.count();
		assertEquals(eventCount, 1);

		//get all events, list should only have one
		Iterable<Event> events = eventRepository.findAll();

		int count = 0;

		for(Event e : events){
			count++;
		}

		assertEquals(count, 1);
	}
}
