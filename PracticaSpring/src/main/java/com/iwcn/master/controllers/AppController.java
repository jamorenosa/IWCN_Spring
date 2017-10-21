package com.iwcn.master.controllers;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;  
import org.springframework.web.servlet.ModelAndView;

import com.iwcn.master.services.UserService;

@Controller
public class AppController {

    @Autowired
    private UserService userService;

    @RequestMapping("/productList")
    public ModelAndView showProducts() {
        return new ModelAndView("/productsList").addObject("productList", userService.GetAll());
    }
    
    @RequestMapping("/showProduct")
    public ModelAndView showProduct(@RequestParam int index) {
        return new ModelAndView("/details").addObject("product", userService.GetProduct(index));
    }

    @RequestMapping("/editCurrProduct")
    public ModelAndView editCurrProduct(@RequestParam String name, @RequestParam float price,
    		String description, String size, String origin, int yearLot, int monthLot, int dayLot, int index)
    {
    	this.userService.EditProduct(name, price, description, size, origin, yearLot, monthLot, dayLot, index);
    	return new ModelAndView("/productsList").addObject("productList", userService.GetAll());
    }
    
    @RequestMapping("/editProduct")
    public ModelAndView editProduct(@RequestParam int index)
    {
    	return new ModelAndView("/product")
        		.addObject("product", userService.GetProduct(index))
        		.addObject("flag","edit").addObject("productId", index);
    }
    
    @RequestMapping("/deleteProduct")
    public ModelAndView deleteProduct(@RequestParam int index) {
    	userService.DeleteProduct(index);
        return new ModelAndView("/productsList").addObject("productList", userService.GetAll());
    }
    
    @RequestMapping("/addCurrProduct")
    public ModelAndView addCurrProduct(@RequestParam String name, @RequestParam float price,
    		String description, String size, String origin, int yearLot, int monthLot, int dayLot) {
    	userService.AddProduct(name, price, description, size, origin, yearLot, monthLot, dayLot);
        return new ModelAndView("/productsList").addObject("productList", userService.GetAll());
    }

    @RequestMapping("/addProduct")
    public ModelAndView addProduct() {
        return new ModelAndView("/product").addObject("flag","add");
    }
}
