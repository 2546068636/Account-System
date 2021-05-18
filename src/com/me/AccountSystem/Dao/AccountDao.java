package com.me.AccountSystem.Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.me.AccountSystem.Bean.Account;
import com.me.AccountSystem.Bean.BaoXianBean;
import com.me.AccountSystem.Bean.GuPiaoBean;
import com.me.AccountSystem.Bean.UserBean;
import com.me.AccountSystem.Bean.ZhaiQuanBean;
import com.me.AccountSystem.Utils.DBUtils;

public class AccountDao {
	// 添加账单
	public static boolean addAccount(Account a) throws SQLException {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		String sql = "insert into account(name,way,description,money,date) values(?,?,?,?,?)";
		int i = qr.update(sql, a.getName(), a.getWay(), a.getDescription(), a.getMoney(), a.getDate());
		if (i > 0) {
			return true;
		} else
			return false;
	}

	// 修改账单
	public static boolean updateAccount(Account a) throws SQLException {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		String sql = "update  account set name=?,way=?,description=?,money=?,date=? where id =?";
		int i = qr.update(sql, a.getName(), a.getWay(), a.getDescription(), a.getMoney(), a.getDate(),a.getId());
		if (i > 0) {
			return true;
		} else
			return false;
	}

	// 删除账单
	public static boolean deleteAccount(int id) throws SQLException {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		String sql = "delete from  account where id=?";
		int i = qr.update(sql, id);
		if (i > 0) {
			return true;
		} else
			return false;
	}

	// 遍历账单
	public static List<Account> selectAllAccounts(String name) throws SQLException {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		String sql = "select name,way,description,money,date,id from account where name=?";
		List<Account> accounts = qr.query(sql, new BeanListHandler<Account>(Account.class), name);
		return accounts;
	}

	// 查询账单根据日期
	public static List<Account> selectAccountsByDate(String date, String name) throws Exception {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		List<Account> accounts=null;
		if(date=="") {
			String sql = "select name,way,description,money,date,id from account where name=?";
			accounts = qr.query(sql, new BeanListHandler<Account>(Account.class),name);
		}else {
			String sql = "select name,way,description,money,date,id from account where date=? and name=?";
			accounts = qr.query(sql, new BeanListHandler<Account>(Account.class), date, name);
		}
		
		return accounts;
	}

	// 通过金额查询账单
	public static List<Account> selectAccountByMoney(String money, String name) throws SQLException {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		List<Account> accounts=null;
		if(money=="") {
			String sql = "select name,way,description,money,date,id from account where name=?";
			accounts = qr.query(sql, new BeanListHandler<Account>(Account.class),name);
		}else {
			
			String sql = "select name,way,description,money,date,id from account where money=? and name=?";
			accounts = qr.query(sql, new BeanListHandler<Account>(Account.class), money, name);
		}

		
		return accounts;
	}

	// 通过收入的方式查询账单
	public static List<Account> selectAccountByShouRu(String name) throws SQLException {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		String sql = "select name,way,description,money,date,id from account where way='收入' and name=?";
		List<Account> accounts = qr.query(sql, new BeanListHandler<Account>(Account.class), name);
		return accounts;
	}

	// 通过支出的方式查询账单
	public static List<Account> selectAccountByZhiChu(String name) throws SQLException {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		String sql = "select name,way,description,money,date,id from account where way='支出'and name=?";
		List<Account> accounts = qr.query(sql, new BeanListHandler<Account>(Account.class), name);
		return accounts;
	}

	// 查询家庭账单
	public static List<Account> selectFamilyAccounts(String id) throws SQLException {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		String sql = "SELECT a.name,a.way,a.description,a.money,a.date FROM userbean u LEFT JOIN account a ON u.name=a.name AND u.identity=?";
		// 通过关联查询来实现对家庭账单的搜索
		List<Account> accounts = qr.query(sql, new BeanListHandler<Account>(Account.class), id);
		return accounts;
	}

