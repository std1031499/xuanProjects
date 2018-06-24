package com.xuan.bs.dao;

import java.util.List;

import com.xuan.bs.entities.Image;

public class ImageDao extends BaseDao{
	
	//�������
	public void saveOrUpdate(Image image){
		
		getSession().saveOrUpdate(image);
	}
	
	/**
	 * ��ȡͼƬ��Ϣ
	 * @param imageId
	 * @return
	 */
	public List<Image> getAllById(Integer imageId){
		
		String hql = "from Image i where i.imageId = ? ";
		return getSession().createQuery(hql).setInteger(0, imageId).list();
	}
}
