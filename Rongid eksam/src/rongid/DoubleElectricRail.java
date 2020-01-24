package rongid;

public class DoubleElectricRail extends SingleRail {

	private int trainLimit = 2;
	
	public DoubleElectricRail(TrainStation firstStation,
			TrainStation secondStation, int time) {
		super(firstStation, secondStation, time);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isElectric(){
		return true;
	}
}
