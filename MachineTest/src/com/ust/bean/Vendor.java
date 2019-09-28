package com.ust.bean;

public class Vendor {               //fields
	private int vendorid;
	private String vendorname;
	private String address;
	private String location;
	private String service;
	private String pincode;
	private String isactive;
	private int personid;
	private String name;
	private String department;
	private String email;
	private String phone;
	private int userid;
	private String username;
	private String password;
	
	
	public int getVendorid() {                     //getters and setters
		return vendorid;
	}
	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setVendorid(int vendorid) {
		this.vendorid = vendorid;
	}
	public String getVendorname() {
		return vendorname;
	}
	public void setVendorname(String vendorname) {
		this.vendorname = vendorname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getIsactive() {
		return isactive;
	}
	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}
	public int getPersonid() {
		return personid;
	}
	public void setPersonid(int personid) {
		this.personid = personid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	public Vendor() {                                    //constructor using superclass
		super();
		// TODO Auto-generated constructor stub
	}
	public Vendor(int vendorid, String vendorname, String address,     //parameterized constructor
			String location, String service, String pincode, String isactive) {
		super();
		this.vendorid = vendorid;
		this.vendorname = vendorname;
		this.address = address;
		this.location = location;
		this.service = service;
		this.pincode = pincode;
		this.isactive = isactive;
	}
	public Vendor(String vendorname, String address, String location,
			String service, String pincode, String isactive) {
		super();
		this.vendorname = vendorname;
		this.address = address;
		this.location = location;
		this.service = service;
		this.pincode = pincode;
		this.isactive = isactive;
	}

	public Vendor(int vendorid, int personid, String name, String department,
			String email, String phone) {
		super();
		this.vendorid = vendorid;
		this.personid = personid;
		this.name = name;
		this.department = department;
		this.email = email;
		this.phone = phone;
	}

	public Vendor(int vendorid, String name, String department, String email,
			String phone) {
		super();
		this.vendorid = vendorid;
		this.name = name;
		this.department = department;
		this.email = email;
		this.phone = phone;
	}

	public Vendor(int userid, String username, String password) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
	}

	public Vendor(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {                    //toString method
		return "Vendor [vendorid=" + vendorid + ", vendorname=" + vendorname
				+ ", address=" + address + ", location=" + location
				+ ", service=" + service + ", pincode=" + pincode
				+ ", isactive=" + isactive + ", personid=" + personid
				+ ", name=" + name + ", department=" + department + ", email="
				+ email + ", phone=" + phone + ", userid=" + userid
				+ ", username=" + username + ", password=" + password + "]";
	}
	
	
	
	
	

}
