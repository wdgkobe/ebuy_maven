package com.wdg.ebuy_maven.web.backstage;
import com.wdg.ebuy_maven.dao.AdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	AdminDao adminDao=new AdminDao();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	    String username=request.getParameter("username");
	    String password=request.getParameter("password");
	    if(adminDao.login(username, password)){
	    	session.setAttribute("name",username);
	    	response.sendRedirect(basePath+"jsp/backstage/main.html");
	    }else{
	    	response.sendRedirect(basePath+"jsp/backstage/login.jsp");
	    }
		
	}

}
