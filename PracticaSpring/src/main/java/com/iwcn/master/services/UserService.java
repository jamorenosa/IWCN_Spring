package com.iwcn.master.services;

import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class UserService {

    LinkedList<Product> ProductsList_;
    public UserService() {
    	this.ProductsList_ = new LinkedList<Product>();
    }
    public void AddProduct(String name, float price, String description, String size, 
    		String origin, int yearLot, int monthLot, int dayLot) {
    	this.ProductsList_.addLast(new Product(name,price,description,size,origin,yearLot,monthLot,dayLot));
    }
    public void EditProduct(String name, float price, String description, String size, 
    		String origin, int yearLot, int monthLot, int dayLot, int index) {
    	this.ProductsList_.set(index, new Product(name,price,description,size,origin,yearLot,monthLot,dayLot));
    }
    public void DeleteProduct(int ListIndex) {
    	this.ProductsList_.remove(ListIndex);
    }
    public LinkedList<Product> GetAll(){
    	return this.ProductsList_;
    }
    public Product GetProduct(int Index) {
    	return this.ProductsList_.get(Index);
    }
}

