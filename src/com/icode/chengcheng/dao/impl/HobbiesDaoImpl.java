package com.icode.chengcheng.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icode.chengcheng.dao.IHobbiesDao;
import com.icode.chengcheng.db.ConnectionManager;
import com.icode.chengcheng.db.DBUtils;
import com.icode.chengcheng.db.TransactionManager;
import com.icode.chengcheng.po.Hobbies;

public class HobbiesDaoImpl implements IHobbiesDao{
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;
	
	public HobbiesDaoImpl(){
		super();
		this.connectionManager=new ConnectionManager();
		this.dbUtils=new DBUtils();
	}

	@Override
	public int insert(Hobbies hobbies) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();				
		int htag = hobbies.getHtag();
		String huser = hobbies.getHuser();		
		String strSQL = "insert into hobbies values(null,?,?)";
		Object[] params = new Object[]{htag, huser};
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		if(affectedRows > 0){
			TransactionManager.commit();
		}else{
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public List<Hobbies> selectAll() {
		// TODO Auto-generated method stub
		List<Hobbies> lstHobbies = new ArrayList<Hobbies>();
		this.conn = connectionManager.openConnection();
		String strSQL = "select * from hobbies order by hid";
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{});
		try {
			while(resultSet.next()){
				Hobbies hobbies = new Hobbies();
				hobbies.setHid(resultSet.getInt(1));
				hobbies.setHtag(resultSet.getInt(2));
				hobbies.setHuser(resultSet.getString(3));				
				lstHobbies.add(hobbies);				
			}
			return lstHobbies;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			this.connectionManager.closeConnection(conn);
		}
	}

	@Override
	public int deleteById(int hid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		String strSQL = "delete from hobbies where hid=?";
		Object[] params = new Object[] { hid };
		int affectedRwos = this.dbUtils.execOthers(conn, strSQL, params);
		if (affectedRwos > 0) {
			TransactionManager.commit(); 
		} else {
			TransactionManager.rollback(); 
		}
		return affectedRwos;
	}

	@Override
	public Hobbies selectById(int hid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		String strSQL = "select * from hobbies where hid=?";
		Object[] params = new Object[] { hid };
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		try {
			if (resultSet.next()) {
				Hobbies hobbies = new Hobbies();
				hobbies.setHid(resultSet.getInt(1));
				hobbies.setHtag(resultSet.getInt(2));
				hobbies.setHuser(resultSet.getString(3));	
				return hobbies;
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
	public int update(Hobbies hobbies) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		String strSQL = "update hobbies set htag=?, huser=? where jid=?";
		Object[] params = new Object[] { hobbies.getHid(), hobbies.getHtag(), hobbies.getHuser() };
		int affectedRwos = this.dbUtils.execOthers(conn, strSQL, params);
		if (affectedRwos > 0) {
			TransactionManager.commit(); 
		} else {
			TransactionManager.rollback(); 
		}
		return affectedRwos;
	}

	@Override
	public List<Hobbies> selectById2(String huser) {
		// TODO Auto-generated method stub
		List<Hobbies> lstHobbies = new ArrayList<Hobbies>();
		this.conn = this.connectionManager.openConnection();
		String strSQL = "select * from hobbies where huser=?";
		Object[] params = new Object[] { huser };
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
			try {
				while (resultSet.next()) {
					Hobbies hobbies = new Hobbies();
					hobbies.setHid(resultSet.getInt(1));
					hobbies.setHtag(resultSet.getInt(2));
					hobbies.setHuser(resultSet.getString(3));				
					lstHobbies.add(hobbies);
				}
				return lstHobbies;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} 
		finally{
			this.connectionManager.closeConnection(conn);}

	}

	@Override
	public int deleteByHuser(String uccid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		String strSQL = "delete from hobbies where huser=?";
		Object[] params = new Object[] { uccid };
		int affectedRwos = this.dbUtils.execOthers(conn, strSQL, params);
		if (affectedRwos > 0) {
			TransactionManager.commit(); 
		} else {
			TransactionManager.rollback(); 
		}
		return affectedRwos;
	}

}
