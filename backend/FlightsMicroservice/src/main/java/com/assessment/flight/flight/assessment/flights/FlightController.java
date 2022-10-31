package com.assessment.flight.webservice.flights;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class FlightController {
	
	private final FlightRepository repository;
	
	FlightController(FlightRepository repository){
		this.repository = repository;
	}
	
	//Metodo para devolver los vuelos en una fecha
	@GetMapping ("/flight/{date}+{origin}+{destination}")
	public List<Flight> AvailableFlightsFromACityAndDate(@PathVariable  Date date,@PathVariable String origin,@PathVariable String destination) {
		return FlightDaoService.getByDate(repository.findAll(), date, origin, destination);
		
	}
}
