package TimetablePlanning.Domain;

import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import TimetablePlanning.common.AbstractPersistable;

public class DefenseType extends AbstractPersistable{
	
	//private static final AtomicLong count = new AtomicLong(0); 
	//private long id;
	
	private Set<String> timeslotPreferenceTagSet;
	private Set<String> timeslotUnsuitableTagSet;
	private Set<String> timeslotUnavailableTagSet;
	
	private String type;
	/*
	public DefenseType() {
		id = count.incrementAndGet();
    }

    public DefenseType(long id) {
        this.id = id;
    }
    */
	
	public DefenseType(){
		
	}
	
	public DefenseType(long id){
		super(id);
	}
	
	public String getType(){
		return type;
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	public Set<String> getTimeslotPreferenceTagSet(){
		return timeslotPreferenceTagSet;
	}
	
	public void setTimeslotPreferenceTagSet(Set<String> timeslotPreferenceTagSet){
		this.timeslotPreferenceTagSet = timeslotPreferenceTagSet;
	}
	
	public Set<String> getTimeslotUnsuitableTagSet(){
		return timeslotUnsuitableTagSet;
	}
	
	public void setTimeslotUnsuitableTagSet(Set<String> timeslotUnsuitableTagSet){
		this.timeslotUnsuitableTagSet = timeslotUnsuitableTagSet;
	}
	
	public Set<String> getTimeslotUnavailableTagSet(){
		return timeslotUnavailableTagSet;
	}
	
	public void setTimeslotUnavailableTagSet(Set<String> timeslotUnavailableTagSet){
		this.timeslotUnavailableTagSet = timeslotUnavailableTagSet;
	}
}
