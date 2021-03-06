package com.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.board.dto.BoardDTO;
import com.board.dto.ReplyDTO;
import com.board.util.DataBaseManager;
import com.board.util.Paging;

public class BoardDAO {
	private BoardDAO() {}
	private static BoardDAO ist = new BoardDAO();
	public static BoardDAO getIst() {return ist;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public int selectAllCount() {
		int count = 0;
		String sql = "SELECT COUNT(*) AS CNT FROM BOARD";
		con = DataBaseManager.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				count = rs.getInt("CNT");
			}
			
		} catch (SQLException e) {e.printStackTrace();
		} finally {DataBaseManager.close(con, pstmt, rs);}
		
		return count;
	}
	
	public ArrayList<BoardDTO> selectAll(Paging paging) {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();

		/** <sql> */
		String sql = "SELECT * FROM "
				+ " (SELECT * FROM "
				+ " (SELECT ROWNUM AS RN, T.* FROM "
				+ " (SELECT * FROM BOARD ORDER BY NUM DESC) T"
				+ " ) WHERE RN >= ?"
				+ " ) WHERE RN <= ?";
		/** </sql> */
		
		con = DataBaseManager.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, paging.getStartNum());
			pstmt.setInt(2, paging.getEndNum());
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				BoardDTO board = new BoardDTO();
				board.setNum(rs.getInt("num"));
				board.setPass(rs.getString("pass"));
				board.setUserid(rs.getString("userid"));
				board.setEmail(rs.getString("email"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setReadcount(rs.getInt("readcount"));
				board.setWritedate(rs.getDate("writedate"));
				
				String sql2 = "SELECT COUNT(*) AS CNT FROM REPLY WHERE BOARDNUM = ?";
				int num = rs.getInt("num");
				PreparedStatement pstmt2 = con.prepareStatement(sql2);
				pstmt2.setInt(1, num);
				ResultSet rs2 = pstmt2.executeQuery();
				if (rs2.next()) {
					board.setReplycnt(rs2.getInt("CNT"));
				} else {
					board.setReplycnt(0);
				}
				
				pstmt2.close();
				rs2.close();
				
				list.add(board);
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {DataBaseManager.close(con, pstmt, rs);}
		
		return list;
	}

	public void updateReadCount(int num) {
		String sql = "UPDATE BOARD SET READCOUNT = READCOUNT + 1 WHERE NUM = ?";
		con = DataBaseManager.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally {DataBaseManager.close(con, pstmt, rs);}
	}

	public BoardDTO getBoardOne(int num) {
		BoardDTO board = null;
		String sql = "SELECT * FROM BOARD WHERE NUM = ?";
		con = DataBaseManager.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				board = new BoardDTO();
				board.setNum(rs.getInt("num"));
				board.setPass(rs.getString("pass"));
				board.setUserid(rs.getString("userid"));
				board.setEmail(rs.getString("email"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setReadcount(rs.getInt("readcount"));
				board.setWritedate(rs.getDate("writedate"));
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {DataBaseManager.close(con, pstmt, rs);}
		
		return board;
	}

	public void insertBoard(BoardDTO board) {
		String sql = "INSERT INTO BOARD(NUM, USERID, EMAIL, PASS, TITLE, CONTENT) "
				+ " VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
		con = DataBaseManager.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getUserid());
			pstmt.setString(2, board.getEmail());
			pstmt.setString(3, board.getPass());
			pstmt.setString(4, board.getTitle());
			pstmt.setString(5, board.getContent());
			int log = pstmt.executeUpdate();
			System.out.println(log);
		} catch (SQLException e) {e.printStackTrace();
		} finally {DataBaseManager.close(con, pstmt, rs);}
	}

	public void updateBoard(BoardDTO board) {
		String sql = "UPDATE BOARD SET "
				+ " PASS = ?"
				+ ", EMAIL = ?"
				+ ", TITLE = ?"
				+ ", CONTENT = ?"
				+ " WHERE NUM = ?"; 
		
		con = DataBaseManager.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getPass());
			pstmt.setString(2, board.getEmail());
			pstmt.setString(3, board.getTitle());
			pstmt.setString(4, board.getContent());
			pstmt.setInt(5, board.getNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} catch (Exception e) {e.printStackTrace();
		} finally { DataBaseManager.close(con, pstmt, rs); }
	}
	
	public void deleteBoard(int num) {
		String sql = "DELETE FROM BOARD WHERE NUM = ?";
		con = DataBaseManager.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} catch (Exception e) {e.printStackTrace();
		} finally { DataBaseManager.close(con, pstmt, rs); }
	}

	public ArrayList<ReplyDTO> selectAllReply(int num) {
		ArrayList<ReplyDTO> list = new ArrayList<ReplyDTO>();
		String sql = "SELECT * FROM REPLY WHERE BOARDNUM = ? ORDER BY NUM DESC";
		con = DataBaseManager.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ReplyDTO reply = new ReplyDTO();
				reply.setNum(rs.getInt("num"));
				reply.setBoardnum(rs.getInt("boardnum"));
				reply.setUserid(rs.getString("userid"));
				reply.setWritedate(rs.getTimestamp("writedate"));
				reply.setContent(rs.getString("content"));
				list.add(reply);
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {DataBaseManager.close(con, pstmt, rs);}
		return list;
	}

	public void insertReply(ReplyDTO reply) {
		String sql = "INSERT INTO REPLY(NUM, BOARDNUM, USERID, CONTENT)"
				+ " VALUES("
				+ " REPLY_SEQ.NEXTVAL"
				+ ", ?, ?, ?)";
		
		con = DataBaseManager.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, reply.getBoardnum());
			pstmt.setString(2, reply.getUserid());
			pstmt.setString(3, reply.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally {DataBaseManager.close(con, pstmt, rs);}
	}

	public void deleteReply(int num) {
		String sql = "DELETE FROM REPLY WHERE NUM = ?";
		
		con = DataBaseManager.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally {DataBaseManager.close(con, pstmt, rs);}
	}
}
