package com.icode.chengcheng.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icode.chengcheng.dao.IShowActInIndexDao;
import com.icode.chengcheng.db.ConnectionManager;
import com.icode.chengcheng.db.DBUtils;
import com.icode.chengcheng.vo.ShowActInIndex;


public class ShowActInIndexDaoImpl implements IShowActInIndexDao {
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;
	
	public ShowActInIndexDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		
		this.dbUtils = new DBUtils();
	}

	@Override
	public List<ShowActInIndex> selectById(String uccid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		List<ShowActInIndex> lstAct = new  ArrayList<>();
	   String strSQL = "select * from showactinindex where uccid=?";
	   Object[] params = { uccid};
	   ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
	   try {
		while(resultSet.next()){
			     ShowActInIndex showActInIndex = new ShowActInIndex();
			     showActInIndex.setUccid(uccid);
			     showActInIndex.setUname(resultSet.getString(2));
			     showActInIndex.setUphoto(resultSet.getString(3));
			     showActInIndex.setAid(resultSet.getInt(4));
			     showActInIndex.setOwner_id(resultSet.getString(5));
			     showActInIndex.setAname(resultSet.getString(6));
			     showActInIndex.setAtopic(resultSet.getString(7));
			     showActInIndex.setPdate(resultSet.getTimestamp(8));
			     showActInIndex.setPtype(resultSet.getInt(9));
			     showActInIndex.setAcontent(resultSet.getString(10));
			     showActInIndex.setAdate(resultSet.getTimestamp(11));
			     showActInIndex.setAdeadline(resultSet.getTimestamp(12));
			    // System.out.println(resultSet.getDate(8));
			      lstAct.add(showActInIndex);
		   }
		  return lstAct;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}finally {
		this.connectionManager.closeConnection(conn);
	}
	 
	}

	@Override
	public List<ShowActInIndex> selectByAId(int aid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		List<ShowActInIndex> lstAct = new  ArrayList<>();
	   String strSQL = "select * from showactinindex where aid=?";
	   Object[] params = { aid};
	   ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
	   try {
		while(resultSet.next()){
			     ShowActInIndex showActInIndex = new ShowActInIndex();
			     showActInIndex.setUccid(resultSet.getString(1));
			     showActInIndex.setUname(resultSet.getString(2));
			     showActInIndex.setUphoto(resultSet.getString(3));
			     showActInIndex.setAid(resultSet.getInt(4));
			     showActInIndex.setOwner_id(resultSet.getString(5));
			     showActInIndex.setAname(resultSet.getString(6));
			     showActInIndex.setAtopic(resultSet.getString(7));
			     showActInIndex.setPdate(resultSet.getTimestamp(8));
			     showActInIndex.setPtype(resultSet.getInt(9));
			     showActInIndex.setAcontent(resultSet.getString(10));
			     showActInIndex.setAdate(resultSet.getTimestamp(11));
			     showActInIndex.setAdeadline(resultSet.getTimestamp(12));
			    // System.out.println(resultSet.getDate(8));
			      lstAct.add(showActInIndex);
		   }
		  return lstAct;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}finally {
		this.connectionManager.closeConnection(conn);
	}
	}

}
