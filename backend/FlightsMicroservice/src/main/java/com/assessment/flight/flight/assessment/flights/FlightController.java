package com.assessment.flight.flight.assessment.flights;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@Service("FlightController")
public class FlightController{
	
	private static FlightRepository repository;
	@Autowired
	FlightController(FlightRepository repository){
		FlightController.repository = repository;
	}
	@Bean(name="entityManagerFactory")
	public LocalSessionFactoryBean sessionFactory() {
	    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

	    return sessionFactory;
	} 
	@GetMapping ("/flights/")
	public static List<Flight> AvailableFlights(){
		return repository.findAll();
	}
	
	@GetMapping ("/flight/{id}")
	public Flight getFlightById(@PathVariable long id) {
		Optional<Flight> myFlight = repository.findById(id);
		return myFlight.get();
	}
	
	//Metodo para devolver los vuelos en una fecha
	@GetMapping ("/flight/{date}+{origin}+{destination}")
	public static List<Flight> availableFlightsFromACityAndDate
	(@PathVariable LocalDate date,@PathVariable String origin,@PathVariable String destination) {
		return FlightDaoService.getByDate(repository.findAll(), date, origin, destination);
	}
	
	//Metodo restar asiento
	@PutMapping ("/flight/reserva/{id}")
	public static void reservaAsiento(@PathVariable Long id) {
		Optional<Flight> myFlight = repository.findById(id);
		if(myFlight!=null) myFlight.get().cogeAsiento();		
	}
	
	//You must present a list of origins (minimum 5 origins). Once the origin has been selected, the 
	//API must be queried to obtain the possible destinations. After selecting the destination, a form 
	//will appear where you can select if it is a one-way or round trip
	@GetMapping ("/flights/{origin}")
	public static List<Flight> getVuelosSegunOrigen(@PathVariable String origin){
		List<Flight> vuelos = repository.findAll();
		List<Flight> destinos = new ArrayList<>();
		for(Flight vuelo : vuelos) {
			if(vuelo.getOrigin() == origin) destinos.add(vuelo);
		}
		return destinos;
	}
	
	@GetMapping ("/flights/{destinations}")
	public static List<String> getDestinosSegunOrigen(@PathVariable String origin){
		List<Flight> vuelos = repository.findAll();
		List<String> destinos = new ArrayList<>();
		for(Flight vuelo : vuelos) {
			if(vuelo.getOrigin() == origin) destinos.add(vuelo.getDestination());
		}
		return destinos;
	}
	
	
}
