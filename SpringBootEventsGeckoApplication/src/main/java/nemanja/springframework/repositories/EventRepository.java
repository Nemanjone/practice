package nemanja.springframework.repositories;

import org.springframework.data.repository.CrudRepository;
import nemanja.springframework.domain.Event;

public interface EventRepository extends CrudRepository<Event, Integer> {

}
