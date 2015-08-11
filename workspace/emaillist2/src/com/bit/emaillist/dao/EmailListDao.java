package com.bit.emaillist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bit.emaillist.vo.EmailListVo;

public class EmailListDao {

	
	//singleton 패턴
	private static EmailListDao instance=null;
	private EmailListDao() {}//내부에서만사용가능하게해둠
	public static EmailListDao getInstance(){
		if(instance==null)
			instance=new EmailListDao();
		return instance;
	}
	
	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	private Connection getConnection() throws SQLException {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bitdb", "bitdb");
		} catch (ClassNotFoundException e) {
			System.out.println("db오류" + e);
		}

		return conn;
	}

	public List<EmailListVo> getList() throws SQLException {

		List<EmailListVo> list = new ArrayList<EmailListVo>();

		conn = getConnection();
		stmt = conn.createStatement();

		String sql = "select * from email_list order by no desc";
		rs = stmt.executeQuery(sql);

		while (rs.next()) {
			long no = rs.getLong(1);
			String first_name = rs.getString(2);
			String last_name = rs.getString(3);
			String email = rs.getString(4);

			EmailListVo vo = new EmailListVo();
			vo.setNo(no);
			vo.setFirst_name(first_name);
			vo.setLast_name(last_name);
			vo.setEmail(email);

			list.add(vo);
		}

		rs.close();
		stmt.close();
		conn.close();
		return list;

	}

	public void insert(EmailListVo vo) throws SQLException {

		conn = getConnection();
		String sql = "insert into EMAIL_LIST values (email_list_no_seq.nextval, ?, ?, ?)";
		pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, vo.getFirst_name());
		pstmt.setString(2, vo.getLast_name());
		pstmt.setString(3, vo.getEmail());

		pstmt.executeUpdate();

		pstmt.close();
		conn.close();
	}

	public void delete(EmailListVo vo) throws SQLException {

		conn = getConnection();
		String sql = "delete from email_list where email=?";
		pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, vo.getEmail());

		pstmt.executeUpdate();

		pstmt.close();
		conn.close();
	}
	
	public void update(EmailListVo vo, String emailReal) throws SQLException {

		conn = getConnection();
		String sql = "UPDATE EMAIL_LIST SET first_name=?, last_name=?,email=? WHERE email=?";
		pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, vo.getFirst_name());
		pstmt.setString(2, vo.getLast_name());
		pstmt.setString(3, vo.getEmail());
		pstmt.setString(4, emailReal);

		pstmt.executeUpdate();

		pstmt.close();
		conn.close();
	}
	
	public EmailListVo upSelect(String emailReal) throws SQLException {
		
		String email=emailReal;
		conn = getConnection();
		String sql = "SELECT first_name, last_name, email FROM EMAIL_LIST WHERE email=?";
		pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, email);

		rs = pstmt.executeQuery();
		
		EmailListVo vo = new EmailListVo();
		
		while(rs.next()){
			String first_name = rs.getString(1);
			String last_name = rs.getString(2);
			email = rs.getString(3);
			
			vo.setFirst_name(first_name);
			vo.setLast_name(last_name);
			vo.setEmail(email);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		return vo;
	}

}
