package freeBoard.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import freeBoard.model.vo.FreeBoard;

public class FreeBoardDAO {

	public List<FreeBoard> selectFreeBoardList(Connection conn, int currentPage) {
		PreparedStatement pstmt = null;
		List<FreeBoard> fList = null;
		ResultSet rset = null;
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY FREEBOARD_NO DESC) ROW_NUM, FREEBOARD_TBL.* FROM FREEBOARD_TBL) WHERE ROW_NUM BETWEEN ? AND ?";
		int recordCountPerPage = 10;
		int start = currentPage * recordCountPerPage - (recordCountPerPage -1);
		int end = currentPage * recordCountPerPage;

		fList = new ArrayList<FreeBoard>();
		try {
			pstmt = conn.prepareCall(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				FreeBoard freeBoard = rsetToFreeBoard(rset);
				fList.add(freeBoard);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return fList;
	}

	private FreeBoard rsetToFreeBoard(ResultSet rset) throws SQLException {
		FreeBoard freeBoard = new FreeBoard();
		freeBoard.setFreeBoardNo(rset.getInt("FREEBOARD_NO"));
		freeBoard.setFreeBoardTitle(rset.getString("FREEBOARD_TITLE"));
		freeBoard.setFreeBoardContent(rset.getString("FREEBOARD_CONTENT"));
		freeBoard.setFreeBoardWriter(rset.getString("FREEBOARD_WRITER"));
		freeBoard.setViewCount(rset.getInt("VIEW_COUNT"));
		freeBoard.setRcmndCount(rset.getInt("RCMND_COUNT"));
		freeBoard.setFreeBoardDate(rset.getTimestamp("FREEBOARD_DATE"));
		freeBoard.setUpdateDate(rset.getTimestamp("UPDATE_DATE"));
		return freeBoard;
	}

	public String generatePageNavi(int currentPage) {
		int totalCount = 200;
		int recordCountPerPage = 10;
		int naviTotalCount = 0;
		if(totalCount % recordCountPerPage > 0) {
			naviTotalCount = totalCount / recordCountPerPage + 1;
		} else {
			naviTotalCount = totalCount / recordCountPerPage;
		}
		int naviCountPerPage = 5;
		
		int startNavi = ((currentPage -1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		if (endNavi > naviTotalCount) {
			endNavi = naviTotalCount;
		}
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi ==1) {
			needPrev = false;
		}
		if(endNavi == naviTotalCount) {
			needNext = false;
		}
		StringBuilder result = new StringBuilder();
		if(needPrev) {
			result.append("<a href='/bulletinBoard/freeBoard/list.do?currentPage="+(startNavi-1)+"'>[이전]</a>");
		}
		for (int i = startNavi; i<= endNavi; i++) {
			result.append("&nbsp;<a href='/bulletinBoard/freeBoard/list.do?currentPage="+i+"'>"+ i + "</a>&nbsp;&nbsp;");
			
		}
		if(needNext) {
			result.append("<a href='/bulletinBoard/freeBoard/list.do?currentPage="+(endNavi+1)+"'>[다음]</a>");
		}
		return result.toString();
	}

	public int insertFreeBoard(Connection conn, FreeBoard freeBoard) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO FREEBOARD_TBL VALUES(SEQ_FREEBOARDNO.NEXTVAL,?,?, 'admin' ,DEFAULT,DEFAULT,DEFAULT,DEFAULT)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, freeBoard.getFreeBoardTitle());
		    pstmt.setString(2, freeBoard.getFreeBoardContent());
//		    pstmt.setString(3, freeBoard.getFreeBoardWriter()); // FreeBoard 객체에서 작성자 아이디 설정
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
