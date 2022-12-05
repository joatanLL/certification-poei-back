package fr.certif.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.certif.model.Channel;
import fr.certif.model.Message;
import fr.certif.model.MessageJson;
import fr.certif.model.User;
import fr.certif.repository.ChannelRepository;
import fr.certif.repository.MessageRepository;
import fr.certif.repository.UserRepository;


@Service
public class MessageService {

	@Autowired
	UserRepository us;
	
	@Autowired
	ChannelRepository cs;
	
	@Autowired
	MessageRepository msr;
	
	public List<Message> getAll(){
		
		return msr.findAll();
	}
	
	public void saveMessage(MessageJson messageJson) {
		Message message = new Message();
		Channel channel = cs.findById(messageJson.getChannel()).get();
		User user = us.findById(messageJson.getUser()).get();
		message.setContent(messageJson.getContent());
		message.setChannel(channel);
		message.setUser(user);
		
		msr.save(message);
	}
	
	public void deleteMessage(Long id) {
		
		msr.deleteById(id);
	}
	
	public void StringMessage(Message message) {
		
		msr.toString();
	}
}
