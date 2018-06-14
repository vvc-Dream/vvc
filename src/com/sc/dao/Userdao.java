package com.sc.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sc.entity.Users;

@Repository("userDao")  //添加bean
public class Userdao {
	
	//需要注入
	@Resource(name="hibernateTemplate")
	HibernateTemplate hibernateTemplate;
	
//	public Users login(Users u){
//		Users user=null;
//		List<Users> list=hibernateTemplate.find
//		("from Users where uname=? and upass=?",
//				u.getUname(),
//				u.getUpass());
//		if(list!=null&&list.size()>0){
//			user=list.get(0);
//		}
//		
//		return user;
//		
//	}
	
	//查询所有用户信息
	public List selectUsers(){
		List list=hibernateTemplate.find("from Users");
		System.out.println(list.size());
		return list;
		
	}
	
	//添加用户
	public void saveUser(Users u){
		hibernateTemplate.save(u);
	}
	
	//通过uid获取用户对象
	public Users getUserById(int uid){
	    return hibernateTemplate.get(Users.class, uid);
	}
	
	//修改用户
	public void updateUser(Users u){
		
		hibernateTemplate.update(u);
		
	}

}
