package com.richowls.project.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.richowls.project.util.Constant;

public class BDao {
	JdbcTemplate template;

	public BDao() {
		this.template = Constant.template;
	}


	public void register(final String bUsername, final String bPassword, final String bRole) {
		
		this.template.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(java.sql.Connection con) throws SQLException {
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				String hashedPassword = passwordEncoder.encode(bPassword);

				String query = "insert into users (username,password,enabled) values (?, ?, ?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, bUsername);
				pstmt.setString(2, hashedPassword);
				pstmt.setBoolean(3, true);
				return pstmt;
			}
		});
		
		this.template.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(java.sql.Connection con) throws SQLException {
				String query = "insert into user_roles (username, role) values (?, ?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, bUsername);
				pstmt.setString(2, bRole);
				return pstmt;
			}
		});

	}

	
}
