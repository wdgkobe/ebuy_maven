package com.wdg.ebuy_maven.dao;

import com.wdg.ebuy_maven.model.Admin;
import com.wdg.ebuy_maven.util.SHA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDao {
	/**
	 * 根据账户名和密码去数据库查询，进行登录判断
	 * @param username 账户名
	 * @param password 密码
	 * @return true表示登录成功,false表示登录失败
	 */
	public Admin getAdmin(String username,String password){
		Admin admin=null;//表示登录状态，默认失败
		Connection conn= DBHelper.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			String sql="select * from admin where username=? and password=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			if(rs.next()){//如果能够从数据库找到记录
				admin=new Admin();
				admin.setId(rs.getInt("id"));
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
				admin.setName(rs.getString("name"));
			}			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBHelper.closeConn(conn,pstmt,rs);
		}
		return admin;
	}
	public boolean uppass(Integer id,String newpass){
		boolean sta=false;//默认修改密码失败
		Connection conn= DBHelper.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			String sql="update admin set password=? where id=?";
			pstmt=conn.prepareStatement(sql);

			pstmt.setString(1, newpass);
			pstmt.setInt(2,id);
			int result=pstmt.executeUpdate();
			if (result==1){
			   sta=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBHelper.closeConn(conn,pstmt,rs);
		}
		return sta;
	}
}
