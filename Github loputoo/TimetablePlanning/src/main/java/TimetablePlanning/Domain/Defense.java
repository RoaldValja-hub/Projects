package TimetablePlanning.Domain;

import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import TimetablePlanning.common.AbstractPersistable;

@PlanningEntity
public class Defense extends AbstractPersistable{
	
	//private static final AtomicLong count = new AtomicLong(0); 
	//private long id;
	
	private String degree;
	private int commissionSize;
	private String thesisTitle;
	//private String thesisLanguage;
	//private String thesisType;
	private String similarThesisTheme;
	//private Room room;
	private DefenseType defenseType;
	private List<Commitee> commiteeList;
	private ThesisAuthor thesisAuthor;
	private long roomId;
	private int roomCapacity;
	
	private Set<String> timeslotPreferenceTagSet;
	private Set<String> timeslotUnsuitableTagSet;
	private Set<String> timeslotUnavailableTagSet;
	
	@PlanningVariable(valueRangeProviderRefs = "timeslotRange")
	private Timeslot timeslot;
	/*
	public Defense() {
		id = count.incrementAndGet();
    }

    public Defense(long id) {
        this.id = id;
    }
    */
	
	public Defense(){
		
	}
	
	public Defense(long id){
		super(id);
	}

	@ValueRangeProvider(id = "timeslotRange")
	public Set<Timeslot> getTimeslotRange(){
		return DefenseType.getCompatibleTimeslotSet();
	}
	
	
	// ************************************************************************
    // Simple getters and setters
    // ************************************************************************
	
	public String getDegree(){
		return degree;
	}
	
	public void setDegree(String degree){
		this.degree = degree;
	}
	
	public int getCommissionSize(){
		return commissionSize;
	}
	
	public void setCommissionSize(int commissionSize){
		this.commissionSize = commissionSize;
	}
	
	public String getThesisTitle(){
		return thesisTitle;
	}
	
	public void setThesisTitle(String thesisTitle){
		this.thesisTitle = thesisTitle;
	}
/*
	public String getThesisLanguage(){
		return thesisLanguage;
	}
	
	public void setThesisLanguage(String thesisLanguage){
		this.thesisLanguage = thesisLanguage;
	}
	
	public String getThesisType(){
		return thesisType;
	}
	
	public void setThesisType(String thesisType){
		this.thesisType = thesisType;
	}
*/
	
	public String getSimilarThesisTheme(){
		return similarThesisTheme;
	}
	
	public void setSimilarThesisTheme(String similarThesisTheme){
		this.similarThesisTheme = similarThesisTheme;
	}
	
	/*
	public Room getRoom(){
		return room;
	}
	
	public void setRoom(Room room){
		this.room = room;
	}
	*/
	
	public long getRoomId(){
		return roomId;
	}
	
	public void setRoomId(long roomId){
		this.roomId = roomId;
	}
	
	public int getRoomCapacity(){
		return roomCapacity;
	}
	
	public void setRoomCapacity(int roomCapacity){
		this.roomCapacity = roomCapacity;
	}
	
	public DefenseType getDefenseType(){
		return defenseType;
	}
	
	public void setDefenseType(DefenseType defenseType){
		this.defenseType = defenseType;
	}
	
	public Timeslot getTimeslot(){
		return timeslot;
	}
	
	public void setTimeslot(Timeslot timeslot){
		this.timeslot = timeslot;
	}
	
	public List<Commitee> getCommiteeList(){
		return commiteeList;
	}
	
	public ThesisAuthor getThesisAuthor(){
		return thesisAuthor;
	}
	
	public void setThesisAuthor(ThesisAuthor thesisAuthor){
		this.thesisAuthor = thesisAuthor;
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
