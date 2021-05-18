package com.me.AccountSystem.Bean;

public class Account {
	private String name;
	private String way;
	private String description;
	private String money;
	private String date;
	private int id;

	public Account(String name, String way, String description, String money, String date, int id) {
		super();
		this.name = name;
		this.way = way;
		this.description = description;
		this.money = money;
		this.date = date;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setWay(String way) {
		this.way = way;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public String getWay() {
		return way;
	}

	public String getDescription() {
		return description;
	}

	public String getMoney() {
		return money;
	}

	public String getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", way=" + way + ", description=" + description + ", money=" + money
				+ ", date=" + date + ", id=" + id + "]";
	}

}
