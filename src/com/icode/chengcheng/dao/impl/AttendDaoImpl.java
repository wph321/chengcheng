package com.icode.chengcheng.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icode.chengcheng.dao.IAttendDao;
import com.icode.chengcheng.db.ConnectionManager;
import com.icode.chengcheng.db.DBUtils;
import com.icode.chengcheng.db.TransactionManager;
import com.icode.chengcheng.po.Attend;



public class AttendDaoImpl implements IAttendDao {
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;
	
	public AttendDaoImpl(){
		super();
		this.connectionManager=new ConnectionManager();
		this.dbUtils=new DBUtils();
	}
	
	@Override
	public int insert(Attend attend) {
		// TODO Auto-generated method stub
		     	this.conn = this.connectionManager.openConnection();
				TransactionManager.conn = this.conn;
				TransactionManager.beginTransaction();				
				int jid = attend.getJid();
				String juser = attend.getJuser();
				int jroom = attend.getJroom();
				String strSQL = "insert into attend values(null,?,?)";
				Object[] params = new Object[]{jid, juser, jroom};
				int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
				if(affectedRows > 0){
					TransactionManager.commit();
				}else{
					TransactionManager.rollback();
				}
		return affectedRows;
	}
	@Override
	public List<Attend> selectAll() {
		// TODO Auto-generated method stub
		List<Attend> lstAttend = new ArrayList<Attend>();
		this.conn = connectionManager.openConnection();
		String strSQL = "select * from attend order by jid";
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{});
		try {
			while(resultSet.next()){
				Attend attend = new Attend();
				attend.setJid(resultSet.getInt(1));
				attend.setJuser(resultSet.getString(2));
				attend.setJroom(resultSet.getInt(3));
				lstAttend.add(attend);				
			}
			return lstAttend;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			this.connectionManager.closeConnection(conn);
		}
		
	}
	@Override
	public int deleteById(int jid) {
		 // TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		String strSQL = "delete from attend where jid=?";
		Object[] params = new Object[] { jid };
		int affectedRwos = this.dbUtils.execOthers(conn, strSQL, params);
		if (affectedRwos > 0) {
			TransactionManager.commit(); 
		} else {
			TransactionManager.rollback(); 
		}
		return affectedRwos;
	}
	@Override
	public Attend selectById(int jid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		String strSQL = "select * from attend where jid=?";
		Object[] params = new Object[] { jid };
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		try {
			if (resultSet.next()) {
				Attend attend = new Attend();
				attend.setJid(resultSet.getInt(1));
				attend.setJuser(resultSet.getString(2));
				attend.setJroom(resultSet.getInt(3));			
				return attend;
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
	public int update(Attend attend) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		String strSQL = "update attend set juser=?, jroom=? where jid=?";
		Object[] params = new Object[] { attend.getJid(), attend.getJuser(), attend.getJroom() };
		int affectedRwos = this.dbUtils.execOthers(conn, strSQL, params);
		if (affectedRwos > 0) {
			TransactionManager.commit(); 
		} else {
			TransactionManager.rollback(); 
		}
		return affectedRwos;
	}

}
