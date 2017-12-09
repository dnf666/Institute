package com.im.project.model;

public class Department {
	private Integer id;
	private String name;
	private String pictureId;
	private String url;
	private Picture picture;
	public Department CompareTo(Department d){
		this.name=this.name!=d.name?this.name:null;
		this.url=this.url!=d.url?this.url:null;
		return this;
	}
	public String getPictureId() {
		return pictureId;
	}
	public void setPictureId(String fileId) {
		this.pictureId = fileId;
	}
	public Picture getPicture() {
		return picture;
	}
	public void setPicture(Picture picture) {
		this.picture = picture;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name==null?null:name.trim();
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url==null?null:url.trim();
	}

	@Override
	public String toString() {
		return "Department{" +
				"id=" + id +
				", name='" + name + '\'' +
				", pictureId='" + pictureId + '\'' +
				", url='" + url + '\'' +
				", picture=" + picture +
				'}';
	}
}
