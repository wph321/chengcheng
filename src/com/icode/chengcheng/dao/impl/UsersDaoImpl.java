package com.icode.chengcheng.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.icode.chengcheng.dao.IUsersDao;
import com.icode.chengcheng.db.ConnectionManager;
import com.icode.chengcheng.db.DBUtils;
import com.icode.chengcheng.db.TransactionManager;
import com.icode.chengcheng.po.Users;
import com.icode.chengcheng.tools.MD5;

public class UsersDaoImpl implements IUsersDao {
	
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;

	public UsersDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	@Override
	public int insert(Users users) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();

		String uccid = users.getUccid();
		String uname = users.getUname();
		String upwd = users.getUpwd();
		String ugender = users.getUgender();
		String uorg = users.getUorg();
		String uphoto = users.getUphoto();
		Date ubirth = users.getUbirth();
		String utele = users.getUtele();
		String uqq = users.getUqq();
		String ucity = users.getUcity();
		String uadd = users.getUadd();
		int ustate = users.getUstate();
		String strSQL = "insert into users values(?,?,?,?,?,?,?,?,?,?,?,?,now())";
		Object[] params = new Object[] {uccid,uname,upwd,ugender,uorg,uphoto,ubirth,utele,uqq,ucity,uadd,ustate };
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		if (affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public List<Users> selectAll() {
		// TODO Auto-generated method stub
		List<Users> lstUsers = new ArrayList<Users>();
		this.conn = connectionManager.openConnection();
		String strSQL = "select * from users order by uccid";
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,new Object[] {});
		try {
			while (resultSet.next()) {
				Users users = new Users();
				users.setUccid(resultSet.getString(1));
				users.setUname(resultSet.getString(2));
				users.setUpwd(resultSet.getString(3));
				users.setUgender(resultSet.getString(4));
				users.setUorg(resultSet.getString(5));
				users.setUphoto(resultSet.getString(6));
				users.setUbirth(resultSet.getDate(7));
				users.setUtele(resultSet.getString(8));
				users.setUqq(resultSet.getString(9));
				users.setUcity(resultSet.getString(10));
				users.setUadd(resultSet.getString(11));
				users.setUstate(resultSet.getInt(12));
				users.setUdate(resultSet.getDate(13));
				lstUsers.add(users);
			}
			return lstUsers;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}

	@Override
	public int deleteById(int uccid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		String strSQL = "delete from users where uccid=?";
		Object[] params = new Object[] { uccid };
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		if (affectedRows > 0) {
			TransactionManager.commit(); 
		} else {
			TransactionManager.rollback(); 
		}
		return affectedRows;
	}

	@Override
	public Users selectById(String uccid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		String strSQL = "select * from users where uccid=?";
		Object[] params = new Object[] { uccid };
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		try {
			if (resultSet.next()) {
				Users users = new Users();
				users.setUccid(resultSet.getString(1));
				users.setUname(resultSet.getString(2));
				users.setUpwd(resultSet.getString(3));
				users.setUgender(resultSet.getString(4));
				users.setUorg(resultSet.getString(5));
				users.setUphoto(resultSet.getString(6));
				users.setUbirth(resultSet.getDate(7));
				users.setUtele(resultSet.getString(8));
				users.setUqq(resultSet.getString(9));
				users.setUcity(resultSet.getString(10));
				users.setUadd(resultSet.getString(11));
				users.setUstate(resultSet.getInt(12));
				users.setUdate(resultSet.getDate(13));
				// 姝ラ7锛氳繑鍥炲璞�
				return users;
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
	public int update(Users users) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		String strSQL = "update users set uname=?,upwd=?,ugender=?,uorg=?,uphoto=?,ubirth=?,utele=?,uqq=?,ucity=?,uadd=? where uccid=?";
		Object[] params = new Object[] { users.getUname(), users.getUpwd(), users.getUgender(), users.getUorg(),users.getUphoto(),users.getUbirth(),users.getUtele(),users.getUqq(),users.getUcity(),users.getUadd(),users.getUccid() };
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		if (affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public Users selectByObject(String uccid, String upwd) {
		// TODO Auto-generated method stub
        Connection conn = this.connectionManager.openConnection();
		MD5.DecoderByMD5(upwd);
		String strSQL = "select * from users where uccid=? and upwd=?";
		Object[] params = new Object[]{uccid, upwd};
		
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		try {
			if(resultSet.next()){
				Users user = new Users();
				user.setUccid(resultSet.getString(1));
				user.setUname(resultSet.getString(2));
				user.setUpwd(resultSet.getString(3));
				user.setUgender(resultSet.getString(4));
				user.setUorg(resultSet.getString(5));
				user.setUphoto(resultSet.getString(6));
				user.setUbirth(resultSet.getDate(7));
				user.setUtele(resultSet.getString(8));
				user.setUqq(resultSet.getString(9));
				user.setUcity(resultSet.getString(10));
				user.setUadd(resultSet.getString(11));
				user.setUstate(resultSet.getInt(12));
				user.setUdate(resultSet.getDate(13));
				
				
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return  null;
		} finally{
			this.connectionManager.closeConnection(conn);
		}	
		return null;
	}
	

	@Override
	public List<Users> selectByUccid(String uccid) {
		// TODO Auto-generated method stub
		List<Users> lstUsers = new ArrayList<Users>();
		this.conn = connectionManager.openConnection();
		String strSQL = "select * from users as a where a.uorg in (select uorg from users where uccid=?) and a.uccid!=?";
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,new Object[] {uccid,uccid});
		try {
			while (resultSet.next()) {
				Users users = new Users();
				users.setUccid(resultSet.getString(1));
				users.setUname(resultSet.getString(2));
				users.setUpwd(resultSet.getString(3));
				users.setUgender(resultSet.getString(4));
				users.setUorg(resultSet.getString(5));
				users.setUphoto(resultSet.getString(6));
				users.setUbirth(resultSet.getDate(7));
				users.setUtele(resultSet.getString(8));
				users.setUqq(resultSet.getString(9));
				users.setUcity(resultSet.getString(10));
				users.setUadd(resultSet.getString(11));
				users.setUstate(resultSet.getInt(12));
				users.setUdate(resultSet.getDate(13));
				lstUsers.add(users);
			}
			return lstUsers;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}

	@Override
	public List<Users> selectByKey(String uname) {
		// TODO Auto-generated method stub
		List<Users> lstUsers = new ArrayList<Users>();
		this.conn = connectionManager.openConnection();
		String strSQL = "select * from users  where uname like ?";
		String keyword = "%"+uname+"%";
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,new Object[] {keyword});
		try {
			while (resultSet.next()) {
				Users users = new Users();
				users.setUccid(resultSet.getString(1));
				users.setUname(resultSet.getString(2));
				users.setUpwd(resultSet.getString(3));
				users.setUgender(resultSet.getString(4));
				users.setUorg(resultSet.getString(5));
				users.setUphoto(resultSet.getString(6));
				users.setUbirth(resultSet.getDate(7));
				users.setUtele(resultSet.getString(8));
				users.setUqq(resultSet.getString(9));
				users.setUcity(resultSet.getString(10));
				users.setUadd(resultSet.getString(11));
				users.setUstate(resultSet.getInt(12));
				users.setUdate(resultSet.getDate(13));
				lstUsers.add(users);
			}
			return lstUsers;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}
	}


