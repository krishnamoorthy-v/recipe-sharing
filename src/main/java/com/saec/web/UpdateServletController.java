package com.saec.web;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.saec.web.dao.RecipeDao;
import com.saec.web.model.RecipeModel;

/**
 * Servlet implementation class UpdateServletController
 */
@WebServlet(urlPatterns = {"/UpdateServletController", "/getOneRecipe"})
@MultipartConfig 
public class UpdateServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		RecipeDao rd = new RecipeDao();
		RecipeModel rm = rd.getOneRecipe(id);
		request.setAttribute("recipe", rm);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("updateRecipe.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		System.out.println(id+" "+title+" "+description);
		String base64image = "";
		
		Part filePart = request.getPart("image");			
		System.out.println("From update post: "+filePart);
		
		if(filePart != null && filePart.getSize() > 0) {
			
			byte[] fileContent = new byte[ (int) filePart.getSize()];
			filePart.getInputStream().read(fileContent);
			
			base64image = Base64.getEncoder().encodeToString(fileContent);
			
			
			System.out.println("do post: "+ title +" "+ (title == null) +" "+ description +" "+ (description == null) +" "+"base64image"+ "  "+ ( base64image == null));
			if( ! (title == null) && !(description == null) && ! (base64image == null) && !(base64image.equals("")) && !(description.equals("")) && !(base64image.equals("")) ) {
				System.out.println("from update call");
				RecipeDao rd = new RecipeDao();
				boolean status = rd.updateRecipe(id, title, base64image, description);
				
				if(status == true) {
					System.out.println(status);
					request.setAttribute("status", "successfully updated");
				} else {
					
					request.setAttribute("status", "failed to update");
				} 
				
			} else {
				
				request.setAttribute("status", "failed to create");
			}
			
		} else {
			
			
			System.out.println("do post: "+ title +" "+ (title == null) +" "+ description +" "+ (description == null) );
			if( ! (title == null) && !(description == null) && !(description.equals("")) ) {
				System.out.println("from update call");
				RecipeDao rd = new RecipeDao();
				boolean status = rd.updateRecipe(id, title, description);
				
				if(status == true) {
					System.out.println(status);
					request.setAttribute("status", "successfully updated");
				} else {
					
					request.setAttribute("status", "failed to update");
				} 
				
			} else {
				
				request.setAttribute("status", "failed to create");
			}
			
			
		}
		
		
		
		
		
		response.sendRedirect("getRecipe?action=show");
		
	}

}
