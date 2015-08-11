package com.bit.emaillist.daotest;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.bit.emaillist.dao.EmailListDao;
import com.bit.emaillist.vo.EmailListVo;

public class TestDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			// testInsert();
			 testGetlist();
			//testupSelect();
		} catch (SQLException e) {
			System.out.println("SQL문법오류" + e);
		}

	}

	public static void testInsert() throws SQLException {

		EmailListDao dao = EmailListDao.getInstance();
		EmailListVo vo = new EmailListVo();

		Scanner sc = new Scanner(System.in);
		System.out.println("성을 적어주세요");
		String first_name = sc.nextLine();
		System.out.println("이름을 적어주세요");
		String last_name = sc.nextLine();
		System.out.println("이메일을 적어주세요");
		String email = sc.nextLine();

		vo.setFirst_name(first_name);
		vo.setLast_name(last_name);
		vo.setEmail(email);

		dao.insert(vo);

	}

	public static void testGetlist() throws SQLException {

		EmailListDao dao = EmailListDao.getInstance();

		List<EmailListVo> list = dao.getList();

		for (EmailListVo vo : list) {
			System.out.println(vo.getNo() + ":" + vo.getFirst_name() + " " + vo.getLast_name() + ":" + vo.getEmail());

		}

	}

	public static void testupSelect() throws SQLException {

		EmailListDao dao = EmailListDao.getInstance();
		String emailReal = "jae9360@gmail.com";
		EmailListVo vo = dao.upSelect(emailReal);

		System.out.println(vo.getFirst_name() + " " + vo.getLast_name() + ":" + vo.getEmail());

	}

}
