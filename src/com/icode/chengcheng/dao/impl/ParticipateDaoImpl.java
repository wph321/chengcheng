package com.icode.chengcheng.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icode.chengcheng.dao.IParticipateDao;
import com.icode.chengcheng.db.ConnectionManager;
import com.icode.chengcheng.db.DBUtils;
import com.icode.chengcheng.db.TransactionManager;
import com.icode.chengcheng.po.Participate;

public class ParticipateDaoImpl implements IParticipateDao {
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;

	public ParticipateDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	@Override
	public int insert(Participate participate) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启一个事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 步骤3：拆分对向属性
		String puser = participate.getPuser();
		int pact = participate.getPact();
		int ptype = participate.getPtype();

		// 步骤4：设置添加SQL语句模板
		String strSQL = "insert into participate values(null,?,?,?,now())";
		Object[] params = new Object[] { puser, pact, ptype };
		// 步骤5：使用dbutils方法实现添加操作
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		// 步骤6：提交事务
		if (affectedRows > 0) {
			// 提交事务
			TransactionManager.commit();
		} else {
			// 回滚事务
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public List<Participate> selectAll() {
		// TODO Auto-generated method stub
		// 步骤1：创建一个空的集合准备存放查询的结果
		List<Participate> lstParticipate = new ArrayList<Participate>();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from participate order by pid";
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,
				new Object[] {});
		// 步骤5：将resultSet结果集转换成List数据结构
		try {
			while (resultSet.next()) {
				// 步骤5-1：创建一个participate对象
				Participate participate = new Participate();
				participate.setPid(resultSet.getInt(1));
				participate.setPuser(resultSet.getString(2));
				participate.setPact(resultSet.getInt(3));
				participate.setPtype(resultSet.getInt(4));
				participate.setPdate(resultSet.getDate(5));

				// 步骤5-2：将封装好的对象添加到List集合中
				lstParticipate.add(participate);
			}
			// 返回结果
			return lstParticipate;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			// 步骤6：关闭数据库连接
			this.connectionManager.closeConnection(conn);
		}
	}

	@Override
	public int deleteById(int pid) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 步骤3：创建SQL语句模板
		String strSQL = "delete from participate where pid=?";
		Object[] params = new Object[] { pid };
		// 步骤4：调用dbutils中的方法完成对数据库的删除操作
		int affectedRwos = this.dbUtils.execOthers(conn, strSQL, params);
		// 步骤5：根据步骤4的操作结果提交或回滚事务
		if (affectedRwos > 0) {
			TransactionManager.commit(); // 事务提交
		} else {
			TransactionManager.rollback(); // 事务的回滚
		}
		// 步骤6：返回影响行数
		return affectedRwos;
	}

	@Override
	public Participate selectById(int pid) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：创建SQL语句模板
		String strSQL = "select * from participate where pid=?";
		Object[] params = new Object[] { pid };
		// 步骤4：调用dbutils中的方法完成对数据库的查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		// 步骤5：获取结果集合并封装成一个对象
		try {
			if (resultSet.next()) {
				// 步骤6：创建一个participate对象
				Participate participate = new Participate();
				participate.setPid(resultSet.getInt(1));
				participate.setPuser(resultSet.getString(2));
				participate.setPact(resultSet.getInt(3));
				participate.setPtype(resultSet.getInt(4));
				participate.setPdate(resultSet.getDate(5));

				// 步骤7：返回对象
				return participate;
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
	public List<Participate> selectAct(int pact) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：创建SQL语句模板
		String strSQL = "select  * from participate where pact=?";
		Object[] params = new Object[] { pact };
		// 步骤4：调用dbutils中的方法完成对数据库的查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
	    List<Participate> lstUser = new ArrayList<>();
		try {
			while (resultSet.next()) {
			   Participate participate = new Participate();
			   participate.setPid(resultSet.getInt(1));
			   participate.setPact(pact);
			   participate.setPuser(resultSet.getString(2));
			   participate.setPtype(resultSet.getInt(4));
			   participate.setPdate(resultSet.getDate(5));
			   lstUser.add(participate);
            }
			return lstUser;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}

	@Override
	public boolean deleteByAid(int aid) {
		// TODO Auto-generated method stub
		
		// 步骤1：获取一个数据库连接对象
				this.conn = this.connectionManager.openConnection();
				// 步骤2：开启事务
				TransactionManager.conn = this.conn;
				TransactionManager.beginTransaction();
				// 步骤3：创建SQL语句模板
				String strSQL = "delete from participate where pact=?";
				Object[] params = new Object[] { aid };
				// 步骤4：调用dbutils中的方法完成对数据库的删除操作
				int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
				// 步骤5：根据步骤4的操作结果提交或回滚事务
				if (affectedRows > 0) {
					TransactionManager.commit(); // 事务提交
					return true;
				} else {
					TransactionManager.rollback(); // 事务的回滚
					return false;
				}
			
	}

	@Override
	public boolean deleteByOthers(String uccid,int aid) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 步骤3：创建SQL语句模板
		String strSQL = "delete from participate where puser=? and pact=? and ptype=1";
		Object[] params = new Object[] { uccid ,aid};
		// 步骤4：调用dbutils中的方法完成对数据库的删除操作
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		// 步骤5：根据步骤4的操作结果提交或回滚事务
		if (affectedRows > 0) {
			TransactionManager.commit(); // 事务提交
			return true;
		} else {
			TransactionManager.rollback(); // 事务的回滚
			return false;
		}
	}
}
