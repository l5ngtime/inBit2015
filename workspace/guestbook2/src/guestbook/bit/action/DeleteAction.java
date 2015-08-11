package guestbook.bit.action;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.bit.util.WebUtil;

import guestbook.bit.dao.GuestBookDao;
import web.bit.action.Action;

public class DeleteAction extends Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		try {
		String no = request.getParameter("no");
		String password=request.getParameter("password");
		//
		GuestBookDao dao = GuestBookDao.getInstance();
		
			dao.delete(no, password);
			
		WebUtil.redirect(request, response, "gb");
		} catch (SQLException e) {
			System.out.println("db 오류 : "+e);
		}
		
	}
}
