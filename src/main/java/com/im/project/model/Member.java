package com.im.project.model;

public class Member {
	private Integer id;

	private String name;

	private String pictureId;

	private String jianjie;

	private String xibie;

	private String zhiwu;


	private Picture picture;
	private String grade;
	private String zhicheng;
	private String xuewei;
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getZhicheng() {
		return zhicheng;
	}

	public void setZhicheng(String zhicheng) {
		this.zhicheng = zhicheng;
	}

	public String getXuewei() {
		return xuewei;
	}

	public void setXuewei(String xuewei) {
		this.xuewei = xuewei;
	}


	public Member CompareTo(Member m){
		this.name=this.name!=m.name?this.name:null;
		this.xibie=this.xibie!=m.xibie?this.xibie:null;
		this.jianjie=this.jianjie!=m.jianjie?this.jianjie:null;
		this.zhiwu=this.zhiwu!=m.zhiwu?this.zhiwu:null;
		this.pictureId=this.pictureId!=m.pictureId?this.pictureId:null;
		this.grade=this.grade!=m.grade?this.grade:null;
		this.zhicheng=this.zhicheng!=m.zhicheng?this.zhicheng:null;
		this.zhiwu=this.zhiwu!=m.zhiwu?this.zhiwu:null;
		this.xuewei=this.xuewei!=m.xuewei?this.xuewei:null;
		return this;
	}
	public String getPictureId() {
		return pictureId;
	}

	public void setPictureId(String pictureId) {
		this.pictureId = pictureId;
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

	public Picture getPicture() {
		return picture;
	}

	public String getXibie() {
		return xibie;
	}

	public String getZhiwu() {
		return zhiwu;
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
	
	public void setPicture(Picture picture) {
		this.picture = picture;
	}
	public void setXibie(String xibie) {
		this.xibie = xibie;
	}
	public void setZhiwu(String zhiwu) {
		this.zhiwu = zhiwu;
	}

	@Override
	public String toString() {
		return "Member{" +
				"id=" + id +
				", name='" + name + '\'' +
				", pictureId='" + pictureId + '\'' +
				", jianjie='" + jianjie + '\'' +
				", xibie='" + xibie + '\'' +
				", zhiwu='" + zhiwu + '\'' +
				", picture=" + picture +
				", grade='" + grade + '\'' +
				", zhicheng='" + zhicheng + '\'' +
				", xuewei='" + xuewei + '\'' +
				'}';
	}
}
