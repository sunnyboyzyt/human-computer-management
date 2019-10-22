package controller.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.*;
import business.dao.*;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value ="NowSick")
public class NowSickController {
	
	/**
	 * 实现现病史的添加 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="addNowSicks")
	public void addNowSick(
			HttpServletRequest request,
			HttpServletResponse response,
			Model model,
			String sicksituation,
			String sickdate,
			String cause,
			String mainsymptom,
			String othersymptom,
			String sickchange,
			String helpprocess,
			Integer patientid) throws IOException{
		  
		TNowSick NowSick = new TNowSick();
		NowSickDAO ndao = DAOFactory.getNowSickDAO();
		ResponseJSON rj = new ResponseJSON();
		
		NowSick.setSicksituation(sicksituation);
		NowSick.setSickdate(sickdate);
		NowSick.setCause(cause);
		NowSick.setMainsymptom(mainsymptom);
		NowSick.setOthersymptom(othersymptom);
		NowSick.setSickchange(sickchange);
		NowSick.setHelpprocess(helpprocess);
		NowSick.setPatientid(patientid);
		if(ndao.addNowSick(NowSick)>0){
			rj.code = ResponseJSON.FLAG_SUCC;
			rj.msg = "添加成功";
		}else{
			rj.code = ResponseJSON.FLAG_FAIL;
			rj.msg = "添加失败 ";
		}
	}  

	/**
	 * 查询现病史 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="getNowSicklist")//映射路径,拦截post请求
	public void getNowSicklist(
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
		NowSickDAO ndao = DAOFactory.getNowSickDAO();	
		List<TNowSick> list = ndao.getNowSickList(wherecondition,page, limit);
		int size = ndao.getNowSickAmount(wherecondition);
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
	 * 实现现病史的删除
	 * @param request 
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value="deletNowSick")
	public void deletNowSick(Integer nowsicktid,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException{
		NowSickDAO ndao = DAOFactory.getNowSickDAO();	
		ResponseJSON rj = new ResponseJSON();
		if (nowsicktid !=null && !nowsicktid.equals("")){
			ndao.deleteNowSick(nowsicktid);
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
	 * 实现现病史的修改
	 * @param request 
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value="modifyNowSick")
	public void modifyNowSick(
			Integer nowsicktid,
			String sicksituation,
			String sickdate,
			String cause,
			String mainsymptom,
			String othersymptom,
			String sickchange,
			String helpprocess,
			Integer patientid,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException{
		TNowSick NowSick = new TNowSick();
		NowSickDAO ndao = DAOFactory.getNowSickDAO();
		ResponseJSON rj = new ResponseJSON();
		
		NowSick.setNowsicktid(nowsicktid);
		NowSick.setSicksituation(sicksituation);
		NowSick.setSickdate(sickdate);
		NowSick.setCause(cause);
		NowSick.setMainsymptom(mainsymptom);
		NowSick.setOthersymptom(othersymptom);
		NowSick.setSickchange(sickchange);
		NowSick.setHelpprocess(helpprocess);
		NowSick.setPatientid(patientid);
		
		if ((ndao.modifyNowSick(NowSick))) {
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
