package com.cumt.pojo;

public class Category {
	private int id;
	private String name;
	private int flight_id;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getFlightId() {
		return flight_id;
	}
	public void setFlightId(int flightId) {
		this.flight_id = flight_id;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", flightId=" + flight_id + "]";
	}
	
	
	
}
