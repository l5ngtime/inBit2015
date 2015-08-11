package guestbook.bit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.bit.action.GuestBookActionFactory;
import web.bit.action.Action;
import web.bit.action.ActionFactory;

/**
 * Servlet implementation class GuestBookServlet
 */
@WebServlet("/gb")
public class GuestBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		ActionFactory actionFactory = new GuestBookActionFactory();
		String actionName = request.getParameter("a");
		Action action = actionFactory.getAction(actionName);
		action.execute(request, response);

	
	}

}
