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

import com.sc.dao.InputDao;
import com.sc.entity.Input;

@Controller
@Scope("prototype")
public class Yinputcontr extends BaseServlet{
	
		//需要注入
		@Resource
		InputDao inputdao;
		
		
		@SuppressWarnings("deprecation")
		@RequestMapping(value="/yinput_analy",method= RequestMethod.GET)			//跳转路径input_analy.do
		public void input_analy(HttpServletRequest req,
				HttpServletResponse resp)
				throws ServletException, IOException, SQLException {
			req.setCharacterEncoding("utf-8");
			
			
			String name=null;
			String good=req.getParameter("goodselect");  
			
			if(good==null) {
				name="冰箱";
			}else {
				name=good;
			}
			
			
			ArrayList listy=new ArrayList();
			ArrayList listv=new ArrayList();
			List list=inputdao.selectyearInput(name);
			List goodlist=inputdao.selectgood();
			
			for (int i = 0; i < list.size(); i++) {
				Map map=(Map) list.get(i);
				listy.add(map.get("time"));
				listv.add(map.get("vat"));
					
			}	
			
			req.setAttribute("name", name);
			
			req.setAttribute("listy", listy);
			req.setAttribute("listv", listv);
			req.setAttribute("goodlist", goodlist);
			
			req.getRequestDispatcher("yinput_analy.jsp").forward(req,resp);
		}
		
		
}

