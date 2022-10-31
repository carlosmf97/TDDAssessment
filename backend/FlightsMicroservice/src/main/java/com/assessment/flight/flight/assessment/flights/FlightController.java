package com.assessment.flight.flight.assessment.flights;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class FlightController {
	
	private final FlightRepository repository;
	
	FlightController(FlightRepository repository){
		this.repository = repository;
	}
	
	@GetMapping ("/flights/")
	public List<Flight> AvailableFlights(){
		return repository.findAll();
	}
	//Metodo para devolver los vuelos en una fecha
	@GetMapping ("/flight/{date}+{origin}+{destination}")
	public List<Flight> availableFlightsFromACityAndDate
	(@PathVariable  Date date,@PathVariable String origin,@PathVariable String destination) {
		return FlightDaoService.getByDate(repository.findAll(), date, origin, destination);
	}
	
	//Metodo restar asiento
	@PutMapping ("/flight/reserva/{id}")
	public void reservaAsiento(@PathVariable Long id) {
		Optional<Flight> myFlight = repository.findById(id);
		if(myFlight!=null) myFlight.get().cogeAsiento();		
	}
	
	//You must present a list of origins (minimum 5 origins). Once the origin has been selected, the 
	//API must be queried to obtain the possible destinations. After selecting the destination, a form 
	//will appear where you can select if it is a one-way or round trip
	@GetMapping ("/flight/{origin}")
	public List<Flight> getVuelosSegunOrigen(@PathVariable String origin){
		List<Flight> vuelos = repository.findAll();
		List<Flight> destinos = new ArrayList<>();
		for(Flight vuelo : vuelos) {
			if(vuelo.getOrigin() == origin) destinos.add(vuelo);
		}
		return destinos;
	}
	
}