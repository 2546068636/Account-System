package com.me.AccountSystem.Bean;

public class BaoXianBean {
	private String bxcode;
	private String name;
	private String time;
	private String type;
	private String money;
	private String beizhu;
	
	public BaoXianBean(String bxcode, String name, String time, String type, String money, String beizhu) {
		super();
		this.bxcode = bxcode;
		this.name = name;
		this.time = time;
		this.type = type;
		this.money = money;
		this.beizhu = beizhu;
	}

	@Override
	public String toString() {
		return "BaoXianBean [bxcode=" + bxcode + ", name=" + name + ", time=" + time + ", type=" + type + ", money="
				+ money + ", beizhu=" + beizhu + "]";
	}

	public String getBxcode() {
		return bxcode;
	}

	public void setBxcode(String bxcode) {
		this.bxcode = bxcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public BaoXianBean() {
		// TODO Auto-generated constructor stub
	}

}
