package controller.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TLife;
import model.TUser;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



import util.Expressionuitl;
import util.LayuiTableData;
import util.ResponseJSON;

import com.alibaba.fastjson.JSON;



import business.dao.LifeDAO;
import business.dao.UserDAO;
import business.factory.DAOFactory;


@Controller
@RequestMapping(value = "user")
public class UserController {
	@RequestMapping(value="loginuser")
	public void login(HttpServletRequest request, HttpServletResponse response, Model model,
			int userid,String pwd) throws IOException{
		
		HttpSession session = request.getSession();
		//����DAOFactory��Spring������ȡAdminUserDAO��Bean
		UserDAO audao = DAOFactory.getUserDAO();
		List<TUser> LoginUser = audao.loginuser(userid, pwd);
		
		ResponseJSON rj = new ResponseJSON();
		if (LoginUser!=null) {
			TUser loginuser = LoginUser.get(0);
			session.setAttribute("loginuser", loginuser);
			rj.code = ResponseJSON.FLAG_SUCC;
			rj.msg = "��¼�ɹ�";
		}else {
			rj.code = ResponseJSON.FLAG_FAIL;
			rj.msg = "��¼ʧ�� ";
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
	 * ʵ��һ���û������ 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="addUser")
	public void addUser(
			HttpServletRequest request,
			HttpServletResponse response,
			Model model,
			Integer userid,
			String name,
			Integer genders,
			String pwd,
			String phone,
			Integer classid,
			Integer roleid,
			String remarks
			) throws IOException{
		
		UserDAO userdao = DAOFactory.getUserDAO();
		TUser user = new TUser();
		ResponseJSON rj = new ResponseJSON();
		int isdelete = 1;
		int photoid = 1;
		String gender = null;
		if(genders==0){
			gender="��";
		}
		if(genders==1){
			gender="Ů";
		}
		user.setClassid(classid);
		user.setGender(gender);
		user.setIsdelete(isdelete);
		user.setName(name);
		user.setPhone(phone);
		user.setPhotoid(photoid);
		user.setPwd(pwd);
		user.setRemarks(remarks);
		user.setRoleid(roleid);
		user.setUserid(userid);
		if(userdao.addUser(user)>0){
			rj.code = ResponseJSON.FLAG_SUCC;
			rj.msg = "��ӳɹ�";
		}else{
			rj.code = ResponseJSON.FLAG_FAIL;
			rj.msg = "���ʧ�� ";
		}
	}  
	
	

	/**
	 * ��ѯ�û� 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="getUserlist")//ӳ��·��,����post����
	public void getUserlist(
						int limit,//һҳ������
						int page,
						Integer isdelete,
						String condition,//��ѯ����1
						HttpServletRequest request,
						HttpServletResponse response,
						Model model) throws IOException{
		Expressionuitl exp = new Expressionuitl();
		if (condition != null && !condition.equals("")) 
			exp.orLike("condition", condition, String.class);
		String wherecondition = exp.toString();
		UserDAO userdao = DAOFactory.getUserDAO();
		List<TUser> list = userdao.getUserList(wherecondition, page, limit);
		int size = userdao.getUserAmount(wherecondition);
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
	 * ʵ���û���ɾ��
	 * @param id ���
	 * @param request 
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value="deletUser")
	public void deletUser(
			Integer userid,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException{
		
		UserDAO userdao = DAOFactory.getUserDAO();
		ResponseJSON rj = new ResponseJSON();
		if (userid !=null && !userid.equals("")){
			userdao.deleteUser(userid);
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
	 * ʵ���û����޸�
	 * @param id ���
	 * @param request 
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value="modifyUser")
	public void modifyUser(
			Integer userid,
			String name,
			String gender,
			String phone,
			Integer classid,
			String remarks,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException{
		UserDAO userdao = DAOFactory.getUserDAO();
		TUser user = new TUser();
		ResponseJSON rj = new ResponseJSON();
		TUser usermod =  userdao.getUserById(userid);
		int isdelete = 1;
		user.setUserid(userid);
		user.setName(name);
		user.setGender(gender);
		user.setClassid(classid);
		user.setPhone(phone);
		user.setRemarks(remarks);
		user.setPwd(usermod.getPwd());
		user.setIsdelete(isdelete);
		user.setPhotoid(usermod.getPhotoid());
		user.setRoleid(usermod.getRoleid());
		if ((userdao.modifyUser(user))) {
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

	/**
	 * �û�������޸�
	 * @param id ���
	 * @param request 
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value="Updetpwd")
	public void Updetpwd(
			Integer userid,
			String newenpwd,
			String oleenpwd,
			String testpwd,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException{
		UserDAO userdao = DAOFactory.getUserDAO();
		ResponseJSON rj = new ResponseJSON();
		HttpSession session = request.getSession();
		TUser loginUser  = (TUser)session.getAttribute("loginuser");
		if(newenpwd!=testpwd){
			rj.code = ResponseJSON.FLAG_FAIL;
			rj.msg = "����������� ";
		}
		else if(oleenpwd!=loginUser.getPwd()){
			rj.code = ResponseJSON.FLAG_FAIL;
			rj.msg = "������� ";
		}
		else if ((userdao.Upedtpwd(userid,newenpwd))) {
			rj.code = ResponseJSON.FLAG_SUCC;
			rj.msg = "�޸ĳɹ�";
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
	 * ͨ�� id��ѯ�û�
	 * @param request
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value="queryUserById")
	public void QueryUserById(
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException{
		
		UserDAO userdao = DAOFactory.getUserDAO();
		ResponseJSON rj = new ResponseJSON();
		int userid = 1001;
		if(userdao.getUserById(userid)!=null){
			rj.code = ResponseJSON.FLAG_SUCC;
			rj.msg = "�ɹ�";
		}
		else{
			rj.code = ResponseJSON.FLAG_FAIL;
			rj.msg = "ʧ�� ";
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
