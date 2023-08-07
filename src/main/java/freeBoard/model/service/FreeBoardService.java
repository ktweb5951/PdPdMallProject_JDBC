package freeBoard.model.service;

import java.sql.Connection;
import java.util.List;

import common.JDBCTemplate;
import freeBoard.model.dao.FreeBoardDAO;
import freeBoard.model.vo.FreeBoard;
import freeBoard.model.vo.PageData;

public class FreeBoardService {

	private FreeBoardDAO fDao;
	private JDBCTemplate jdbcTemplate;
	
	public FreeBoardService() {
		fDao = new FreeBoardDAO();
		jdbcTemplate = JDBCTemplate.getInstance();
	}
	
	//전체 목록 조회
	public PageData selectFreeBoardList(int currentPage) {
		Connection conn = jdbcTemplate.createConnection();
		List<FreeBoard> fList = fDao.selectFreeBoardList(conn, currentPage);
		String pageNavi = fDao.generatePageNavi(currentPage);
		PageData pd = new PageData(fList, pageNavi);
		jdbcTemplate.close(conn);
		return pd;
	}

	public int insertFreeBoard(FreeBoard freeBoard) {
		Connection conn = jdbcTemplate.createConnection();
		int result = fDao.insertFreeBoard(conn, freeBoard);
		if(result > 0) {
			jdbcTemplate.commit(conn);
		} else {
			jdbcTemplate.rollback(conn);
		}
		jdbcTemplate.close(conn);
		return result;
	}
}
