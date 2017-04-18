package org.openmrs.module.teammodule.api.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.teammodule.TeamMember;
import org.openmrs.module.teammodule.TeamMemberPatientRelation;
import org.openmrs.module.teammodule.api.TeamMemberPatientRelationService;
import org.openmrs.module.teammodule.api.db.TeamMemberPatientRelationDAO;

public class TeamMemberPatientRelationServiceImpl extends BaseOpenmrsService implements TeamMemberPatientRelationService {
	
	@SuppressWarnings("unused")
	private final Log log = LogFactory.getLog(this.getClass());
	
	private TeamMemberPatientRelationDAO dao;	
	
	public TeamMemberPatientRelationDAO getDao() {
		return dao;
	}

	public void setDao(TeamMemberPatientRelationDAO dao) {
		this.dao = dao;
	}

	public void save(TeamMemberPatientRelation tmpr) {
		 dao.save(tmpr);
	}
	
	public void delete(TeamMemberPatientRelation tmpr) {
		 dao.delete(tmpr);
	}
	
	public TeamMemberPatientRelation getTeamPatientRelation(Integer id) {
		return dao.getTeamPatientRelation(id);
	}

	public TeamMemberPatientRelation getTeamPatientRelation(String uuid) {
		return dao.getTeamPatientRelation(uuid);
	}

	public void update(TeamMemberPatientRelation tmpr) {
		dao.update(tmpr);
	}
	
	public TeamMemberPatientRelation getTeamPatientRelations(TeamMemberPatientRelation id) {
		return dao.getTeamPatientRelations(id);
	}
	
	public List<TeamMemberPatientRelation> getTeamPatientRelations(TeamMember tm) {
		return dao.getTeamPatientRelations(tm);
	}
	
}