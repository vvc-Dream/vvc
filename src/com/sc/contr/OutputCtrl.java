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

public class OutputCtrl {
	
	//需要注入
	@Resource
	Outputdao outputdao;
	
	

	
	
	
	@RequestMapping(value="/moutput",method = {RequestMethod.POST,RequestMethod.GET})
	public String output(HttpServletRequest request,ModelMap m) throws Exception {
		
		String time =request.getParameter("timeselect");
		System.out.println(time);
		if (time==null) {
			time="2012";
		}
		List yearlist=new ArrayList();
		List listaa=outputdao.selectyear();
		for (int i = 0; i < listaa.size(); i++) {
			Map map=(Map)listaa.get(i);
			yearlist.add(map.get("time"));
		}
	
		
		List list=outputdao.selectalloutput(time);
		
		ArrayList listm=new ArrayList();
		ArrayList listv=new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			Map map=(Map) list.get(i);
			listm.add(map.get("mon"));
			listv.add(map.get("vat"));
				
		}
		//把集合放入模型中
		m.addAttribute("yearlist", yearlist);
		m.addAttribute("listv", listv);
		m.addAttribute("listm", listm);
		return "moutput"; 
	}

	
	
}
