package com.xiaoxiaomo.day11.shop;

public class Bags {

	
	public Bags(Integer bjjCount, Integer klCount, Integer ownTotal) {
		this.bjjCount = bjjCount;
		this.klCount = klCount;
		this.ownTotal = ownTotal;
	}
	//冰激淋库存
	private Integer bjjCount;
	//可乐库存
	private Integer klCount;
	//赚的总钱数
	private Integer ownTotal;
	
	public Integer getBjjCount() {
		return bjjCount;
	}
	public void setBjjCount(Integer bjjCount) {
		this.bjjCount = bjjCount;
	}
	public Integer getKlCount() {
		return klCount;
	}
	public void setKlCount(Integer klCount) {
		this.klCount = klCount;
	}
	public Integer getOwnTotal() {
		return ownTotal;
	}
	public void setOwnTotal(Integer ownTotal) {
		this.ownTotal = ownTotal;
	}
	
	
}
