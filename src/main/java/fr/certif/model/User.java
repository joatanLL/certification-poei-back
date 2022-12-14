package fr.certif.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import lombok.Data;

@Data
@Entity
@Table(name="user")

public class User implements Serializable{

		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@Column(nullable = false, length = 20, name ="username")
		private String username;
		
		@OneToMany(mappedBy = "user" , fetch=FetchType.EAGER)
		@JsonIgnore
		private List<Message> messages = new ArrayList<Message>();

		public User() {		
		}
		
		public User(String username, List<Message> messages) {		
			this.username = username;
			this.messages = messages;
		}
		
		

}