package rongid;


import java.util.ArrayList;
import java.util.List;


public class TrainStation {

	List<Passenger> passengers = new ArrayList<Passenger>();

	private String name;
	
	
	public TrainStation(String name){
		this.name = name;
	}
	
	public void addPassenger(Passenger passenger){
		passengers.add(passenger);
	}
	
	public int getPassengerListSize(){
		return passengers.size();
	}

	public String getName(){
		return name;
	}

	synchronized Passenger getPassengerInfo(int i){
		if (passengers.size() > 0){
			return passengers.get(i);
		} else {
			return null;
		}
	}
	
	synchronized Passenger getPassenger(int i){
		if (passengers.size() > 0){
			return passengers.remove(i);
		} else {
			return null;
		}
	}

	
	
}
