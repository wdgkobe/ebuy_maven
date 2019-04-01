package com.wdg.ebuy_maven.web.backstage;

import com.wdg.ebuy_maven.dao.AdminDao;
import com.wdg.ebuy_maven.model.Admin;
import com.wdg.ebuy_maven.util.SHA;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.security.util.Password;

import javax.servlet.http.HttpSession;

@Controller
public class LoginContronller {
    AdminDao adminDao=new AdminDao();
   @RequestMapping(value = "/backstage/login", method = RequestMethod.POST)
    public String login(String username, String password,HttpSession session){
       Admin admin=adminDao.getAdmin(username,password);
       if(admin !=null) {
           session.setAttribute("admin",admin);
           return "/backstage/index";
       }else{
           return "/jsp/backstage/login.jsp";
       }
   }
    @RequestMapping(value = "/backstage/index")
    public String index(){
        return "/jsp/backstage/main.jsp";
    }
}
