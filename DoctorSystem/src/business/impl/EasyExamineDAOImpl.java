package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import business.basic.HibBaseDAOImpl;
import business.basic.iHibBaseDAO;
import business.dao.EasyExamineDAO;
import model.TEasyExamine;

/**
 * 鐢瓕顫夊Λ锟界叀娑撴艾濮熺�鐐靛箛缁拷
 * @author zhangyt
 * @version 2019-10-13
 */
@Component("EasyExaminedao")
public class EasyExamineDAOImpl implements EasyExamineDAO {

	//鏉╃偞甯撮弫鐗堝祦鎼存挻鎼锋担婊冪湴閹恒儱褰�鐎圭偟骞囨稉姘娑撳孩鏆熼幑顔炬畱娴溿倖宕�
			private iHibBaseDAO bdao= null; 
			
			public EasyExamineDAOImpl(){
				bdao = new HibBaseDAOImpl();
			}
			
	@Override
	public int addEasyExamine(TEasyExamine easyexamine) {
		// TODO Auto-generated method stub
		return (Integer) bdao.insert(easyexamine);
	}

	@Override
	public boolean deleteEasyExamine(int easyexamineid) {
		// TODO Auto-generated method stub
		TEasyExamine easyexamine = (TEasyExamine) bdao.findById(TEasyExamine.class, easyexamineid);
		return bdao.delete(easyexamine);
	}

	@Override
	public boolean modifyEasyExamine(TEasyExamine easyexamine) {
		// TODO Auto-generated method stub
		return bdao.update(easyexamine);
	}

	@Override
	public List<TEasyExamine> getEasyExamineList(String wherecondition, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		String hql = "from TEasyExamine";
		if (wherecondition == null && wherecondition.equals("")){
			hql += "order by easyexamineitem desc"; 
		}
		if (wherecondition != null && !wherecondition.equals("")){
			hql += "order by easyexamineitem desc"; 
		}
		
		List<TEasyExamine> list = bdao.selectByPage(hql, currentPage, pageSize);
		return list;
	}

	@Override
	public int getEasyExamineAmount(String wherecondition) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from TEasyExamine";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition; 
		}
		return bdao.selectValue(hql);
	}

}
