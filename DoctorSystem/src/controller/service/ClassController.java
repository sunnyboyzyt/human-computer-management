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
@RequestMapping(value = "Class")
public class ClassController {
	
	
	/**
	 * 实现班级的添加 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="addClass")
	public void addRole(
			HttpServletRequest request,
			HttpServletResponse response,
			Model model,
			String classname,
			String grade
			) throws IOException{
		ClassDAO Cdao = DAOFactory.getClassDAO();
		TClass Class = new TClass();
		ResponseJSON rj = new ResponseJSON();

		Class.setClassname(classname);
		Class.setGrade(grade);
		if(Cdao.addClass(Class)>0){
			rj.code = ResponseJSON.FLAG_SUCC;
			rj.msg = "添加成功";
		}else{
			rj.code = ResponseJSON.FLAG_FAIL;
			rj.msg = "添加失败 ";
		}
	}  
	
	/**
	 * 查询班级
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="getClasslist")//映射路径,拦截post请求
	public void getClasslist(
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
		ClassDAO Cdao = DAOFactory.getClassDAO();
		List<TClass> list = Cdao.getClassList(wherecondition,page, limit);
		int size = Cdao.getClassAmount(wherecondition);
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
	 * 实现班级的删除
	 * @param id 编号
	 * @param request 
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value="deletClass")
	public void deletClass(
			Integer classid,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException{
		
		ClassDAO Cdao = DAOFactory.getClassDAO();
		ResponseJSON rj = new ResponseJSON();
		if (classid !=null && !classid.equals("")){
			Cdao.deleteClass(classid);
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
	 * 实现班级的修改
	 * @param id 编号
	 * @param request 
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value="modifyClass")
	public void modifyClass(
			Integer classid,
			String classname,
			String grade,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException{
		ClassDAO Cdao = DAOFactory.getClassDAO();
		TClass Class = new TClass();
		ResponseJSON rj = new ResponseJSON();
		
		Class.setClassid(classid);
		Class.setClassname(classname);
		Class.setGrade(grade);
		if ((Cdao.modifyClass(Class))) {
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
