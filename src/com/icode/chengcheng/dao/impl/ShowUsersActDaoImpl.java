package com.icode.chengcheng.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icode.chengcheng.dao.IShowUsersActDao;
import com.icode.chengcheng.db.ConnectionManager;
import com.icode.chengcheng.db.DBUtils;
import com.icode.chengcheng.vo.ShowUsersAct;

public class ShowUsersActDaoImpl implements IShowUsersActDao {
	
	private ConnectionManager connectionManager;
	private DBUtils dbUtils;
	
	public ShowUsersActDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	@Override
	public List<ShowUsersAct> selectByUccid(String uccid) {
		// TODO Auto-generated method stub
		String strSQL = "select * from showusersact where uccid=? ";
		Connection conn = this.connectionManager.openConnection();
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{uccid});
		List<ShowUsersAct> lstShowUsersAct = new ArrayList<ShowUsersAct>();
		try {
			while(resultSet.next()){
				ShowUsersAct showUsersAct = new ShowUsersAct();
				showUsersAct.setUccid(resultSet.getString(1));
				showUsersAct.setUname(resultSet.getString(2));
				showUsersAct.setAname(resultSet.getString(3));
				showUsersAct.setPtype(resultSet.getInt(4));
				showUsersAct.setPdate(resultSet.getDate(5));
				lstShowUsersAct.add(showUsersAct);
			}
			return lstShowUsersAct;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			this.connectionManager.closeConnection(conn);
		}
	}

	@Override
	public List<ShowUsersAct> selectByAid(int aid) {
		// TODO Auto-generated method stub
		String strSQL = "select * from showusersact where aid=?";
		Connection conn = this.connectionManager.openConnection();
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{aid});
		List<ShowUsersAct> lstShowUsersAct = new ArrayList<ShowUsersAct>();
		try {
			while(resultSet.next()){
				ShowUsersAct showUsersAct = new ShowUsersAct();
				showUsersAct.setUccid(resultSet.getString(1));
				showUsersAct.setUname(resultSet.getString(2));
				showUsersAct.setAname(resultSet.getString(3));
				showUsersAct.setPtype(resultSet.getInt(4));
				showUsersAct.setPdate(resultSet.getDate(5));
				lstShowUsersAct.add(showUsersAct);
			}
			return lstShowUsersAct;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			this.connectionManager.closeConnection(conn);
		}
	}

}
