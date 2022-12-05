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

import fr.certif.model.Channel;
import fr.certif.service.ChannelService;

@RestController
@RequestMapping(path = "/channel")
public class ChannelController {

	@Autowired
	ChannelService channelService;

	/*
	 * Exemple avec JPA
	 */

	@GetMapping(path = "/list", // path / url
			produces = { "application/json" } // négociation de contenu / par défaut JSON
	)
	public List<Channel> channels() {

		return channelService.getAll();

	}

	@PostMapping(path = "/post", // path / url
			consumes = { "application/json" } // négociation de contenu / par défaut JSON
	)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void getUserJpa(@RequestBody Channel channel) {

		channelService.saveChannel(channel);

	}

	@DeleteMapping(path = "/delete/{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void deleteChannel(@PathVariable ("id") Long id) {

		channelService.deleteChannel(id);
		System.out.println("channel supprimé");

	}
}