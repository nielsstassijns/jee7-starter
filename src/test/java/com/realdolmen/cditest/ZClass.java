package com.realdolmen.cditest;

public class ZClass {

	private int numberZ;
	private String someTextZ;
	
	public ZClass() {
		super();
	}
	public ZClass(int numberZ, String someTextZ) {
		super();
		this.numberZ = numberZ;
		this.someTextZ = someTextZ;
	}
	public int getNumber() {
		return numberZ;
	}
	public void setNumber(int numberZ) {
		this.numberZ = numberZ;
	}
	public String getSomeText() {
		return someTextZ;
	}
	public void setSomeText(String someTextZ) {
		this.someTextZ = someTextZ;
	}
	
	
	
}
