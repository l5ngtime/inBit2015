package guestbook.bit.testdao;

import java.sql.SQLException;
import java.util.List;


import guestbook.bit.dao.GuestBookDao;
import guestbook.bit.vo.GuestBookVo;

public class GuestBookTest {

	public static void main(String[] args) {
		
		try {
			//select();
			delselect();
		} catch (SQLException e) {
			System.out.println("DB오류 : "+e);
		}
	}
	
	public static void select() throws SQLException{
		GuestBookDao dao = GuestBookDao.getInstance();
		List<GuestBookVo> list = dao.getList();
		
		for (GuestBookVo vo : list) {
			System.out.println(vo);
		}
		
	}
	
	public static void delselect() throws SQLException{
		GuestBookDao dao = GuestBookDao.getInstance();
		String no = "6";
		dao.delSelect(no);
		
		System.out.println();
		
	}

}
