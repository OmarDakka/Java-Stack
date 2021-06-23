package com.codingdojo.relationships.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.relationships.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
	List<Person> findAll();
	@Query(value="SELECT p.* From persons p LEFT OUTER JOIN licenses l on p.id=l.person_id WHERE l.id IS NULL", nativeQuery=true)
	List<Person> findByNoLicense();
	
	List<Person> findByLicenseIdIsNull();
}
