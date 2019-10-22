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
import business.dao.PersonalDAO;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "Personal")
public class PersonalController {
	
	/**
	 * ʵ�ָ���ʷ����� 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="addPersonal")
	public void Personaladd(
			HttpServletRequest request,
			HttpServletResponse response,
			Model model,
			String grow,
			String menses,
			String fertility,
			String family,
			Integer patientid) throws IOException{
		System.out.println(grow);
		PersonalDAO pdao = DAOFactory.getPersonalDAO();
		TPersonal Personal = new TPersonal();
		ResponseJSON rj = new ResponseJSON();
		
		Personal.setGrow(grow);
		Personal.setMenses(menses);
		Personal.setFertility(fertility);
		Personal.setFamily(family);
		Personal.setPatientid(patientid);
		if(pdao.addPersonal(Personal)>0){
			rj.code = ResponseJSON.FLAG_SUCC;
			rj.msg = "��ӳɹ�";
		}else{
			rj.code = ResponseJSON.FLAG_FAIL;
			rj.msg = "���ʧ�� ";
	}
	}  

	/**
	 * ��ѯ����ʷ 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="getPersonallist")//ӳ��·��,����post����
	public void getPersonallist(
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
		PersonalDAO pdao = DAOFactory.getPersonalDAO();
		List<TPersonal> list = pdao.getTPersonalList(wherecondition, page, limit);
		int size = pdao.getPersonalAmount(wherecondition);
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
	 * ʵ��һ����ʷ��ɾ��
	 * @param id ���
	 * @param request 
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value="deletPersonal")
	public void deletPersonal(Integer personalid,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException{
		PersonalDAO pdao = DAOFactory.getPersonalDAO();
		ResponseJSON rj = new ResponseJSON();
		if (personalid !=null && !personalid.equals("")){
			pdao.deletePersonal(personalid);
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
	
	@RequestMapping(value="modifyPersonal")
	public void modifyPersonal(
			Integer personalid,
			String grow,
			String menses,
			String fertility,
			String family,
			Integer patientid,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException{
		PersonalDAO pdao = DAOFactory.getPersonalDAO();
		TPersonal Personal = new TPersonal();
		ResponseJSON rj = new ResponseJSON();
		Personal.setPersonalid(personalid);;
		Personal.setGrow(grow);
		Personal.setMenses(menses);
		Personal.setFertility(fertility);
		Personal.setFamily(family);
		Personal.setPatientid(patientid);
		if ((pdao.modifyPersonal(Personal))) {
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
