package fr.certif.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.certif.model.Message;
import fr.certif.model.MessageJson;
import fr.certif.service.MessageService;

@RestController
@RequestMapping(path = "/message")
public class MessageController {

	@Autowired
	MessageService messageService;
	
	private final String URL = "/channel";

	/*
	 * Exemple avec JPA
	 */

	//LISTE MESSAGE
	@GetMapping(path = "/list", // path / url
			produces = { "application/json" } // négociation de contenu / par défaut JSON
	)
	public List<Message> getMessages() {

		return messageService.getAll();

	}
	
	//AJOUT MESSAGE
	@GetMapping (path = "/post")
	public String getMessageAdd() {
		return URL + "/post";
	}

	@PostMapping(path = "/post", // path / url
			consumes = { "application/json" } // négociation de contenu / par défaut JSON
	)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void getMessageJpa(@RequestBody MessageJson message) {
		
		System.out.println(message);
		messageService.saveMessage(message);

	}

	@DeleteMapping(path = "/delete/{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void deletUser(@PathVariable ("id") Long id) {

		messageService.deleteMessage(id);
		System.out.println("utilisateur effacé");

	}
}
