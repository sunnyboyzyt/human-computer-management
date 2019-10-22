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
@RequestMapping(value = "Unit")
public class UnitController {
	
	/**
	 * 实现章节的添加 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="addUnit")
	public void addUnit(
			HttpServletRequest request,
			HttpServletResponse response,
			Model model,
			String unitcode,
			String unitname
			) throws IOException{
		TUnitDAO Udao = DAOFactory.getTUnitDAO();
		TUnit Unit = new TUnit();
		ResponseJSON rj = new ResponseJSON();

		Unit.setUnitcode(unitcode);
		Unit.setUnitname(unitname);
		if(Udao.addTUnit(Unit)>0){
			rj.code = ResponseJSON.FLAG_SUCC;
			rj.msg = "添加成功";
		}else{
			rj.code = ResponseJSON.FLAG_FAIL;
			rj.msg = "添加失败 ";
		}
	}  
	
	/**
	 * 查询科室
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="getUnitlist")//映射路径,拦截post请求
	public void getUnitlist(
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
		TUnitDAO Udao = DAOFactory.getTUnitDAO();
		List<TUnit> list = Udao.getTUnitList(wherecondition, page, limit);
		int size = Udao.getTUnitAmount(wherecondition);
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
	 * 实现科室的删除
	 * @param id 编号
	 * @param request 
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value="deletUnit")
	public void deletUnit(
			Integer unitid,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException{
		
		TUnitDAO Udao = DAOFactory.getTUnitDAO();
		ResponseJSON rj = new ResponseJSON();
		if (unitid !=null && !unitid.equals("")){
			Udao.deleteTUnit(unitid);
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
	 * 实现章节的修改
	 * @param id 编号
	 * @param request 
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value="modifyUnit")
	public void modifyUnit(
			Integer unitid,
			String unitcode,
			String unitname,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException{
		TUnitDAO Udao = DAOFactory.getTUnitDAO();
		TUnit unit = new TUnit();
		ResponseJSON rj = new ResponseJSON();
		
		unit.setUnitid(unitid);
		unit.setUnitcode(unitcode);
		unit.setUnitname(unitname);
		if ((Udao.modifyTUnit(unit))) {
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
