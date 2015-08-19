package com.bit2015.mysite2.dao;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.bit2015.mysite2.vo.UserVo;

@Repository
public class UserDao {
	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;
	
	public UserVo get( String email, String password ) {
		Map<String, String> map = new HashMap<String, String>();
		map.put( "email", email );
		map.put( "password", password );
		
		UserVo vo = (UserVo)sqlMapClientTemplate.queryForObject( "user.getByEmailAndPassword", map );
		return vo;
	}
	
	//insert
	public void insert( UserVo vo ) {
		sqlMapClientTemplate.insert( "user.insert", vo );
	}	
	
	//update
	public void update(UserVo vo){
		sqlMapClientTemplate.update("user.update", vo);
	}
	
	public UserVo updateform(long no){
		UserVo vo = (UserVo)sqlMapClientTemplate.queryForObject("user.getByNo", no);
		return vo;
	}
}
