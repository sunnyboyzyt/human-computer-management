package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import business.basic.HibBaseDAOImpl;
import business.basic.iHibBaseDAO;
import business.dao.MentalSocietyDAO;
import model.TMentalSociety;

/**
 * 韫囧啰鎮婄粈鍙ョ窗閻樿泛鍠屾稉姘鐎圭偟骞囩猾锟� * @author zhangyt
 * @version 2019-10-13
 */
@Component("MentalSocietydao")
public class MentalSocietyDAOImpl implements MentalSocietyDAO {

	//鏉╃偞甯撮弫鐗堝祦鎼存挻鎼锋担婊冪湴閹恒儱褰�鐎圭偟骞囨稉姘娑撳孩鏆熼幑顔炬畱娴溿倖宕�
			private iHibBaseDAO bdao= null; 
			
			public MentalSocietyDAOImpl(){
				bdao = new HibBaseDAOImpl();
			}
			
	@Override
	public int addMentalSociety(TMentalSociety mentalSociety) {
		// TODO Auto-generated method stub
		return (Integer) bdao.insert(mentalSociety);
	}

	@Override
	public boolean deleteMentalSociety(int mentalsocietyid) {
		// TODO Auto-generated method stub
		TMentalSociety mentalSociety = (TMentalSociety) bdao.findById(TMentalSociety.class, mentalsocietyid);
		return bdao.delete(mentalSociety);
	}

	@Override
	public boolean modifyMentalSociety(TMentalSociety mentalSociety) {
		return bdao.update(mentalSociety);
	}

	@Override
	public List<TMentalSociety> getMentalSocietyList(String wherecondition, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		String hql = "from TMentalSociety";
		if (wherecondition == null && wherecondition.equals("")){
			hql += "order by knowability desc"; 
		}
		if (wherecondition != null && !wherecondition.equals("")){
			hql += "order by knowability desc"; 
		}
		List<TMentalSociety> list = bdao.selectByPage(hql, currentPage, pageSize);
		return list;
	}

	@Override
	public int getMentalSocietyAmount(String wherecondition) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from TMentalSociety";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition; 
		}
		return bdao.selectValue(hql);
	}

}
