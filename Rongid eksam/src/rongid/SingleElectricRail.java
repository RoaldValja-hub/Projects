package rongid;

public class SingleElectricRail extends SingleRail{
	

	public SingleElectricRail(TrainStation firstStation,
			TrainStation secondStation, int time) {
		super(firstStation, secondStation, time);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isElectric(){
		return true;
	}
	
	
}
