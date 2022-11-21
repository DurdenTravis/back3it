package cl.it.test.testit.service;

import java.util.List;

import cl.it.test.testit.entity.Poll;
import cl.it.test.testit.model.PollResponseModel;

public interface PollService {

	List<PollResponseModel> findAll();
	
	Poll findByEmail(String email);
	
	Poll save(Poll poll);
}
