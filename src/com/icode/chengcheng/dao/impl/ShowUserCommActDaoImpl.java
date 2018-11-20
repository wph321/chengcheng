package com.icode.chengcheng.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.icode.chengcheng.dao.IShowUserCommActDao;
import com.icode.chengcheng.db.ConnectionManager;
import com.icode.chengcheng.db.DBUtils;
import com.icode.chengcheng.vo.ShowUserCommAct;

public class ShowUserCommActDaoImpl implements IShowUserCommActDao {

	private ConnectionManager connectionManager;
	private DBUtils dbUtils;
		
	public ShowUserCommActDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	@Override
	public List<ShowUserCommAct> selectByAname(String tname) {
		// TODO Auto-generated method stub
		String strSQL = "select * from showuserscommact where aname=? ";
		Connection conn = this.connectionManager.openConnection();
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{tname});
		List<ShowUserCommAct> lstShowUserCommAct = new ArrayList<ShowUserCommAct>();
		try {
			while(resultSet.next()){
				ShowUserCommAct showUserCommAct = new ShowUserCommAct();
				showUserCommAct.setUname(resultSet.getString(1));
				showUserCommAct.setPhoto(resultSet.getString(2));
				showUserCommAct.setCid(resultSet.getInt(3));
				showUserCommAct.setCuser_from(resultSet.getString(4));
				showUserCommAct.setCuser_to(resultSet.getInt(5));
				showUserCommAct.setCcontent(resultSet.getString(6));
				showUserCommAct.setCdate(resultSet.getTimestamp(7));
				showUserCommAct.setAid(resultSet.getInt(8));
				lstShowUserCommAct.add(showUserCommAct);
			}
			return lstShowUserCommAct;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			this.connectionManager.closeConnection(conn);
		}
	}

	@Override
	public List<ShowUserCommAct> selectByAid(int aid) {
		// TODO Auto-generated method stub
		String strSQL = "select * from showusercommact where aid=? ";
		Connection conn = this.connectionManager.openConnection();
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{aid});
		List<ShowUserCommAct> lstShowUserCommAct = new ArrayList<ShowUserCommAct>();
		try {
			while(resultSet.next()){
				ShowUserCommAct showUserCommAct = new ShowUserCommAct();
				showUserCommAct.setUname(resultSet.getString(1));
				showUserCommAct.setPhoto(resultSet.getString(2));
				showUserCommAct.setCid(resultSet.getInt(3));
				showUserCommAct.setCuser_from(resultSet.getString(4));
				showUserCommAct.setCuser_to(resultSet.getInt(5));
				showUserCommAct.setCcontent(resultSet.getString(6));
				showUserCommAct.setCdate(resultSet.getTimestamp(7));
				showUserCommAct.setAid(resultSet.getInt(8));
				lstShowUserCommAct.add(showUserCommAct);
			}
			return lstShowUserCommAct;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			this.connectionManager.closeConnection(conn);
		}
	}
}