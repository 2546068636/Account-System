package com.me.AccountSystem.Bean;

public class UserBean {

	public UserBean() {
		// TODO Auto-generated constructor stub
	}

	private String name;
	private String sex;
	private String phone;
	private String identity;
	private String password;
	private int account;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "UserBean [account=" + account + ", identity=" + identity + ", name=" + name + ", password=" + password
				+ ", phone=" + phone + ", sex=" + sex + "]";
	}

	public UserBean(String name, String sex, String phone, String identity, String password, int account) {
		super();
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.identity = identity;
		this.password = password;
		this.account = account;
	}

}
