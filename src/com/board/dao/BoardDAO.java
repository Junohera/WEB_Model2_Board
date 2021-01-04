package com.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.board.dto.BoardDTO;
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
	
	public ArrayList<BoardDTO> selectAll(Paging pagingUtil) {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();

		/** <paging> */
		int startNum = pagingUtil.getStartNum();
		int endNum = pagingUtil.getEndNum();
		String sql = "SELECT * FROM "
				+ " (SELECT ROWNUM AS RN, T.* FROM "
				+ " 	(SELECT * FROM BOARD ORDERY BY NUM DESC) T"
				+ ") WHERE RN >= ? AND RN <= ?;";
		/** </paging> */
		con = DataBaseManager.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
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
}
