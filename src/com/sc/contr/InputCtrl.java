package com.sc.contr;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.dao.InputDao;
import com.sc.entity.Input;



@Controller
@Scope("prototype")
public class InputCtrl {
	
	//需要注入
	@Resource
	InputDao inputdao;
	
	


	
	//HttpServletRequest request获取
	@RequestMapping(value="/minput",method = {RequestMethod.POST,RequestMethod.GET})
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
		ArrayList listm=new ArrayList();
		ArrayList listv=new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			Map map=(Map) list.get(i);
			listm.add(map.get("mon"));
			listv.add(map.get("vat"));
				
		}
		
		m.addAttribute("listv", listv);
		m.addAttribute("listm", listm);
		m.addAttribute("yearlist", yearlist);
		return "minput"; 
	}
	
//	@RequestMapping("/yinput")
//	public String yinput(Model m) throws Exception {
//		List list=inputdao.selectyearInput();
//		
//		System.out.println(list.size());
//		ArrayList listm=new ArrayList();
//		ArrayList listv=new ArrayList();
//		for (int i = 0; i < list.size(); i++) {
//			Map map=(Map) list.get(i);
//			listm.add(map.get("mon"));
//			listv.add(map.get("vat"));
//				
//		}
//		//把集合放入模型中
//		m.addAttribute("listv", listv);
//		m.addAttribute("listm", listm);
//		return "minput"; //返回页面："/userlist.jsp"
//	}
	
}
