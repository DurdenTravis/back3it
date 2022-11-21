package cl.it.test.testit.repository;

import org.springframework.data.repository.CrudRepository;

import cl.it.test.testit.entity.Poll;

public interface PollRepository extends CrudRepository<Poll, Long> {
	
	Poll findByEmail(String email);

}
