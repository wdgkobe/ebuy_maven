package com.wdg.ebuy_maven.web.backstage.admin;

import com.wdg.ebuy_maven.dao.AdminDao;
import com.wdg.ebuy_maven.model.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
@Controller
public class PasswordUpdateController {
    AdminDao adminDao=new AdminDao();
    @RequestMapping(value = "/admin/PasswordUpdate", method = RequestMethod.POST)
    public String updatepassword(){
        return "/admin/toPasswordUpdate";
    }
    @RequestMapping(value="/admin/toPasswordUpdate", method = RequestMethod.POST)
    public String toPasswordUpdate(String oldpass,String newpass,String confirm, HttpSession session){
        Admin admin=(Admin) session.getAttribute("admin");
        if (admin !=null && admin.getPassword().equals(oldpass) && newpass.equals(confirm)) {
            adminDao.uppass(admin.getId(), newpass);
            System.out.println(oldpass + "   " + newpass);
        }else{
            System.out.println("原密码错误或新密码不一致！");
        }
       return "jsp/backstage/admin/password_update.jsp";
    }
}
