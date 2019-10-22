package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import business.basic.HibBaseDAOImpl;
import business.basic.iHibBaseDAO;
import business.dao.ChiefComplaintDAO;
import model.TChiefComplaint;

/**
 * 娑撴槒鐦旀稉姘鐎圭偟骞囩猾锟� * @author zhangyt
 * @version 2019-10-13
 */
@Component("ChiefComplaintdao")
public class ChiefComplaintDAOImpl implements ChiefComplaintDAO {

	//鏉╃偞甯撮弫鐗堝祦鎼存挻鎼锋担婊冪湴閹恒儱褰�鐎圭偟骞囨稉姘娑撳孩鏆熼幑顔炬畱娴溿倖宕�
			private iHibBaseDAO bdao= null; 
			
			public ChiefComplaintDAOImpl(){
				bdao = new HibBaseDAOImpl();
			}
			
	@Override
	public int addChiefComplaint(TChiefComplaint chiefComplaint) {
		// TODO Auto-generated method stub
		return (Integer) bdao.insert(chiefComplaint);
	}

	@Override
	public boolean deleteChiefComplaint(int chiefComplaintid) {
		// TODO Auto-generated method stub
		TChiefComplaint chiefComplaint = (TChiefComplaint) bdao.findById(TChiefComplaint.class, chiefComplaintid);
		return bdao.delete(chiefComplaint);
	}

	@Override
	public boolean modifyChiefComplaint(TChiefComplaint chiefComplaint) {
		// TODO Auto-generated method stub
		return bdao.update(chiefComplaint);
	}

	@Override
	public List<TChiefComplaint> getChiefComplaintList(String wherecondition, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		String hql = "from TChiefComplaint";
		if (wherecondition == null && wherecondition.equals("")){
			hql += "order by chiefComplaint desc"; 
		}
		if (wherecondition != null && !wherecondition.equals("")){
			hql += "order by chiefComplaint desc"; 
		}
		
		List<TChiefComplaint> list = bdao.selectByPage(hql, currentPage, pageSize);
		return list;
	}

	@Override
	public int getChiefComplaintAmount(String wherecondition) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from TChiefComplaint";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition; 
		}
		return bdao.selectValue(hql);
	}

}
