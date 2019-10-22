package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import business.basic.HibBaseDAOImpl;
import business.basic.iHibBaseDAO;
import business.dao.ClassDAO;
import model.TClass;

/**
 * 閻濐厾楠囨稉姘鐎圭偟骞囩猾锟� * @author zhangyt
 * @version 2019-10-13
 */
@Component("classdao")
public class ClassDAOImpl implements ClassDAO {

	//鏉╃偞甯撮弫鐗堝祦鎼存挻鎼锋担婊冪湴閹恒儱褰�鐎圭偟骞囨稉姘娑撳孩鏆熼幑顔炬畱娴溿倖宕�
	private iHibBaseDAO bdao= null; 
	
	public ClassDAOImpl(){
		bdao = new HibBaseDAOImpl();
	}
			
	@Override
	public int addClass(TClass class1) {
		// TODO Auto-generated method stub
		return (Integer) bdao.insert(class1);
	}

	@Override
	public boolean deleteClass(int classid) {
		// TODO Auto-generated method stub
		TClass class1 = (TClass) bdao.findById(TClass.class, classid);
		return bdao.delete(class1);
	}

	@Override
	public boolean modifyClass(TClass class1) {
		// TODO Auto-generated method stub
		return bdao.update(class1);
	}

	@Override
	public List<TClass> getClassList(String wherecondition, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		String hql = "from TClass";
		if (wherecondition == null && wherecondition.equals("")){
			hql += "order by classname desc"; 
		}
		if (wherecondition != null && !wherecondition.equals("")){
			hql += "order by classname desc"; 
		}
		
		List<TClass> list = bdao.selectByPage(hql, currentPage, pageSize);
		return list;
	}

	@Override
	public int getClassAmount(String wherecondition) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from TClass";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition; 
		}
		return bdao.selectValue(hql);
	}

}
