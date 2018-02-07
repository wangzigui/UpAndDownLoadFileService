package com.nf.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class CreateMsgReq {
	// 标题
	@Size(max=100, min=1, message="标题不能少于1大于200个字符")  
	private String title;
	
	//内容
	private String content;
	
	//内容
	@Size(max=10, min=1, message="类型不能少于1大于10个字符")  
	private String type;
	
	//创建者
	@Size(max=50, min=1, message="创建者不能少于1大于50个字符")
	private String creator;
	
	//主题id
	@Min(value=1, message="主题id最小不能小于1")
	private String topicId;
	
	// condition
	private String condition;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "CreateMsgReq [title=" + title + ", content=" + content + ", type=" + type + ", creator=" + creator
				+ ", topicId=" + topicId + ", condition=" + condition + "]";
	}

	
}
