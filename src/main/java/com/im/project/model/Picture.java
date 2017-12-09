package com.im.project.model;
public class Picture {
	private String id ;
	private String date;
	private String type;
	private String link;
	private String realPath;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getRealPath() {
		return realPath;
	}
	public void setRealPath(String realPath) {
		this.realPath = realPath;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type==null?null:type;
	}

	@Override
	public String toString() {
		return "Picture{" +
				"id='" + id + '\'' +
				", date='" + date + '\'' +
				", type='" + type + '\'' +
				", link='" + link + '\'' +
				", realPath='" + realPath + '\'' +
				'}';
	}
}
