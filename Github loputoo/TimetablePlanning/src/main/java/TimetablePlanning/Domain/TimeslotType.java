package TimetablePlanning.Domain;

public class TimeslotType {

	private boolean timeslotPreference = false;
	private boolean timeslotUnsuitable = false;
	private boolean timeslotNotPreferred = false;
	
	public void isTimeslotPreference(){
		timeslotPreference = true;
	}
	
	public void isTimeslotUnsuitable(){
		timeslotUnsuitable = true;
	}
	
	public void isTimeslotNotPreferred(){
		timeslotNotPreferred = true;
	}
}
