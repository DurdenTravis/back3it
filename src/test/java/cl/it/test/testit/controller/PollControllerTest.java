package cl.it.test.testit.controller;



import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cl.it.test.testit.entity.Poll;
import cl.it.test.testit.model.PollRequestModel;
import cl.it.test.testit.model.PollResponseModel;
import cl.it.test.testit.service.PollService;

@ExtendWith(MockitoExtension.class)
class PollControllerTest {
	
	@InjectMocks
	PollController pollController;
	
	
	@Mock
	PollService pollService;
	
	@Mock
	private BindingResult mockBingingdResult;

	@Before(value="")
	void setupTest() {
		MockitoAnnotations.openMocks(this);
		Mockito.when(mockBingingdResult.hasErrors()).thenReturn(false);
	}

	@Test
	void testFindAll() {
		List<PollResponseModel> list = new ArrayList<>();
		PollResponseModel model1 = new PollResponseModel("ROCK", 13L, 0);
		list.add(model1);
		PollResponseModel model2 = new PollResponseModel("POP", 13L, 0);
		list.add(model2);
		
		when(pollService.findAll()).thenReturn(list);
		
		ResponseEntity<Object> result = pollController.all();
		
		assertNotNull(result);
		
	}
	
	@Test
	void testCreate() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		PollRequestModel poll = new PollRequestModel(new Date(), "manuel.escarate.inf@gmail.com" , "ROCK");
		Poll pollEntiy1 = new Poll((long) 1,new Date(), "manuel.escarate.inf@gmail.com" , "ROCK");
		Poll pollEntiy2 = new Poll((long) 1,new Date(), "manuel.escarate.inf@gmail.com" , "ROCK");
		Mockito.when(mockBingingdResult.hasErrors()).thenReturn(false);
		
		when(pollService.findByEmail(anyString())).thenReturn(pollEntiy1);
		when(pollService.save(pollEntiy1)).thenReturn(pollEntiy2);

		ResponseEntity<Object> result = pollController.create(poll,mockBingingdResult);
		
		// assertThat(result.getStatusCode()).isEqualTo(201);
		
	}
	
	
}
