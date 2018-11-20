package com.icode.chengcheng.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.icode.chengcheng.dao.IActivitiesDao;
import com.icode.chengcheng.db.ConnectionManager;
import com.icode.chengcheng.db.DBUtils;
import com.icode.chengcheng.db.TransactionManager;
import com.icode.chengcheng.po.Activities;


public class ActivitiesDaoImpl implements IActivitiesDao {

	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;

	public ActivitiesDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	@Override
	public int insert(Activities activity) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启一个事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();

		// 步骤3：拆分对向属性

		String owner_id = activity.getOwner_id();
		Date adeadline = activity.getAdeadline();
		Date adate = activity.getAdate();
		String aaddress = activity.getAaddress();
		int amax_num = activity.getAmax_num();
		int amin_num = activity.getAmin_num();
		int acurr_num = activity.getAcurr_num();
		String acontent = activity.getAcontent();
		String atopic = activity.getAtopic();
		String astate = activity.getAstate();
		String aresid = activity.getAresid();
		int aproise_num = activity.getAproise_num();
		int ashare_num = activity.getAshare_num();
		int acomm_num = activity.getAcomm_num();
		int atype = activity.getAtype();
		String aname = activity.getAname();
		int avisit_num = activity.getAvisit_num();
		// 步骤4：设置添加SQL语句模板
		String strSQL = "insert into activities values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = new Object[] { owner_id, adeadline, adate, aaddress,
				amax_num, amin_num, acurr_num, acontent, atopic, astate,
				aresid, aproise_num, ashare_num, acomm_num, atype, aname,
				avisit_num };
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
	public List<Activities> selectAll() {
		// TODO Auto-generated method stub
		// 步骤1：创建一个空的集合准备存放查询的结果
		List<Activities> lstActivities = new ArrayList<Activities>();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from activities order by aid";
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,
				new Object[] {});
		// 步骤5：将resultSet结果集转换成List数据结构
		try {
			while (resultSet.next()) {
				// 步骤5-1：创建一个Customers对象
				Activities activity = new Activities();
				activity.setAid(resultSet.getShort(1));
				activity.setOwner_id(resultSet.getString(2));
				activity.setAdeadline(resultSet.getDate(3));
				activity.setAdate(resultSet.getDate(4));
				activity.setAaddress(resultSet.getString(5));
				activity.setAmax_num(resultSet.getInt(6));
				activity.setAmin_num(resultSet.getInt(7));
				activity.setAcurr_num(resultSet.getInt(8));
				activity.setAcontent(resultSet.getString(9));
				activity.setAtopic(resultSet.getString(10));
				activity.setAstate(resultSet.getString(11));
				activity.setAresid(resultSet.getString(12));
				activity.setAproise_num(resultSet.getInt(13));
				activity.setAshare_num(resultSet.getInt(14));
				activity.setAcomm_num(resultSet.getInt(15));
				activity.setAtype(resultSet.getInt(16));
				activity.setAname(resultSet.getString(17));
				activity.setAvisit_num(resultSet.getInt(18));
				// 步骤5-2：将封装好的对象添加到List集合中
				lstActivities.add(activity);
			}
			// 返回结果
			return lstActivities;
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
	public int deleteById(int aid) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 步骤3：创建SQL语句模板
		String strSQL = "delete from activities where aid=?";
		Object[] params = new Object[] { aid };
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
	public Activities selectById(int aid) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：创建SQL语句模板
		String strSQL = "select * from activities where aid=?";
		Object[] params = new Object[] { aid };
		// 步骤4：调用dbutils中的方法完成对数据库的查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		// 步骤5：获取结果集合并封装成一个对象
		try {
			if (resultSet.next()) {
				// 步骤6：创建一个Customers对象
				Activities activity = new Activities();
				activity.setAid(resultSet.getShort(1));
				activity.setOwner_id(resultSet.getString(2));
				activity.setAdeadline(resultSet.getDate(3));
				activity.setAdate(resultSet.getDate(4));
				activity.setAaddress(resultSet.getString(5));
				activity.setAmax_num(resultSet.getInt(6));
				activity.setAmin_num(resultSet.getInt(7));
				activity.setAcurr_num(resultSet.getInt(8));
				activity.setAcontent(resultSet.getString(9));
				activity.setAtopic(resultSet.getString(10));
				activity.setAstate(resultSet.getString(11));
				activity.setAresid(resultSet.getString(12));
				activity.setAproise_num(resultSet.getInt(13));
				activity.setAshare_num(resultSet.getInt(14));
				activity.setAcomm_num(resultSet.getInt(15));
				activity.setAtype(resultSet.getInt(16));
				activity.setAname(resultSet.getString(17));
				activity.setAvisit_num(resultSet.getInt(18));
				// 步骤7：返回对象
				return activity;
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
	public int update(Activities activity) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 步骤3：创建SQL语句模板
		String strSQL = "update activities set owner_id=?, adeadline=?, adate=?, aaddress=?,amax_num=?, amin_num=?, acurr_num=?, acontent=?, atopic=?, astate=?,aresid=?, aproise_num=?, ashare_num=?, acomm_num=?, atype=?, aname=?,avisit_num=? where aid=?";
		Object[] params = new Object[] { activity.getOwner_id(),activity.getAdeadline(),activity.getAdate(),activity.getAaddress(),
				activity.getAmax_num() , activity.getAmin_num() ,activity.getAcurr_num(), activity.getAcontent() ,activity.getAtopic(),
				activity.getAstate(),activity.getAresid(),activity.getAproise_num() ,activity.getAshare_num(),activity.getAcomm_num(),
				activity.getAtype(),activity.getAname(),activity.getAvisit_num(),activity.getAid() };
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
	public int selectAid(Activities activity) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
				this.conn = this.connectionManager.openConnection();
				// 步骤2：创建SQL语句模板
				String strSQL = "select max(aid) from activities";
				ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, new Object[] {});
				int aid = 0;
				try {
					if (resultSet.next())
					try {
						aid = resultSet.getInt(1);
						return aid;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 步骤5：获取结果集合并封装成一个对象
					this.connectionManager.closeConnection(conn);
					return aid;
			
	}
	@Override
	public int updatezan(int aid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 步骤3：创建SQL语句模板
		String strSQL = "update activities set aproise_num=aproise_num+1 where aid=?";
		Object[] params = new Object[] {aid};
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
	public int updatecom_num(int aid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 步骤3：创建SQL语句模板
		String strSQL = "update activities set acomm_num=acomm_num+1 where aid=?";
		Object[] params = new Object[] {aid};
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
	public int updateShare(int aid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 步骤3：创建SQL语句模板
		String strSQL = "update activities set ashare_num=ashare_num+1 where aid=?";
		Object[] params = new Object[] {aid};
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
	public int updateCurr(int aid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 步骤3：创建SQL语句模板
		String strSQL = "update activities set acurr_num=acurr_num+1 where aid=?";
		Object[] params = new Object[] {aid};
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
	public List<Activities> searchAllByname(String searchcont) {
		// TODO Auto-generated method stub
		// 步骤1：创建一个空的集合准备存放查询的结果
				List<Activities> lstActivities = new ArrayList<Activities>();
				// 步骤2：获取一个数据库的连接对象
				this.conn = connectionManager.openConnection();
				// 步骤3：创建查询语句的模板
				String strSQL = "select * from activities where aname like ? ";
				String searchcont2="%"+searchcont+"%";
				// 步骤4：使用dbutils方法实现查询操作
				ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,
						new Object[] {searchcont2});
				// 步骤5：将resultSet结果集转换成List数据结构
				try {
					while (resultSet.next()) {
						// 步骤5-1：创建一个Customers对象
						Activities activity = new Activities();
						activity.setAid(resultSet.getShort(1));
						activity.setOwner_id(resultSet.getString(2));
						activity.setAdeadline(resultSet.getDate(3));
						activity.setAdate(resultSet.getDate(4));
						activity.setAaddress(resultSet.getString(5));
						activity.setAmax_num(resultSet.getInt(6));
						activity.setAmin_num(resultSet.getInt(7));
						activity.setAcurr_num(resultSet.getInt(8));
						activity.setAcontent(resultSet.getString(9));
						activity.setAtopic(resultSet.getString(10));
						activity.setAstate(resultSet.getString(11));
						activity.setAresid(resultSet.getString(12));
						activity.setAproise_num(resultSet.getInt(13));
						activity.setAshare_num(resultSet.getInt(14));
						activity.setAcomm_num(resultSet.getInt(15));
						activity.setAtype(resultSet.getInt(16));
						activity.setAname(resultSet.getString(17));
						activity.setAvisit_num(resultSet.getInt(18));
						// 步骤5-2：将封装好的对象添加到List集合中
						lstActivities.add(activity);
					}
					// 返回结果
					return lstActivities;
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
	public List<Activities> searchAllBytopic(String searchcont) {
		// TODO Auto-generated method stub
		// 步骤1：创建一个空的集合准备存放查询的结果
		List<Activities> lstActivities = new ArrayList<Activities>();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from activities where atopic like ? ";
		String searchcont2="%"+searchcont+"%";
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,
				new Object[] {searchcont2});
		// 步骤5：将resultSet结果集转换成List数据结构
		try {
			while (resultSet.next()) {
				// 步骤5-1：创建一个Customers对象
				Activities activity = new Activities();
				activity.setAid(resultSet.getShort(1));
				activity.setOwner_id(resultSet.getString(2));
				activity.setAdeadline(resultSet.getDate(3));
				activity.setAdate(resultSet.getDate(4));
				activity.setAaddress(resultSet.getString(5));
				activity.setAmax_num(resultSet.getInt(6));
				activity.setAmin_num(resultSet.getInt(7));
				activity.setAcurr_num(resultSet.getInt(8));
				activity.setAcontent(resultSet.getString(9));
				activity.setAtopic(resultSet.getString(10));
				activity.setAstate(resultSet.getString(11));
				activity.setAresid(resultSet.getString(12));
				activity.setAproise_num(resultSet.getInt(13));
				activity.setAshare_num(resultSet.getInt(14));
				activity.setAcomm_num(resultSet.getInt(15));
				activity.setAtype(resultSet.getInt(16));
				activity.setAname(resultSet.getString(17));
				activity.setAvisit_num(resultSet.getInt(18));
				// 步骤5-2：将封装好的对象添加到List集合中
				lstActivities.add(activity);
			}
			// 返回结果
			return lstActivities;
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
	public List<Activities> searchAllBycontent(String searchcont) {
		// TODO Auto-generated method stub
		// 步骤1：创建一个空的集合准备存放查询的结果
				List<Activities> lstActivities = new ArrayList<Activities>();
				// 步骤2：获取一个数据库的连接对象
				this.conn = connectionManager.openConnection();
				// 步骤3：创建查询语句的模板
				String strSQL = "select * from activities where acontent like ? ";
				String searchcont2="%"+searchcont+"%";
				// 步骤4：使用dbutils方法实现查询操作
				ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,
						new Object[] {searchcont2});
				// 步骤5：将resultSet结果集转换成List数据结构
				try {
					while (resultSet.next()) {
						// 步骤5-1：创建一个Customers对象
						Activities activity = new Activities();
						activity.setAid(resultSet.getShort(1));
						activity.setOwner_id(resultSet.getString(2));
						activity.setAdeadline(resultSet.getDate(3));
						activity.setAdate(resultSet.getDate(4));
						activity.setAaddress(resultSet.getString(5));
						activity.setAmax_num(resultSet.getInt(6));
						activity.setAmin_num(resultSet.getInt(7));
						activity.setAcurr_num(resultSet.getInt(8));
						activity.setAcontent(resultSet.getString(9));
						activity.setAtopic(resultSet.getString(10));
						activity.setAstate(resultSet.getString(11));
						activity.setAresid(resultSet.getString(12));
						activity.setAproise_num(resultSet.getInt(13));
						activity.setAshare_num(resultSet.getInt(14));
						activity.setAcomm_num(resultSet.getInt(15));
						activity.setAtype(resultSet.getInt(16));
						activity.setAname(resultSet.getString(17));
						activity.setAvisit_num(resultSet.getInt(18));
						// 步骤5-2：将封装好的对象添加到List集合中
						lstActivities.add(activity);
					}
					// 返回结果
					return lstActivities;
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
	public int minusCurr(int aid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 步骤3：创建SQL语句模板
		String strSQL = "update activities set acurr_num=acurr_num-1 where aid=?";
		Object[] params = new Object[] {aid};
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
	public String findPub(int aid) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
				this.conn = this.connectionManager.openConnection();
				// 步骤2：创建SQL语句模板
				String strSQL = "select  owner_id from activities where aid=? ";
				Object[] params = new Object[] { aid };
				// 步骤4：调用dbutils中的方法完成对数据库的查询操作
				ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
				// 步骤5：获取结果集合并封装成一个对象
				try {
					if (resultSet.next()) {
		               String owner_id = resultSet.getString(1);
		               return owner_id;
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
