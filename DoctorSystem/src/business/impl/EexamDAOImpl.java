package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import business.basic.HibBaseDAOImpl;
import business.basic.iHibBaseDAO;
import business.dao.EexamDAO;
import model.TAnswer;
import model.TEexam;

/**
 * 閼板啳鐦稉姘鐎圭偟骞囩猾锟� * @author zhangyt
 * @version 2019-10-13
 */
@Component("examdao")
public class EexamDAOImpl implements EexamDAO {
	
	//鏉╃偞甯撮弫鐗堝祦鎼存挻鎼锋担婊冪湴閹恒儱褰�鐎圭偟骞囨稉姘娑撳孩鏆熼幑顔炬畱娴溿倖宕�
	private iHibBaseDAO bdao= null; 
	
	public EexamDAOImpl(){
		bdao = new HibBaseDAOImpl();
	}
			
	@Override
	public int addEexam(TEexam eexam) {
		// TODO Auto-generated method stub
		return (Integer) bdao.insert(eexam);
	}

	@Override
	public boolean deleteEexam(int examid) {
		// TODO Auto-generated method stub
		TEexam eexam = (TEexam) bdao.findById(TEexam.class, examid);
		return bdao.delete(eexam);
	}

	@Override
	public boolean modifyEexam(TEexam eexam) {
		// TODO Auto-generated method stub
		return bdao.update(eexam);
	}

	@Override
	public List<TEexam> getEexamList(String wherecondition, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		String hql = "from TEexam";
		if (wherecondition == null && wherecondition.equals("")){
			hql += "order by userid desc"; 
		}
		if (wherecondition != null && !wherecondition.equals("")){
			hql += "order by userid desc"; 
		}
		
		List<TEexam> list = bdao.selectByPage(hql, currentPage, pageSize);
		return list;
	}

	@Override
	public int getEexamAmount(String wherecondition) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from TEexam";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition; 
		}
		return bdao.selectValue(hql);
	}

}
