package TimetablePlanning.Domain;

import java.util.concurrent.atomic.AtomicLong;

import org.optaplanner.core.api.domain.constraintweight.ConstraintWeight;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import TimetablePlanning.common.AbstractPersistable;

public class TimetableConstraintConfiguration extends AbstractPersistable{

	public static final String COMMISSION_AT_LEAST_THREE_MEMBERS = "Commission at least three members";
	public static final String AUTHOR_PREREQUISITES_DONE = "Author prerequisites done";
	public static final String AUTHOR_UNAVAILABLE_DATES = "Author unavailable dates";
	public static final String AUTHOR_UNAVAILABLE_TIME = "Author unavailable time";
	public static final String COMMISSION_MEMBER_UNAVAILABLE_DATE = "Commission member unavailable date";
	public static final String COMMISSION_MEMBER_UNAVAILABLE_TIME = "Commission member unavailable time";
	public static final String DEFENSE_HAS_ONE_CHAIRMAN = "Defense has one chairman";

	public static final String DEFENSE_GROUPED_BY_SAME_LANGUAGE = "Defense grouped by same language";
	public static final String DEFENSE_GROUPED_BY_SAME_THESIS_TYPE = "Defense grouped by same thesis type";
	public static final String CLOSED_DEFENSES_AT_START_OR_END_DAY_OR_AT_BEFORE_OR_AFTER_LUNCH = "Closed defenses at start or end day or at before or after lunch";
	public static final String DEFENSE_ON_AUTHORS_PREFERRED_DATE = "Defense on authors preferred date";
	public static final String DEFENSE_ON_AUTHORS_PREFERRED_TIME = "Defense on authors preferred time";
	public static final String DEFENSE_ON_COMMISSION_MEMBERS_PREFERRED_DATE = "Defense on commission members preferred date";
	public static final String DEFENSE_ON_COMMISSION_MEMBERS_PREFERRED_TIME = "Defense on commission members preferred time";
	public static final String DEFENSE_ON_AUTHORS_SUPERVISORS_PREFERRED_DATE = "Defense on authors supervisors preferred date";
	public static final String DEFENSE_ON_AUTHORS_SUPERVISORS_PREFERRED_TIME = "Defense on authors supervisors preferred time";
	public static final String DEFENSE_AUTHORS_SUPERVISOR_UNAVAILABLE_DATE = "Defense authors supervisor unavailable date";
	public static final String DEFENSE_AUTHORS_SUPERVISOR_UNAVAILABLE_TIME = "Defense authors supervisor unavailable time";
	public static final String GROUP_DEFENSE_AUTHORS_BY_COMMON_SUPERVISOR = "Group defense authors by common supervisor";

	@ConstraintWeight(COMMISSION_AT_LEAST_THREE_MEMBERS)
	private HardSoftScore commissionAtLeastThreeMembers = HardSoftScore.ofHard(10);
	@ConstraintWeight(AUTHOR_PREREQUISITES_DONE)
	private HardSoftScore authorPrerequisitesDone = HardSoftScore.ofHard(10);
	@ConstraintWeight(AUTHOR_UNAVAILABLE_DATES)
	private HardSoftScore authorUnavailableDates = HardSoftScore.ofHard(10);
	@ConstraintWeight(AUTHOR_UNAVAILABLE_TIME)
	private HardSoftScore authorUnavailableTime = HardSoftScore.ofHard(10);
	@ConstraintWeight(COMMISSION_MEMBER_UNAVAILABLE_DATE)
	private HardSoftScore commissionMemberUnavailableDate = HardSoftScore.ofHard(10);
	@ConstraintWeight(COMMISSION_MEMBER_UNAVAILABLE_TIME)
	private HardSoftScore commissionMemberUnavailableTime = HardSoftScore.ofHard(10);
	@ConstraintWeight(DEFENSE_HAS_ONE_CHAIRMAN)
	private HardSoftScore defenseHasOneChairman = HardSoftScore.ofHard(10);

