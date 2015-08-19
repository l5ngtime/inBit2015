package com.bit2015.guestbook3.exception;


public class GuestbookGetListException extends RuntimeException {
private static final long serialVersionUID=1L;

public GuestbookGetListException(){
	super ("EmailListDao:getList Exception");
	
}
	public GuestbookGetListException(String msg){
		super(msg);
	}
}
