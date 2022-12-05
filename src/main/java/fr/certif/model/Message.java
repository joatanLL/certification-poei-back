package fr.certif.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="message")
public class Message implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length= 255, name="content")
	private String content;
	
	@ManyToOne (fetch=FetchType.EAGER)
	@JoinColumn(name="channel_id")
	private Channel channel;
	
	@ManyToOne (fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
		

}
