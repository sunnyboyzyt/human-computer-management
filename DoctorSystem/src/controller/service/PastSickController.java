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
import business.dao.PastSickDAO;
import business.dao.PersonalDAO;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "PastSick")
public class PastSickController {
	
	/**
	 * 实现病史的添加 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="addPastSick")
	public void addPastSick(
			HttpServletRequest request,
			HttpServletResponse response,
			Model model,
			String pasthealth,
			String date,
			String realization,
			String medical,
			String returnsituation,
			String istrauma,
			String issurgery,
			String hospital,
			Integer patientid) throws IOException{
		
		PastSickDAO pdao = DAOFactory.getPastSickDAO();
		TPastSick PastSick = new TPastSick();
		ResponseJSON rj = new ResponseJSON();
		
		
		PastSick.setPasthealth(pasthealth);
		PastSick.setDate(date);
		PastSick.setRealization(realization);
		PastSick.setMedical(medical);
		PastSick.setReturnsituation(returnsituation);
		PastSick.setIstrauma(istrauma);
		PastSick.setIssurgery(issurgery);
		PastSick.setHospital(hospital);
		PastSick.setPatientid(patientid);
		if(pdao.addPastSick(PastSick)>0){
			rj.code = ResponseJSON.FLAG_SUCC;
			rj.msg = "添加成功";
		}else{
			rj.code = ResponseJSON.FLAG_FAIL;
			rj.msg = "添加失败 ";
	}
	}  

	/**
	 * 查询病史 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="getPastSicklist")//映射路径,拦截post请求
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
		PastSickDAO pdao = DAOFactory.getPastSickDAO();
		
		List<TPastSick> list = pdao.getTPastSickList(wherecondition,page, limit);
		int size = pdao.getPastSickAmount(wherecondition);
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
	 * 实现病史的删除
	 * @param request 
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value="deletPastSick")
	public void deletPastSick(Integer pastsickid,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException{
		PastSickDAO pdao = DAOFactory.getPastSickDAO();
		ResponseJSON rj = new ResponseJSON();
		if (pastsickid !=null && !pastsickid.equals("")){
			pdao.deletePastSick(pastsickid);
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
	@RequestMapping(value="modifyPastSick")
	public void modifyPastSick(
			Integer pastsickid,
			String pasthealth,
			String date,
			String realization,
			String medical,
			String returnsituation,
			String istrauma,
			String issurgery,
			String hospital,
			Integer patientid,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException{
		PastSickDAO pdao = DAOFactory.getPastSickDAO();
		TPastSick PastSick = new TPastSick();
		ResponseJSON rj = new ResponseJSON();
		
		PastSick.setPastsickid(pastsickid);
		PastSick.setPasthealth(pasthealth);
		PastSick.setDate(date);
		PastSick.setRealization(realization);
		PastSick.setMedical(medical);
		PastSick.setReturnsituation(returnsituation);
		PastSick.setIstrauma(istrauma);
		PastSick.setIssurgery(issurgery);
		PastSick.setHospital(hospital);
		PastSick.setPatientid(patientid);
		
		if ((pdao.modifyPastSick(PastSick))) {
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
