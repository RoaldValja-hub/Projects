package rongid;

import java.util.ArrayList;
import java.util.List;

public class Route {

	List<TrainStation> stations = new ArrayList<TrainStation>();
	List<SingleRail> rails = new ArrayList<SingleRail>();
	private String name;
	
	public Route(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}

	public void addStation(TrainStation station){
		stations.add(station);
	}
	
	public void addRails(SingleRail rail){
		rails.add(rail);
	}
	
	public TrainStation getStationByName(String name){
		TrainStation station;
		for(int i = 0; i<stations.size(); i++){
			if (stations.get(i).getName().equals(name)){
				station = stations.get(i);
				return station;
			}
		}
		return null;
	}
	
	public TrainStation getStationById(int i){
		return stations.get(i);
	}
	
	public int getStationSize(){
		return stations.size();
	}
	
	public SingleRail getRail(int i){
		return rails.get(i);
	}
	public SingleRail getRailByTime(int t){
		for(int i = 0; i < rails.size(); i++){
			if(t == rails.get(i).getTime()){
				return rails.get(i);
			}
		}
		return rails.get(0);
	}

}
