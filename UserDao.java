package com.me.AccountSystem.Dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.me.AccountSystem.Bean.UserBean;
import com.me.AccountSystem.Utils.DBUtils;

public class UserDao {

	// 注册
	public static boolean register(UserBean userbean) throws SQLException {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		String sql = "insert into userbean values(?,?,?,?,?,?)";
		int i = qr.update(sql, userbean.getName(), userbean.getSex(), userbean.getPhone(), userbean.getIdentity(),
				userbean.getPassword(), userbean.getAccount());
		if (i > 0) {
			return true;
		} else
			return false;
	}

	// 修改用户个人信息方法
	public static boolean update(UserBean b) throws SQLException {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		String sql = "update userbean set name=?,sex=?,phone=?,identity=?,password=?,account=?";
		int i = qr.update(sql, b.getName(), b.getSex(), b.getPhone(), b.getIdentity(), b.getPassword(), b.getAccount());
		if (i > 0) {
			return true;
		} else
			return false;

	}

	// 登录功能
	public static UserBean login(String name, String pass) throws SQLException {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		String sql = "select * from userbean where name=? and password=?";
		UserBean s = qr.query(sql, new BeanHandler<UserBean>(UserBean.class), name,pass);
		return s;
	}

	public UserDao() {
		// TODO Auto-generated constructor stub
	}

}
