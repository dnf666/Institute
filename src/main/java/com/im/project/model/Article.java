package com.im.project.model;


public class Article {
	private Integer id;
	private String title;
	private String content;
	private String date;
	private String author;
	private String keyword;
    private String summary;
    private String picture;

	@Override
	public String toString() {
		return "Article{" +
				"id=" + id +
				", title='" + title + '\'' +
				", content='" + content + '\'' +
				", date='" + date + '\'' +
				", author='" + author + '\'' +
				", keyword='" + keyword + '\'' +
				", summary='" + summary + '\'' +
				", picture='" + picture + '\'' +
				'}';
	}

	public Article CompareTo(Article a){
    	this.author=this.author!=a.author?this.author:null;
    	this.content=this.content!=a.content?this.content:null;
    	this.keyword=this.keyword!=a.keyword?this.keyword:null;
    	this.summary=this.summary!=a.summary?this.summary:null;
    	this.title=this.title!=a.title?this.title:null;
    	return this;
    }
	public String getAuthor() {
		return author;
	}

	public String getContent() {
		return content;
	}
	

	public Integer getId() {
		return id;
	}
	
	public String getKeyword() {
		return keyword;
	}


	public String getSummary() {
		return summary;
	}

	public String getTitle() {
		return title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setContent(String content) {
		this.content = content==null?null:content.trim();
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}


	public void setSummary(String summary) {
		this.summary = summary;
	}

	public void setTitle(String title) {
		this.title = title==null?null:title.trim();
	}

}
