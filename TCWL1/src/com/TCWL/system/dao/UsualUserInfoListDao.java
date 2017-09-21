package com.TCWL.system.dao;

import java.util.List;

import com.TCWL.system.entities.Usualuserinfolist;

public class UsualUserInfoListDao extends BaseDao {
	
	//��ȡ��ͨ�û�������Ϣ--userId
	public Usualuserinfolist get(Integer userId){
		
		return (Usualuserinfolist) getSession().get(Usualuserinfolist.class, userId);
	}
	
	//��ȡ��ȡ��ͨ�û�������Ϣ--userId
	public List<Usualuserinfolist> getAllById(Integer userId ){
		String hql = "from Usualuserinfolist u left outer join fetch u.userloginlist where u.userId = ?";
		return getSession().createQuery(hql).setInteger(0, userId).list();
	}
	
	//�����޸�
	public void saveOrUpdate(Usualuserinfolist usualuserinfolist){
		
		getSession().saveOrUpdate(usualuserinfolist);
	}
}
