package TimetablePlanning.Domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicLong;

import TimetablePlanning.common.AbstractPersistable;

public class Timeslot extends AbstractPersistable{

	//private static final AtomicLong count = new AtomicLong(0); 
	//private long id;
	
	private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate date;
    
    private boolean timeslotPreference = false;
	private boolean timeslotUnsuitable = false;
	private boolean timeslotNotPreferred = false;
/*    
    public Timeslot() {
		id = count.incrementAndGet();
    }

    public Timeslot(long id) {
        this.id = id;
    }
*/
	
	public Timeslot(){
		
	}
	
	public Timeslot(long id){
		super(id);
	}
	
    public void isTimeslotPreference(){
		timeslotPreference = true;
	}
	
	public void isTimeslotUnsuitable(){
		timeslotUnsuitable = true;
	}
	
	public void isTimeslotNotPreferred(){
		timeslotNotPreferred = true;
	}
    
    public LocalTime getStartTime(){
    	return startTime;
    }
    
    public void setStartTime(LocalTime startTime){
    	this.startTime = startTime;
    }
    
    public LocalTime getEndTime(){
    	return endTime;
    }
    
    public void setEndTime(LocalTime endTime){
    	this.endTime = endTime;
    }
    
    public LocalDate getDate(){
    	return date;
    }
    
    public void setDate(LocalDate date){
    	this.date = date;
    }
}
