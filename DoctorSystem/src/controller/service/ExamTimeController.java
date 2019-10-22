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
@RequestMapping(value = "ExamTime")
public class ExamTimeController {
	
	
	/**
	 * ʵ�ֿ��Գ��ε���� 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="addExamTime")
	public void addExamTime(
			HttpServletRequest request,
			HttpServletResponse response,
			Model model,
			String examtimename,
			String begindate,
			String enddate,
			Integer unitid
			) throws IOException{
		ExamTimeDAO Edao = DAOFactory.getExamTimeDAO();
		TExamTime ExamTime = new TExamTime();
		ResponseJSON rj = new ResponseJSON();

		ExamTime.setBegindate(begindate);
		ExamTime.setEnddate(enddate);
		ExamTime.setExamtimename(examtimename);
		ExamTime.setUnitid(unitid);
		if(Edao.addExamTime(ExamTime)>0){
			rj.code = ResponseJSON.FLAG_SUCC;
			rj.msg = "��ӳɹ�";
		}else{
			rj.code = ResponseJSON.FLAG_FAIL;
			rj.msg = "���ʧ�� ";
		}
	}  
	
	/**
	 * ��ѯ���Գ���
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="getExamTimelist")//ӳ��·��,����post����
	public void getExamTimelist(
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
		ExamTimeDAO Edao = DAOFactory.getExamTimeDAO();
		List<TExamTime> list = Edao.getExamTimeList(wherecondition, page, limit);
		int size = Edao.getExamTimeAmount(wherecondition);
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
	 * ʵ�ֿ��Գ��ε�ɾ��
	 * @param id ���
	 * @param request 
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value="deletExamTime")
	public void deletExamTime(
			Integer examtimeid,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException{
		
		ExamTimeDAO Edao = DAOFactory.getExamTimeDAO();
		ResponseJSON rj = new ResponseJSON();
		if (examtimeid !=null && !examtimeid.equals("")){
			Edao.deleteExamTime(examtimeid);
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
	 * ʵ�ֿ���ʱ����޸�
	 * @param id ���
	 * @param request 
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value="modifyExamTime")
	public void modifyOtherExamine(
			Integer examtimeid,
			String examtimename,
			String begindate,
			String enddate,
			Integer unitid,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException{
		ExamTimeDAO Edao = DAOFactory.getExamTimeDAO();
		TExamTime ExamTime = new TExamTime();
		ResponseJSON rj = new ResponseJSON();
		
		ExamTime.setBegindate(begindate);
		ExamTime.setEnddate(enddate);
		ExamTime.setExamtimeid(examtimeid);
		ExamTime.setExamtimename(examtimename);
		ExamTime.setUnitid(unitid);
		if ((Edao.modifyExamTime(ExamTime))) {
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
