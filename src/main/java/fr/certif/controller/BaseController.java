package fr.certif.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.certif.model.Channel;
import fr.certif.model.Message;
import fr.certif.service.ChannelService;
import fr.certif.service.MessageService;

@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RestController
public class BaseController {
	
	@Autowired
	ChannelService cs;
	
	@Autowired
	MessageService ms;
	
	
	@RequestMapping(path="/general", method=RequestMethod.GET, produces= {"application/json"})
	public Map<String, Object> getGeneralEndpoint(Model model) {
		
		//Creation d'un map pour les listes
		Map<String, Object> map = new HashMap<String, Object>();
		List<Channel> channelList = cs.getAll(); 
		map.put("channelList", channelList);
		
		List<Message> messageList = ms.getMessageByCanal(cs.findGeneral().getId());
		map.put("messageList", messageList);
		
		return map;
	}
	
}
