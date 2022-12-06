package fr.certif.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.certif.model.Channel;
import fr.certif.repository.ChannelRepository;

@Service
public class ChannelService {

	@Autowired
	ChannelRepository csr;

	public List<Channel> getAll() {

		return csr.findAll();
	}
	
	public Optional<Channel> getChannelById(Long id) {
		
		return csr.findById(id);
	}

	public void saveChannel(Channel channel) {
		csr.save(channel);
	}

	public void updateChannel(Channel channel) {
		if (csr.existsById(channel.getId())) {
			csr.save(channel);
		} else {
			System.out.println("Channel inexistant");
		}

	}

	public void deleteChannel(Long id) {
		if (csr.existsById(id)) {
			csr.deleteById(id);
		} else {
			System.out.println("Suppression impossible");
		}
	}

	public void StringChannel(Channel channel) {

		csr.toString();
	}

	public String setMessageAjout(Channel channel) {
		return "Vous avez bien ajouté " + channel.getName() + ".";
	}

	public String setMessageDelete(Channel channel) {
		return "Vous avez bien supprimé " + channel.getName() + ".";
	}

}