package com.xuan.bs.dao;

import java.util.List;

import com.xuan.bs.entities.Team;

public class TeamDao extends BaseDao{
	
	/**
	 * ������¶�����Ϣ
	 * @param team
	 */
	public void saveOrUpdate(Team team){
		
		getSession().saveOrUpdate(team); 
	}
	
	/**
	 * ��ȡ���ж�����Ϣ ����teamTeamID��������
	 * @return
	 */
	public List<Team> getAll(){
		
		String hql = "from Team m order by m.teamTeamId desc";
		return getSession().createQuery(hql).list();
	}
	
	/**
	 * ��ȡ������Ϣ -- �û�ID ����״̬
	 * @param userId
	 * @param teamState
	 * @return
	 */
	
	public List<Team> getTeamById(Integer userId,String teamState){
		
		String hql = "from Team m where m.users.userId = ? and m.teamState = ?";
		return getSession().createQuery(hql).setInteger(0, userId).setString(1, teamState).list();
	}
	
	/**
	 * ����teamId��ȡ������Ϣ
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
