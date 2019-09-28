package com.ust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.bean.Vendor;
import com.ust.dao.VenderDaoImpl;





@RestController                                       //restcontroller
public class VendorController {
	@Autowired                                        //autowired
	VenderDaoImpl dao;
	
	                                                  //listvendor
	@RequestMapping(value="/api/vendor",method=RequestMethod.GET)
	@ResponseBody
	public List<Vendor> getAllVendors(){
		List list=dao.getVendorDetails();
		return list;
		
		
	}
	                                                  //vendorbyid
	@RequestMapping(value="/api/vendor/{vendorid}",method=RequestMethod.GET)
	@ResponseBody
	public Vendor getVendorById(@PathVariable("vendorid")int vendorid){
		return dao.getByVendorId(vendorid);
		}
	
	                                                  //searchvendor
	@RequestMapping(value = "/api/vendor1/{searchString}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Vendor> findDoc(@PathVariable("searchString") String searchString) {
		
		List list=dao.getBySearch(searchString);
		return list;
	}
	
	
	
	                                                         //insertvendor
	@RequestMapping(value = "/insertvendor", method = { RequestMethod.POST,
			RequestMethod.PUT }, produces = "application/json")
	public void updateProd(@RequestBody Vendor v) {

		if (v.getVendorid() != 0) {
			

			dao.updateVendor(v);
		} else {
			System.out.println("hai");
			dao.insertVendor(v);
		}
		
		
	}                                                         //disablevendor
	
	@RequestMapping(value = "/disablevendor", method = RequestMethod.PUT, produces = "application/json")
	public void disablevendor(@RequestBody Vendor v) {
		dao.disable(v);
	}
	                                                         //validation
	
	@RequestMapping(value="/api/login/{uname}/{upassword}",method=RequestMethod.GET)
	@ResponseBody
	public Vendor getloginById(@PathVariable("uname")String username,@PathVariable("upassword")String password){
		Vendor v=dao.roleChecker(username, password);
		return v;
	}

	
	
}
