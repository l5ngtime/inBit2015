package com.bit.emaillist.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.emaillist.dao.EmailListDao;
import com.bit.emaillist.vo.EmailListVo;
import com.bit.web.action.Action;
import com.bit.web.util.WebUtil;

public class InsertAction extends Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
			try {
			String first_name = request.getParameter("first_name");
			String last_name = request.getParameter("last_name");
			String email = request.getParameter("email");
	
			EmailListVo vo = new EmailListVo();
			vo.setFirst_name(first_name);
			vo.setLast_name(last_name);
			vo.setEmail(email);
	
			EmailListDao dao = EmailListDao.getInstance();
			
				dao.insert(vo);
			
			WebUtil.redirect(request, response, "el");
		} catch (SQLException e) {
			System.out.println("db 오류 : "+e);
		}

	}
		

}
