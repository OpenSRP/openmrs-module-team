package org.openmrs.module.teammodule.api;

import java.util.List;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.teammodule.TeamMember;
import org.openmrs.module.teammodule.TeamMemberPatientRelation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TeamMemberPatientRelationService extends OpenmrsService {

	public void save(TeamMemberPatientRelation tmpr);

	public void delete(TeamMemberPatientRelation tmpr);

	public TeamMemberPatientRelation getTeamPatientRelation(Integer Id);
	
	public TeamMemberPatientRelation getTeamPatientRelation(String uuid);

	public void update(TeamMemberPatientRelation tmpr);

	public TeamMemberPatientRelation getTeamPatientRelations(TeamMemberPatientRelation tmpr);

	public List<TeamMemberPatientRelation> getTeamPatientRelations(TeamMember tm);
}