	// 转账支付的方法
	public static void out(String u1, int money) {
		try {
			QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
			String sql1 = "update userbean set account=account-? where name=?";
			qr.update(sql1, money, u1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 转账收钱的方法
	public static void in(String u2, int money) {
		try {
			QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
			String sql2 = "update userbean set account=account+? where name=?";
			qr.update(sql2, money, u2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 向数据库搜索改名字的用户，然后返回用户，在通过get方法来获得其钱包余额，进而判断
	public static UserBean isMinus(String name) throws SQLException {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		String sql = "select * from userbean where name=?";
		UserBean user = qr.query(sql, new BeanHandler<UserBean>(UserBean.class), name);
		return user;
	}

	// 转账的方法
	public static boolean transfer(String user1, String user2, int money) throws Exception {
		// TODO Auto-generated method stub
		boolean transferSuccess = true;

		Connection conn = DBUtils.getConnection();
		conn.setAutoCommit(false);
		DBUtils.startTransaction();
		UserBean user = AccountDao.isMinus(user1);
		if (user.getAccount() < money) {
			System.out.println("qianbugou");
			DBUtils.rollback();
			transferSuccess = false;
		} else {
			AccountDao.out(user1, money);
			AccountDao.in(user2, money);
			System.out.println(user);
			System.out.println(user.getAccount());
		}
		DBUtils.commitAndRelease();

		return transferSuccess;
	}

	// 通过具体方式模糊查询
	public static List<Account> selectAccountByLike(String name, String des) throws SQLException {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		String sql = "select name,way,description,money,date,id from account where description like ? and name=?";
		List<Account> accounts = qr.query(sql, new BeanListHandler<Account>(Account.class), "%" + des + "%", name);
		return accounts;
	}

	// 计算收入总和
	public static Account sumOfShouRu(String name) throws SQLException {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		String sql = "select sum(money) as money from account where way='收入' and name=?";
		Account s = qr.query(sql, new BeanHandler<Account>(Account.class), name);
		return s;
	}

	// 计算支出总和
	public static Account sumOfZhiChu(String name) throws SQLException {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		String sql = "select sum(money) as money from account where way='支出' and name=?";
		Account s = qr.query(sql, new BeanHandler<Account>(Account.class), name);
		return s;
	}

	public AccountDao() {
		// TODO Auto-generated constructor stub
	}
	
	
	// 添加股票
	public static boolean addGuPiao(GuPiaoBean a) throws SQLException {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		String sql = "insert into gupiao values(?,?,?,?,?,?,?,?)";
		int i = qr.update(sql, a.getName(), a.getGpname(),a.getGpcode(),a.getBuyprice(),a.getGushu(),a.getSoldprice(),a.getBenefit(),a.getTime());
		if (i > 0) {
			return true;
		} else
			return false;
	}

	// 修改股票
	public static boolean updateGuPiao(GuPiaoBean a) throws SQLException {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		String sql = "update  gupiao set name=?,gpname=?,buyprice=?,gushu=?,soldprice=?,benefit=?,time=? where gpcode=?";
		int i = qr.update(sql, a.getName(),a.getGpname(),a.getBuyprice(),a.getGushu(),a.getSoldprice(),a.getBenefit(),a.getTime(),a.getGpcode());
		if (i > 0) {
			return true;
		} else
			return false;
	}

	// 删除股票
	public static boolean deleteGuPiao(String id) throws SQLException {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		String sql = "delete from  gupiao where gpcode=?";
		int i = qr.update(sql, id);
		if (i > 0) {
			return true;
		} else
			return false;
	}

	// 遍历股票
	public static List<GuPiaoBean> selectAllGuPiao(String name) throws SQLException {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		String sql = "select * from gupiao where name=?";
		List<GuPiaoBean> gupiaos = qr.query(sql, new BeanListHandler<GuPiaoBean>(GuPiaoBean.class), name);
		return gupiaos;
	}
	
	
	// 添加保险
	public static boolean addBaoXian(BaoXianBean a) throws SQLException {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		String sql = "insert into baoxian values(?,?,?,?,?,?)";
		int i = qr.update(sql, a.getBxcode(),a.getName(),a.getTime(),a.getType(),a.getMoney(),a.getBeizhu());
		if (i > 0) {
			return true;
		} else
			return false;
	}

	// 修改保险
	public static boolean updateBaoXian(BaoXianBean a) throws SQLException {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		String sql = "update  baoxian set name=?,time=?,type=?,money=?,beizhu=? where bxcode =?";
		int i = qr.update(sql,a.getName(),a.getTime(),a.getType(),a.getMoney(),a.getBeizhu(),a.getBxcode());
		if (i > 0) {
			return true;
		} else
			return false;
	}

	// 删除保险
	public static boolean deleteBaoXian(String id) throws SQLException {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		String sql = "delete from  baoxian where bxcode=?";
		int i = qr.update(sql, id);
		if (i > 0) {
			return true;
		} else
			return false;
	}

	// 遍历保险
	public static List<BaoXianBean> selectAllBaoXian(String name) throws SQLException {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		String sql = "select * from baoxian where name=?";
		List<BaoXianBean> baoxians = qr.query(sql, new BeanListHandler<BaoXianBean>(BaoXianBean.class), name);
		return baoxians;
	}
	
	// 添加债券
	public static boolean addZhaiQuan(ZhaiQuanBean a) throws SQLException {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		String sql = "insert into zhaiquan values(?,?,?,?,?,?,?)";
		int i = qr.update(sql, a.getName(),a.getZqname(),a.getZqcode(),a.getMoney(),a.getInterest(),a.getProfit(),a.getTime());
		if (i > 0) {
			return true;
		} else
			return false;
	}

	// 修改债券
	public static boolean updateZhaiQuan(ZhaiQuanBean a) throws SQLException {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		String sql = "update  zhaiquan set name=?,zqname=?,money=?,interest=?,profit=?,time=? where zqcode=?";
		int i = qr.update(sql, a.getName(),a.getZqname(),a.getMoney(),a.getInterest(),a.getProfit(),a.getTime(),a.getZqcode());
		if (i > 0) {
			return true;
		} else
			return false;
	}

	// 删除债券
	public static boolean deleteZhaiQuan(String id) throws SQLException {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		String sql = "delete from  zhaiquan where zqcode=?";
		int i = qr.update(sql, id);
		if (i > 0) {
			return true;
		} else
			return false;
	}

	// 遍历债券
	public static List<ZhaiQuanBean> selectAllZhaiQuan(String name) throws SQLException {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		String sql = "select * from zhaiquan where name=?";
		List<ZhaiQuanBean> zhaiquans = qr.query(sql, new BeanListHandler<ZhaiQuanBean>(ZhaiQuanBean.class), name);
		return zhaiquans;
	}
	
	

}
