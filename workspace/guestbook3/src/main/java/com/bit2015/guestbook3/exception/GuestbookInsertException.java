package com.bit2015.guestbook3.exception;

public class GuestbookInsertException extends RuntimeException {
	private static final long serialVersionUID=1L;

	public GuestbookInsertException(){
		super ("EmailListDao:Insert Exception");
		
	}
		public GuestbookInsertException(String msg){
			super(msg);
		}
	}

