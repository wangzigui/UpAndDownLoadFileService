package com.nf.entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;


import oracle.sql.CLOB;

public class MessageRowMapperTest implements RowMapper<Message>{
	
	//@Override
	public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
			Message message = new Message();
			byte[] bytes = rs.getBytes("content");
			message.setContent(bytes);
			

//			message.setId(rs.getInt("id"));
//			Date date = new Date(rs.getTimestamp("createtimestamp").getTime());
//			
//
//			message.setCreator(rs.getString("creator"));
//			message.setTitle(rs.getString("title"));
//			message.setTopicId(rs.getInt("topicId"));
//			message.setType(rs.getString("type"));
			
			return message;
	}

	
	
}
