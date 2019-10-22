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
	 * ʵ�ֽ�ɫ����� 
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
			rj.msg = "��ӳɹ�";
		}else{
			rj.code = ResponseJSON.FLAG_FAIL;
			rj.msg = "���ʧ�� ";
		}
	}  
	
	/**
	 * ��ѯ��ɫ
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="getRolelist")//ӳ��·��,����post����
	public void getRolelist(
						int limit,//һҳ������
						int page,
						String condition,//��ѯ����1
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
		//�ش�json�ַ���
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		LayuiTableData td = new LayuiTableData();
		if (list!=null) {
			td.code = LayuiTableData.FLAG_SUCCC;
			td.count = size;
			td.msg = "��ѯ�ɹ��������" + td.count;
			td.data = list;
		}else{
			   td.code = LayuiTableData.FLAG_FAIL;
			   td.msg = "��ѯʧ��";
	    }
		out.write(JSON.toJSONString(td));
		out.flush();
		out.close();
	}
	
	
	/**
	 * ʵ�ֽ�ɫ��ɾ��
	 * @param id ���
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
			rj.msg = "ɾ���ɹ�";
		}else {
			rj.code = ResponseJSON.FLAG_FAIL;
			rj.msg = "ɾ��ʧ�� ";
		}
		//�ش�json�ַ���
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(rj));
		out.flush();
		out.close();
	}
	
	
	/**
	 * ʵ�ֽ�ɫ���޸�
	 * @param id ���
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
			rj.msg = "�޸ĳɹ�";
		}else {
			rj.code = ResponseJSON.FLAG_FAIL;
			rj.msg = "�޸�ʧ�� ";
		}
		//�ش�json�ַ���
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(rj));
		out.flush();
		out.close();
	}

}
