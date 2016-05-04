package cn.xxo.day20.work.o4;

public class Student {
	
	private String sNo;
	private String sName;
	private String sSex;
	private int sAge;
	private double sJava;
	public Student(String sNo, String sName, String sSex, int sAge, double sJava) {
		super();
		this.sNo = sNo;
		this.sName = sName;
		this.sSex = sSex;
		this.sAge = sAge;
		this.sJava = sJava;
	}
	
	public String getsNo() {
		return sNo;
	}
	public String getsName() {
		return sName;
	}
	public String getsSex() {
		return sSex;
	}
	public int getsAge() {
		return sAge;
	}
	public double getsJava() {
		return sJava;
	}

	@Override
	public String toString() {
		return "Student [sNo=" + sNo + ", sName=" + sName + ", sSex=" + sSex
				+ ", sAge=" + sAge + ", sJava=" + sJava + "]";
	}
}
