package fr.certif.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import fr.certif.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  {
	
	//Automatise les find, findAll, read, query, count et get et recherche après le By
	
	
}
