package com.bit2015.mysite2.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.bit2015.mysite2.vo.BoardVo;
import com.bit2015.mysite2.vo.ReplyVo;
import com.bit2015.mysite2.vo.UserVo;

@Repository
public class BoardDao {
	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;
	
	public int totalPage(){
		Integer total=(Integer)sqlMapClientTemplate.queryForObject("board.getTotal");
		return total;
	}
	
	public List<BoardVo> getList(int num){
		List<BoardVo> list = (List<BoardVo>)sqlMapClientTemplate.queryForList("board.getList", num);
		return list;
	}
	
	public BoardVo getView(long no){
		BoardVo vo =(BoardVo)sqlMapClientTemplate.queryForObject("board.getView", no);
		return vo;
	}
	
	public List<ReplyVo> getReList(long no){
		List<ReplyVo> rist = sqlMapClientTemplate.queryForList("board.getReList", no);
		return rist;
	}
	
	public void plusCnt(long no){
		sqlMapClientTemplate.update("board.plusCnt", no);
	}
	
	public void insert(UserVo uvo, BoardVo vo){
		vo.setMember_name(uvo.getName());
		vo.setMember_no(uvo.getNo());
		sqlMapClientTemplate.update("board.insert", vo);
		System.out.println("다오성공");
	}
	
	
	public void dapInsert(BoardVo vo){
		BoardVo upvo = new BoardVo();
		upvo.setMy_no(vo.getMy_no());
		upvo.setOrder_no(vo.getOrder_no());
		
		vo.setDap(vo.getDap()+1);
		if(vo.getOrder_no()>0){
			vo.setOrder_no(vo.getOrder_no()+1);
		}else{
			vo.setOrder_no(1);
		}
		sqlMapClientTemplate.update("board.dapUpdate", upvo);
		sqlMapClientTemplate.insert("board.dapInsert", vo);
	}
		
	public int searchPage(String kwd){
		Integer total=(Integer)sqlMapClientTemplate.queryForObject("board.searchTotal", kwd);
		System.out.println("서치토탈 쿼리 성공"+total);
		return total;
	}
	
	public List<BoardVo> searchList(String kwd, int num){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("kwd", kwd);
		map.put("page", num);
		List<BoardVo> list = (List<BoardVo>)sqlMapClientTemplate.queryForList("board.search", map);
		return list;
	}
	
	public void reply(ReplyVo vo){
		sqlMapClientTemplate.insert("board.reInsert", vo);
	}
	
	public void redelete(long no){
		sqlMapClientTemplate.delete("board.redelete", no);
	}
	
	public void delete(long no){
		sqlMapClientTemplate.delete("board.delete", no);
	}
	
	public BoardVo upView(long no){
		BoardVo vo =(BoardVo)sqlMapClientTemplate.queryForObject("board.upView", no);
		return vo;
	}
	
	public void update(BoardVo vo){
		sqlMapClientTemplate.update("board.update", vo);
	}
	
}
