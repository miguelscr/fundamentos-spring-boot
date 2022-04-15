package com.example.fundamentosspring.fundamentos;

import com.example.fundamentosspring.fundamentos.Bean.*;
import com.example.fundamentosspring.fundamentos.configuration.*;
import com.example.fundamentosspring.fundamentos.component.ComponentDependency;
import com.example.fundamentosspring.fundamentos.entity.User;
import com.example.fundamentosspring.fundamentos.pojo.UserPojo;
import com.example.fundamentosspring.fundamentos.repository.UserRepository;
import com.example.fundamentosspring.fundamentos.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanNewDependency myBeanNewDependency;
	private MyBeanHiDependency myBeanHiDependency;
	private MyBeanPropeties myBeanPropeties;
	//private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;
	private UserService userService;

	public FundamentosApplication(@Qualifier("componentThreeImplement") ComponentDependency componentDependency,
								  MyBean myBean, MyBeanWithDependency myBeanWithDependency,
								  MyBeanNewDependency myBeanNewDependency,MyBeanPropeties myBeanPropeties, UserPojo userPojo,
								  UserRepository userRepository, UserService userService){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanNewDependency = myBeanNewDependency;
		//this.myBeanHiDependency = myBeanHiDependency;
		//this.myBeanWithProperties = myBeanWithProperties;
		this.myBeanPropeties = myBeanPropeties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		saveUsersInDataBase();
		getInformationJpqlFromUsers();
		saveWithErrorTransactional();
	}

	private void saveWithErrorTransactional(){
		User test1 = new User("TestTransactional1", "TestTransactional1@domain.com", LocalDate.now());
		User test2 = new User("TestTransactional2", "TestTransactional2@domain.com", LocalDate.now());
		User test3 = new User("TestTransactional3", "TestTransactional3@domain.com", LocalDate.now());
		User test4 = new User("TestTransactional4", "TestTransactional4@domain.com", LocalDate.now());

		List<User> users = Arrays.asList(test1,test2,test3,test4);
		userService.saveTransactional(users);

		userService.getAllUsers()
				.stream()
				.forEach(user -> LOGGER.info("Usuario dentro del método transaccional " + user));
	}

	private void getInformationJpqlFromUsers(){
		/*LOGGER.info("Usuario con el método findByUserName " + userRepository.findByUserEmail("miguel@ejemplo.com")
				.orElseThrow(() -> new RuntimeException("No se encontró el usuario")));
		userRepository.findAndSort("Ejem", Sort.by("id").descending())
				.stream()
				.forEach(user -> LOGGER.info("Usuario con método sort " + user));
		userRepository.findByName("Wendy")
				.stream()
				.forEach(user -> LOGGER.info("Usuario con Query method" + user));
		LOGGER.info("Usuario con query method findByEmailAndName " + userRepository.findByEmailAndName("miguel@ejemplo.com","Daniela")
				.orElseThrow(() -> new RuntimeException("No se encontró el usuario")));
		userRepository.findByNameLike("%M%")
				.stream()
				.forEach(user -> LOGGER.info("Se encontró findByNameLike "+ user));
		userRepository.findByNameOrEmail(null,"miguel@ejemplo.com")
				.stream()
				.forEach(user -> LOGGER.info("Se encontró findByNameOrEmail "+ user));

		userRepository.findByBirthDateBetween(LocalDate.of(2012,12,23),LocalDate.of(2020,11,29))
				.stream()
				.forEach(user -> LOGGER.info("User findByBirthdateBetween " + user));*/
		userRepository.findByNameContainingOrderByIdDesc("Miguel")
				.stream()
				.forEach(user -> LOGGER.info("Usuario findByNameContainingOrderByIdDesc " + user));
		LOGGER.info("Usuario getAllByBirthdayAndEmail " + userRepository.getAllByBirthdayAndEmail(LocalDate.of(2022,12,12),"miguel@ejemplo.com")
				.orElseThrow(() -> new RuntimeException("No se encontró el usuario")));
	}

	private void saveUsersInDataBase(){
		User user1 = new User("Miguel","miguel@ejemplo.com", LocalDate.of(2022,12,12));
		User user2 = new User("Wendy","Wendy@ejemplo.com", LocalDate.of(2021,11,23));
		User user3 = new User("Ejemplo","Ejemplo@ejemplo.com", LocalDate.of(2023,10,21));
		User user4 = new User("Luis","Luis@ejemplo.com", LocalDate.of(2024,9,14));
		User user5 = new User("Keee","Keee@ejemplo.com", LocalDate.of(2020,1,13));
		List<User> list = Arrays.asList(user1,user2,user3,user4,user5);
		list.stream().forEach(userRepository::save);
	}

	private void ejemplosAnteriores(){
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		myBeanNewDependency.showIt();
		System.out.println(myBeanPropeties.showMe());
		System.out.println(userPojo.getEmail() + " " + userPojo.getPassword() + " " +userPojo.getAge());
		//myBeanHiDependency.sayHi();
		//System.out.println(myBeanWithProperties.function());
		try{
			int value = 10/0;
			LOGGER.debug("no llegas");
		}catch(Exception e){
			LOGGER.error("Esto es un error :'v " + e.getMessage());
		}
	}
}
