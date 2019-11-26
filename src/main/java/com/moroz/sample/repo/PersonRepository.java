package com.moroz.sample.repo;

import com.moroz.sample.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
