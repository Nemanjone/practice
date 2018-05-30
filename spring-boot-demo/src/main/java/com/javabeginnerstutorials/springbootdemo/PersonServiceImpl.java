package com.javabeginnerstutorials.springbootdemo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
	
@Autowired
private PersonRepository personRepository;

	public Person createPerson(Person person) {
		return personRepository.save(person);
	}

	public Optional<Person> getPerson(Long id) {
		return personRepository.findById(id);
	}

	public Person editPerson(Person person) {
		return personRepository.save(person);
	}

	public void deletePerson(Person person) {
		 personRepository.delete(person);
		
	}

	public void deletePerson(Long id) {
	 personRepository.deleteById(id);	
	}

	public List<Person> getAllPersons(int pageNumber, int pageSiz) {
		return personRepository.findAll(new PageRequest(pageNumber, pageSiz)).getContent();
	}

	public List<Person> getAllPerson() {
		return personRepository.findAll();
	}
	
}
