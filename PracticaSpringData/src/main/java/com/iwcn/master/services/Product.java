package com.iwcn.master.services;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	String name_;
	float price_;
	String description_;
	String size_;
	String origin_;
	String reference_;
	int yearLot_;
	int monthLot_;
	int dayLot_;
	protected Product() {}
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
	public Product setAll(String name, float price, String description, String size, String origin, 
			int yearLot, int monthLot, int dayLot) {
		this.name_=name;
		this.price_=price;
		this.description_=description;
		this.size_=size;
		this.origin_=origin;
		this.yearLot_=yearLot;
		this.monthLot_=monthLot;
		this.dayLot_=dayLot;
		return this;
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
