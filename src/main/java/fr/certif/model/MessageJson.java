package fr.certif.model;

import java.io.Serializable;


import lombok.Data;

@Data
public class MessageJson implements Serializable{
	
private static final long serialVersionUID = 1L;
	

	/*private Long id;*/
	
	private String content;
		
	private Long channel;
	
	private Long  user;

}
