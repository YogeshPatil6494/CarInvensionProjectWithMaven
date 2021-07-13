package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.beans.CarDetails;

public class CarDao {

  private DataSource dataSource;
  private JdbcTemplate jdbcTemplate;
  private String insertSql,readSql;
  

  public void setDatasource(DataSource datasource)
  {
      this.dataSource=datasource;
      jdbcTemplate=new JdbcTemplate(datasource);
  }

  public void insert(CarDetails cd)
  {
	  insertSql="insert into car values(?,?,?,?)";
      jdbcTemplate.update(insertSql,new Object[]{cd.getMake(),cd.getModel(),cd.getYear(),cd.getSalePrice()});
	  System.out.println("Insert Data Successfully");
	  System.out.println("-------------------------------------------");
  }
  
  public int update(CarDetails cd){  
	    String update="update car set mode='"+cd.getModel()+"',year="+cd.getYear()+",saleprice="+cd.getSalePrice()+" where make='"+cd.getMake()+"'";
	    System.out.println("Data Update successfully  ");
	    System.out.println("-------------------------------------------");
	    return jdbcTemplate.update(update);  
	   
	}  
  public int delete(CarDetails cd)
   {
	  	String delete="delete from car where make='"+cd.getMake()+"' ";  
	  	System.out.println("Data Delete successfully");
	  	System.out.println("-------------------------------------------");
	    return jdbcTemplate.update(delete);  
  }
  
  public int sum(CarDetails cd)
  {
	  String sumq="select sum(saleprice)from car";  
	  return jdbcTemplate.update(sumq);  
  }
  
  
public List<CarDetails> getCardata(){  
 return jdbcTemplate.query("select * from car",new RowMapper<CarDetails>(){  
    @Override  
    public CarDetails mapRow(ResultSet rs, int rownumber) throws SQLException {  
    	  CarDetails car=new CarDetails();  
    	  car.setMake(rs.getString(1));
	      car.setModel(rs.getString(2));
	      car.setYear(rs.getInt(3));
	      car.setSalePrice(rs.getDouble(4));
        return car;  
    }  
    });  
}  
}
