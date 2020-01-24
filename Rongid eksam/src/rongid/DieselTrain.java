package rongid;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class DieselTrain implements Runnable{

	
	private int maxPassengerCount;
	private int tripCount;
	private String name;
	List<Passenger> passengers = new ArrayList<Passenger>();
	private Route route;
	Random random = new Random();

	
	public DieselTrain(String name, int maximumPassengerCount, Route route){
		this.maxPassengerCount = maximumPassengerCount;
		this.route = route;
		this.name = name;
	}
	
	protected int getTripCount(){
		return tripCount;
	}
	
	public boolean isElectric(){
		return false;
	}
	
	public Passenger getPassenger(int i){
		passengers.remove(passengers.get(i));
		return passengers.get(i);
	}

	public int getMaxPassengerCount(){
		return maxPassengerCount;
	}
	public void addPassenger(Passenger passenger){
		passengers.add(passenger);
	}
	
	public String getName(){
		return name;
	}
	
	protected Route getRoute(){
		return route;
	}

	public void trainArrival(String stationName, int gotOff){
		System.out.println(name + " rong saabus " + stationName 
				+ " ja sõidab liinil " + route.getStationById(0).getName() + "-" 
				+ route.getStationById(route.getStationSize()-1).getName() 
				+ " ja maha läks " + gotOff + " reisijat.");
	}
	
	public void trainDeparture(String stationName, int gotOn){
		System.out.println(name + " rong väljub " + stationName 
				+ " ja sõidab liinil " + route.getStationById(0).getName() + "-" 
				+ route.getStationById(route.getStationSize()-1).getName() 
				+ " ja peale tuli " + gotOn + " reisijat.");
	}
	@Override
	public void run() {
		TrainSchedule schedule = new TrainSchedule();
		for (int i = 0; i < route.getStationSize(); i++){
			schedule.addStation(route.getStationById(i));
			if (i>0){
				schedule.addTime(route.getRail(i-1).getTime());
			}
		}
		for (int i = route.getStationSize()-2; i > -1 ;i--){
			schedule.addStation(route.getStationById(i));
			schedule.addTime(route.getRail(i).getTime());
		}
		
		int position = 0;
		while(tripCount < 6){
			int gotOn = 0;
			int gotOff = 0;
			boolean isInspector = false;
			try {
				for(int k = 0; k<schedule.getStationSize()-1; k++){
					gotOn = 0;
					gotOff = 0;
					isInspector = false;
					if(passengers.size() > 0){
						for(int i = 0; i < passengers.size(); i++){
							if(passengers.get(i).getDestination() == schedule.getStation(position).getName()){
								schedule.getStation(position).addPassenger(passengers.get(i));
								passengers.remove(i);
								gotOff++;
							}
						}
					}
					trainArrival(schedule.getStation(position).getName(), gotOff);
	
					for(int i = 0; i < passengers.size(); i++){
						if(passengers.get(i).isInspector()){
							isInspector = true;
						}
					}
					
					if(isInspector){
						int stowawayChance;
						for(int i = 0; i < passengers.size(); i++){
							stowawayChance = random.nextInt(100) + 1;
							if(!passengers.get(i).hasTicket() && stowawayChance < 71){
								try{
						             String content = "Kontrolör püüdis kinni jänest sõitvat reisijat rongis " + getName() 
						            		+ " liinis "
						            		+ route.getStationById(0).getName() + "-" 
						     				+ route.getStationById(route.getStationSize()-1).getName();
						             String path="caughtStowaways.txt";
						             File file = new File(path);

						             if (!file.exists()) {
						                 file.createNewFile();
						             }

						             FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
						             BufferedWriter bw = new BufferedWriter(fw);
						             bw.append(content);
						             bw.newLine();
						             bw.close();
						       }catch(Exception e){
						           System.out.println(e);
						       }
							}
						}
					}
					
					int suurus = maxPassengerCount-passengers.size();
					for(int i = 0; i < suurus; i++){
						for(int j = 0; j < schedule.getStation(position).getPassengerListSize(); j++){
							//System.out.println(schedule.getStation(position).getPassengerListSize());
							if(schedule.getStation(position).getPassengerInfo(j).getLastTrainName() != getName()){
								schedule.getStation(position).getPassengerInfo(j).setLastTrainName(getName());
								int stationId = position;
								while(stationId == position){
									stationId = random.nextInt(schedule.getStationSize());
								}
								schedule.getStation(position).getPassengerInfo(j).setDestination(schedule.getStation(stationId).getName());
								addPassenger(schedule.getStation(position).getPassenger(j));
								gotOn++;
								break;
							} else {
								continue;
							}
						}
					}
					trainDeparture(schedule.getStation(position).getName(), gotOn);
					while(route.getRailByTime(schedule.getTime(position)).getTrainCount() > route.getRailByTime(schedule.getTime(position)).getTrainLimit()-1){
						Thread.sleep(50);
					}
					route.getRailByTime(schedule.getTime(position)).addTrain();
					Thread.sleep(schedule.getTime(position));
					route.getRailByTime(schedule.getTime(position)).removeTrain();
					position++;
				}
				position = 0;
				tripCount++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(tripCount == 6){
				if(passengers.get(0).getDestination() == schedule.getStation(position).getName()){
					schedule.getStation(position).addPassenger(passengers.get(0));
					passengers.remove(0);
					gotOff++;
				}
				trainArrival(schedule.getStation(position).getName(), gotOff);
			}
		}
		
	}
}
