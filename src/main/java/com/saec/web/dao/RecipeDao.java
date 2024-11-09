package com.saec.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.saec.web.model.RecipeModel;

public class RecipeDao 
{
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/recipe";
	private static final String USER = "root";
	private static final String PASSWORD = "MYSQL";
	
	public RecipeModel getOneRecipe(String id) {
		RecipeModel rm = new RecipeModel();
		try {
			System.out.println("LOG: Driver Register");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("LOG: Driver Loaded");
			Connection con = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
			Statement stmt = con.createStatement();
			String query = "select * from recipe where id = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			
			try(ResultSet rs = pstmt.executeQuery()) {	
				if(rs.next()) {
					
					rm.setRid( Integer.parseInt(rs.getString("id")));
					rm.setTitle( rs.getString("title"));
					rm.setDescription( rs.getString("description"));
					rm.setImage( rs.getString("image") );
				}
				
			}
			
			stmt.close();
			con.close();
		
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return rm;
	}
	

	public List<RecipeModel> getRecipe()
	{
		
		List<RecipeModel> results = new ArrayList<>();
		
		try {
			System.out.println("LOG: Driver Register");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("LOG: Driver Loaded");
			Connection con = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
			Statement stmt = con.createStatement();
			String query = "select * from recipe";
			
			try(ResultSet rs = stmt.executeQuery(query) ){
				System.out.println("LOG: Query Excuted ");
								
				while(rs.next()) {
					RecipeModel rm = new RecipeModel();
			
					rm.setTitle(rs.getString("title"));
					rm.setDescription(rs.getString("description"));
					rm.setImage(rs.getString("image"));
					rm.setRid(Integer.parseInt(rs.getString("id")));
					
					results.add(rm);
				}
//				System.out.println(results);
				stmt.close();
				con.close();
			}
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
				
		return results;
	}
	
	public boolean postRecipe(String title, String description, String image ) {
		
		
		try {
			System.out.println("LOG: Driver Register");
			System.out.println("LOG: Driver Register");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("LOG: Driver Loaded");
			Connection con = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
			String query = "INSERT into recipe (image, description, title) value( ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, image);
			pstmt.setString(2,  description);
			pstmt.setString(3,  title);
			if( pstmt.executeUpdate() == 0) {
				System.out.println("Data not stored");
				return false;
			}
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		System.out.println("Data stored");
		return true;
	}
	
	public boolean deleteRecipe(String id) {
		
		try {
			System.out.println("LOG: Driver Register");
			System.out.println("LOG: Driver Register");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("LOG: Driver Loaded");
			Connection con = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
			String query = "Delete from recipe where id = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
	
			pstmt.setString(1, id);
			System.out.print("LOG: From Delete");
			if( pstmt.executeUpdate() == 0) {
				return false;
			}
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return true;
	}
	
	public boolean updateRecipe(String id, String title, String image, String description) {
	
		try {
			System.out.println("LOG: Driver Register");
			System.out.println("LOG: Driver Register");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("LOG: Driver Loaded");
			Connection con = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
			String query = "UPDATE recipe set title = ?, image = ? , description = ? where id = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
	
			pstmt.setString(1, title);
			pstmt.setString(2, image);
			pstmt.setString(3, description);
			pstmt.setString(4, id);
			
			System.out.println("LOG: From Update");
			if( pstmt.executeUpdate() == 0) {
				return false;
			}
			
			
		} catch(Exception e) {
			System.out.println(e);
			return false;
		}
		
		return true;
		
	}
	
	
	public boolean updateRecipe(String id, String title, String description) {
		
		try {
			System.out.println("LOG: Driver Register");
			System.out.println("LOG: Driver Register");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("LOG: Driver Loaded");
			Connection con = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
			String query = "UPDATE recipe set title = ?, description = ? where id = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
	
			pstmt.setString(1, title);
			pstmt.setString(2, description);
			pstmt.setString(3, id);
			
			System.out.println("LOG: From Update");
			if( pstmt.executeUpdate() == 0) {
				return false;
			}
			
			
		} catch(Exception e) {
			System.out.println(e);
			return false;
		}
		
		return true;
		
	}
}
