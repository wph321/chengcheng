package com.icode.chengcheng.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icode.chengcheng.dao.INewsDao;
import com.icode.chengcheng.db.ConnectionManager;
import com.icode.chengcheng.db.DBUtils;
import com.icode.chengcheng.db.TransactionManager;
import com.icode.chengcheng.po.News;


public class NewsDaoImpl implements INewsDao {
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;

	public NewsDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	@Override
	public int insert(News news) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启一个事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 步骤3：拆分对向属性
		String nuser = news.getNuser();
		String nfrom = news.getNfrom();
		int ntype = news.getNtype();
		String ncontent = news.getNcontent();
		// 步骤4：设置添加SQL语句模板
		String strSQL = "insert into news values(null,?,?,?,?,now())";
		Object[] params = new Object[] { nuser, nfrom, ntype, ncontent };
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
	public List<News> selectAll() {
		// TODO Auto-generated method stub
		// 步骤1：创建一个空的集合准备存放查询的结果
		List<News> lstNews = new ArrayList<News>();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from news order by nid";
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,
				new Object[] {});
		// 步骤5：将resultSet结果集转换成List数据结构
		try {
			while (resultSet.next()) {
				// 步骤5-1：创建一个news对象
				News news = new News();
				news.setNid(resultSet.getInt(1));
				news.setNuser(resultSet.getString(2));
				news.setNfrom(resultSet.getString(3));
				news.setNtype(resultSet.getInt(4));
				news.setNcontent(resultSet.getString(5));
				news.setNdate(resultSet.getDate(6));

				// 步骤5-2：将封装好的对象添加到List集合中
				lstNews.add(news);
			}
			// 返回结果
			return lstNews;
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
	public int deleteById(int nid) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 步骤3：创建SQL语句模板
		String strSQL = "delete from news where nid=?";
		Object[] params = new Object[] { nid };
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
	public News selectById(int nid) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：创建SQL语句模板
		String strSQL = "select * from news where nid=?";
		Object[] params = new Object[] { nid };
		// 步骤4：调用dbutils中的方法完成对数据库的查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		// 步骤5：获取结果集合并封装成一个对象
		try {
			if (resultSet.next()) {
				// 步骤6：创建一个news对象
				News news = new News();
				news.setNid(resultSet.getInt(1));
				news.setNuser(resultSet.getString(2));
				news.setNfrom(resultSet.getString(3));
				news.setNtype(resultSet.getInt(4));
				news.setNcontent(resultSet.getString(5));
				news.setNdate(resultSet.getDate(6));
				// 步骤7：返回对象
				return news;
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
	public List<News> selectByUccid(String uccid) {
		// TODO Auto-generated method stub
		List<News> lstNews = new ArrayList<News>();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from news where nuser = ? order by ndate";
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,uccid);
		// 步骤5：将resultSet结果集转换成List数据结构
		try {
			while (resultSet.next()) {
				// 步骤5-1：创建一个news对象
				News news = new News();
				news.setNid(resultSet.getInt(1));
				news.setNuser(resultSet.getString(2));
				news.setNfrom(resultSet.getString(3));
				news.setNtype(resultSet.getInt(4));
				news.setNcontent(resultSet.getString(5));
				news.setNdate(resultSet.getDate(6));

				// 步骤5-2：将封装好的对象添加到List集合中
				lstNews.add(news);
			}
			// 返回结果
			return lstNews;
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
	public int deleteByUccid(String uccid) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 步骤3：创建SQL语句模板
		String strSQL = "delete from news where nfrom=? and ntype=4";
		Object[] params = new Object[] { uccid };
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
	}

