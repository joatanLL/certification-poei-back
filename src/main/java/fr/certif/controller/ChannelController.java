package fr.certif.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.certif.model.Channel;
import fr.certif.service.ChannelService;

@RestController
@RequestMapping(path = "/channel")
public class ChannelController {

	@Autowired
	ChannelService cs;
	
	private final String URL = "/channel";
	

	//LISTE CHANNEL
	@CrossOrigin("http://localhost:4200")
	@GetMapping(path = "/list", // path / url
			produces = { "application/json" } // négociation de contenu / par défaut JSON
	)
	public List<Channel> channels() {
		return cs.getAll();

	}
	
	//GET ONE CHANNEL
		@GetMapping(path="/list/{id}",
				    produces={"application/json"} 	
	    )
		@ResponseStatus(code=HttpStatus.FOUND)
		public Optional<Channel> getChannel(@PathVariable ("id") Long id) {
			
			return cs.getChannelById(id);
				
		}
		
	//ADD CHANNEL
	@GetMapping (path = "/post")
	public String getFormulaireAdd() {
		return URL + "/post";
	}

	@PostMapping(path = "/post", // path / url
			consumes = { "application/json" } // négociation de contenu / par défaut JSON
	)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void postFormAdd(@RequestBody Channel channel) {

		cs.saveChannel(channel);

		
	}
	@PutMapping(path = "/put", // path / url
			consumes = { "application/json" } // négociation de contenu / par défaut JSON
			)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void putFormAdd(@RequestBody Channel channel) {
		
		cs.saveChannel(channel);
		
	}
	
	//SUPPRESSION CHANNEL
	@DeleteMapping(path = "/delete/{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void deleteChannel(@PathVariable ("id") Long id) {

		cs.deleteChannel(id);
		System.out.println("channel supprimé");

	}
}