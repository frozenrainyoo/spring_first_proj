package com.richowls.project.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.mysql.jdbc.Connection;
import com.richowls.project.util.Constant;

public class BDao {
	JdbcTemplate template;

	public BDao() {
		this.template = Constant.template;
	}

	
//	INSERT INTO users(username,password,enabled)
//	VALUES ('mkyong','123456', true);

	public void register(final String bUsername, final String bPassword) {
		// TODO Auto-generated method stub
		
		this.template.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(java.sql.Connection con) throws SQLException {
				String query = "insert into users (username,password,enabled) values (?, ?, ?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, bUsername);
				pstmt.setString(2, bPassword);
				pstmt.setBoolean(3, true);
				return pstmt;
			}
		});
	}
}
