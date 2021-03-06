package by.htp.controller.action.imple;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.bean.Book;
import by.htp.bean.User;
import by.htp.controller.action.BaseAction;
import by.htp.servis.BookService;

public class OpenBookImple implements BaseAction {
	private BookService servis = new BookService();	
	
	List<Book> list = new ArrayList<>();

	@Override
	public String todoAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int f = Integer.parseInt(request.getParameter("book_id2"));
		list = servis.outputBook();				
		HttpSession session = request.getSession();
		User us = (User)session.getAttribute("user"); 
		request.setAttribute("user_name", us.getLogin());
		System.out.println("us: " + us.getLogin() + ", user: " + us.getLogin());
		request.setAttribute("listbook", list);		
		
		return "/openBook";
		
	}
	
}
