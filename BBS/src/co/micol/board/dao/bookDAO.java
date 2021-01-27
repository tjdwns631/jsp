package co.micol.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.board.vo.bookVO;

public class bookDAO extends DAO{
	private PreparedStatement psmt; // sql 명령문 실행
	private ResultSet rs; 
	private bookVO vo;
	private final String bookselect_all = " SELECT *FROM book_tbl_06 ";
	private final String bookinsert = " INSERT INTO book_tbl_06 VALUES((select max (book_no)+1 from book_tbl_06),?,?,?,?,?,?)";
	private final String rentselect_all =" select a.book_no, a.book_name, sum(b.rent_price) as rent_price, count(b.rent_status) as rent_status " + 
			" from book_tbl_06 a inner join rent_tbl_06 b " + 
			" on a.book_no= b.book_no group by a.book_no, a.book_name order by 4 desc";
	
	//렌트
	public List<bookVO> rentselect_all() {// 멤버 리스트 전체를 가져오는 메소드
		List<bookVO> list = new ArrayList<bookVO>();
		try {
			psmt = conn.prepareStatement(rentselect_all);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new bookVO();
				vo.setBook_no(rs.getInt("book_no"));
				vo.setBook_name(rs.getString("book_name"));
				vo.setRent_price(rs.getInt("rent_price"));
				vo.setRent_status(rs.getString("rent_status"));
				list.add(vo);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}
	
	
	//도서 전체 조회
	public List<bookVO> bookselect_all() {
		List<bookVO> list = new ArrayList<bookVO>();
		try {
			psmt = conn.prepareStatement(bookselect_all);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new bookVO();
				vo.setBook_no(rs.getInt("book_no"));
				vo.setBook_name(rs.getString("book_name"));
				vo.setBook_coverimg(rs.getString("book_coverimg"));
				vo.setBook_date(rs.getDate("book_date"));
				vo.setBook_price(rs.getInt("book_price"));
				vo.setBook_publisher(rs.getString("book_publisher"));
				vo.setBook_info(rs.getString("book_info"));
				list.add(vo);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}
	
//도서등록
public int bookinsert(bookVO vo) {// 인서트
	int n = 0;
	try {
		psmt = conn.prepareStatement(bookinsert);
		psmt.setString(1, vo.getBook_name());
		psmt.setString(2, vo.getBook_coverimg());
		psmt.setDate(3, vo.getBook_date());
		psmt.setInt(4, vo.getBook_price());
		psmt.setString(5, vo.getBook_publisher());
		psmt.setString(6, vo.getBook_info());
		n = psmt.executeUpdate();

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		close();
	}
	return n;
	
}

private void close() {
	try {
		if (rs != null)
			rs.close();
		if (psmt != null)
			psmt.close();
		if (conn != null)
			conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}

}

}