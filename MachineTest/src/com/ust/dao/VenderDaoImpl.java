package com.ust.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ust.bean.Vendor;

public interface VenderDaoImpl {

	//Set Template
	public abstract void setTemplate(JdbcTemplate template);

	//list all vendors

	public abstract List<Vendor> getVendorDetails();

	public abstract Vendor getByVendorId(int vendorid);

	public abstract List<Vendor> getBySearch(String searchString);

	//insert vendor
	public abstract int insertVendor(Vendor v);

	//update vendor
	public abstract int updateVendor(Vendor v);

	//disable vendor
	public abstract int disable(Vendor v);

	//rolechecker
	public abstract Vendor roleChecker(String uname, String upassword);

}