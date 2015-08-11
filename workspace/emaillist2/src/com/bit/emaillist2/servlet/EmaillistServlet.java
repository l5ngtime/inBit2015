package com.bit.emaillist2.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.emaillist.action.EmailListActionFactory;
import com.bit.emaillist.action.FormAction;
import com.bit.emaillist.action.IndexAction;
import com.bit.emaillist.action.InsertAction;
import com.bit.web.action.Action;
import com.bit.web.action.ActionFactory;

/**
 * Servlet implementation class EmaillistServlet
 */
@WebServlet("/el")
public class EmaillistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		ActionFactory actionFactory = new EmailListActionFactory();
		String actionName = request.getParameter("a");
		Action action = actionFactory.getAction(actionName);
		action.execute(request, response);

	}

}
