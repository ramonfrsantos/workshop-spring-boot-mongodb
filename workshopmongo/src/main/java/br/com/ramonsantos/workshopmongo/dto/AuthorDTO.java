package br.com.ramonsantos.workshopmongo.dto;

import java.io.Serializable;

import br.com.ramonsantos.workshopmongo.domain.User;

public class AuthorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;

	public AuthorDTO(User user) {
		this.id = user.getId();
		this.name = user.getName();
	}

	public AuthorDTO() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
