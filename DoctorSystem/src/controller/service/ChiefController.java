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
@RequestMapping(value="chief")
public class ChiefController {
	
	/**
	 * ʵ��һ�����ߵ���� 
	 * @param 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="chiefadd")
	public void Chiefadd(
			HttpServletRequest request,
			HttpServletResponse response,
			Model model,
			String symptoms,
			String nature,
			String degree,
			String time,
			Integer number
			) throws IOException{
		
		
		TChiefComplaint chiefmod =new TChiefComplaint();		
		ResponseJSON rj = new ResponseJSON();
		ChiefComplaintDAO chief = DAOFactory.getChiefComplaintDAO();
		chiefmod.setSymptom(symptoms);
		chiefmod.setNature(nature);
		chiefmod.setDegree(degree);
		chiefmod.setContinueddate(time);
		chiefmod.setPatientid(number);
		
		if (chief.addChiefComplaint(chiefmod)>0) {
			rj.code = ResponseJSON.FLAG_SUCC;
			rj.msg = "������ӳɹ�";
		}		
			
		else{
			rj.code = ResponseJSON.FLAG_FAIL;
			rj.msg = "�������ʧ�� ";
	}
	}
	
	/**
	 * ��ѯ���� 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="getchieflist")//ӳ��·��,����post����
	public void getchieflist(
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
		ChiefComplaintDAO chief = DAOFactory.getChiefComplaintDAO();
		List<TChiefComplaint> list = chief.getChiefComplaintList(wherecondition, page, limit);
		int size = chief.getChiefComplaintAmount(wherecondition);
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
	 * ���ߵ�ɾ��
	 * @param id ���
	 * @param request 
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value="deletchief")
	public void deleteAdminUser(Integer chiefComplaintid,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException{
		ChiefComplaintDAO chief = DAOFactory.getChiefComplaintDAO();
		ResponseJSON rj = new ResponseJSON();
		if (chiefComplaintid !=null && !chiefComplaintid.equals("")){
			chief.deleteChiefComplaint(chiefComplaintid);
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
	
	@RequestMapping(value="/modifychief")
	public void modifyAdminUser(
			Integer chiefComplaintid,
			String symptom,
			String nature,
			String degree,
			String continueddate,
			Integer patientid,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException{
		ChiefComplaintDAO chiefComplaintdao = DAOFactory.getChiefComplaintDAO();
		ResponseJSON rj = new ResponseJSON();
		TChiefComplaint chiefmod =new TChiefComplaint();
		chiefmod.setChiefComplaintid(chiefComplaintid);
		chiefmod.setSymptom(symptom);
		chiefmod.setNature(nature);
		chiefmod.setDegree(degree);
		chiefmod.setContinueddate(continueddate);
		chiefmod.setPatientid(patientid);
		if ((chiefComplaintdao.modifyChiefComplaint(chiefmod))) {
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