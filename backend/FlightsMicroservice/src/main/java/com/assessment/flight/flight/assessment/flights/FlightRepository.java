package com.assessment.flight.flight.assessment.flights;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long>{
	
	public  List<Flight> getByDate(Date date, String origin, String destination) ;
	
}
