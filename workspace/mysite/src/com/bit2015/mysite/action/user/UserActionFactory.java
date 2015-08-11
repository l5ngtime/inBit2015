package com.bit2015.mysite.action.user;

import com.bit2015.mysite.action.index.IndexAction;
import com.bit2015.web.action.Action;
import com.bit2015.web.action.ActionFactory;

public class UserActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		
		Action action = null;
		if("joinform".equals(actionName)){
			action = new JoinFormAction();
		}else if("join".equals(actionName)){
			action = new JoinAction();
		}
		else if("joinsuccess".equals(actionName)){
			action = new JoinSuccesAction();
		}
		else if("loginform".equals(actionName)){
			action = new LoginFormAction();
			
		}else if("login".equals(actionName)){
			action=new LoginAction();
			
			
		}else if("logout".equals(actionName)){
			action = new LogoutAction();
			
		}else if("update".equals(actionName)){
			action = new UpdateAction();
			
		}else if("updateform".equals(actionName)){
			action = new UpdateFormAction();
			
		}else if("updatesuccess".equals(actionName)){
			action = new UpdateSuccesAction();
			
		}else if("checkemail".equals(actionName)){
			action = new CheckEmailAction();
			
		}else{
			action = new IndexAction();
		}
		
		return action;
	}

}
