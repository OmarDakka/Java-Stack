package com.codingdojo.loginandregisteration.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.loginandregisteration.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByEmail(String Email);
}
