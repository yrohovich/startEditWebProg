package by.htp.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import by.htp.bean.Book;
import by.htp.bean.User;
import by.htp.dao.BaseDao;

public class UserAuthenticationImpl implements BaseDao {
	private static final String URL = "jdbc:mysql://localhost/logindb?"
			+ "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode"
			+ "=false&serverTimezone=UTC&useSSL=false";
	
	public User searchUser(String login, String password) {
		User us = new User();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");			
		} catch (ClassNotFoundException e1) {			
			e1.printStackTrace();
		}
		
		try(Connection cn = DriverManager.getConnection(URL,"root","root")){
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("select * from user");
			
			while(rs.next()) {
				String login1 = rs.getString("login");
				String pass1 = rs.getString("login");
				System.out.println(login1 + " data base");
				if (login1.equals(login) && pass1.equals(password)) {
					us.setLogin(rs.getString("login"));
					us.setPassword(rs.getString("password"));
					us.setRole(rs.getString("role"));
	                System.out.println("успешно нашел, имя:" + us.getLogin() + ", роль: " + us.getRole());
	                
				}
			}			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return us;
	}

	@Override
	public List<Book> searchBookDao(String bookName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> outputBook() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void criate(Book entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editBook(int id, Book book) {
		// TODO Auto-generated method stub
		
	}	
}
