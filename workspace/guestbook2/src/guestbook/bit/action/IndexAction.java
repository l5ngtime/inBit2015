package guestbook.bit.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.bit.dao.GuestBookDao;
import guestbook.bit.vo.GuestBookVo;
import web.bit.action.Action;
import web.bit.util.WebUtil;

public class IndexAction extends Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		
		try {
		//
		GuestBookDao dao = GuestBookDao.getInstance();
		List<GuestBookVo> list = dao.getList();
		
		
		request.setAttribute("list", list);
		WebUtil.forward(request, response, "/index.jsp");
			
		} catch (SQLException e) {
			System.out.println("DBerror : "+e);
		}
		
	}

}
