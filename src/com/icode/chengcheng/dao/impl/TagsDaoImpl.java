package com.icode.chengcheng.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icode.chengcheng.dao.ITagsDao;
import com.icode.chengcheng.db.ConnectionManager;
import com.icode.chengcheng.db.DBUtils;
import com.icode.chengcheng.db.TransactionManager;
import com.icode.chengcheng.po.Tags;

public class TagsDaoImpl implements ITagsDao{
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;
	
	public TagsDaoImpl(){
		super();
		this.connectionManager=new ConnectionManager();
		this.dbUtils=new DBUtils();
	}

	@Override
	public int insert(Tags tags) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();				
		int tid = tags.getTid();
		String tname = tags.getTname();
		String strSQL = "insert into tags values(null,?)";
		Object[] params = new Object[]{tid, tname};
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		if(affectedRows > 0){
			TransactionManager.commit();
		}else{
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public List<Tags> selectAll() {
		// TODO Auto-generated method stub
		List<Tags> lstTags = new ArrayList<Tags>();
		this.conn = connectionManager.openConnection();
		String strSQL = "select * from tags order by tid";
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{});
		try {
			while(resultSet.next()){
				Tags tags = new Tags();
				tags.setTid(resultSet.getInt(1));
				tags.setTname(resultSet.getString(2));			
				lstTags.add(tags);				
			}
			return lstTags;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			this.connectionManager.closeConnection(conn);
		}
	}

	@Override
	public int deleteById(int tid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		String strSQL = "delete from tags where tid=?";
		Object[] params = new Object[] { tid };
		int affectedRwos = this.dbUtils.execOthers(conn, strSQL, params);
		if (affectedRwos > 0) {
			TransactionManager.commit(); 
		} else {
			TransactionManager.rollback(); 
		}
		return affectedRwos;
	}

	@Override
	public Tags selectById(int tid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		String strSQL = "select * from tags where tid=?";
		Object[] params = new Object[] { tid };
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		try {
			if (resultSet.next()) {
				Tags tags = new Tags();
				tags.setTid(resultSet.getInt(1));
				tags.setTname(resultSet.getString(2));	
				return tags;
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
	public int update(Tags tags) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		String strSQL = "update tags set tname=?? where tid=?";
		Object[] params = new Object[] { tags.getTid(), tags.getTname() };
		int affectedRwos = this.dbUtils.execOthers(conn, strSQL, params);
		if (affectedRwos > 0) {
			TransactionManager.commit(); 
		} else {
			TransactionManager.rollback(); 
		}
		return affectedRwos;
	}

}
