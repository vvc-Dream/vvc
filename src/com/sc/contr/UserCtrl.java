package com.sc.contr;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sc.dao.Userdao;
import com.sc.entity.Users;


@Controller
@Scope("prototype")
@RequestMapping("/user")
public class UserCtrl {
	
	//需要注入
	@Resource
	Userdao userDao;
	
	//用户列表方法
	@RequestMapping("/userlist")//请求该方法的路径是:user/userlist.do
	public String userList(Model m) throws Exception {
		List list=userDao.selectUsers();
		//把集合放入模型中
		m.addAttribute("list", list);
		return "userlist"; //返回页面："/userlist.jsp"
	}
	
//	//用户列表方法
//	@RequestMapping("/userlist1")//请求该方法的路径是:user/userlist.do
//	public ModelAndView userList1(ModelAndView mav) throws Exception {
//		List list=userDao.selectUsers();
//		//把集合放入模型中
//		mav.addObject("list", list);
//		mav.setViewName("userlist");
//		return mav; //返回页面："/userlist.jsp"
//	}
//	
//	@RequestMapping("/useractive")//请求该方法的路径是:user/userlist.do
//	public ModelAndView useractive(Users u,ModelAndView mav) throws Exception {
//		System.out.println("---uid:"+u.getUid()+"---active:"+u.getActive());
//		Users u1=userDao.getUserById(u.getUid());
//		u1.setActive(u.getActive());
//		userDao.updateUser(u1);
//		
//		mav.setViewName("redirect:userlist.do");
//		return mav; //返回页面："/userlist.jsp"
//	}
//	

}
