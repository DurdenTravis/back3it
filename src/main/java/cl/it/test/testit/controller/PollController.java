package cl.it.test.testit.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.it.test.testit.controller.exception.BusinessException;
import cl.it.test.testit.entity.Poll;
import cl.it.test.testit.model.PollRequestModel;
import cl.it.test.testit.service.PollService;

import static  cl.it.test.testit.util.Constants.MESSAGE;
import static  cl.it.test.testit.util.Constants.ERROR;
import static  cl.it.test.testit.util.Constants.ERRORS;

@RestController
@RequestMapping("polls")
@CrossOrigin("*")
public class PollController {

	private final Logger log = LoggerFactory.getLogger(PollController.class);

	@Autowired
	PollService pollService;

	@GetMapping("/")
	public ResponseEntity<Object> all() {
		if(log.isDebugEnabled()) {
			log.debug("Obteniendo encuestas");
		}
		return new ResponseEntity<>(pollService.findAll(), HttpStatus.OK);
	}

	@PostMapping("/poll")
	public ResponseEntity<Object> create(@Valid @RequestBody PollRequestModel poll, BindingResult result) {
		Poll newPoll = null;
		Map<String, Object> response = new HashMap<>();
		if(result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put(ERRORS, errors);
			throw new BusinessException("400", response.toString());
		}
		try {
			Poll pollEntity = Poll.builder()
					.createAt(new Date())
					.email(poll.getEmail())
					.kindMusic(poll.getKindMusic())
					.build();
			Poll pollByEmail = pollService.findByEmail(pollEntity.getEmail());
			if (pollByEmail != null) {
				response.put(MESSAGE, "Error al realizar la solicitud");
				response.put(ERROR, "Mail ya encuestado");
				return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			newPoll = pollService.save(pollEntity);
		} catch(DataAccessException e) {
			response.put(MESSAGE, "Error al realizar el insert en la base de datos");
			response.put(ERROR, e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put(MESSAGE, "Su respuesta ha sido creada con éxito!");
		response.put("poll", newPoll);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

}
