package cl.it.test.testit.model;


import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PollRequestModel {
	
    @JsonFormat(pattern="dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
	private Date createAt;
	
    @NotEmpty(message = "no puede estar vacio")
	private String email;
	
    @NotEmpty(message = "no puede estar vacio")
	private String kindMusic;

}
