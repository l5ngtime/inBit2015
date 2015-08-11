package com.bit.emaillist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.web.action.Action;
import com.bit.web.util.WebUtil;

public class FormAction extends Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		// JSP(View)한테 포워딩(요청을 넘김)
		WebUtil.forward(request, response, "/form_emaillist.jsp");

	}

}
