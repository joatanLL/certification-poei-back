package fr.certif.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="channel")

public class Channel implements Serializable{

		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@Column(nullable = false, length = 20, name ="name")
		private String name;
		
			
		@Column(nullable = false, name ="general")
		private int general = 0;
				
		@OneToMany(mappedBy = "channel", cascade=CascadeType.ALL)
		@JsonIgnore
		private List<Message> messages = new ArrayList<>();

			
		
}