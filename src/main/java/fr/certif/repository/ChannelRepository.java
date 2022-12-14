package fr.certif.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.certif.model.Channel;


@Repository
public interface ChannelRepository  extends JpaRepository<Channel, Long> {
	
	@Query("SELECT c FROM Channel c WHERE general=1")
	public List<Channel> findGeneral();
	
	
}