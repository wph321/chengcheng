package com.icode.chengcheng.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icode.chengcheng.dao.ICommentsDao;
import com.icode.chengcheng.db.ConnectionManager;
import com.icode.chengcheng.db.DBUtils;
import com.icode.chengcheng.db.TransactionManager;
import com.icode.chengcheng.po.Comments;



public class CommentsDaoImpl implements ICommentsDao {
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;
	
	public CommentsDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	@Override
	public int insert(Comments comments) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启一个事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 步骤3：拆分对向属性
		int cact = comments.getCact();
		String cuser = comments.getCuser_from();
		String ccontent = comments.getCcontent();
		int cuser_to = comments.getCuser_to();


		// 步骤4：设置添加SQL语句模板
		String strSQL = "insert into comments values(null,?,?,?,now(),?)";
		Object[] params = new Object[] { cact, cuser, ccontent,cuser_to };
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
	public List<Comments> selectAll() {
		// TODO Auto-generated method stub
		// 步骤1：创建一个空的集合准备存放查询的结果
		List<Comments> lstComments = new ArrayList<Comments>();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from comments order by cid";
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,new Object[] {});
		// 步骤5：将resultSet结果集转换成List数据结构
		try {
			while (resultSet.next()) {
				// 步骤5-1：创建一个comments对象
				Comments comments = new Comments();
				comments.setCid(resultSet.getInt(1));
				comments.setCact(resultSet.getInt(2));
				comments.setCuser_from(resultSet.getString(3));
				comments.setCcontent(resultSet.getString(4));
				comments.setCdate(resultSet.getDate(5));
				comments.setCuser_to(resultSet.getInt(6));


				// 步骤5-2：将封装好的对象添加到List集合中
				lstComments.add(comments);
			}
			// 返回结果
			return lstComments;
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
	public int deleteById(int cid) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 步骤3：创建SQL语句模板
		String strSQL = "delete from comments where cid=?";
		Object[] params = new Object[] { cid };
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
	public Comments selectById(int cid) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：创建SQL语句模板
		String strSQL = "select * from comments where cid=?";
		Object[] params = new Object[] { cid };
		// 步骤4：调用dbutils中的方法完成对数据库的查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		// 步骤5：获取结果集合并封装成一个对象
		try {
			if (resultSet.next()) {
				// 步骤6：创建一个comments对象
				Comments comments = new Comments();
				comments.setCid(resultSet.getInt(1));
				comments.setCact(resultSet.getInt(2));
				comments.setCuser_from(resultSet.getString(3));
				comments.setCcontent(resultSet.getString(4));
				comments.setCdate(resultSet.getDate(5));
				comments.setCuser_to(resultSet.getInt(6));

				// 步骤7：返回对象
				return comments;
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
	public boolean deleteByAid(int aid) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
				this.conn = this.connectionManager.openConnection();
				// 步骤2：开启事务
				TransactionManager.conn = this.conn;
				TransactionManager.beginTransaction();
				// 步骤3：创建SQL语句模板
				String  strSQL = "select cid from comments where cact=?";
			    String strSQL2 = "delete from comments where cact=?";
			    Object[] params = new Object[] { aid };
		         ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		         try {
					if(resultSet.next()){
					// 步骤4：调用dbutils中的方法完成对数据库的删除操作
					int affectedRwos = this.dbUtils.execOthers(conn, strSQL2, params);
					// 步骤5：根据步骤4的操作结果提交或回滚事务
					if (affectedRwos > 0) {
						TransactionManager.commit(); // 事务提交
						return true;
					} else {
						TransactionManager.rollback(); // 事务的回滚
						return false;
					}
					}else{
						return true;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
	}
	@Override
	public int insertu(Comments comments) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启一个事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 步骤3：拆分对向属性
		int cact = comments.getCact();
		String cuser = comments.getCuser_from();
		String ccontent = comments.getCcontent();

		// 步骤4：设置添加SQL语句模板
		String strSQL = "insert into comments values(null,?,?,?,now(),null)";
		Object[] params = new Object[] { cact, cuser, ccontent};
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


}
