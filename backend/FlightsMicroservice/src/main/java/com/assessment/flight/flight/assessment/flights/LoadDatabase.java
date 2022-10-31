package com.assessment.flight.flight.assessment.flights;

import java.time.LocalDate;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LoadDatabase {
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	//Sevilla, Madrid, Berlin, Barcelona, Paris
	  @Bean
	  CommandLineRunner initDatabase(FlightRepository repository) {
	    return args -> {
	      log.info("Preloading " + repository.save(new Flight("Vueling", LocalDate.of(2022, 10, 31), "Sevilla", "Madrid", null, true)));
	      log.info("Preloading " + repository.save(new Flight("Rayanair", LocalDate.of(2022, 10, 31), "Sevilla", "Berlin", Arrays.asList("Madrid", "Paris"), false)));
	      log.info("Preloading " + repository.save(new Flight("Iberia", LocalDate.of(2022, 11, 01), "Paris", "Barcelona", null, true)));

	    };
	  }
	  
	  /*@Bean
	  CommandLineRunner initUsersDatabase(UserAccountRepository repository) {

	    return args -> {
	      log.info("Preloading " + repository.save(new UserAccount("solera", "account","solera@solera.com","bootcamp2")));
	    };
	  }
	  @Bean
	  CommandLineRunner initBanksDatabaseBanks(Flight repository) {

	    return args -> {
	      log.info("Preloading " + repository.save(new BankAccount("BBVA", "solera@solera.com")));
	      log.info("Preloading " + repository.save(new BankAccount("Santander", "framarlav")));
	      log.info("Preloading " + repository.save(new BankAccount("BBVA", "framarlav")));
	    };
	  }
	  @Bean
	  CommandLineRunner initTransactionsDatabaseTransactions(TransactionRepository repository) {

	    return args -> {
	      log.info("Preloading " + repository.save(new Transaction("solera@solera.com", "framarlav","BBVA","Santander",2000)));
	    };
	  }*/
}
