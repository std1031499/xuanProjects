package com.xuan.bs.service;

import java.util.List;

import com.xuan.bs.dao.ImageDao;
import com.xuan.bs.entities.Image;

public class ImageService {
	
	private ImageDao imageDao;
	public void setImageDao(ImageDao imageDao) {
		this.imageDao = imageDao;
	}
	
	//保存更新
	public void saveOrUpdate(Image image){
		
		imageDao.saveOrUpdate(image);
	}
	
	/**
	 * 获取图片信息
	 * @param imageId
	 * @return
	 */
	public List<Image> getAllById(Integer imageId){
		
		return imageDao.getAllById(imageId);
	}
}
