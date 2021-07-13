package com.beans;

public class CarDetails {
	private String Make; 
	private String Model;
	private int year;
	private double salePrice;
	  
 public CarDetails() {
			super();
			// TODO Auto-generated constructor stub
		}   
  public CarDetails(String make, String model, int year, double salePrice) {
		super();
		Make = make;
		Model = model;
		this.year = year;
		this.salePrice = salePrice;
	} 
  
public String getMake() {
	return Make;
}
public void setMake(String make) {
	Make = make;
}
public String getModel() {
	return Model;
}
public void setModel(String model) {
	Model = model;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
public double getSalePrice() {
	return salePrice;
}
public void setSalePrice(double salePrice) {
	this.salePrice = salePrice;
}
@Override
public String toString() {
	return "Manifacture=" + Make + ", Model=" + Model + ", year=" + year + ", salePrice=" + salePrice;
}
  
}
