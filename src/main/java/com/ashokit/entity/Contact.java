package com.ashokit.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;

//import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
@Entity
@Table(name = "CONTAC_DTLS")
public class Contact {

	@Id
	@GeneratedValue
	private Integer cid;

	private String name;
	private String email;
	private long phno;
	private String activeSw;

}
