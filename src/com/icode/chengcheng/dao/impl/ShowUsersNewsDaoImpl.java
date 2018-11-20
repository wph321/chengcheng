package com.icode.chengcheng.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icode.chengcheng.dao.IShowUsersNewsDao;
import com.icode.chengcheng.db.ConnectionManager;
import com.icode.chengcheng.db.DBUtils;
import com.icode.chengcheng.vo.ShowUsersNews;

public class ShowUsersNewsDaoImpl implements IShowUsersNewsDao {
	
	private ConnectionManager connectionManager;
	private DBUtils dbUtils;
	
	public ShowUsersNewsDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	@Override
	public List<ShowUsersNews> selectById(String uccid) {
		// TODO Auto-generated method stub
		String strSQL = "select * from shownewsusers where uccid=? ";
		Connection conn = this.connectionManager.openConnection();
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{uccid});
		List<ShowUsersNews> lstShowUsersNews = new ArrayList<ShowUsersNews>();
		try {
			while(resultSet.next()){
				ShowUsersNews showUsersNews = new ShowUsersNews();
				showUsersNews.setUccid(resultSet.getString(1));
				showUsersNews.setUname(resultSet.getString(2));
				showUsersNews.setNuser(resultSet.getString(3));
				showUsersNews.setNcontent(resultSet.getString(4));
				showUsersNews.setNdate(resultSet.getDate(5));
				showUsersNews.setNtype(resultSet.getInt(6));
				lstShowUsersNews.add(showUsersNews);
			}
			return lstShowUsersNews;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			this.connectionManager.closeConnection(conn);
		}
	}

}
