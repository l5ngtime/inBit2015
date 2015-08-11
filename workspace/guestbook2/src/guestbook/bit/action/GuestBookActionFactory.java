package guestbook.bit.action;

import web.bit.action.Action;
import web.bit.action.ActionFactory;

public class GuestBookActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		
		Action action = null;

		if ("add".equals(actionName)) {
			action = new AddAction();
		} else if ("delete".equals(actionName)) {
			action = new DeleteAction();
		} else if ("deleteForm".equals(actionName)) {
			action = new DeleteFormAction();
		} else {
			action = new IndexAction();

		}

		return action;
	}

}
