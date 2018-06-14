package com.sc.contr;

import java.io.IOException;
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

import com.sc.dao.Outputdao;

@Controller
@Scope("prototype")
public class Youtputcontrl extends BaseServlet{

		@Resource
		Outputdao outputdao;
		
		
		@SuppressWarnings("deprecation")
		@RequestMapping(value="/youtput_analy",method= RequestMethod.GET)			//Ìø×ªÂ·¾¶input_analy.do
		public void input_analy(HttpServletRequest req,
				HttpServletResponse resp)
				throws ServletException, IOException, SQLException {
			req.setCharacterEncoding("utf-8");
			
			
			String name=null;
			String good=req.getParameter("goodselect"); 
			
			if (good==null) {
				name="±ùÏä";
			}else {
				name=good;
			}
			
			
			ArrayList listy=new ArrayList();
			ArrayList listv=new ArrayList();
			List list=outputdao.selectyearOutput(name);
			List goodlist=outputdao.selectgood();
			
			for (int i = 0; i < list.size(); i++) {
				Map map=(Map) list.get(i);
				listy.add(map.get("time"));
				listv.add(map.get("vat"));
					
			}	
			
			req.setAttribute("name", name);
			
			req.setAttribute("listy", listy);
			req.setAttribute("listv", listv);
			req.setAttribute("goodlist", goodlist);
			
			req.getRequestDispatcher("youtput_analy.jsp").forward(req,resp);
		}
		
		
}

