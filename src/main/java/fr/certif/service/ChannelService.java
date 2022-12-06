package fr.certif.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.certif.model.Channel;
import fr.certif.repository.ChannelRepository;


@Service
public class ChannelService {
		
		@Autowired 
		ChannelRepository csr;
		
		
		public List<Channel> getAll(){
			
			return csr.findAll();
		}
		
		public void saveChannel(Channel channel) {
			
			csr.save(channel);
		}
		
		public void updateChannel(Channel channel) {
			
			csr.save(channel);
		}
		
		public void deleteChannel(Long id) {
			
			csr.deleteById(id);
		}
		
		public void StringChannel(Channel channel) {
			
			csr.toString();
		}
		
		public String setMessageAjout (Channel channel) {
			return "Vous avez bien ajouté "+ channel.getName() + ".";
		}

		public String setMessageDelete(Channel channel) {
			return "Vous avez bien supprimé "+ channel.getName() + ".";
		}



}