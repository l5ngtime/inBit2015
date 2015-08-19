package com.bit2015.mysite2.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.bit2015.mysite2.vo.GuestBookVo;

@Repository
public class GuestBookDao {
	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;
	
	public List<GuestBookVo> get(){
		List<GuestBookVo> list = (List<GuestBookVo>)sqlMapClientTemplate.queryForList("guestbook.getList");
		return list;
	}
	
	public void delete(long no, String password){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("password", password);
		sqlMapClientTemplate.delete("guestbook.delete", map);
	}
	
}
