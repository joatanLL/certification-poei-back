package fr.certif.model;

import java.io.Serializable;


import lombok.Data;
/*  recuperation de l'id de user et channel  */
@Data
public class MessageJson implements Serializable{
	
private static final long serialVersionUID = 1L;
	

	/*private Long id;*/
	
	private String content;
		
	private Long channel;
	
	private Long  user;

}
