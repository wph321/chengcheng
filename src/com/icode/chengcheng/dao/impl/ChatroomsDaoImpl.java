package com.icode.chengcheng.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.icode.chengcheng.dao.IChatroomsDao;
import com.icode.chengcheng.db.ConnectionManager;
import com.icode.chengcheng.db.DBUtils;
import com.icode.chengcheng.db.TransactionManager;
import com.icode.chengcheng.po.Chatrooms;

public class ChatroomsDaoImpl implements IChatroomsDao{
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;
	
	public ChatroomsDaoImpl(){
		super();
		this.connectionManager=new ConnectionManager();
		this.dbUtils=new DBUtils();
	}

	@Override
	public int insert(Chatrooms chatrooms) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();				
		int rid = chatrooms.getRid();
		String rname = chatrooms.getRname();
		Date rdate = chatrooms.getRdate();
		int rtype = chatrooms.getRtype();
		String strSQL = "insert into chatrooms values(null,?,?,?)";
		Object[] params = new Object[]{rid, rname, rdate,rtype};
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		if(affectedRows > 0){
			TransactionManager.commit();
		}else{
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public List<Chatrooms> selectAll() {
		// TODO Auto-generated method stub
		List<Chatrooms> lstChatrooms = new ArrayList<Chatrooms>();
		this.conn = connectionManager.openConnection();
		String strSQL = "select * from chatrooms order by rid";
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{});
		try {
			while(resultSet.next()){
				Chatrooms chatrooms = new Chatrooms();
				chatrooms.setRid(resultSet.getInt(1));
				chatrooms.setRname(resultSet.getString(2));
				chatrooms.setRdate(resultSet.getDate(3));
				chatrooms.setRtype(resultSet.getInt(4));
				lstChatrooms.add(chatrooms);				
			}
			return lstChatrooms;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			this.connectionManager.closeConnection(conn);
		}
	}

	@Override
	public int deleteById(int rid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		String strSQL = "delete from chatrooms where rid=?";
		Object[] params = new Object[] { rid };
		int affectedRwos = this.dbUtils.execOthers(conn, strSQL, params);
		if (affectedRwos > 0) {
			TransactionManager.commit(); 
		} else {
			TransactionManager.rollback(); 
		}
		return affectedRwos;
	}

	@Override
	public Chatrooms selectById(int rid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		String strSQL = "select * from chatrooms where rid=?";
		Object[] params = new Object[] { rid };
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		try {
			if (resultSet.next()) {
				Chatrooms chatrooms = new Chatrooms();
				chatrooms.setRid(resultSet.getInt(1));
				chatrooms.setRname(resultSet.getString(2));
				chatrooms.setRdate(resultSet.getDate(3));	
				chatrooms.setRtype(resultSet.getInt(4));
				return chatrooms;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}

	@Override
	public int update(Chatrooms chatrooms) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		String strSQL = "update chatrooms set rname=?, rdate=?, rtype=? where rid=?";
		Object[] params = new Object[] { chatrooms.getRid(), chatrooms.getRname(), chatrooms.getRdate(),chatrooms.getRtype() };
		int affectedRwos = this.dbUtils.execOthers(conn, strSQL, params);
		if (affectedRwos > 0) {
			TransactionManager.commit(); 
		} else {
			TransactionManager.rollback(); 
		}
		return affectedRwos;
	
	}

}
