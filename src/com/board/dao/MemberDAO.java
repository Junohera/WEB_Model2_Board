package com.board.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.board.dto.MemberDTO;
import com.board.util.DataBaseManager;

public class MemberDAO {
	private MemberDAO() {}
	private static MemberDAO ist = new MemberDAO();
	public static MemberDAO getIst() { return ist; }
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public MemberDTO getMember(String userid) {
		MemberDTO member = null;
		con = DataBaseManager.getConnection();
		String sql = "SELECT * FROM MEMBER WHERE USERID = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				member = new MemberDTO();
				member.setName(rs.getString("NAME"));
				member.setUserid(rs.getString("USERID"));
				member.setPwd(rs.getString("PWD"));
				member.setEmail(rs.getString("EMAIL"));
				member.setPhone(rs.getString("PHONE"));
				member.setAdmin(rs.getInt("ADMIN"));
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {DataBaseManager.close(con, pstmt, rs);}
		
		return member;
	}

	public int confirmId(String userid) {
		int result = 0;
		con = DataBaseManager.getConnection();
		String sql = "SELECT USERID FROM MEMBER WHERE USERID = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				result = 1;
			}
			
		} catch (SQLException e) {e.printStackTrace();
		} finally {DataBaseManager.close(con, pstmt, rs);}
		
		return result;
	}

	public int addMember(MemberDTO member) {
		int result = 0;
		String sql = "INSERT INTO MEMBER VALUES(?, ?, ?, ?, ?, ?)";
		con = DataBaseManager.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getUserid());
			pstmt.setString(3, member.getPwd());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getPhone());
			pstmt.setInt(6, member.getAdmin());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {e.printStackTrace();
		} catch (Exception e) {e.printStackTrace();
		} finally { DataBaseManager.close(con, pstmt, rs); }


		
		con = DataBaseManager.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getUserid());
			pstmt.setString(3, member.getPwd());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getPhone());
			pstmt.setInt(6, member.getAdmin());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {e.printStackTrace();
		} catch (Exception e) {e.printStackTrace();
		} finally { DataBaseManager.close(con, pstmt, rs); }
		
		return result;
	}

	public void updateMember(MemberDTO member) {
		String sql = "UPDATE MEMBER SET "
				+ " PWD = ?"
				+ ", NAME = ?"
				+ ", PHONE = ?"
				+ ", EMAIL = ?"
				+ ", ADMIN = ?"
				+ " WHERE USERID = ?"; 
		con = DataBaseManager.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getPwd());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPhone());
			pstmt.setString(4, member.getEmail());
			pstmt.setInt(5, member.getAdmin());
			pstmt.setString(6, member.getUserid());
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} catch (Exception e) {e.printStackTrace();
		} finally { DataBaseManager.close(con, pstmt, rs); }
	}
}
