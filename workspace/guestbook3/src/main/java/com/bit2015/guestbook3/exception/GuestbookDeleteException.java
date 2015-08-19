package com.bit2015.guestbook3.exception;

public class GuestbookDeleteException extends RuntimeException {
	private static final long serialVersionUID=1L;

	public GuestbookDeleteException(){
		super ("EmailListDao:Delete Exception");
		
	}
		public GuestbookDeleteException(String msg){
			super(msg);
		}
	}
