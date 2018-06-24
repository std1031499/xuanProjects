package com.xuan.bs.dao;

import java.util.List;

import com.xuan.bs.entities.RoleMenu;
import com.xuan.bs.entities.UserRole;
import com.xuan.bs.entities.Users;

public class MainDao extends BaseDao{
	
	/**
	 * �ж��û���Ϣ�Ƿ���ȷ
	 * @param userName	�û���
	 * @param userPwd	����
	 * @return
	 */
	public List<Users> loginCheck(String userName,String userPwd){
		
		String hql = "from Users u where u.userName = ? and u.userPwd = ?";
		return getSession().createQuery(hql).setString(0, userName).setString(1, userPwd).list();
	}
	
	/**
	 * ��ȡ�û�
	 * @param userId	�û�ID
	 * @return
	 */
	public List<Users> getUsersById(Integer userId){
		
		String hql = "from Users u where u.userId = ?";
		return getSession().createQuery(hql).setInteger(0, userId).list();
	}
	
	/**
	 * ��ȡ�û���ɫ
	 * @param userId	�û�ID
	 * @return
	 */
	public List<UserRole> getRoleById(Integer userId){
		
		String hql = "from UserRole ur where ur.id.users.userId = ?";
		return getSession().createQuery(hql).setInteger(0, userId).list();
	}
	
	/**
	 * ��ȡ��ɫȨ�޲˵�
	 * @param roleId	��ɫID
	 * @param permiss	�˵���״̬
	 * @return
	 */
	public List<RoleMenu> getMenuById(Integer roleId,Integer permiss){
		
		String hql = "select rm.id.menu.menuId from RoleMenu rm where rm.id.role.roleId = ? and rm.permiss = ?";
		return getSession().createQuery(hql).setInteger(0, roleId).setInteger(1, permiss).list();
	}
	
}
