package com.icode.chengcheng.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icode.chengcheng.dao.IFriendsDao;
import com.icode.chengcheng.db.ConnectionManager;
import com.icode.chengcheng.db.DBUtils;
import com.icode.chengcheng.db.TransactionManager;
import com.icode.chengcheng.po.Friends;

public class FriendsDaoImpl implements IFriendsDao {
	
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;
	
	public FriendsDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	@Override
	public int insert(Friends friends) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		String fuser = friends.getFuser();
		String fuserfri = friends.getFuserfri();
		String strSQL = "insert into customers values(null,?,?)";
		Object[] params = new Object[] {fuser,fuserfri };
		Object[] params2 = new Object[] {fuserfri,fuser };
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		int affectedRows2 = this.dbUtils.execOthers(conn, strSQL, params2);
		if (affectedRows > 0&&affectedRows2 >0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public List<Friends> selectAll() {
		// TODO Auto-generated method stub
		List<Friends> lstFriends = new ArrayList<Friends>();
		this.conn = connectionManager.openConnection();
		String strSQL = "select * from friends order by relid";
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,new Object[] {});
		try {
			while (resultSet.next()) {
				Friends friends = new Friends();
				friends.setRelid(resultSet.getInt(1));
				friends.setFuser(resultSet.getString(2));
				friends.setFuserfri(resultSet.getString(3));
				lstFriends.add(friends);
			}
			return lstFriends;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}

	@Override
	public int deleteById(int relid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		String strSQL = "delete from friends where relid=?";
		Object[] params = new Object[] { relid };
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		if (affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public Friends selectById(int relid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		String strSQL = "select * from friends where relid=?";
		Object[] params = new Object[] { relid };
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		try {
			if (resultSet.next()) {
				Friends friends = new Friends();
				friends.setRelid(resultSet.getInt(1));
				friends.setFuser(resultSet.getString(2));
				friends.setFuserfri(resultSet.getString(3));
				return friends;
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
	public int update(Friends friends) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		String strSQL = "update customers set fuser=?, fuserfri=? where relid=?";
		Object[] params = new Object[] { friends.getFuser(), friends.getFuserfri(), friends.getRelid() };
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		if (affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback(); 
		}
		return affectedRows;
	}

	@Override
	public List<String> selectByUccid(String fuser) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		List<String> lstFri = new ArrayList<>();
		String strSQL = "select fuserfri from friends where fuser=?";
		Object[] params = new Object[] { fuser };
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		try {
			while (resultSet.next()) {
                   lstFri.add(resultSet.getString(1));
			
			} 
		       return lstFri;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}

	@Override
	public int insertById(String uccid,String uccidfri) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		String fuser = uccid;
		String fuserfri = uccidfri;
		String strSQL = "insert into friends values(null,?,?)";
		Object[] params = new Object[] {fuser,fuserfri };
		//Object[] params2 = new Object[] {fuserfri,fuser };
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		//int affectedRows2 = this.dbUtils.execOthers(conn, strSQL, params2);
		if (affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public boolean selectByUfid(String fuser, String fuserfri) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		String strSQL = "select relid from friends where fuser=? and fuserfri =?";
		Object[] params = new Object[] { fuser,fuserfri };
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		try {
			if (resultSet.next()) {
			
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return true;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}

	@Override
	public boolean deleteByUfid(String fuser, String fuserfri) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		String strSQL = "delete from friends where fuser=? and fuserfri=?";
		Object[] params = new Object[] { fuser,fuserfri };
		Object[] params2 = new Object[] { fuserfri,fuser };
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		int affectedRows2 = this.dbUtils.execOthers(conn, strSQL, params2);
		if (affectedRows > 0&&affectedRows2 > 0) {
			TransactionManager.commit();
			return true;
		} else {
			TransactionManager.rollback();
			return false;
		}

	}

	
}
