package fr.certif.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

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
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, name="date")
	private Date LastUpdate;
	
	@PrePersist
	private void onCreate() {
		LastUpdate = new Date();
	}
	
	@ManyToOne ()
	@JsonIncludeProperties(value= {"id", "name"})
	@JoinColumn(name="channel_id")
	private Channel channel;
	
	@ManyToOne ()
	@JsonIncludeProperties(value= {"id", "username"})
	@JoinColumn(name="user_id")
	private User user;
	
		

}
