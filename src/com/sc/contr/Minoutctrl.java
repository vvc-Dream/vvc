package com.sc.contr;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sc.dao.InputDao;
import com.sc.dao.Outputdao;

@Controller
@Scope("prototype")

public class Minoutctrl {
	
	
	@Resource
	InputDao inputdao;
	@Resource
	Outputdao outputdao;
	


	
	@RequestMapping(value="/minout_analy",method = {RequestMethod.POST,RequestMethod.GET})
	public String minput(HttpServletRequest request,ModelMap m) throws Exception {
		String time =request.getParameter("timeselect");
		System.out.println(time);
		if (time==null) {
			time="2012";
		}
		
		List yearlist=new ArrayList();
		List listaa=inputdao.selectyear();
		for (int i = 0; i < listaa.size(); i++) {
			Map map=(Map)listaa.get(i);
			yearlist.add(map.get("time"));
		}
		
		
		List list=inputdao.selectallInput(time);
		List olist=outputdao.selectalloutput(time);
		System.out.println(list.size());
		ArrayList listm=new ArrayList();
		ArrayList listv=new ArrayList();
		ArrayList olistv=new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			Map map=(Map) list.get(i);
			Map map1=(Map) olist.get(i);
			listm.add(map.get("mon"));
			listv.add(map.get("vat"));
			olistv.add(map1.get("vat"));
		}
		
		
		m.addAttribute("listv", listv);
		m.addAttribute("listm", listm);
		m.addAttribute("olistv", olistv);
		m.addAttribute("yearlist", yearlist);
		return "minout_analy"; 
	}
	

	
}
