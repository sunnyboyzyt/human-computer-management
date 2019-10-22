package controller.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
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

import util.Expressionuitl;
import util.LayuiTableData;
import util.ResponseJSON;

import com.alibaba.fastjson.JSON;

import business.dao.*;
import business.factory.DAOFactory;

@Controller
@RequestMapping(value="MentalSociety")
public class MentalSocietyController {
	
	/**
	 * 实现一条心理问题的添加 
	 * @param 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="MentalSocietyadd")
	public void MentalSocietydd(
			HttpServletRequest request,
			HttpServletResponse response,
			Model model,
			String self,
			String knowability,
			String mood,
			String sickknow,
			String stress,
			String belief,
			String career,
			String environment,
			String familyrelationship,
			Integer patientid
			) throws IOException{
		
		TMentalSociety MentalSociety =new TMentalSociety();		
		ResponseJSON rj = new ResponseJSON();
		MentalSocietyDAO mdo = DAOFactory.getMentalSocietyDAO();
		MentalSociety.setSelf(self);
		MentalSociety.setKnowability(knowability);
		MentalSociety.setMood(mood);
		MentalSociety.setSickknow(sickknow);
		MentalSociety.setStress(stress);
		MentalSociety.setBelief(belief);
		MentalSociety.setCareer(career);
		MentalSociety.setEnvironment(environment);
		MentalSociety.setFamilyrelationship(familyrelationship);
		MentalSociety.setPatientid(patientid);
		if (mdo.addMentalSociety(MentalSociety)>0) {
			rj.code = ResponseJSON.FLAG_SUCC;
			rj.msg = "主诉添加成功";
		}		
			
		else{
			rj.code = ResponseJSON.FLAG_FAIL;
			rj.msg = "主诉添加失败 ";
		}
	}
	
	/**
	 * 查询心理问题
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="getMentalSociety")//映射路径,拦截post请求
	public void getMentalSociety(
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
		MentalSocietyDAO mdao = DAOFactory.getMentalSocietyDAO();
		List<TMentalSociety> list = mdao.getMentalSocietyList(wherecondition, page, limit);
		int size = mdao.getMentalSocietyAmount(wherecondition);
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
	 * 心理的删除
	 * @param id 编号
	 * @param request 
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value="deletMentalSociety")
	public void deletMentalSociety(Integer mentalsocietyid,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException{
		MentalSocietyDAO mdao = DAOFactory.getMentalSocietyDAO();
		ResponseJSON rj = new ResponseJSON();
		if (mentalsocietyid !=null && !mentalsocietyid.equals("")){
			mdao.deleteMentalSociety(mentalsocietyid);
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
	/**
	 * 心理的修改
	 * @param id 编号
	 * @param request 
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value="modifychiefMental")
	public void modifychiefMental(
			Integer mentalsocietyid,
			String self,
			String knowability,
			String mood,
			String sickknow,
			String stress,
			String belief,
			String career,
			String environment,
			String familyrelationship,
			Integer patientid,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException{
		
		MentalSocietyDAO mdao = DAOFactory.getMentalSocietyDAO();
		ResponseJSON rj = new ResponseJSON();
		TMentalSociety MentalSociety =new TMentalSociety();		
		MentalSociety.setMentalsocietyid(mentalsocietyid);
		MentalSociety.setSelf(self);
		MentalSociety.setKnowability(knowability);
		MentalSociety.setMood(mood);
		MentalSociety.setSickknow(sickknow);
		MentalSociety.setStress(stress);
		MentalSociety.setBelief(belief);
		MentalSociety.setCareer(career);
		MentalSociety.setEnvironment(environment);
		MentalSociety.setFamilyrelationship(familyrelationship);
		MentalSociety.setPatientid(patientid);
		if ((mdao.modifyMentalSociety(MentalSociety))) {
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
