package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import business.basic.HibBaseDAOImpl;
import business.basic.iHibBaseDAO;
import business.dao.ExamTimeDAO;
import model.TExamTime;

/**
 * 閼板啳鐦崷鐑橆偧娑撴艾濮熺�鐐靛箛缁拷
 * @author zhangyt
 * @version 2019-10-13
 */
@Component("ExamTimedao")
public class ExamTimeDAOImpl implements ExamTimeDAO {
	
	//鏉╃偞甯撮弫鐗堝祦鎼存挻鎼锋担婊冪湴閹恒儱褰�鐎圭偟骞囨稉姘娑撳孩鏆熼幑顔炬畱娴溿倖宕�
			private iHibBaseDAO bdao= null; 
			
			public ExamTimeDAOImpl(){
				bdao = new HibBaseDAOImpl();
			}
			
	@Override
	public int addExamTime(TExamTime examTime) {
		// TODO Auto-generated method stub
		return (Integer) bdao.insert(examTime);
	}

	@Override
	public boolean deleteExamTime(int examtimeid) {
		// TODO Auto-generated method stub
		TExamTime examTime = (TExamTime) bdao.findById(TExamTime.class, examtimeid);
		return bdao.delete(examTime);
	}

	@Override
	public boolean modifyExamTime(TExamTime examTime) {
		// TODO Auto-generated method stub
		return bdao.update(examTime);
	}

	@Override
	public List<TExamTime> getExamTimeList(String wherecondition, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		String hql = "from TExamTime";
		if (wherecondition == null && wherecondition.equals("")){
			hql += "order by examtimename desc"; 
		}
		if (wherecondition != null && !wherecondition.equals("")){
			hql += "order by examtimename desc"; 
		}
		
		List<TExamTime> list = bdao.selectByPage(hql, currentPage, pageSize);
		return list;
	}

	@Override
	public int getExamTimeAmount(String wherecondition) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from TExamTime";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition; 
		}
		return bdao.selectValue(hql);
	}

}
