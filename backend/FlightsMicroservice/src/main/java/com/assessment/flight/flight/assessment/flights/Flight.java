package com.assessment.flight.webservice.flights;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity 
public class Flight {
	
	private @Id @GeneratedValue Long id;
	private String Airline;
	private Date date;
	private String origin;
	private String destination;
	private List<String> scales;
	private Boolean luggage;
	
	public Flight() {}
	
	public Flight(String airline, String origin, String destination, Date date, List<String> scales, Boolean luggage) {
		this.Airline = airline;
		this.date = date;
		this.origin = origin;
		this.destination = destination;
		this.scales = scales;
		this.luggage = luggage;
	}

	public String getAirline() {
		return Airline;
	}

	public void setAirline(String airline) {
		Airline = airline;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<String> getScales() {
		return scales;
	}

	public void setScales(List<String> scales) {
		this.scales = scales;
	}

	public Boolean getLuggage() {
		return luggage;
	}

	public void setLuggage(Boolean luggage) {
		this.luggage = luggage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	@Override
	public String toString() {
		return "Flight [Airline=" + Airline + ", date=" + date + ", scales=" + scales + ", luggage=" + luggage + "]";
	}
	
	
}
