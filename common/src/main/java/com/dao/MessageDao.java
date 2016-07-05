package com.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.MessageMq;

@Repository
public class MessageDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(DataSource ds){
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	/**
	 * 
	 * @param msg
	 */
	public void saveMessage(final MessageMq msg){
		StringBuilder query = new StringBuilder(150);
		
		query.append("INSERT INTO T_MESSAGE (NAME, VALEUR) VALUES (?, ?)");
		
		this.jdbcTemplate.update(query.toString(), new Object[]{msg.getName(), msg.getValeur()});
	}
	
	/**
	 * 
	 * @return
	 */
	public List<MessageMq>getAllMessage(){
		StringBuilder query = new StringBuilder(150);
		query.append("SELECT NAME, VALEUR FROM T_MESSAGE");
		
		
		return this.jdbcTemplate.queryForList(query.toString(), MessageMq.class);
	}
}
