package TimetablePlanning.Domain;

import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import TimetablePlanning.common.AbstractPersistable;

public class ThesisSupervisor extends AbstractPersistable{

	//private static final AtomicLong count = new AtomicLong(0); 
	//private long id;
	
	private String name;
	private String role;
	private Set<String> timeslotPreferenceTagSet;
	private Set<String> timeslotUnsuitableTagSet;
	private Set<String> timeslotUnavailableTagSet;
/*	
	public ThesisSupervisor() {
		id = count.incrementAndGet();
    }

    public ThesisSupervisor(long id) {
        this.id = id;
    }
*/
	
	public ThesisSupervisor(){
		
	}
	
	public ThesisSupervisor(long id){
		super(id);
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getRole(){
		return role;
	}
	
	public void setRole(String role){
		this.role = role;
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
