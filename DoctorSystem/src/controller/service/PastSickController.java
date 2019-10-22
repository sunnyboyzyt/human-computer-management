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
	 * ʵ�ֲ�ʷ����� 
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
			rj.msg = "��ӳɹ�";
		}else{
			rj.code = ResponseJSON.FLAG_FAIL;
			rj.msg = "���ʧ�� ";
	}
	}  

	/**
	 * ��ѯ��ʷ 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="getPastSicklist")//ӳ��·��,����post����
	public void getPastSicklist(
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
		PastSickDAO pdao = DAOFactory.getPastSickDAO();
		
		List<TPastSick> list = pdao.getTPastSickList(wherecondition,page, limit);
		int size = pdao.getPastSickAmount(wherecondition);
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
	 * ʵ�ֲ�ʷ��ɾ��
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
	 * ʵ�ֲ�ʷ���޸�
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
