package fr.certif.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.certif.service.MessageService;

@RestController
@RequestMapping(path="/message")
public class MessageController {
	
	@Autowired
	MessageService messageService;
	

}
