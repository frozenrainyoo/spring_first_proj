package com.richowls.project.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.richowls.project.dao.BDao;

public class BRegisterCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String bUsername = request.getParameter("bUsername");
		String bPassword = request.getParameter("bPassword");
		
		BDao dao = new BDao();
		dao.register(bUsername, bPassword);
	}

}