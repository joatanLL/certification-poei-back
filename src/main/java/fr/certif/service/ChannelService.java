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
        if(channel.getGeneral() != 1) {
            csr.save(channel);
        } else {
            System.err.println("Channel General déjà crée!");
        }

    }

    public Channel findGeneral() {
        return csr.findGeneral().get(0);

    }

 
    public void updateChannel(Channel channel) {
        
            csr.save(channel);
      

    }

 
    public void deleteChannel(Long id) {
        if (csr.existsById(id) && csr.findById(id).get().getGeneral() !=1) {
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