package com.sc.contr;

import java.io.IOException;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.annotations.Target;
import org.hibernate.mapping.Array;
import org.omg.CORBA.Request;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.opensymphony.xwork2.ActionSupport;


import com.sc.dao.InputDao;
import com.sc.entity.Input;

import net.sf.json.JSONObject;



//@RequestMapping("/input")		//�˴��������·��  ��Ӻ� �������ת��/input/input_analy.do  ��ת��ҳ�����/input/input_analy.jsp ���ص�JS·������ 

@Controller
@Scope("prototype")
public class InputCtrlservlet extends BaseServlet{
	
		//��Ҫע��
		@Resource
		InputDao inputdao;
		
		
		@SuppressWarnings("deprecation")
		@RequestMapping(value="/input_analy",method= RequestMethod.GET)			//��ת·��input_analy.do
		public void input_analy(HttpServletRequest req,
				HttpServletResponse resp)
				throws ServletException, IOException, SQLException {
			req.setCharacterEncoding("utf-8");
			
			System.out.println("����inout_analy");
			
			List<Integer>  list_inputvat = new ArrayList<Integer>();
			List<Integer> list_Months = new ArrayList<Integer>();
			List yearlist=new ArrayList();
			String name=null;
			String good=req.getParameter("goodselect"); 
			//String good=URLDecoder.decode(req.getParameter("goodselect"),"utf-8");
			//String good = new String(req.getParameter("goodselect").getBytes("iso-8859-1"), "utf-8");  
			//String good = new String(good0.getBytes("iso-8859-1"), "utf-8");
			
			System.out.println("123 good:"+good);
			
			String time=req.getParameter("timeselect"); 
			
			if (good==null) {
				name="����";
				time="2012";
			}else {
				//name=new String(good.getBytes("iso-8859-1"), "utf-8");
				name=good;
			}
			
			
			List list=inputdao.selectInput(name,time);
			List<Input> goodlist=inputdao.selectgood();
			List listaa=inputdao.selectyear();
			for (int i = 0; i < listaa.size(); i++) {
				Map map=(Map)listaa.get(i);
				yearlist.add(map.get("time"));
			}
		
			
			
			
			
			
			for (int i = 0; i < list.size(); i++) {
				Input input = (Input) list.get(i);
				Integer temp =input.getTime().getMonth()+1;
				list_Months.add(temp);
				list_inputvat.add(input.getIncomeVat().intValue());
			}
			
			
			req.setAttribute("list_inputvat", list_inputvat);
			//req.setAttribute("list_outputvat", list_outputvat);
			req.setAttribute("name", name);
			
			req.setAttribute("goodlist", goodlist);
			req.setAttribute("yearlist", yearlist);
			req.setAttribute("list_Months", list_Months);
			
			req.getRequestDispatcher("input_analy.jsp").forward(req,resp);
		}
		
		
}
