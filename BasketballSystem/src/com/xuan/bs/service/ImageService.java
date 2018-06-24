package com.xuan.bs.service;

import java.util.List;

import com.xuan.bs.dao.ImageDao;
import com.xuan.bs.entities.Image;

public class ImageService {
	
	private ImageDao imageDao;
	public void setImageDao(ImageDao imageDao) {
		this.imageDao = imageDao;
	}
	
	//�������
	public void saveOrUpdate(Image image){
		
		imageDao.saveOrUpdate(image);
	}
	
	/**
	 * ��ȡͼƬ��Ϣ
	 * @param imageId
	 * @return
	 */
	public List<Image> getAllById(Integer imageId){
		
		return imageDao.getAllById(imageId);
	}
}
