package com.icode.chengcheng.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icode.chengcheng.dao.IShowUserFriendDao;
import com.icode.chengcheng.db.ConnectionManager;
import com.icode.chengcheng.db.DBUtils;
import com.icode.chengcheng.vo.ShowUserFriend;

public class ShowUserFriendDaoImpl implements IShowUserFriendDao {
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;
	
	public ShowUserFriendDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
	
		this.dbUtils = new DBUtils();
	}

	@Override
	public List<ShowUserFriend> selectByUser(String uccid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		List<ShowUserFriend> lstFri = new  ArrayList<>();
	   String strSQL = "select * from showuserfriend where uccid=?";
	   Object[] params = { uccid};
	   ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
	   try {
		while(resultSet.next()){
			     ShowUserFriend showUserFriend = new ShowUserFriend();
			     showUserFriend.setUccid(uccid);
			     showUserFriend.setFccid(resultSet.getString(2));
			     showUserFriend.setFname(resultSet.getString(3));
			     showUserFriend.setFgender(resultSet.getString(4));
			     showUserFriend.setFphoto(resultSet.getString(5));
			    lstFri.add(showUserFriend);
		   }
		  return lstFri;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}finally {
		this.connectionManager.closeConnection(conn);
	}
	 
	}

	@Override
	public List<ShowUserFriend> selectByKey(String uccid,String keyword) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		List<ShowUserFriend> lstFri = new  ArrayList<>();
	   String strSQL = "select * from showuserfriend where fname like ?  and uccid = ?";
	   String keyword2="%"+keyword+"%";
	   Object[] params = { keyword2 ,uccid};
	   ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
	   try {
		while(resultSet.next()){
			     ShowUserFriend showUserFriend = new ShowUserFriend();
			     showUserFriend.setUccid(resultSet.getString(1));
			     showUserFriend.setFccid(resultSet.getString(2));
			     showUserFriend.setFname(resultSet.getString(3));
			     showUserFriend.setFgender(resultSet.getString(4));
			     showUserFriend.setFphoto(resultSet.getString(5));
			    lstFri.add(showUserFriend);
		   }
		  return lstFri;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}finally {
		this.connectionManager.closeConnection(conn);
	}
	 
	}


}
