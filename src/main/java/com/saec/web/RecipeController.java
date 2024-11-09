package com.saec.web;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

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
 * Servlet implementation class RecipeController
 */
@WebServlet(urlPatterns= {"/getRecipe", "/postRecipe"})
@MultipartConfig 
public class RecipeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Do get ");
		String action = request.getParameter("action");
//		System.out.println(Integer.parseInt(id)+" "+action);
		if(action.equals("getOneRecipe") ) {
			String id = request.getParameter("rid");
			if(id.equals("")) {
				id = "-1";
			}
			if( Integer.parseInt(id) > -1) {
				
				System.out.println("To getOneRecipe ");
				RecipeDao rd = new RecipeDao();
				RecipeModel rm = rd.getOneRecipe(id);
				request.setAttribute("recipe_info", rm);
				RequestDispatcher dispatcher = request.getRequestDispatcher("oneRecipe.jsp");
				dispatcher.forward(request, response);
			}
//			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
//			dispatcher.forward(request, response);
			
		} else if(action.equals("show")) {
		
			System.out.println("To Show ");
			RecipeDao rd = new RecipeDao();
			List<RecipeModel> list = rd.getRecipe();
			
			request.setAttribute("recipe_info", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("showRecipe.jsp");
			dispatcher.forward(request, response);
		}
		else {
		System.out.println("Index");
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
		}
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String action = request.getParameter("action");
		System.out.println(action);
		if(action.equals("to create")) {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("postRecipe.jsp");
			dispatcher.forward(request, response);
		} 
		else {
			
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			String base64image = "";
			
			Part filePart = request.getPart("image");	
			System.out.println("Part "+filePart);
			System.out.println(filePart.getSize());
			if(filePart != null && filePart.getSize() > 0) {
				
				byte[] fileContent = new byte[ (int) filePart.getSize()];
				filePart.getInputStream().read(fileContent);
				
				base64image = Base64.getEncoder().encodeToString(fileContent);
				
			}
			
			
//			String image = request.getParameter("image");
			System.out.println("do post: "+ title +" "+ (title == null) +" "+ description +" "+ (description == null) +" "+"base64image"+ "  "+ ( base64image == null));
			if( ! (title == null) && !(description == null) && ! (base64image == null) && !(base64image.equals("")) && !(description.equals("")) && !(base64image.equals("")) ) {
				System.out.println("from post call");
				
				RecipeDao rd = new RecipeDao();
				boolean status = rd.postRecipe(title, description, base64image);
				request.setAttribute("status", "successfully created");
				if(status == true) {
					System.out.println(status);
					
					response.sendRedirect("getRecipe?action=show");
				} 
				
				
			} else {
				
				request.setAttribute("status", "failed to create");
				RequestDispatcher dispatcher = request.getRequestDispatcher("postRecipe.jsp");
				dispatcher.forward(request, response);
				
			}	
			
		}
	}
}
