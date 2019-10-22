package controller.service;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
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
@RequestMapping(value = "OtherExamine")
public class OtherExamineController {
	
	/**
	 * 实现辅助检查的添加 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="addOtherExamine")
	public void addOtherExamine(
			HttpServletRequest request,
			HttpServletResponse response,
			Model model,
			String otherexamineitem,
			String otherexamineparam,
			Integer patientid
			) throws IOException{
		OtherExamineDAO Odao = DAOFactory.getOtherExamineDAO();
		TOtherExamine OtherExamine = new TOtherExamine();
		ResponseJSON rj = new ResponseJSON();

		OtherExamine.setOtherexamineitem(otherexamineitem);
		OtherExamine.setOtherexamineparam(otherexamineparam);
		OtherExamine.setPatientid(patientid);
		if(Odao.addOtherExamine(OtherExamine)>0){
			rj.code = ResponseJSON.FLAG_SUCC;
			rj.msg = "添加成功";
		}else{
			rj.code = ResponseJSON.FLAG_FAIL;
			rj.msg = "添加失败 ";
		}
	}  
	
	/**
	 * 查询辅助检查
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="getOtherExaminelist")//映射路径,拦截post请求
	public void getOtherExaminelist(
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
		OtherExamineDAO Odao = DAOFactory.getOtherExamineDAO();
		List<TOtherExamine> list = Odao.getOtherExamineList(wherecondition, page, limit);
		int size = Odao.getOtherExamineAmount(wherecondition);
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
	 * 实现辅助检查的删除
	 * @param id 编号
	 * @param request 
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value="deletOtherExamine")
	public void deletOtherExamine(
			Integer otherexamineid,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException{
		
		OtherExamineDAO Odao = DAOFactory.getOtherExamineDAO();
		ResponseJSON rj = new ResponseJSON();
		if (otherexamineid !=null && !otherexamineid.equals("")){
			Odao.deleteOtherExamine(otherexamineid);
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
	 * 实现辅助检查的修改
	 * @param id 编号
	 * @param request 
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value="modifyOtherExamine")
	public void modifyOtherExamine(
			Integer otherexamineid,
			String otherexamineitem,
			String otherexamineparam,
			Integer patientid,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException{
		OtherExamineDAO Odao = DAOFactory.getOtherExamineDAO();
		TOtherExamine OtherExamine = new TOtherExamine();
		ResponseJSON rj = new ResponseJSON();
		
		OtherExamine.setOtherexamineid(otherexamineid);
		OtherExamine.setOtherexamineitem(otherexamineitem);
		OtherExamine.setOtherexamineparam(otherexamineparam);
		OtherExamine.setPatientid(patientid);
		if ((Odao.modifyOtherExamine(OtherExamine))) {
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
