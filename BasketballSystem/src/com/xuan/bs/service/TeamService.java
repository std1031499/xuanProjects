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
	 * 保存更新队伍信息
	 * @param team
	 */
	public void saveOrUpdate(Team team){
		
		teamDao.saveOrUpdate(team);
	}
	
	/**
	 * 获取所有队伍信息
	 * @return
	 */
	public List<Team> getAll(){
		
		return teamDao.getAll();
	}
	
	/**
	 * 根据userID获取队伍Id
	 * @param userId
	 * @return
	 */
	public List<Team> getTeamById(Integer userId,String teamState){
		
		return teamDao.getTeamById(userId, teamState);
	}
	
	/**
	 * 根据teamId获取队伍信息
	 * @param teamId
	 * @return
	 */
	public List<Team> getNameById(Integer teamTeamId){
		
		return teamDao.getNameById(teamTeamId);
	}
}
