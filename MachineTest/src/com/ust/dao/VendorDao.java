package com.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ust.bean.Vendor;





public class VendorDao implements VenderDaoImpl {
	
	//Jdbc Template
JdbcTemplate template;                                                        

	//Set Template
	
	@Override
	public void setTemplate(JdbcTemplate template) {
		this.template = template;

}
	//list all vendors
	
	
	@Override
	public List<Vendor> getVendorDetails(){
		return template.query("select vendorid,vendorname,location,service,name,department,phone from tb_vendor join tb_contactperson using (vendorid) where isactive='yes'",new RowMapper<Vendor>(){

			@Override
			public Vendor mapRow(ResultSet rs, int row)
					throws SQLException {
				Vendor s=new Vendor();
				s.setVendorid(rs.getInt(1));
				s.setVendorname(rs.getString(2));
				s.setLocation(rs.getString(3));
				s.setService(rs.getString(4));
				s.setName(rs.getString(5));
				s.setDepartment(rs.getString(6));
				s.setPhone(rs.getString(7));
				// TODO Auto-generated method stub
				return s;
			}
			
		});
		
	}
	
	
	//getvendorbyid
	
	
	@Override
	public Vendor getByVendorId(int vendorid){
		String sql="select vendorid,vendorname,location,service,name,department,phone,email,address from tb_vendor join tb_contactperson using (vendorid) where vendorid=?";
		return (Vendor) template.queryForObject(sql, new Object[]{vendorid},new BeanPropertyRowMapper<Vendor>(Vendor.class));
	}
	
	
	//search vendor
	
	
	@Override
	public List<Vendor> getBySearch(String searchString) {

		return template
				.query("select vendorid,vendorname,location,service,name,department,phone from tb_vendor join tb_contactperson using (vendorid) where location like '"
						+ searchString
						+ "%' or name like '"
						+ searchString
						+ "%' or service like '"
						+searchString+"%'and isactive='yes'", new RowMapper<Vendor>() {
					public Vendor mapRow(ResultSet rs, int row)
							throws SQLException {
					Vendor s = new Vendor();
					s.setVendorid(rs.getInt(1));
					s.setVendorname(rs.getString(2));
					s.setLocation(rs.getString(3));
					s.setService(rs.getString(4));
					s.setName(rs.getString(5));
					s.setDepartment(rs.getString(6));
					s.setPhone(rs.getString(7));
					return s;
						
					}
				});

	}
	
	
	
	//insert vendor
	
	@Override
	public int insertVendor(Vendor v) {
		String sql="insert into tb_vendor(vendorname,address,location,service,pincode,isactive)values(?,?,?,?,?,'yes')";
		 template.update(sql, new Object[] { v.getVendorname(),v.getAddress(),v.getLocation(),v.getService(),v.getPincode()});
		 
		String sql1 = "select max(vendorid) from tb_vendor";
		
		int vendorid = template.queryForObject(sql1, Integer.class);

		String sql2 = "insert into tb_contactperson(name,vendorid,department,email,phone) values(?,?,?,?,?)";

		return template.update(sql2, new Object[] {v.getName(),vendorid,v.getDepartment(),v.getEmail(),v.getPhone()});
	}
	
	
	
	//update vendor
	
	@Override
	public int updateVendor(Vendor v){
		String sql="update tb_vendor set vendorname=?,address=?,location=?,service=?,pincode=? where vendorid=?";
	    template.update(sql, new Object[] { v.getVendorname(),v.getAddress(),v.getLocation(),v.getService(),v.getPincode(),v.getVendorid()});
	    
	    String sql1="update tb_contactperson set name=?,department=?,email=?,phone=? where vendorid=?";
	    return template.update(sql1, new Object[] { v.getName(),v.getDepartment(),v.getEmail(),v.getPhone(),v.getVendorid()});
	    
	    
	}
	
	
	
    //disable vendor
	
	@Override
	public int disable(Vendor v) {
		String sql = "update tb_vendor set isActive='n' where vendorId=?";
		return template.update(sql, new Object[] { v.getVendorid() });
	}
	
	
	
	
	
	//rolechecker
	
	@Override
	public Vendor roleChecker(String uname,String upassword) {                                           
		Vendor v=new Vendor();

		String sql = "select userid,username,password from tb_ustlogin where username=? and password=?";

		try {
			System.out.println("hai");
			v =(Vendor) template.queryForObject(sql,new Object[] {uname,upassword},new BeanPropertyRowMapper<Vendor> (Vendor.class));

			

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return v;
}

	
	
	
	
	
	

}
