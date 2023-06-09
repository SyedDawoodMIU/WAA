package com.waa.assignments;

import com.waa.assignments.entity.business.Role;
import com.waa.assignments.repo.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class AssignmentsApplication implements CommandLineRunner {

	@Autowired
	private RoleRepository roleRepository;
	public static void main(String[] args) {
		SpringApplication.run(AssignmentsApplication.class, args);
	}


	@Override
	public void run(String... args) {
		if(roleRepository.findByName("Admin").isEmpty()){
			roleRepository.save(Role.builder().name("Admin").build());
		};
		if(roleRepository.findByName("Client").isEmpty()){
			roleRepository.save(Role.builder().name("Client").build());
		};

	}
}
