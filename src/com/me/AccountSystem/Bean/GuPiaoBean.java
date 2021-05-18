package com.me.AccountSystem.Bean;

public class GuPiaoBean {
	private String name;
	private String gpname;
	private String gpcode;
	private String buyprice;
	private String gushu;
	private String soldprice;
	private String benefit;
	private String time;
	
	public GuPiaoBean(String name, String gpname, String gpcode, String buyprice, String gushu, String soldprice,
			String benefit, String time) {
		super();
		this.name = name;
		this.gpname = gpname;
		this.gpcode = gpcode;
		this.buyprice = buyprice;
		this.gushu = gushu;
		this.soldprice = soldprice;
		this.benefit = benefit;
		this.time = time;
	}

	@Override
	public String toString() {
		return "GuPiaoBean [name=" + name + ", gpname=" + gpname + ", gpcode=" + gpcode + ", buyprice=" + buyprice
				+ ", gushu=" + gushu + ", soldprice=" + soldprice + ", benefit=" + benefit + ", time=" + time + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGpname() {
		return gpname;
	}

	public void setGpname(String gpname) {
		this.gpname = gpname;
	}

	public String getGpcode() {
		return gpcode;
	}

	public void setGpcode(String gpcode) {
		this.gpcode = gpcode;
	}

	public String getBuyprice() {
		return buyprice;
	}

	public void setBuyprice(String buyprice) {
		this.buyprice = buyprice;
	}

	public String getGushu() {
		return gushu;
	}

	public void setGushu(String gushu) {
		this.gushu = gushu;
	}

	public String getSoldprice() {
		return soldprice;
	}

	public void setSoldprice(String soldprice) {
		this.soldprice = soldprice;
	}

	public String getBenefit() {
		return benefit;
	}

	public void setBenefit(String benefit) {
		this.benefit = benefit;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public GuPiaoBean() {
		// TODO Auto-generated constructor stub
	}

}
