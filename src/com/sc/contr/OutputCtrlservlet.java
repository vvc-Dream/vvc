package com.sc.contr;

import java.io.IOException;
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


import com.sc.dao.Outputdao;
import com.sc.entity.Input;
import com.sc.entity.Output;

import net.sf.json.JSONObject;



//@RequestMapping("/input")		//此处不能添加路径  添加后 后面的跳转是/input/input_analy.do  跳转到页面就是/input/input_analy.jsp 加载的JS路劲报错 

@Controller
@Scope("prototype")
public class OutputCtrlservlet extends BaseServlet{
	
		//需要注入
		@Resource
		Outputdao outputdao;
		
		
		@SuppressWarnings("deprecation")
		@RequestMapping(value="/output_analy",method= RequestMethod.GET)			//跳转路径input_analy.do
		public void input_analy(HttpServletRequest req,
				HttpServletResponse resp)
				throws ServletException, IOException, SQLException {
			req.setCharacterEncoding("utf-8");
			
			
			List<Integer>  list_outputvat = new ArrayList<Integer>();
			List<Integer> list_Months = new ArrayList<Integer>();
			List yearlist=new ArrayList();
			String name=null;
			String good=req.getParameter("goodselect"); 
			
			String time=req.getParameter("timeselect"); 
			
			if (good==null) {
				name="冰箱";
				time="2012";
			}else {
				name=good;
			}
			
			
			List list=outputdao.selectOutput(name, time);
			List<Output> goodlist=outputdao.selectgood();
			List listaa=outputdao.selectyear();
			for (int i = 0; i < listaa.size(); i++) {
				Map map=(Map)listaa.get(i);
				yearlist.add(map.get("time"));
			}
		
			
			
			
			
			
			for (int i = 0; i < list.size(); i++) {
				Output output = (Output) list.get(i);
				Integer temp =output.getTime().getMonth()+1;
				list_Months.add(temp);
				list_outputvat.add(output.getIncomeVat().intValue());
			}
			
			
			req.setAttribute("list_outputvat", list_outputvat);
			req.setAttribute("name", name);
			
			req.setAttribute("goodlist", goodlist);
			req.setAttribute("yearlist", yearlist);
			req.setAttribute("list_Months", list_Months);
			
			req.getRequestDispatcher("output_analy.jsp").forward(req,resp);
		}
		
}
