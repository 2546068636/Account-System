package com.me.AccountSystem.Bean;

public class ZhaiQuanBean {
	private String name;
	private String zqname;
	private String zqcode;
	private String money;
	private String interest;
	private String profit;
	private String time;
	
	public ZhaiQuanBean(String name, String zqname, String zqcode, String money, String interest, String profit,
			String time) {
		super();
		this.name = name;
		this.zqname = zqname;
		this.zqcode = zqcode;
		this.money = money;
		this.interest = interest;
		this.profit = profit;
		this.time = time;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public ZhaiQuanBean(String name, String zqname, String zqcode, String money, String interest, String profit) {
		super();
		this.name = name;
		this.zqname = zqname;
		this.zqcode = zqcode;
		this.money = money;
		this.interest = interest;
		this.profit = profit;
	}

	@Override
	public String toString() {
		return "ZhaiQuanBean [name=" + name + ", zqname=" + zqname + ", zqcode=" + zqcode + ", money=" + money
				+ ", interest=" + interest + ", profit=" + profit + ", time=" + time + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZqname() {
		return zqname;
	}

	public void setZqname(String zqname) {
		this.zqname = zqname;
	}

	public String getZqcode() {
		return zqcode;
	}

	public void setZqcode(String zqcode) {
		this.zqcode = zqcode;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getProfit() {
		return profit;
	}

	public void setProfit(String profit) {
		this.profit = profit;
	}

	public ZhaiQuanBean() {
		// TODO Auto-generated constructor stub
	}

}
