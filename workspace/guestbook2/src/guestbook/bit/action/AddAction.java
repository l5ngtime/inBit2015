package guestbook.bit.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.bit.dao.GuestBookDao;
import guestbook.bit.vo.GuestBookVo;
import web.bit.action.Action;
import web.bit.util.WebUtil;

public class AddAction extends Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		try {
		//
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String content=request.getParameter("content");
		
		GuestBookVo vo = new GuestBookVo();
		vo.setName(name);
		vo.setPassword(password);
		vo.setContent(content);
		
		GuestBookDao dao = GuestBookDao.getInstance();
		
			dao.insert(vo);
			
			WebUtil.redirect(request, response, "gb");
		} catch (SQLException e) {
			System.out.println("db 오류 : "+e);
		}
		
		
	}
}
