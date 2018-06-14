package com.sc.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sc.entity.Users;

@Repository("userDao")  //���bean
public class Userdao {
	
	//��Ҫע��
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
	
	//��ѯ�����û���Ϣ
	public List selectUsers(){
		List list=hibernateTemplate.find("from Users");
		System.out.println(list.size());
		return list;
		
	}
	
	//����û�
	public void saveUser(Users u){
		hibernateTemplate.save(u);
	}
	
	//ͨ��uid��ȡ�û�����
	public Users getUserById(int uid){
	    return hibernateTemplate.get(Users.class, uid);
	}
	
	//�޸��û�
	public void updateUser(Users u){
		
		hibernateTemplate.update(u);
		
	}

}
