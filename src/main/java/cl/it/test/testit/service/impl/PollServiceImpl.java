package cl.it.test.testit.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cl.it.test.testit.entity.Poll;
import cl.it.test.testit.model.PollResponseModel;
import cl.it.test.testit.repository.PollRepository;
import cl.it.test.testit.service.PollService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PollServiceImpl implements PollService {

	private final Logger log = LoggerFactory.getLogger(PollServiceImpl.class);

	private final PollRepository repository;

	private List<PollResponseModel> listResponse = null;

	@Override
	public List<PollResponseModel> findAll() {
		if (log.isDebugEnabled()) {
			log.debug("findAll");
		}
		List<Poll> list = (List<Poll>) repository.findAll();
		listResponse = new ArrayList<>();
		
		Map<String, Long> result = list.stream()
				.collect(Collectors.groupingBy(Poll::getKindMusic, Collectors.counting()));
		result.forEach((k,v) -> listResponse.add(new PollResponseModel(k,v,list.size())));
		
		return listResponse;
	}

	@Override
	public Poll save(Poll poll) {
		return repository.save(poll);
	}

	@Override
	public Poll findByEmail(String email) {
		return repository.findByEmail(email);
	}

}