	@ConstraintWeight(DEFENSE_GROUPED_BY_SAME_LANGUAGE)
	private HardSoftScore defenseGroupedBySameLanguage = HardSoftScore.ofSoft(10);
	@ConstraintWeight(DEFENSE_GROUPED_BY_SAME_THESIS_TYPE)
	private HardSoftScore defenseGroupedBySameThesisType = HardSoftScore.ofSoft(10);
	@ConstraintWeight(CLOSED_DEFENSES_AT_START_OR_END_DAY_OR_AT_BEFORE_OR_AFTER_LUNCH)
	private HardSoftScore closedDefensesAtStartOrEndDatOrAtBeforeOrAfterLunch = HardSoftScore.ofSoft(10);
	@ConstraintWeight(DEFENSE_ON_AUTHORS_PREFERRED_DATE)
	private HardSoftScore defenseOnAuthorsPreferredDate = HardSoftScore.ofSoft(10);
	@ConstraintWeight(DEFENSE_ON_AUTHORS_PREFERRED_TIME)
	private HardSoftScore defenseOnAuthorsPreferredTime = HardSoftScore.ofSoft(10);
	@ConstraintWeight(DEFENSE_ON_COMMISSION_MEMBERS_PREFERRED_DATE)
	private HardSoftScore defenseOnCommissionMembersPreferredDate = HardSoftScore.ofSoft(10);
	@ConstraintWeight(DEFENSE_ON_COMMISSION_MEMBERS_PREFERRED_TIME)
	private HardSoftScore defenseOnCommissionMembersPReferredTime = HardSoftScore.ofSoft(10);
	@ConstraintWeight(DEFENSE_ON_AUTHORS_SUPERVISORS_PREFERRED_DATE)
	private HardSoftScore defenseOnAuthorsSupervisorsPreferredDate = HardSoftScore.ofSoft(10);
	@ConstraintWeight(DEFENSE_ON_AUTHORS_SUPERVISORS_PREFERRED_TIME)
	private HardSoftScore defenseOnAuthorsSupervisorsPreferredTime = HardSoftScore.ofSoft(10);
	@ConstraintWeight(DEFENSE_AUTHORS_SUPERVISOR_UNAVAILABLE_DATE)
	private HardSoftScore defenseAuthorsSupervisorUnavailableDate = HardSoftScore.ofSoft(10);
	@ConstraintWeight(DEFENSE_AUTHORS_SUPERVISOR_UNAVAILABLE_TIME)
	private HardSoftScore defenseAuthorsSupervisorUnavailableTime = HardSoftScore.ofSoft(10);
	@ConstraintWeight(GROUP_DEFENSE_AUTHORS_BY_COMMON_SUPERVISOR)
	private HardSoftScore groupDefenseAuthorsByCommonSupervisor = HardSoftScore.ofSoft(10);

	//private long id;
	//private static final AtomicLong count = new AtomicLong(0); 
/*	
	public TimetableConstraintConfiguration() {
		id = count.incrementAndGet();
    }

    public TimetableConstraintConfiguration(long id) {
        this.id = id;
    }
*/
	
	public TimetableConstraintConfiguration(){
		
	}
	
	public TimetableConstraintConfiguration(long id){
		super(id);
	}
	
    // ************************************************************************
    // Simple getters and setters
    // ************************************************************************

