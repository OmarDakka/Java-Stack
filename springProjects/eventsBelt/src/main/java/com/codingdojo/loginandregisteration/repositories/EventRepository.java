package com.codingdojo.loginandregisteration.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.loginandregisteration.models.Event;


@Repository
public interface EventRepository extends CrudRepository<Event, Long>{
	List<Event> findByState(String state);
	List<Event> findByStateIsNot(String state);

}
