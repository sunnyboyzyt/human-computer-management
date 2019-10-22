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
@RequestMapping(value="patient")
public class PatientController {
	/**
	 * 实现一条基本信息的添加 
	 * @param 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="addpatient")
	public void Patientadd(
			HttpServletRequest request,
			HttpServletResponse response,
			Model model,
			String name,
			Integer age,
			Integer genders,
			String job,
			String nationality,
			String birthplace,
			Integer marriages,
			String culture,
			String faith,
			String addr,
			String phone,
			String joindate,
			Integer unitid
			) throws IOException{
		
		
		TPatient patient =new TPatient();				
		ResponseJSON rj = new ResponseJSON();
		PatientDAO patientDAO =DAOFactory.getPatientDAO();	
		String gender = null;
		String marriage =null;
		if(genders==0){
			gender="男";
		}
		if(genders==1){
			gender="女";
		}
		if(marriages==0){
			marriage="是";
		}
		if(marriages==1){
			marriage="否";
		}
		patient.setAddr(addr);
		patient.setAge(age);
		patient.setBirthplace(birthplace);
		patient.setCulture(culture);
		patient.setFaith(faith);
		patient.setGender(gender);
		patient.setJob(job);
		patient.setJoindate(joindate);
		patient.setMarriage(marriage);
		patient.setName(name);
		patient.setNationality(nationality);
		patient.setPhone(phone);
		patient.setUnitid(unitid);
		
		if (patientDAO.addPatient(patient)>0) {
			rj.code = ResponseJSON.FLAG_SUCC;
			rj.msg = "基本情况添加成功";
		}		
			
		else{
			rj.code = ResponseJSON.FLAG_FAIL;
			rj.msg = "基本情况添加失败 ";
		}
	}
	
	
	/**
	 * 查询基本信息
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="getPatientlist")//映射路径,拦截post请求
	public void getPastSicklist(
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
		PatientDAO patientDAO =DAOFactory.getPatientDAO();	
		List<TPatient> list = patientDAO.getTPatientList(wherecondition, page, limit);
		int size = patientDAO.getPatientAmount(wherecondition);
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
	 * 实现基本信息的删除
	 * @param request 
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value="deletPatient")
	public void deletPatient(Integer patientid,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException{
		PatientDAO patientDAO =DAOFactory.getPatientDAO();	
		ResponseJSON rj = new ResponseJSON();
		if (patientid !=null && !patientid.equals("")){
			patientDAO.deletePatient(patientid);
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
	 * 实现病史的修改
	 * @param request 
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value="modifyPatient")
	public void modifyPastSick(
			Integer patientid,
			String name,
			Integer age,
			String gender,
			String job,
			String nationality,
			String birthplace,
			String marriage,
			String culture,
			String faith,
			String addr,
			String phone,
			String joindate,
			Integer unitid,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException{
		PatientDAO patientDAO =DAOFactory.getPatientDAO();	
		TPatient patient =new TPatient();		
		ResponseJSON rj = new ResponseJSON();
		
		patient.setPatientid(patientid);
		patient.setAddr(addr);
		patient.setAge(age);
		patient.setBirthplace(birthplace);
		patient.setCulture(culture);
		patient.setFaith(faith);
		patient.setGender(gender);
		patient.setJob(job);
		patient.setJoindate(joindate);
		patient.setMarriage(marriage);
		patient.setName(name);
		patient.setNationality(nationality);
		patient.setPhone(phone);
		patient.setUnitid(unitid);
		
		if ((patientDAO.modifyPatient(patient))) {
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
