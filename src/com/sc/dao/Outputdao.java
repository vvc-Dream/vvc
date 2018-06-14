package com.sc.dao;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sc.entity.Input;
import com.sc.entity.Output;


@Repository("outputdao")
public class Outputdao {
	@Resource(name="hibernateTemplate")
	HibernateTemplate hibernateTemplate;
	

	
	
	public List selectgood(){
		List<Output>  list=hibernateTemplate.find("from Output  GROUP BY good ");
		return list;
		
	}
	
	
	
	public List selectOutput(String good,String time){
		
		List<Input> list=hibernateTemplate.find
		("from Output where good='"+good+"' and Year(time)='"+time+"'");
		
		
		return list;
		
	}
	
	//自定义hibernateTemplate sql语句查询
	
	
	
	//查询年份分类
	public List selectyear(){
		final String sql="select year(time)AS time FROM output GROUP BY YEAR(time)";
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
	
	
	
	
	
	public List selectalloutput(String time){
		final String sql="SELECT SUBSTRING(time, 6, 2) AS mon,SUM(IncomeVAT) AS vat," +
				"sum(count) AS counts FROM Output WHERE SUBSTRING(time, 1, 4)='"+time+"'" +
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
	
	
	public List selectyearOutput(String good){
		final String sql="select YEAR(time)AS time, sum(IncomeVAT) AS vat  " +
				"from output where output.good='"+good+"' AND output.time between" +
				"'2012-01-1' and '2016-01-01' GROUP BY good,YEAR(time) ";
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



//每种商品的年销售额度
public List selectyearoutput(String good){
	final String sql="select YEAR(time)AS time, sum(IncomeVAT) AS vat  " +
			"from output where output.good='"+good+"' AND output.time between" +
			"'2012-01-1' and '2016-01-01' GROUP BY good,YEAR(time) ";
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
	final String sql="select YEAR(time) AS time, sum(IncomeVAT) AS vat  from output" +
			" where output.time between'2012-01-1' " +
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

