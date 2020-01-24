package rongid;

public class Passenger {

	private String destination = "";
	private String lastTrainName = "";
	
	public void setDestination(String dest){
		destination = dest;
	}
	
	public String getDestination(){
		return destination;
	}
	
	public String getLastTrainName(){
		return lastTrainName;
	}
	
	public void setLastTrainName(String name){
		lastTrainName = name;
	}
	
	public boolean hasTicket(){
		return true;
	}
	
	public boolean isInspector(){
		return false;
	}
}
