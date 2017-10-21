package com.iwcn.master.controllers;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;  
import org.springframework.web.servlet.ModelAndView;

import com.iwcn.master.services.ProductDataBase;
import com.iwcn.master.services.UserService;

@Controller
public class AppController {

    @Autowired
    private ProductDataBase Service;

    
	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("login");
	}

	@RequestMapping("/login")  public ModelAndView login() {
		return new ModelAndView("login");
	}

	@RequestMapping("/home")  public ModelAndView home() {
		return new ModelAndView("home");
	}
    
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @RequestMapping("/productList")
    public ModelAndView showProducts() {
        return new ModelAndView("/productsList").addObject("productList", Service.GetAll());
    }
    
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @RequestMapping("/showProduct")
    public ModelAndView showProduct(@RequestParam Long index) {
        return new ModelAndView("/details").addObject("product", Service.GetProduct(index));
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping("/editCurrProduct")
    public ModelAndView editCurrProduct(@RequestParam String name, @RequestParam float price,
    		@RequestParam String description, @RequestParam String size, @RequestParam String origin,
    		@RequestParam int yearLot, @RequestParam int monthLot, @RequestParam int dayLot,
    		@RequestParam Long index)
    {
    	this.Service.EditProduct(name, price, description, size, origin, yearLot, monthLot, dayLot, index);
    	return new ModelAndView("/productsList").addObject("productList", Service.GetAll());
    }
    
    @Secured({"ROLE_ADMIN"})
    @RequestMapping("/editProduct")
    public ModelAndView editProduct(@RequestParam Long index)
    {
    	return new ModelAndView("/product")
        		.addObject("product", Service.GetProduct(index))
        		.addObject("flag","edit").addObject("productId", index);
    }
    
    @Secured({"ROLE_ADMIN"})
    @RequestMapping("/deleteProduct")
    public ModelAndView deleteProduct(@RequestParam Long index) {
    	Service.DeleteProduct(index);
        return new ModelAndView("/productsList").addObject("productList", Service.GetAll());
    }
    
    @Secured({"ROLE_ADMIN"})
    @RequestMapping("/addCurrProduct")
    public ModelAndView addCurrProduct(@RequestParam String name, @RequestParam float price,
    		@RequestParam String description, @RequestParam String size, @RequestParam String origin,
    		@RequestParam int yearLot, @RequestParam int monthLot, @RequestParam int dayLot) {
    	Service.AddProduct(name, price, description, size, origin, yearLot, monthLot, dayLot);
        return new ModelAndView("/productsList").addObject("productList", Service.GetAll());
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping("/addProduct")
    public ModelAndView addProduct() {
        return new ModelAndView("/product").addObject("flag","add");
    }
    
}
