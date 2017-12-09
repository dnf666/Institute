package com.im.project.model;

public class Leader {
	private Integer id;
	private String name;
	private String zhicheng;
	private String pictureId;
	private String jianjie;
	private String xibie;
	private Picture picture;
	public Leader CompareTo(Leader l){
		this.name=this.name!=l.name?this.name:null;
		this.xibie=this.xibie!=l.xibie?this.xibie:null;
		this.jianjie=this.jianjie!=l.jianjie?this.jianjie:null;
		this.zhicheng=this.zhicheng!=l.zhicheng?this.zhicheng:null;
		return this;
	}
	public Integer getId() {
		return id;
	}

	public String getJianjie() {
		return jianjie;
	}

	public String getName() {
		return name;
	}

	
	public String getPictureId() {
		return pictureId;
	}

	public void setPictureId(String pictureId) {
		this.pictureId = pictureId;
	}

	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	public String getXibie() {
		return xibie;
	}

	public String getZhicheng() {
		return zhicheng;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setJianjie(String jianjie) {
		this.jianjie = jianjie;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public void setXibie(String xibie) {
		this.xibie = xibie;
	}

	public void setZhicheng(String zhicheng) {
		this.zhicheng = zhicheng;
	}
	
}
