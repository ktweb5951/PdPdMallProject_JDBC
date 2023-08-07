package member.model.dao;

import java.sql.*;


import member.model.vo.Member;

public class MemberDAO {

	public int insertMember(Connection conn, Member member) {
		String query = "INSERT INTO MALLMEMBER_TBL VALUES(?,?,?,?,?,?,?,?,?,DEFAULT)";
		PreparedStatement pstmt = null;
		int result = 0;
		
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, member.getMemberId());
				pstmt.setString(2, member.getMemberPw());
				pstmt.setString(3, member.getMemberName());
				pstmt.setString(4, member.getMemberNickname());
				pstmt.setString(5, member.getMemberPhone());
				pstmt.setString(6, member.getMemberAddress());
				pstmt.setString(7, member.getPostalCodeOne());
				pstmt.setString(8, member.getPostalCodeTwo());
				pstmt.setString(9, member.getMemberEmail());
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

	public int updateMember(Connection conn, Member member) {
		String query = "UPDATE MALLMEMBER_TBL SET MEMBER_PW=?, MEMBER_NICKNAME=?, MEMBER_PHONE=?, MEMBER_ADDRESS=?, POSTALCODE_ONE=?, POSTALCODE_TWO=?, MEMBER_EMAIL=? WHERE MEMBER_ID=?";
		PreparedStatement pstmt = null;
		int result = 0;
		
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(8, member.getMemberId());
				pstmt.setString(1, member.getMemberPw());
				pstmt.setString(2, member.getMemberNickname());
				pstmt.setString(3, member.getMemberPhone());
				pstmt.setString(4, member.getMemberAddress());
				pstmt.setString(5, member.getPostalCodeOne());
				pstmt.setString(6, member.getPostalCodeTwo());
				pstmt.setString(7, member.getMemberEmail());
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

	public int deleteMemberById(Connection conn, String memberId) {
		String query = "DELETE FROM MALLMEMBER_TBL WHERE MEMBER_ID = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
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

	public Member selectCheckLogin(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM MALLMEMBER_TBL WHERE MEMBER_ID = ? AND MEMBER_PW = ?";
		Member mOne = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			rset = pstmt.executeQuery();	// 누락 주의, 결과값 받기 주의
			if(rset.next()) {
				mOne = rsetToMember(rset);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return mOne;
	}

	public Member selectOneById(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM MALLMEMBER_TBL WHERE MEMBER_ID = ?";
		Member member = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);

			rset = pstmt.executeQuery(); //누락주의 , 결과값 받기 주의
			if(rset.next()) {
				member = rsetToMember(rset);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return member;
	}

	private Member rsetToMember(ResultSet rset) {
		Member member = new Member();
		try {
			member.setMemberId(rset.getString("MEMBER_ID"));
			member.setMemberPw(rset.getString("MEMBER_PW"));
			member.setMemberName(rset.getString("MEMBER_NAME"));
			member.setMemberNickname(rset.getString("MEMBER_NICKNAME"));
			member.setMemberPhone(rset.getString("MEMBER_PHONE"));
			member.setMemberAddress(rset.getString("MEMBER_ADDRESS"));
			member.setPostalCodeOne(rset.getString("POSTALCODE_ONE"));
			member.setPostalCodeTwo(rset.getString("POSTALCODE_TWO"));
			member.setMemberPhone(rset.getString("MEMBER_EMAIL"));
			member.setMemberDate(rset.getTimestamp("MEMBER_DATE"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}
	

}
