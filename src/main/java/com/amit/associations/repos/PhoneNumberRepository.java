package com.amit.associations.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amit.associations.entities.PhoneNumber;
@Repository
public interface PhoneNumberRepository extends CrudRepository<PhoneNumber, Long>{

}
