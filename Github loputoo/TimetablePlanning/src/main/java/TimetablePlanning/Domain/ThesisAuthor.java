package TimetablePlanning.Domain;

import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import TimetablePlanning.common.AbstractPersistable;

public class ThesisAuthor extends AbstractPersistable{

	//private static final AtomicLong count = new AtomicLong(0); 
	//private long id;
	
	private String name;
	private boolean preconditionsFulfilled = false;
	private List<ThesisSupervisor> thesisSupervisorList;
	private Set<String> timeslotPreferenceTagSet;
	private Set<String> timeslotUnsuitableTagSet;
	private Set<String> timeslotUnavailableTagSet;
/*
	public ThesisAuthor() {
		id = count.incrementAndGet();
    }

    public ThesisAuthor(long id) {
        this.id = id;
    }
*/
	
	public ThesisAuthor(){
		
	}
	
	public ThesisAuthor(long id){
		super(id);
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void hasPreconditionsFulfilled(){
		preconditionsFulfilled = true;
	}
	
	public List<ThesisSupervisor> getThesisSupervisorList(){
		return thesisSupervisorList;
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
