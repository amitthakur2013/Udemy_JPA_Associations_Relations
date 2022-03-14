package com.amit.associations.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amit.associations.entities.Customer;
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
