package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import business.basic.HibBaseDAOImpl;
import business.basic.iHibBaseDAO;
import business.dao.OtherExamineDAO;
import model.TAnswer;
import model.TOtherExamine;

/**
 * 鏉堝懎濮Λ锟界叀娑撴艾濮熺�鐐靛箛缁拷
 * @author zhangyt
 * @version 2019-10-13
 */
@Component("OtherExaminedao")
public class OtherExamineDAOImpl implements OtherExamineDAO {

	//鏉╃偞甯撮弫鐗堝祦鎼存挻鎼锋担婊冪湴閹恒儱褰�鐎圭偟骞囨稉姘娑撳孩鏆熼幑顔炬畱娴溿倖宕�
			private iHibBaseDAO bdao= null; 
			
			public OtherExamineDAOImpl(){
				bdao = new HibBaseDAOImpl();
			}
			
	@Override
	public int addOtherExamine(TOtherExamine ohExamine) {
		// TODO Auto-generated method stub
		return (Integer) bdao.insert(ohExamine);
	}

	@Override
	public boolean deleteOtherExamine(int otherexamineid) {
		// TODO Auto-generated method stub
		TOtherExamine ohExamine = (TOtherExamine) bdao.findById(TOtherExamine.class, otherexamineid);
		return bdao.delete(ohExamine);
	}

	@Override
	public boolean modifyOtherExamine(TOtherExamine ohExamine) {
		// TODO Auto-generated method stub
		return bdao.update(ohExamine);
	}

	@Override
	public List<TOtherExamine> getOtherExamineList(String wherecondition, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		String hql = "from TOtherExamine";
		if (wherecondition == null && wherecondition.equals("")){
			hql += "order by otherexamineitem desc"; 
		}
		if (wherecondition != null && !wherecondition.equals("")){
			hql += "order by otherexamineitem desc"; 
		}
		
		List<TOtherExamine> list = bdao.selectByPage(hql, currentPage, pageSize);
		return list;
	}

	@Override
	public int getOtherExamineAmount(String wherecondition) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from TOtherExamine";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition; 
		}
		return bdao.selectValue(hql);
	}

}
