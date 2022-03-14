package com.amit.associations;

import java.util.HashSet;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.amit.associations.manytomany.entities.Programmer;
import com.amit.associations.manytomany.entities.Project;
import com.amit.associations.manytomany.repository.ProgrammerRepository;

@SpringBootTest
class ManyToManyTests {
	
	@Autowired
	ProgrammerRepository repository;

	@Test
	void contextLoads() {
	}
	
	@Test
	void testM2MCreateProgrammer() {
		Programmer programmer = new Programmer();
		programmer.setName("John");
		programmer.setSalary(10000);
		
		HashSet<Project> projects = new HashSet<Project>();
		
		Project project = new Project();
		project.setName("Hibernate Project");
		projects.add(project);
		
		programmer.setProjects(projects);
		
		repository.save(programmer);
	}
	
	@Test
	@Transactional
	void testLoad() {
		Programmer programmer = repository.findById(1).get();
		
		System.out.println(programmer);
		System.out.println(programmer.getProjects());
	}
	
}
