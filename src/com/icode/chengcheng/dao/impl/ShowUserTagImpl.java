package com.icode.chengcheng.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icode.chengcheng.dao.IShowUserTagDao;
import com.icode.chengcheng.db.ConnectionManager;
import com.icode.chengcheng.db.DBUtils;
import com.icode.chengcheng.vo.ShowUserTag;

public class ShowUserTagImpl implements IShowUserTagDao {
	private ConnectionManager connectionManager;
	private DBUtils dbUtils;
	
	public ShowUserTagImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	@Override
	public List<ShowUserTag> selectById(String uccid) {
		// TODO Auto-generated method stub
		String strSQL = "select * from showusertag where uccid=?";
		Connection conn = this.connectionManager.openConnection();
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{uccid});
		List<ShowUserTag> lstShowUserTag = new ArrayList<ShowUserTag>();
		try {
			while(resultSet.next()){
				ShowUserTag showUserTag = new ShowUserTag();
				showUserTag.setUccid(resultSet.getString(1));
				showUserTag.setUname(resultSet.getString(2));
				showUserTag.setTname(resultSet.getString(3));
				lstShowUserTag.add(showUserTag);
			}
			return lstShowUserTag;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			this.connectionManager.closeConnection(conn);
		}
	}

	@Override
	public List<ShowUserTag> selectByTname(String tname) {
		// TODO Auto-generated method stub
		String strSQL = "select * from showusertag where tname=? order by uccid";
		Connection conn = this.connectionManager.openConnection();
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{tname});
		List<ShowUserTag> lstShowUserTag = new ArrayList<ShowUserTag>();
		try {
			while(resultSet.next()){
				ShowUserTag showUserTag = new ShowUserTag();
				showUserTag.setUccid(resultSet.getString(1));
				showUserTag.setUname(resultSet.getString(2));
				showUserTag.setTname(resultSet.getString(3));
				lstShowUserTag.add(showUserTag);
			}
			return lstShowUserTag;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			this.connectionManager.closeConnection(conn);
		}
	}


}
