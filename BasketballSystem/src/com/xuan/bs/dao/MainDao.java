package com.xuan.bs.dao;

import java.util.List;

import com.xuan.bs.entities.RoleMenu;
import com.xuan.bs.entities.UserRole;
import com.xuan.bs.entities.Users;

public class MainDao extends BaseDao{
	
	/**
	 * 判断用户信息是否正确
	 * @param userName	用户名
	 * @param userPwd	密码
	 * @return
	 */
	public List<Users> loginCheck(String userName,String userPwd){
		
		String hql = "from Users u where u.userName = ? and u.userPwd = ?";
		return getSession().createQuery(hql).setString(0, userName).setString(1, userPwd).list();
	}
	
	/**
	 * 获取用户
	 * @param userId	用户ID
	 * @return
	 */
	public List<Users> getUsersById(Integer userId){
		
		String hql = "from Users u where u.userId = ?";
		return getSession().createQuery(hql).setInteger(0, userId).list();
	}
	
	/**
	 * 获取用户角色
	 * @param userId	用户ID
	 * @return
	 */
	public List<UserRole> getRoleById(Integer userId){
		
		String hql = "from UserRole ur where ur.id.users.userId = ?";
		return getSession().createQuery(hql).setInteger(0, userId).list();
	}
	
	/**
	 * 获取角色权限菜单
	 * @param roleId	角色ID
	 * @param permiss	菜单栏状态
	 * @return
	 */
	public List<RoleMenu> getMenuById(Integer roleId,Integer permiss){
		
		String hql = "select rm.id.menu.menuId from RoleMenu rm where rm.id.role.roleId = ? and rm.permiss = ?";
		return getSession().createQuery(hql).setInteger(0, roleId).setInteger(1, permiss).list();
	}
	
}
