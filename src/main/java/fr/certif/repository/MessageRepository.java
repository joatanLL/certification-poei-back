package fr.certif.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.certif.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{
	
	@Query("SELECT m FROM Message m WHERE channel_id=?1")
	public List<Message> findByCanal(Long id);

}
