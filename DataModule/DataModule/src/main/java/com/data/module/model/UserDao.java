package com.data.module.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class UserDao {
	
	private JdbcTemplate jdbcTemplate;
	private ResultSetExtractor<User> rowMapper = new ResultSetExtractor<User>() {

		public User extractData(ResultSet arg0) throws SQLException, DataAccessException {
			if (arg0.next()) {
				return new User(arg0.getInt(1), arg0.getString(2));
			} else {
				return null;
			}
		}
	};
	
	
	private ResultSetExtractor<List<User>> allUsers = new ResultSetExtractor<List<User>>(){  
	    public List<User> extractData(ResultSet rs) throws SQLException,  
	            DataAccessException {  
	      
	        List<User> list=new ArrayList<User>();  
	        while(rs.next()){  
	        User e=new User();  
	        e.setId(rs.getInt(1));  
	        e.setName(rs.getString(2));  
	     
	        list.add(e);  
	        }  
	        return list;  
	        }  
	    };
	  
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}  
	  
//	Simple implementation where we are passing the id values
//	public int saveUser(User e){  
//	    String query="insert into User values('"+e.getId()+"','"+e.getName()+"')";  
//	    return jdbcTemplate.update(query);  
//	}  
	
	public Number saveUser(User e){  
	    final String query="insert into User (name)  values(?)";  
	    final String name = e.getName();
	    
	    KeyHolder holder = new GeneratedKeyHolder();
	   
	    jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException 
			{ PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, name);
            return ps;
            }}, holder);  
	    
	    return holder.getKey();
	}  
	public int updateUser(User e){  
	    String query="update User set name='"+e.getName()+"' where id='"+e.getId()+"' ";  
	    return jdbcTemplate.update(query);  
	}  
	public int deleteUser(User e){  
	    String query="delete from User where id='"+e.getId()+"' ";  
	    return jdbcTemplate.update(query);  
	}  
	
	public User findUser(int id){  
	    String query="select * from User where id='"+id+"' ";  
	   
		User user = jdbcTemplate.query(query, rowMapper );
		return user;  
	} 
	
	public List<User> getAll(int id){  
	    String query="select * from User";  
	   
		List<User> user = jdbcTemplate.query(query, allUsers );
		return user;  
	}

}
