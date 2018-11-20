package com.icode.chengcheng.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icode.chengcheng.dao.IShowUserChatroomsDao;
import com.icode.chengcheng.db.ConnectionManager;
import com.icode.chengcheng.db.DBUtils;
import com.icode.chengcheng.vo.ShowUserChatrooms;

public class ShowUserChatroomsDaoImpl implements IShowUserChatroomsDao {

	private ConnectionManager connectionManager;
	private DBUtils dbUtils;
	
	public ShowUserChatroomsDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	@Override
	public List<ShowUserChatrooms> selectById(String uccid) {
		// TODO Auto-generated method stub
		String strSQL = "select * from showuserchatrooms where uccid=? ";
		Connection conn = this.connectionManager.openConnection();
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{uccid});
		List<ShowUserChatrooms> lstShowUserChatrooms = new ArrayList<ShowUserChatrooms>();
		try {
			while(resultSet.next()){
				ShowUserChatrooms showUserChatrooms = new ShowUserChatrooms();
				showUserChatrooms.setUccid(resultSet.getString(1));
				showUserChatrooms.setUname(resultSet.getString(2));
				showUserChatrooms.setRname(resultSet.getString(3));
				lstShowUserChatrooms.add(showUserChatrooms);
			}
			return lstShowUserChatrooms;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			this.connectionManager.closeConnection(conn);
		}
	}
}
