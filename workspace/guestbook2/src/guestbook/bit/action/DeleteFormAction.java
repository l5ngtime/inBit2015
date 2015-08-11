package guestbook.bit.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.bit.dao.GuestBookDao;
import guestbook.bit.vo.GuestBookVo;
import web.bit.util.WebUtil;

import web.bit.action.Action;

public class DeleteFormAction extends Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
			
			WebUtil.forward(request, response, "/deleteform.jsp");
				
		
	}
}
