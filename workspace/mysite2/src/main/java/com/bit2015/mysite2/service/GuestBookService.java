package com.bit2015.mysite2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2015.mysite2.dao.GuestBookDao;
import com.bit2015.mysite2.vo.GuestBookVo;

@Service
public class GuestBookService {
	
	@Autowired
	GuestBookDao guestbookDao;
	
	public List<GuestBookVo> list() {
		List<GuestBookVo> list = guestbookDao.get();
		return list;
	}
	
	
	public void delete(long no, String password ) {
		guestbookDao.delete(no, password);
	}
}
