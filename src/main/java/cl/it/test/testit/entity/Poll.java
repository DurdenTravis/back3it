package cl.it.test.testit.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Poll implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @JsonFormat(pattern="dd-MM-yyyy")
    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    @Column(name = "email_poll")
    private String email;

    @Column(name = "kind_music_poll")
    private String kindMusic;

 
}
