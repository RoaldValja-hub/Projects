package TimetablePlanning.Domain;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import TimetablePlanning.common.AbstractPersistable;

@PlanningSolution
public class TimetableSolution extends AbstractPersistable{

	//private static final AtomicLong count = new AtomicLong(0); 
	//private long id;
	
	@PlanningEntityCollectionProperty
	private List<Defense> defenseList;
	@ProblemFactCollectionProperty
	private List<DefenseType> defenseTypeList;
	@ProblemFactCollectionProperty
	private List<ThesisAuthor> thesisAuthorList;
	@ProblemFactCollectionProperty
	private List<Timeslot> timeslotList;
	@ProblemFactCollectionProperty
	private List<Commitee> commiteeList;
	@ProblemFactCollectionProperty
	private List<ThesisSupervisor> thesisSupervisorList;
	
	@PlanningScore
	private HardSoftScore score = null;
/*	
	public TimetableSolution() {
		id = count.incrementAndGet();
    }

    public TimetableSolution(long id) {
        this.id = id;
    }
*/
	
	public TimetableSolution(){
		
	}
	
	public TimetableSolution(long id){
		super(id);
	}
	
    public List<Defense> getDefenseList(){
    	return defenseList;
    }
    
    public void setDefenseList(List<Defense> defenseList){
    	this.defenseList = defenseList;
    }
    
    public List<DefenseType> getDefenseTypeList(){
    	return defenseTypeList;
    }
    
    public void setDefenseTypeList(List<DefenseType> defenseTypeList){
    	this.defenseTypeList = defenseTypeList;
    }
    
    public List<ThesisAuthor> getThesisAuthorList(){
    	return thesisAuthorList;
    }
    
    public void setThesisAuthorList(List<ThesisAuthor> thesisAuthorList){
    	this.thesisAuthorList = thesisAuthorList;
    }
    
    public List<Timeslot> getTimeslotList(){
    	return timeslotList;
    }
    
    public void setTimeslotList(List<Timeslot> timeslotList){
    	this.timeslotList = timeslotList;
    }
    
    public List<Commitee> getCommiteeList(){
    	return commiteeList;
    }
    
    public void setCommiteeList(List<Commitee> commiteeList){
    	this.commiteeList = commiteeList;
    }
    
    public List<ThesisSupervisor> getThesisSupervisorList(){
    	return thesisSupervisorList;
    }
    
    public void setThesisSupervisorList(List<ThesisSupervisor> thesisSupervisorList){
    	this.thesisSupervisorList = thesisSupervisorList;
    }
    
    public HardSoftScore getScore(){
    	return score;
    }
    
    public void setScore(HardSoftScore score){
    	this.score = score;
    }
    
}
