package com.iwcn.master.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.iwcn.master.entities.Product;

import org.springframework.data.repository.CrudRepository;

@Service
public class ProductDataBase {
	
	@Autowired
	private com.iwcn.master.repositories.ProductRepository ProductRepository;

    public void AddProduct(String name, float price, String description, String size, 
    		String origin, int yearLot, int monthLot, int dayLot) {
    	Product newProd = new Product(name,price,description,size,origin,yearLot,monthLot,dayLot);
    	this.ProductRepository.save(newProd);
    }
    public void EditProduct(String name, float price, String description, String size, 
    		String origin, int yearLot, int monthLot, int dayLot, Long index) {
    	Product editedProd = this.ProductRepository.findOne(index)
    			.setAll(name,price,description,size,origin,yearLot,monthLot,dayLot);
    	this.ProductRepository.save(editedProd);
    }
    public void DeleteProduct(Long index) {
    	this.ProductRepository.delete(index);
    }
    public Iterable<Product> GetAll(){
    	return this.ProductRepository.findAll();
    }
    public Product GetProduct(long index) {
    	return this.ProductRepository.findOne(index);
    }
}
