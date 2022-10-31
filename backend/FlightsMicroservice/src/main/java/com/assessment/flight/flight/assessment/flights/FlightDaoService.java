package com.assessment.flight.flight.assessment.flights;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightDaoService{
	
	public static List<Flight> getByDate(List<Flight> vuelos, Date date, String origin, String destination) {
			List<Flight> listaDevolver = new ArrayList<>();
			for(Flight vuelo : vuelos) {
				if(vuelo.getDate().equals(date) && vuelo.getOrigin().equals(origin) && vuelo.getDestination().equals(destination)) {
					listaDevolver.add(vuelo);
				}
			}
			return listaDevolver;
	}

}
