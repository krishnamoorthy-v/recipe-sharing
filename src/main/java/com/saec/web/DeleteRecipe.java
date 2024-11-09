package com.saec.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saec.web.dao.RecipeDao;

/**
 * Servlet implementation class DeleteRecipe
 */
@WebServlet("/DeleteRecipe")
public class DeleteRecipe extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("from delete call");
		String id = request.getParameter("id");
		RecipeDao rd = new RecipeDao();
		boolean status = rd.deleteRecipe(id);
		if(status == true) {
			System.out.println("data deleted");
		}
//		RequestDispatcher dispatcher = request.getRequestDispatcher("showRecipe.jsp");
//		dispatcher.forward(request, response);
		
		response.sendRedirect("getRecipe?action=show");
	}

}
