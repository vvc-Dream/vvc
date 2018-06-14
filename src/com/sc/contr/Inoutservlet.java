package com.sc.contr;

import java.io.IOException;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sc.dao.InputDao;
import com.sc.dao.Outputdao;
import com.sc.entity.Input;
import com.sc.entity.Output;

@Controller
@Scope("prototype")
public class Inoutservlet extends BaseServlet{
	
		//需要注入
		@Resource
		InputDao inputdao;
		
		@Resource
		Outputdao outputdao;
		
		
		@SuppressWarnings("deprecation")
		@RequestMapping(value="/inout_analy",method= RequestMethod.GET)			
		public void input_analy(HttpServletRequest req,
				HttpServletResponse resp)
				throws ServletException, IOException, SQLException {
			req.setCharacterEncoding("utf-8");
			
			
			System.out.println("进入inout_analy");
			
			String name=null;
			 String time=null; 
			String good=req.getParameter("goodselect");
			
			System.out.println("123 good:"+good);
			
			if (good==null) {
				name="冰箱";
				time="2012";
			}else {
				name=good;
				time=req.getParameter("timeselect");
			}
			
			
			
			List list=inputdao.selectInput(name,time);
			List<Input> goodlist=inputdao.selectgood();
			
			List olist=outputdao.selectOutput(name,time);
			List listaa=inputdao.selectyear();
			List yearlist=new ArrayList();
			for (int i = 0; i < listaa.size(); i++) {
				Map map=(Map)listaa.get(i);
				yearlist.add(map.get("time"));
			}
		
			
			
			List<Integer>  list_inputvat = new ArrayList<Integer>();
			List<Integer>  list_outputvat = new ArrayList<Integer>();
			List<Integer> list_Months = new ArrayList<Integer>();
			
			
			for (int i = 0; i < list.size(); i++) {
				Input input = (Input) list.get(i);
				Integer temp =input.getTime().getMonth()+1;
				list_Months.add(temp);
				list_inputvat.add(input.getIncomeVat().intValue());
			}
			
			for (int i = 0; i < olist.size(); i++) {
				Output output = (Output) olist.get(i);
				list_outputvat.add(output.getIncomeVat().intValue());
			}
			
			
			req.setAttribute("list_inputvat", list_inputvat);
			req.setAttribute("list_outputvat", list_outputvat);
			req.setAttribute("name", name);
			
			req.setAttribute("goodlist", goodlist);
			req.setAttribute("yearlist", yearlist);
			req.setAttribute("list_Months", list_Months);
			
			req.getRequestDispatcher("inout_analy.jsp").forward(req,resp);
		}
		
		
}

