package com.iwcn.master.services;


public class Product {
	String name_;
	float price_;
	String description_;
	String size_;
	String origin_;
	String reference_;
	int yearLot_;
	int monthLot_;
	int dayLot_;
	public Product(String name, float price, String description, String size, String origin, 
			int yearLot, int monthLot, int dayLot) {
		this.name_=name;
		this.price_=price;
		this.description_=description;
		this.size_=size;
		this.origin_=origin;
		this.yearLot_=yearLot;
		this.monthLot_=monthLot;
		this.dayLot_=dayLot;
	}
	public String Name() {return this.name_;}
	public float Price() {return this.price_;}
	public String Description() {return this.description_;}
	public String Size() {return this.size_;}
	public String Origin() {return this.origin_;}
	public String Lot() {
		return ""+this.dayLot_+"-"+this.monthLot_+"-"+this.yearLot_;
		}
}
