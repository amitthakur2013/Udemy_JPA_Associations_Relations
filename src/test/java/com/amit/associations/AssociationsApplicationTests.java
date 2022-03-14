package com.amit.associations;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;import org.hibernate.resource.beans.internal.FallbackBeanInstanceProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.amit.associations.entities.Customer;
import com.amit.associations.entities.PhoneNumber;
import com.amit.associations.repos.CustomerRepository;

@SpringBootTest
class AssociationsApplicationTests {
	
	@Autowired
	CustomerRepository repository;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testCreateCustomer() {
		Customer customer = new Customer();
		customer.setName("John");
		
		PhoneNumber e = new PhoneNumber();
		e.setNumber("1234567890");
		e.setType("cell");
		
		
		PhoneNumber e2 = new PhoneNumber();
		e2.setNumber("9873456543");
		e2.setType("home");
		
		customer.addPhoneNumber(e);
		customer.addPhoneNumber(e2);
		
		repository.save(customer);
	}
	
	@Test
	@Transactional  // For Lazy Loading mark it as Transactional
	public void testLoadCustomer() {
		Customer customer=repository.findById(4L).get();
		Set<PhoneNumber> numbers = customer.getNumbers();
		numbers.forEach(e -> System.out.println(e.getNumber()));
		System.out.println(customer.getName());
	}
	
	
	@Test
	@Transactional
	@Rollback(false)
	public void testUpdateCustomer() {
		Customer customer=repository.findById(4L).get();
		customer.setName("John Bull");
		Set<PhoneNumber> numbers = customer.getNumbers();
		numbers.forEach(e -> e.setType("cell"));
	
		repository.save(customer);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void testDeleteCustomer() {
		repository.deleteById(4L);
	}
	

}
