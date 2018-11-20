package com.icode.chengcheng.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icode.chengcheng.dao.IShowActTagDao;
import com.icode.chengcheng.db.ConnectionManager;
import com.icode.chengcheng.db.DBUtils;
import com.icode.chengcheng.vo.ShowActTag;

public class ShowActTagDaoImpl implements IShowActTagDao {
	private ConnectionManager connectionManager;
	private DBUtils dbUtils;
	
	public ShowActTagDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}
	@Override
	public List<ShowActTag> selectById(int aid) {
		// TODO Auto-generated method stub
		String strSQL = "select * from showacttag where aid=?";
		Connection conn = this.connectionManager.openConnection();
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{aid});
		List<ShowActTag> lstShowActTag = new ArrayList<ShowActTag>();
		try {
			while(resultSet.next()){
				ShowActTag showActTag = new ShowActTag();
				showActTag.setOwner_id(resultSet.getString(1));
				showActTag.setUname(resultSet.getString(2));
				showActTag.setUphoto(resultSet.getString(3));
				showActTag.setAid(resultSet.getInt(4));
				showActTag.setAname(resultSet.getString(5));
				showActTag.setAdate(resultSet.getDate(6));
				showActTag.setAaddress(resultSet.getString(7));
				showActTag.setTid(resultSet.getInt(8));
				showActTag.setTname(resultSet.getString(9));
				showActTag.setAcontent(resultSet.getString(10));
				showActTag.setAtopic(resultSet.getString(11));
				lstShowActTag.add(showActTag);
			}
			return lstShowActTag;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			this.connectionManager.closeConnection(conn);
		}
	}
	@Override
	public List<ShowActTag> selectByTname(int tname) {
		// TODO Auto-generated method stub
		String strSQL = "select * from showacttag where tname=? order by aid";
		Connection conn = this.connectionManager.openConnection();
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{tname});
		List<ShowActTag> lstShowActTag = new ArrayList<ShowActTag>();
		try {
			while(resultSet.next()){
				ShowActTag showActTag = new ShowActTag();
				showActTag.setAid(resultSet.getInt(1));
				showActTag.setAname(resultSet.getString(2));
				showActTag.setTname(resultSet.getString(9));
				lstShowActTag.add(showActTag);
			}
			return lstShowActTag;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			this.connectionManager.closeConnection(conn);
		}
	}
	@Override
	public List<ShowActTag> selectAll() {
		// TODO Auto-generated method stub
		String strSQL = "select * from showacttag  order by aid";
		Connection conn = this.connectionManager.openConnection();
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{});
		List<ShowActTag> lstShowActTag = new ArrayList<ShowActTag>();
		try {
			while(resultSet.next()){
				ShowActTag showActTag = new ShowActTag();
				showActTag.setAid(resultSet.getInt(1));
				showActTag.setAname(resultSet.getString(2));
				showActTag.setTname(resultSet.getString(9));
				lstShowActTag.add(showActTag);
			}
			return lstShowActTag;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			this.connectionManager.closeConnection(conn);
		}
	}
	@Override
	public List<ShowActTag> selectByTag(int tid) {
		// TODO Auto-generated method stub
		String strSQL = "select * from showacttag where tid=? order by aid";
		Connection conn = this.connectionManager.openConnection();
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{tid});
		List<ShowActTag> lstShowActTag = new ArrayList<ShowActTag>();
		try {
			while(resultSet.next()){
				ShowActTag showActTag = new ShowActTag();
				showActTag.setOwner_id(resultSet.getString(1));
				showActTag.setUname(resultSet.getString(2));
				showActTag.setUphoto(resultSet.getString(3));
				showActTag.setAid(resultSet.getInt(4));
				showActTag.setAname(resultSet.getString(5));
				showActTag.setAdate(resultSet.getDate(6));
				showActTag.setAaddress(resultSet.getString(7));
				showActTag.setTid(resultSet.getInt(8));
				showActTag.setTname(resultSet.getString(9));
				showActTag.setAcontent(resultSet.getString(10));
				showActTag.setAtopic(resultSet.getString(11));
				lstShowActTag.add(showActTag);
			}
			return lstShowActTag;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			this.connectionManager.closeConnection(conn);
		}
	}
	
	

}
