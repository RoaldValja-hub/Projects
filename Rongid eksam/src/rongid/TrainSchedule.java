package rongid;

import java.util.ArrayList;
import java.util.List;

public class TrainSchedule {
	
	List<TrainStation> stations = new ArrayList<TrainStation>();
	List<Integer> times = new ArrayList<Integer>();
	
	public void addStation(TrainStation station){
		stations.add(station);
	}
	
	public void addTime(int time){
		times.add(time);
	}
	
	public TrainStation getStation(int i){
		return stations.get(i);
	}

	public int getTime(int i){
		return times.get(i);
	}
	
	public int getStationSize(){
		return stations.size();
	}
	
	public int getTimesSize(){
		return times.size();
	}
}
