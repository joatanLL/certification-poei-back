package fr.certif.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.certif.model.Message;
import fr.certif.repository.MessageRepository;


@Service
public class MessageService {

	@Autowired
	MessageRepository msr;
	
	public List<Message> getAll(){
		
		return msr.findAll();
	}
	
	public void saveMessage(Message message) {
		
		msr.save(message);
	}
	
	public void deleteMessage(Long id) {
		
		msr.deleteById(id);
	}
	
	public void StringMessage(Message message) {
		
		msr.toString();
	}
}
