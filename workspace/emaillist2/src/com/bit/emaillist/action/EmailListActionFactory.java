package com.bit.emaillist.action;

import com.bit.web.action.Action;
import com.bit.web.action.ActionFactory;

public class EmailListActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		if ("insert".equals(actionName)) {
			action = new InsertAction();

		} else if ("form".equals(actionName)) {
			action = new FormAction();
		} else { // index, default
			action = new IndexAction();

		}
		return action;
	}

}