	public HardSoftScore getCommissionAtLeastThreeMembers(){
		return commissionAtLeastThreeMembers;
	}
	public void setCommissionAtLeastThreeMembers(HardSoftScore commissionAtLeastThreeMembers){
		this.commissionAtLeastThreeMembers = commissionAtLeastThreeMembers;
	}
	public HardSoftScore getAuthorPrerequisitesDone(){
		return authorPrerequisitesDone;
	}
	public void setAuthorPrerequisitesDone(HardSoftScore authorPrerequisitesDone){
		this.authorPrerequisitesDone = authorPrerequisitesDone;
	}
	public HardSoftScore getAuthorUnavailableDates(){
		return authorUnavailableDates;
	}
	public void setAuthorUnavailableDates(HardSoftScore authorUnavailableDates){
		this.authorUnavailableDates = authorUnavailableDates;
	}
	public HardSoftScore getAuthorUnavailableTime(){
		return authorUnavailableTime;
	}
	public void authorUnavailableTime(HardSoftScore authorUnavailableTime){
		this.authorUnavailableTime = authorUnavailableTime;
	}
	public HardSoftScore getCommissionMemberUnavailableDate(){
		return commissionMemberUnavailableDate;
	}
	public void setCommissionMemberUnavailableDate(HardSoftScore commissionMemberUnavailableDate){
		this.commissionMemberUnavailableDate = commissionMemberUnavailableDate;
	}
	public HardSoftScore getCommissionMemberUnavailableTime(){
		return commissionMemberUnavailableTime;
	}
	public void setCommissionMemberUnavailableTime(HardSoftScore commissionMemberUnavailableTime){
		this.commissionMemberUnavailableTime = commissionMemberUnavailableTime;
	}
	public HardSoftScore getDefenseHasOneChairman(){
		return defenseHasOneChairman;
	}
	public void setDefenseHasOneChairman(HardSoftScore defenseHasOneChairman){
		this.defenseHasOneChairman = defenseHasOneChairman;
	}
	public HardSoftScore getDefenseGroupedBySameLanguage(){
		return defenseGroupedBySameLanguage;
	}
	public void setDefenseGroupedBySameLanguage(HardSoftScore defenseGroupedBySameLanguage){
		this.defenseGroupedBySameLanguage = defenseGroupedBySameLanguage;
	}
	public HardSoftScore getDefenseGroupedBySameThesisType(){
		return defenseGroupedBySameThesisType;
	}
	public void setDefenseGroupedBySameThesisType(HardSoftScore defenseGroupedBySameThesisType){
		this.defenseGroupedBySameThesisType = defenseGroupedBySameThesisType;
	}
	public HardSoftScore getClosedDefensesAtStartOrEndDatOrAtBeforeOrAfterLunch(){
		return closedDefensesAtStartOrEndDatOrAtBeforeOrAfterLunch;
	}
	public void setClosedDefensesAtStartOrEndDatOrAtBeforeOrAfterLunch(HardSoftScore closedDefensesAtStartOrEndDatOrAtBeforeOrAfterLunch){
		this.closedDefensesAtStartOrEndDatOrAtBeforeOrAfterLunch = closedDefensesAtStartOrEndDatOrAtBeforeOrAfterLunch;
	}
	public HardSoftScore getDefenseOnAuthorsPreferredDate(){
		return defenseOnAuthorsPreferredDate;
	}
	public void setDefenseOnAuthorsPreferredDate(HardSoftScore defenseOnAuthorsPreferredDate){
		this.defenseOnAuthorsPreferredDate = defenseOnAuthorsPreferredDate;
	}
	public HardSoftScore getDefenseOnAuthorsPreferredTime(){
		return defenseOnAuthorsPreferredTime;
	}
	public void setDefenseOnAuthorsPreferredTime(HardSoftScore defenseOnAuthorsPreferredTime){
		this.defenseOnAuthorsPreferredTime = defenseOnAuthorsPreferredTime;
	}
	public HardSoftScore getDefenseOnCommissionMembersPreferredDate(){
		return defenseOnCommissionMembersPreferredDate;
	}
	public void setDefenseOnCommissionMembersPreferredDate(HardSoftScore defenseOnCommissionMembersPreferredDate){
		this.defenseOnCommissionMembersPreferredDate = defenseOnCommissionMembersPreferredDate;
	}
	public HardSoftScore getDefenseOnCommissionMembersPReferredTime(){
		return defenseOnCommissionMembersPReferredTime;
	}
	public void setDefenseOnCommissionMembersPReferredTime(HardSoftScore defenseOnCommissionMembersPReferredTime){
		this.defenseOnCommissionMembersPReferredTime = defenseOnCommissionMembersPReferredTime;
	}
	public HardSoftScore getDefenseOnAuthorsSupervisorsPreferredDate(){
		return defenseOnAuthorsSupervisorsPreferredDate;
	}
	public void setDefenseOnAuthorsSupervisorsPreferredDate(HardSoftScore defenseOnAuthorsSupervisorsPreferredDate){
		this.defenseOnAuthorsSupervisorsPreferredDate = defenseOnAuthorsSupervisorsPreferredDate;
	}
	public HardSoftScore getDefenseOnAuthorsSupervisorsPreferredTime(){
		return defenseOnAuthorsSupervisorsPreferredTime;
	}
	public void setDefenseOnAuthorsSupervisorsPreferredTime(HardSoftScore defenseOnAuthorsSupervisorsPreferredTime){
		this.defenseOnAuthorsSupervisorsPreferredTime = defenseOnAuthorsSupervisorsPreferredTime;
	}
	public HardSoftScore getDefenseAuthorsSupervisorUnavailableDate(){
		return defenseAuthorsSupervisorUnavailableDate;
	}
	public void setDefenseAuthorsSupervisorUnavailableDate(HardSoftScore defenseAuthorsSupervisorUnavailableDate){
		this.defenseAuthorsSupervisorUnavailableDate = defenseAuthorsSupervisorUnavailableDate;
	}
	public HardSoftScore getDefenseAuthorsSupervisorUnavailableTime(){
		return defenseAuthorsSupervisorUnavailableTime;
	}
	public void setDefenseAuthorsSupervisorUnavailableTime(HardSoftScore defenseAuthorsSupervisorUnavailableTime){
		this.defenseAuthorsSupervisorUnavailableTime = defenseAuthorsSupervisorUnavailableTime;
	}
	public HardSoftScore getGroupDefenseAuthorsByCommonSupervisor(){
		return groupDefenseAuthorsByCommonSupervisor;
	}
	public void setGroupDefenseAuthorsByCommonSupervisor(HardSoftScore groupDefenseAuthorsByCommonSupervisor){
		this.groupDefenseAuthorsByCommonSupervisor = groupDefenseAuthorsByCommonSupervisor;
	}
    
}
