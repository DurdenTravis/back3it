package cl.it.test.testit.components;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import cl.it.test.testit.entity.Poll;
import cl.it.test.testit.enums.MusicTypeEnum;
import cl.it.test.testit.repository.PollRepository;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
    private PollRepository pollRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		pollRepository.save(new Poll((long) 1, new Date(), "manuel.escarate.inf@gmail.com" ,MusicTypeEnum.CLASICA.description));
		pollRepository.save(new Poll((long) 2, new Date(),  "manuel.escarate1.inf@gmail.com" ,MusicTypeEnum.ROCK.description));
		pollRepository.save(new Poll((long) 3, new Date(),  "manuel.escarate2.inf@gmail.com" ,MusicTypeEnum.JAZZ.description));
		pollRepository.save(new Poll((long) 4, new Date(),  "manuel.escarate3.inf@gmail.com" ,MusicTypeEnum.OTRO.description));
		pollRepository.save(new Poll((long) 5, new Date(),  "manuel.escarate4.inf@gmail.com" ,MusicTypeEnum.OTRO.description));
	}

}