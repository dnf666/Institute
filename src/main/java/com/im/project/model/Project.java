package com.im.project.model;

public class Project {
	private Integer id;
	private String title;
	private String content;
	private String leader;
	private String startline;
	private String deadline;
	private Integer type;

	public String getContent() {
		return content;
	}

	public String getDeadline() {
		return deadline;
	}

	public Integer getId() {
		return id;
	}
	public String getLeader() {
		return leader;
	}

	public String getStartline() {
		return startline;
	}

	public String getTitle() {
		return title;
	}

	public Integer getType() {
		return type;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLeader(String leader) {
		this.leader = leader == null ? null : leader.trim();
	}

	public void setStartline(String startline) {
		this.startline = startline;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
