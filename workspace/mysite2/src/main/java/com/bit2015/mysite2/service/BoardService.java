package com.bit2015.mysite2.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2015.mysite2.dao.BoardDao;
import com.bit2015.mysite2.vo.BoardVo;
import com.bit2015.mysite2.vo.ReplyVo;
import com.bit2015.mysite2.vo.UserVo;

@Service
public class BoardService {
	
	@Autowired
	BoardDao boardDao;
	
	
	public int totalPage(){
		int total = boardDao.totalPage();
		return total;
	}
	
	public int searchPage(String kwd){
		int total = boardDao.searchPage(kwd);
		return total;
	}
	
	public List<BoardVo> getList(int num){
		List<BoardVo> list = boardDao.getList(num);
		return list;
	}
	
	public BoardVo getView(long no){
		BoardVo vo = boardDao.getView(no);
		return vo;
	}
	
	public List<ReplyVo> getReList(long no){
		List<ReplyVo> rist = boardDao.getReList(no);
		return rist;
	}
	
	public void plusCnt(long no){
		boardDao.plusCnt(no);
	}
	
	public void insert(BoardVo vo, UserVo uvo){
		boardDao.insert(uvo, vo);
	}
	
	public void dapInsert(BoardVo vo){
		boardDao.dapInsert(vo);
	}
	
	public List<BoardVo> search(String kwd, int num){
		List<BoardVo> list =boardDao.searchList(kwd, num);
		return list;
	}
	
	public void reply(ReplyVo vo){
		boardDao.reply(vo);
	}
	
	public void redelete(long no){
		boardDao.redelete(no);
	}
	
	public void delete(long no){
		boardDao.delete(no);
	}
	
	public BoardVo upView(long no){
		BoardVo vo =boardDao.upView(no);
		return vo;
	}
	
	public void update(BoardVo vo){
		boardDao.update(vo);
	}
	
}
