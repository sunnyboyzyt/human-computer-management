package controller.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.*;
import business.dao.LifeDAO;
import business.dao.PersonalDAO;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "Personal")
public class PersonalController {
	
	/**
	 * 实现个人史的添加 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="addPersonal")
	public void Personaladd(
			HttpServletRequest request,
			HttpServletResponse response,
			Model model,
			String grow,
			String menses,
			String fertility,
			String family,
			Integer patientid) throws IOException{
		System.out.println(grow);
		PersonalDAO pdao = DAOFactory.getPersonalDAO();
		TPersonal Personal = new TPersonal();
		ResponseJSON rj = new ResponseJSON();
		
		Personal.setGrow(grow);
		Personal.setMenses(menses);
		Personal.setFertility(fertility);
		Personal.setFamily(family);
		Personal.setPatientid(patientid);
		if(pdao.addPersonal(Personal)>0){
			rj.code = ResponseJSON.FLAG_SUCC;
			rj.msg = "添加成功";
		}else{
			rj.code = ResponseJSON.FLAG_FAIL;
			rj.msg = "添加失败 ";
	}
	}  

	/**
	 * 查询个人史 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="getPersonallist")//映射路径,拦截post请求
	public void getPersonallist(
						int limit,//一页多少条
						int page,
						String condition,//查询条件1
						HttpServletRequest request,
						HttpServletResponse response,
						Model model) throws IOException{
		Expressionuitl exp = new Expressionuitl();
		if (condition != null && !condition.equals("")) 
			exp.orLike("condition", condition, String.class);
		String wherecondition = exp.toString();
		PersonalDAO pdao = DAOFactory.getPersonalDAO();
		List<TPersonal> list = pdao.getTPersonalList(wherecondition, page, limit);
		int size = pdao.getPersonalAmount(wherecondition);
		//回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		LayuiTableData td = new LayuiTableData();
		if (list!=null) {
			td.code = LayuiTableData.FLAG_SUCCC;
			td.count = size;
			td.msg = "查询成功，共查出" + td.count;
			td.data = list;
		}else{
			   td.code = LayuiTableData.FLAG_FAIL;
			   td.msg = "查询失败";
	    }
		out.write(JSON.toJSONString(td));
		out.flush();
		out.close();
	}
	
	/**
	 * 实现一个人史的删除
	 * @param id 编号
	 * @param request 
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value="deletPersonal")
	public void deletPersonal(Integer personalid,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException{
		PersonalDAO pdao = DAOFactory.getPersonalDAO();
		ResponseJSON rj = new ResponseJSON();
		if (personalid !=null && !personalid.equals("")){
			pdao.deletePersonal(personalid);
			rj.code = ResponseJSON.FLAG_SUCC;
			rj.msg = "删除成功";
		}else {
			rj.code = ResponseJSON.FLAG_FAIL;
			rj.msg = "删除失败 ";
		}
		//回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(rj));
		out.flush();
		out.close();
	}
	
	@RequestMapping(value="modifyPersonal")
	public void modifyPersonal(
			Integer personalid,
			String grow,
			String menses,
			String fertility,
			String family,
			Integer patientid,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException{
		PersonalDAO pdao = DAOFactory.getPersonalDAO();
		TPersonal Personal = new TPersonal();
		ResponseJSON rj = new ResponseJSON();
		Personal.setPersonalid(personalid);;
		Personal.setGrow(grow);
		Personal.setMenses(menses);
		Personal.setFertility(fertility);
		Personal.setFamily(family);
		Personal.setPatientid(patientid);
		if ((pdao.modifyPersonal(Personal))) {
			rj.code = ResponseJSON.FLAG_SUCC;
			rj.msg = "修改成功";
		}else {
			rj.code = ResponseJSON.FLAG_FAIL;
			rj.msg = "修改失败 ";
		}
		//回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(rj));
		out.flush();
		out.close();
	}

}
