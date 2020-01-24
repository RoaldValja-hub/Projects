package TimetablePlanning.Domain;

import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import TimetablePlanning.common.AbstractPersistable;

public class Commitee extends AbstractPersistable{
	
	//private static final AtomicLong count = new AtomicLong(0); 
	//private long id;
	
	private String name;
	private String degree;
	private boolean chairman = false;
	private Set<String> timeslotPreferenceTagSet;
	private Set<String> timeslotUnsuitableTagSet;
	private Set<String> timeslotNotPreferredTagSet;
	/*
	public Commitee() {
		id = count.incrementAndGet();
    }

    public Commitee(long id) {
        this.id = id;
    }
	*/
	
	public Commitee(){
		
	}
	
	public Commitee(long id){
		super(id);
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getDegree(){
		return degree;
	}

	public void setDegree(String degree){
		this.degree = degree;
	}
	
	public void isChairman(){
		chairman = true;
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
	
	public Set<String> getTimeslotNotPreferredTagSet(){
		return timeslotNotPreferredTagSet;
	}
	
	public void setTimeslotNotPreferredTagSet(Set<String> timeslotNotPreferredTagSet){
		this.timeslotNotPreferredTagSet = timeslotNotPreferredTagSet;
	}
	
}
