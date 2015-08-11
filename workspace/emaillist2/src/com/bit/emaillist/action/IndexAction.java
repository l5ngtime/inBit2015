package com.bit.emaillist.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.emaillist.dao.EmailListDao;
import com.bit.emaillist.vo.EmailListVo;
import com.bit.web.action.Action;
import com.bit.web.util.WebUtil;

public class IndexAction extends Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		try {
			// default action list
			// 1.DAO(Model)한테 list요청
			EmailListDao dao = EmailListDao.getInstance();

			List<EmailListVo> list;

			list = dao.getList();

			// 2.list를 request 범위안에 저장
			request.setAttribute("list", list);

			// 3.JSP(View)한테 포워딩(요청을 넘김)
			WebUtil.forward(request, response, "/index.jsp");
		} catch (SQLException e) {
			System.out.println("db 오류 : " + e);
		}
	}

}
