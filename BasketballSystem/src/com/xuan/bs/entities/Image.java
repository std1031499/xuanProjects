package com.xuan.bs.entities;

/**
 * Image entity. @author MyEclipse Persistence Tools
 */

public class Image implements java.io.Serializable {

	// Fields

	private Integer imageId;
	private String imageName;
	private String imageUrl;

	// Constructors

	/** default constructor */
	public Image() {
	}

	/** full constructor */
	public Image(String imageName, String imageUrl) {
		this.imageName = imageName;
		this.imageUrl = imageUrl;
	}

	// Property accessors

	public Integer getImageId() {
		return this.imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public String getImageName() {
		return this.imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}