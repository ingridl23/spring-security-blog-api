package com.ingrid.blogapi.dto;

import java.util.Date;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequest {

	
	private String titulo;
	
	private String content;
	
	private Date created_at;
	Long authorId;
}
