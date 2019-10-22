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
import business.factory.DAOFactory;


import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "Life")
public class LifeController {
	
	/**
	 * ʵ��һ���ճ��������� 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="Lifeadd")
	public void Lifeadd(
			HttpServletRequest request,
			HttpServletResponse response,
			Model model,
			String diet,
			String excretion,
			String sleep,
			String activity,
			String useself,
			String hobby,
			Integer patientid) throws IOException{
		
		LifeDAO Life = DAOFactory.getLifeDAO();
		TLife Lifemod = new TLife();
		ResponseJSON rj = new ResponseJSON();
		
		Lifemod.setDiet(diet);
		Lifemod.setExcretion(excretion);
		Lifemod.setSleep(sleep);
		Lifemod.setActivity(activity);
		Lifemod.setUseself(useself);
		Lifemod.setHobby(hobby);
		Lifemod.setPatientid(patientid);
		if(Life.addLife(Lifemod)>0){
			rj.code = ResponseJSON.FLAG_SUCC;
			rj.msg = "��ӳɹ�";
		}else{
			rj.code = ResponseJSON.FLAG_FAIL;
			rj.msg = "���ʧ�� ";
	}
	}  

	/**
	 * ��ѯ�ճ��������� 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="getLifelist")//ӳ��·��,����post����
	public void getLifelist(
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
		LifeDAO Life = DAOFactory.getLifeDAO();
		List<TLife> list = Life.getLifeList(wherecondition, page, limit);
		int size = Life.getLifeAmount(wherecondition);
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
	 * ʵ��һ���ճ������ɾ��
	 * @param id ���
	 * @param request 
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value="deletLife")
	public void deleteAdminUser(Integer lifeid,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException{
		LifeDAO Life = DAOFactory.getLifeDAO();
		ResponseJSON rj = new ResponseJSON();
		if (lifeid !=null && !lifeid.equals("")){
			Life.deleteLife(lifeid);
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
	
	@RequestMapping(value="/modifyLife")
	public void modifyAdminUser(
			Integer lifeid,
			String diet,
			String excretion,
			String sleep,
			String activity,
			String useself,
			String hobby,
			Integer patientid,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException{
		LifeDAO Life = DAOFactory.getLifeDAO();
		TLife Lifemod = new TLife();
		ResponseJSON rj = new ResponseJSON();
		Lifemod.setLifeid(lifeid);
		Lifemod.setDiet(diet);
		Lifemod.setExcretion(excretion);
		Lifemod.setSleep(sleep);
		Lifemod.setActivity(activity);
		Lifemod.setUseself(useself);
		Lifemod.setHobby(hobby);
		Lifemod.setPatientid(patientid);
		if ((Life.modifyLife(Lifemod))) {
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
