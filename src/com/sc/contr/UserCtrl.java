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
	
	//��Ҫע��
	@Resource
	Userdao userDao;
	
	//�û��б���
	@RequestMapping("/userlist")//����÷�����·����:user/userlist.do
	public String userList(Model m) throws Exception {
		List list=userDao.selectUsers();
		//�Ѽ��Ϸ���ģ����
		m.addAttribute("list", list);
		return "userlist"; //����ҳ�棺"/userlist.jsp"
	}
	
//	//�û��б���
//	@RequestMapping("/userlist1")//����÷�����·����:user/userlist.do
//	public ModelAndView userList1(ModelAndView mav) throws Exception {
//		List list=userDao.selectUsers();
//		//�Ѽ��Ϸ���ģ����
//		mav.addObject("list", list);
//		mav.setViewName("userlist");
//		return mav; //����ҳ�棺"/userlist.jsp"
//	}
//	
//	@RequestMapping("/useractive")//����÷�����·����:user/userlist.do
//	public ModelAndView useractive(Users u,ModelAndView mav) throws Exception {
//		System.out.println("---uid:"+u.getUid()+"---active:"+u.getActive());
//		Users u1=userDao.getUserById(u.getUid());
//		u1.setActive(u.getActive());
//		userDao.updateUser(u1);
//		
//		mav.setViewName("redirect:userlist.do");
//		return mav; //����ҳ�棺"/userlist.jsp"
//	}
//	

}
