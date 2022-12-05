package fr.certif.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.certif.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{

}
