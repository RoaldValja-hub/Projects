package rongid;

public class SingleRail {
	
	private TrainStation firstStation;
	private TrainStation secondStation;
	private int time;
	private int trainCount = 0;
	private int trainLimit = 1;
	
	public SingleRail(TrainStation firstStation, TrainStation secondStation, int time){
		this.firstStation = firstStation;
		this.secondStation = secondStation;
		this.time = time;
	}
	
	public int getTrainLimit(){
		return trainLimit;
	}
	
	public void addTrain(){
		trainCount++;
	}
	
	public void removeTrain(){
		trainCount--;
	}
	
	public int getTrainCount(){
		return trainCount;
	}
	
	public TrainStation getFirstStation(){
		return firstStation;
	}
	
	public TrainStation getSecondStation(){
		return secondStation;
	}
	
	public int getTime(){
		return time;
	}

	public boolean isElectric(){
		return false;
	}

	@Override
	public String toString(){
		return firstStation.getName() + "-" + secondStation.getName();
	}
}
