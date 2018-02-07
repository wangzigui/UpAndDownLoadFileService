package com.nf.entity;


public class Message {
	// 标题
	private Integer id;

	// 标题
	private String title;

	// 内容
	private byte[] content;

	// 标题
	private String createtimestamp;

	// 内容
	private String type;

	// 创建者
	private String creator;

	// 主题id
	private Integer topicId;

	//
	private String whiteList;
	
	//
	private Integer readLogStatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public String getCreatetimestamp() {
		return createtimestamp;
	}

	public void setCreatetimestamp(String createtimestamp) {
		this.createtimestamp = createtimestamp;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public String getWhiteList() {
		return whiteList;
	}

	public void setWhiteList(String whiteList) {
		this.whiteList = whiteList;
	}

	public Integer getReadLogStatus() {
		return readLogStatus;
	}

	public void setReadLogStatus(Integer readLogStatus) {
		this.readLogStatus = readLogStatus;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", title=" + title + ", content=" + content + ", createtimestamp="
				+ createtimestamp + ", type=" + type + ", creator=" + creator + ", topicId=" + topicId + ", whiteList="
				+ whiteList + ", readLogStatus=" + readLogStatus + "]";
	}
	
}
