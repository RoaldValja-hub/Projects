package rongid;


import java.util.Random;

public class PassengerGenerator implements Runnable{

	private Route route;
	Random random = new Random();
	
	public PassengerGenerator(Route route){
		this.route = route;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 100; i++){
			createPassenger(i);
		}
	}

	public void createPassenger(int i){
		int stationId = random.nextInt(route.getStationSize());
		if (i <= 97){
			Passenger passenger = new Passenger();
			route.getStationById(stationId).addPassenger(passenger);
		} else {
			Passenger passenger = new StowawayPassenger();
			route.getStationById(stationId).addPassenger(passenger);
		}
		
	}
}
