package com.bit2015.guestbook3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2015.guestbook3.exception.GuestbookDeleteException;
import com.bit2015.guestbook3.exception.GuestbookGetListException;
import com.bit2015.guestbook3.exception.GuestbookInsertException;
import com.bit2015.guestbook3.vo.GuestBookVo;

import oracle.jdbc.pool.OracleDataSource;

@Repository
public class GuestBookDao {
	
	@Autowired
	OracleDataSource oracleDataSource;
	// singleton 패턴
	private static GuestBookDao instance = null;

	private GuestBookDao() {
	}// 내부에서만사용가능하게해둠

	public static GuestBookDao getInstance() {
		if (instance == null)
			instance = new GuestBookDao();
		return instance;
	}

	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public List<GuestBookVo> getList() {

		List<GuestBookVo> list = new ArrayList<GuestBookVo>();
		try {
			conn = oracleDataSource.getConnection();
			stmt = conn.createStatement();

			String sql = "  SELECT no, name, password, content, TO_CHAR (reg_date, 'YYYY-MMDD HH:MM:SS') FROM guest_table ORDER BY reg_date DESC";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				String content = rs.getString(4);
				String reg_date = rs.getString(5);

				GuestBookVo vo = new GuestBookVo(no, name, password, content, reg_date);

				list.add(vo);
			}

			rs.close();
			stmt.close();
			conn.close();
			return list;
		} catch (SQLException e) {
			throw new GuestbookGetListException();
		}
	}

	public void insert(GuestBookVo vo) {
		try {
			conn = oracleDataSource.getConnection();
			String sql = "insert into guest_table values ( guest_table_no_seq.nextval, ?, ?, ?, sysdate)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getContent());

			pstmt.executeUpdate();

			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			throw new GuestbookInsertException(e.toString());
		}
	}

	public void delete(int no, String password){
		try {
			conn = oracleDataSource.getConnection();
			String sql = "DELETE FROM guest_table WHERE no=? AND password=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, no);
			pstmt.setString(2, password);

			pstmt.executeUpdate();

			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			throw new GuestbookDeleteException(e.toString());
		}
	}

	public GuestBookVo delSelect(String no) {
		try {
			int ino = Integer.parseInt(no);
			conn = oracleDataSource.getConnection();
			String sql = "SELECT password FROM guest_table WHERE no=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, ino);

			rs = pstmt.executeQuery();

			GuestBookVo vo = new GuestBookVo();

			while (rs.next()) {
				String pass = rs.getString(1);

				vo.setPassword(pass);
			}

			rs.close();
			pstmt.close();
			conn.close();
			return vo;
		} catch (SQLException e) {
			throw new GuestbookDelSelException(e.toString());
		}

	}

}
