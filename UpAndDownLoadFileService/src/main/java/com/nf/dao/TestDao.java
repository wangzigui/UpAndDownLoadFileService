package com.nf.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.stereotype.Repository;

import com.nf.DataSource;
import com.nf.domain.CreateMsgReq;
import com.nf.entity.AssetQuota;
import com.nf.entity.Message;
import com.nf.entity.MessageRowMapperTest;
import com.nf.util.SerializableInterface;

@Repository
public class TestDao {

	public void createMsg(CreateMsgReq createMsgReq) {
		// 存入数据库
		DataSource.busin.update(
				"insert into RSCH_S_MSG(ID, Title,Content,Creator,Type,TopicID,Whitelist) values(S_RSCH_MSG_MESSAGE.nextval, ?,?,?,?,?,?)",
				new MyPreparedStatementSetter(createMsgReq));
	}
	
	public AssetQuota getMsgById(String id) {
		String sql = "select * from businessdata.RSCH_S_MSG t where t.id = ? ";
		List<Message> messages = DataSource.busin.query(sql, new Object[] {id}, new MessageRowMapperTest());
		Message ms = messages.get(0);
		
		// 反序列化byte数组
		Map<String, AssetQuota> map = SerializableInterface.deserialize(ms.getContent());
		System.out.println(map.get("sa"));
		return map.get("sa");
	}
	
	private class MyPreparedStatementSetter<T> implements PreparedStatementSetter
	{
		final T temList;  
	      
	    public MyPreparedStatementSetter(T list){  
	        temList = list;  
	    }  

		@Override
		public void setValues(PreparedStatement ps) throws SQLException {
			Map<String, AssetQuota> strss = new HashMap<String, AssetQuota>();
			AssetQuota assetQuota = new AssetQuota();
			assetQuota.setN_cash_ratio(11.1);
			assetQuota.setN_left_3aasset(11.6);
			assetQuota.setV_jjdm("sdfd"+new Random().nextInt(100));
			assetQuota.setTime(new Date());
			strss.put("sa", assetQuota);
			
			// 序列化Map集合为二进制数组
			byte[] bytes = SerializableInterface.serialize(strss);
			
			CreateMsgReq message = (CreateMsgReq) temList;
			ps.setString(1, message.getTitle());
			ps.setBytes(2, bytes);
			ps.setString(3, message.getCreator());
			ps.setString(4, message.getType());
			ps.setString(5, message.getType());
			ps.setString(6, message.getType());
		}
		
	}
}
