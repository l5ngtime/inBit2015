package com.bit2015.guestbook3.dao;

public class GuestbookDelSelException extends RuntimeException {
	private static final long serialVersionUID=1L;

	public GuestbookDelSelException(){
		super ("EmailListDao:DelSel Exception");
		
	}
		public GuestbookDelSelException(String msg){
			super(msg);
		}
	}
