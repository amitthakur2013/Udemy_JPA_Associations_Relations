package com.amit.associations.manytomany.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amit.associations.manytomany.entities.Programmer;
@Repository
public interface ProgrammerRepository extends CrudRepository<Programmer, Integer> {

}
