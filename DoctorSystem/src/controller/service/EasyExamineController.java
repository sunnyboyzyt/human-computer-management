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
@RequestMapping(value = "EasyExamine")
public class EasyExamineController {
	
	/**
	 * ʵ�ֳ��������� 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="addEasyExamine")
	public void addEasyExamine(
			HttpServletRequest request,
			HttpServletResponse response,
			Model model,
			String easyexamineitem,
			String easyexamineparam,
			Integer patientid
			) throws IOException{
		EasyExamineDAO Edao = DAOFactory.getEasyExamineDAO();
		TEasyExamine EasyExamine = new TEasyExamine();
		ResponseJSON rj = new ResponseJSON();

		EasyExamine.setEasyexamineitem(easyexamineitem);
		EasyExamine.setEasyexamineparam(easyexamineparam);
		EasyExamine.setPatientid(patientid);
		if(Edao.addEasyExamine(EasyExamine)>0){
			rj.code = ResponseJSON.FLAG_SUCC;
			rj.msg = "��ӳɹ�";
		}else{
			rj.code = ResponseJSON.FLAG_FAIL;
			rj.msg = "���ʧ�� ";
		}
	}  
	
	/**
	 * ��ѯ������
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="getEasyExaminelist")//ӳ��·��,����post����
	public void getEasyExaminelist(
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
		EasyExamineDAO Edao = DAOFactory.getEasyExamineDAO();
		List<TEasyExamine> list = Edao.getEasyExamineList(wherecondition,  page, limit);
		int size = Edao.getEasyExamineAmount(wherecondition);
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
	 * ʵ�ֳ������ɾ��
	 * @param id ���
	 * @param request 
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value="deletEasyExamine")
	public void deletEasyExamine(
			Integer easyexamineid,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException{
		
		EasyExamineDAO Edao = DAOFactory.getEasyExamineDAO();
		ResponseJSON rj = new ResponseJSON();
		if (easyexamineid !=null && !easyexamineid.equals("")){
			Edao.deleteEasyExamine(easyexamineid);
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
	 * ʵ�ֳ�������޸�
	 * @param id ���
	 * @param request 
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value="modifyEasyExamine")
	public void modifyEasyExamine(
			Integer easyexamineid,
			String easyexamineitem,
			String easyexamineparam,
			Integer patientid,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException{
		EasyExamineDAO Edao = DAOFactory.getEasyExamineDAO();
		TEasyExamine EasyExamine = new TEasyExamine();
		ResponseJSON rj = new ResponseJSON();
		
		EasyExamine.setEasyexamineid(easyexamineid);
		EasyExamine.setEasyexamineitem(easyexamineitem);
		EasyExamine.setEasyexamineparam(easyexamineparam);
		EasyExamine.setPatientid(patientid);
		if ((Edao.modifyEasyExamine(EasyExamine))) {
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
