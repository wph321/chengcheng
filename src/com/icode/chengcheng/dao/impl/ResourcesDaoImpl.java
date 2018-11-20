package com.icode.chengcheng.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icode.chengcheng.dao.IResourcesDao;
import com.icode.chengcheng.db.ConnectionManager;
import com.icode.chengcheng.db.DBUtils;
import com.icode.chengcheng.db.TransactionManager;
import com.icode.chengcheng.po.Resources;

public class ResourcesDaoImpl implements IResourcesDao {
	
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;

	
	public ResourcesDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	@Override
	public int insert(Resources resourse) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		int restype = resourse.getRestype();
		String resurl = resourse.getResurl();
		String strSQL = "insert into resources values(null,?,?)";
		Object[] params = new Object[] {restype,resurl };
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		if (affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public List<Resources> selectAll() {
		// TODO Auto-generated method stub
		List<Resources> lstResources = new ArrayList<Resources>();
		this.conn = connectionManager.openConnection();
		String strSQL = "select * from resources order by resid";
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,new Object[] {});
		try {
			while (resultSet.next()) {
				Resources resource = new Resources();
                resource.setResid(resultSet.getInt(1));
                resource.setRestype(resultSet.getInt(2));
                resource.setResurl(resultSet.getString(3));
				lstResources.add(resource);
			}
			return lstResources;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}

	@Override
	public int deleteById(int resid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		String strSQL = "delete from resources where resid=?";
		Object[] params = new Object[] { resid };
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		if (affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public Resources selectById(int resid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		String strSQL = "select * from resources where resid=?";
		Object[] params = new Object[] { resid };
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		try {
			if (resultSet.next()) {
				Resources resource = new Resources();
				resource.setResid(resultSet.getInt(1));
				resource.setRestype(resultSet.getInt(2));
				resource.setResurl(resultSet.getString(3));
				return resource;
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

}
