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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sc.dao.InputDao;
import com.sc.dao.Outputdao;
import com.sc.entity.Input;
import com.sc.entity.Output;

@Controller
@Scope("prototype")

public class Yinoutctrl extends BaseServlet{
	
	
	@Resource
	InputDao inputdao;
	@Resource
	Outputdao outputdao;
	


	//所有商品年度对比
	@RequestMapping(value="/yallinout_analy",method = {RequestMethod.POST,RequestMethod.GET})
	public String minput(HttpServletRequest request,ModelMap m) throws Exception {
		
		List list=inputdao.selectallyear();
		List olist=outputdao.selectallyear();
		
		System.err.println("进入yallinout_analy");
		
		ArrayList listy=new ArrayList();
		ArrayList ilistv=new ArrayList();
		ArrayList olistv=new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			Map map=(Map) list.get(i);
			listy.add(map.get("time"));
			ilistv.add(map.get("vat"));
				
		}
		
		for (int i = 0; i < olist.size(); i++) {
			Map map=(Map) olist.get(i);
			olistv.add(map.get("vat"));
		}
		
		m.addAttribute("ilistv", ilistv);	//input
		m.addAttribute("olistv", olistv);	//output
		m.addAttribute("listy", listy);		//时间
	
		
		return "yallinout_analy"; 
	}
	
	
	
		//所有商品年度进项
		@RequestMapping(value="/yallinput_analy",method = {RequestMethod.POST,RequestMethod.GET})
		public String minput1(HttpServletRequest request,ModelMap m) throws Exception {
			
			List list=inputdao.selectallyear();
			
			
			System.err.println("21313进入yallinput_analy");
			
			ArrayList listy=new ArrayList();
			ArrayList ilistv=new ArrayList();
			for (int i = 0; i < list.size(); i++) {
				Map map=(Map) list.get(i);
				listy.add(map.get("time"));
				ilistv.add(map.get("vat"));
					
			}
			
			
			m.addAttribute("ilistv", ilistv);	//input
			m.addAttribute("listy", listy);	//时间
		
			
			return "yallinput_analy"; 
		}
		
		
		
		//所有商品年度销项
		@RequestMapping(value="/yalloutput_analy",method = {RequestMethod.POST,RequestMethod.GET})
		public String minput2(HttpServletRequest request,ModelMap m) throws Exception {
			
			List list=inputdao.selectallyear();
			List olist=outputdao.selectallyear();
			
			System.err.println("进入yallinout_analy");
			
			ArrayList listy=new ArrayList();
			ArrayList ilistv=new ArrayList();
			ArrayList olistv=new ArrayList();
			for (int i = 0; i < list.size(); i++) {
				Map map=(Map) list.get(i);
				listy.add(map.get("time"));
				ilistv.add(map.get("vat"));
					
			}
			
			for (int i = 0; i < olist.size(); i++) {
				Map map=(Map) olist.get(i);
				olistv.add(map.get("vat"));
			}
			
			m.addAttribute("ilistv", ilistv);	//input
			m.addAttribute("olistv", olistv);	//output
			m.addAttribute("listy", listy);		//时间
		
			
			return "yalloutput_analy"; 
		}
	
	
	
	///////////////////////////////////////////////////////////////////////看一下
	
	//单一商品年度对比
	@RequestMapping(value="/yinout_analy",method = {RequestMethod.POST,RequestMethod.GET})
	public String yinout(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException, SQLException {
		
		req.setCharacterEncoding("utf-8");
		
		System.err.println("12312312312  进入yinout_analy 213123");
		
		String name;
		String good=req.getParameter("goodselect");  
		
		if(good==null) {
			name="冰箱";
		}else {
			name=good;
		}
		
		
		List list=inputdao.selectyearInput(name);
		List goodlist=inputdao.selectgood();
		System.out.println("good"+goodlist.size());
		
		List olist=outputdao.selectyearOutput(name);
		
		List listaa=inputdao.selectyear();
		
		List yearlist=new ArrayList();
		
		List list_inputvat = new ArrayList();
		List  list_outputvat = new ArrayList();

		for (int i = 0; i < listaa.size(); i++) {
			Map map=(Map)listaa.get(i);
			yearlist.add(map.get("time"));
		}
		
		
		
		for (int i = 0; i < list.size(); i++) {
			Map map=(Map)list.get(i);
			list_inputvat.add(map.get("vat"));
		}
		
		for (int i = 0; i < olist.size(); i++) {
			Map map=(Map)olist.get(i);
			list_outputvat.add(map.get("vat"));
		}
		
	
		req.setAttribute("name", name);
		req.setAttribute("goodlist", goodlist);
		req.setAttribute("yearlist", yearlist);
		req.setAttribute("list_inputvat", list_inputvat);
		req.setAttribute("list_outputvat", list_outputvat);
		
		return "yinout_analy"; 
	}
	/////////////////////////////////////////////////////
	
}
