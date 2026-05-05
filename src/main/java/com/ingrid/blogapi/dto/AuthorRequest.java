package com.ingrid.blogapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorRequest {

	private String nombre;
	private String email;
	private String bio;
}
