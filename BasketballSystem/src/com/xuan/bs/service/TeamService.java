package com.xuan.bs.service;

import java.util.List;

import com.xuan.bs.dao.TeamDao;
import com.xuan.bs.entities.Team;

public class TeamService {
	
	private TeamDao teamDao;
	
	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}
	
	/**
	 * ������¶�����Ϣ
	 * @param team
	 */
	public void saveOrUpdate(Team team){
		
		teamDao.saveOrUpdate(team);
	}
	
	/**
	 * ��ȡ���ж�����Ϣ
	 * @return
	 */
	public List<Team> getAll(){
		
		return teamDao.getAll();
	}
	
	/**
	 * ����userID��ȡ����Id
	 * @param userId
	 * @return
	 */
	public List<Team> getTeamById(Integer userId,String teamState){
		
		return teamDao.getTeamById(userId, teamState);
	}
	
	/**
	 * ����teamId��ȡ������Ϣ
	 * @param teamId
	 * @return
	 */
	public List<Team> getNameById(Integer teamTeamId){
		
		return teamDao.getNameById(teamTeamId);
	}
}
