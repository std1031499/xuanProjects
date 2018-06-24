package com.xuan.bs.dao;

import java.util.List;

import com.xuan.bs.entities.Team;

public class TeamDao extends BaseDao{
	
	/**
	 * 保存更新队伍信息
	 * @param team
	 */
	public void saveOrUpdate(Team team){
		
		getSession().saveOrUpdate(team); 
	}
	
	/**
	 * 获取所有队伍信息 根据teamTeamID降序排列
	 * @return
	 */
	public List<Team> getAll(){
		
		String hql = "from Team m order by m.teamTeamId desc";
		return getSession().createQuery(hql).list();
	}
	
	/**
	 * 获取队伍信息 -- 用户ID 队伍状态
	 * @param userId
	 * @param teamState
	 * @return
	 */
	
	public List<Team> getTeamById(Integer userId,String teamState){
		
		String hql = "from Team m where m.users.userId = ? and m.teamState = ?";
		return getSession().createQuery(hql).setInteger(0, userId).setString(1, teamState).list();
	}
	
	/**
	 * 根据teamId获取队伍信息
	 * @param teamId
	 * @return
	 */
	public List<Team> getNameById(Integer teamTeamId){
		
		String hql = "from Team m " +
				"left outer join fetch m.users " +
				"where m.teamTeamId = ?";
		return getSession().createQuery(hql).setInteger(0, teamTeamId).list();
		
	}
	
	
}
