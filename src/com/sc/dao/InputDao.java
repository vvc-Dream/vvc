package com.sc.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sc.entity.Input;
import com.sc.entity.Users;

@Repository("inputdao")
public class InputDao {
	@Resource(name="hibernateTemplate")
	HibernateTemplate hibernateTemplate;
	
	

	
//查询商品分类
	public List selectgood(){
		List<Input>  list=hibernateTemplate.find("from Input  GROUP BY good ");
		return list;
		
	}
	

	
	
	
	public List selectInput(String good,String time){
		
		List<Input> list=hibernateTemplate.find
		("from Input where good='"+good+"' and Year(time)='"+time+"'");
		
		
		return list;
		
	}
	
	//自定义hibernateTemplate sql语句查询
	
	
	//查询年份分类
	public List selectyear(){
		final String sql="select year(time)AS time FROM input GROUP BY YEAR(time)";
		List list = hibernateTemplate.executeFind(new HibernateCallback() {  
    public Object doInHibernate(Session session) throws HibernateException,  
            SQLException {  
        Query query = session.createSQLQuery(sql).
        addScalar("time").setResultTransformer((Transformers.ALIAS_TO_ENTITY_MAP));    
        List list = query.list();
        
   
		return list;  
}}); 



return list;  
	
	
		
	}
		
	
	
	
	//2012年月度分析
public List selectallInput(String time){
	final String sql="SELECT SUBSTRING(time, 6, 2) AS mon,SUM(IncomeVAT) AS vat," +
			"sum(count) AS counts FROM Input WHERE SUBSTRING(time, 1, 4)='"+time+"'" +
			"GROUP BY SUBSTRING(time, 6, 2)";
	List list = hibernateTemplate.executeFind(new HibernateCallback() {  
        public Object doInHibernate(Session session) throws HibernateException,  
                SQLException {  
            Query query = session.createSQLQuery(sql).
            addScalar("mon") .addScalar("vat") .addScalar("counts").setResultTransformer((Transformers.ALIAS_TO_ENTITY_MAP));    
            List list = query.list();
            
       
			return list;  
    }}); 
    
    
    
    return list;  
		
		
	}


//每种商品年度项额
public List selectyearInput(String good){
	final String sql="select YEAR(time) AS time, sum(IncomeVAT) AS vat  " +
			"from input where input.good='"+good+"' AND input.time between" +
			"'2012-01-1' and '2017-01-01' GROUP BY good,YEAR(time) ";
	List list = hibernateTemplate.executeFind(new HibernateCallback() {  
        public Object doInHibernate(Session session) throws HibernateException,  
                SQLException {  
        	
            Query query = session.createSQLQuery(sql).
            addScalar("time") .addScalar("vat").setResultTransformer((Transformers.ALIAS_TO_ENTITY_MAP));    
            List list = query.list();
            
       
			return list;  
    }}); 
    
    
    
    return list;  
		
		
	}

//每一年全部商品的销项额度
public List selectallyear(){
	final String sql="select YEAR(time) AS time, sum(IncomeVAT) AS vat  from input" +
			" where input.time between'2012-01-1' " +
			"and '2017-01-01'GROUP BY YEAR(time) ;";

	List list = hibernateTemplate.executeFind(new HibernateCallback() {  
        public Object doInHibernate(Session session) throws HibernateException,  
                SQLException {  
        	
            Query query = session.createSQLQuery(sql).
            addScalar("time") .addScalar("vat").setResultTransformer((Transformers.ALIAS_TO_ENTITY_MAP));    
            List list = query.list();
       
			return list;  
    }}); 
    
    
    
    return list;  
		
		
	}


}
