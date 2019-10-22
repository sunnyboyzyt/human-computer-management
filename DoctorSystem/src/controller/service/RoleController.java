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
@RequestMapping(value = "Role")
public class RoleController {
	
	/**
	 * 实现角色的添加 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="addRole")
	public void addRole(
			HttpServletRequest request,
			HttpServletResponse response,
			Model model,
			String rolename,
			String roledescription
			) throws IOException{
		TRoleDAO Rdao = DAOFactory.getTRoleDAO();
		TRole role = new TRole();
		ResponseJSON rj = new ResponseJSON();

		role.setRolename(rolename);
		role.setRoledescription(roledescription);
		if(Rdao.addRole(role)>0){
			rj.code = ResponseJSON.FLAG_SUCC;
			rj.msg = "添加成功";
		}else{
			rj.code = ResponseJSON.FLAG_FAIL;
			rj.msg = "添加失败 ";
		}
	}  
	
	/**
	 * 查询角色
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="getRolelist")//映射路径,拦截post请求
	public void getRolelist(
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
		TRoleDAO Rdao = DAOFactory.getTRoleDAO();
		List<TRole> list = Rdao.getRoleList(wherecondition,page, limit);
		int size = Rdao.getRoleAmount(wherecondition);
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
	 * 实现角色的删除
	 * @param id 编号
	 * @param request 
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value="deletRole")
	public void deletRole(
			Integer roleid,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException{
		
		TRoleDAO Rdao = DAOFactory.getTRoleDAO();
		ResponseJSON rj = new ResponseJSON();
		if (roleid !=null && !roleid.equals("")){
			Rdao.deleteRole(roleid);
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
	 * 实现角色的修改
	 * @param id 编号
	 * @param request 
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value="modifyRole")
	public void modifyUser(
			Integer roleid,
			String roledescription,
			String rolename,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException{
		TRoleDAO Rdao = DAOFactory.getTRoleDAO();
		TRole role = new TRole();
		ResponseJSON rj = new ResponseJSON();
		
		role.setRoleid(roleid);
		role.setRoledescription(roledescription);
		role.setRolename(rolename);
		if ((Rdao.modifyRole(role))) {
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
