package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import business.basic.HibBaseDAOImpl;
import business.basic.iHibBaseDAO;
import business.dao.AnswerKeyDAO;
import model.TAnswer;
import model.TAnswerKey;

/**
 * 閸欏倽锟界粵鏃�攳閸忔娊鏁�妞剧瑹閸斺�鐤勯悳鎵
 * @author zhangyt
 * @version 2019-10-13
 */
@Component("answerKeydao")
public class AnswerKeyDAOImpl implements AnswerKeyDAO {
	
	//鏉╃偞甯撮弫鐗堝祦鎼存挻鎼锋担婊冪湴閹恒儱褰�鐎圭偟骞囨稉姘娑撳孩鏆熼幑顔炬畱娴溿倖宕�
			private iHibBaseDAO bdao= null; 
			
			public AnswerKeyDAOImpl(){
				bdao = new HibBaseDAOImpl();
			}
			
	@Override
	public int addAnswerKey(TAnswerKey answerkey) {
		// TODO Auto-generated method stub
		return (Integer) bdao.insert(answerkey);
	}

	@Override
	public boolean deleteAnswerKey(int akeyid) {
		// TODO Auto-generated method stub
		TAnswerKey answerKey = (TAnswerKey) bdao.findById(TAnswerKey.class, akeyid);
		return bdao.delete(answerKey);
	}

	@Override
	public boolean modifyAnswerKey(TAnswerKey answerkey) {
		// TODO Auto-generated method stub
		return bdao.update(answerkey);
	}

	@Override
	public List<TAnswerKey> getAnswerKeyList(String wherecondition, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		String hql = "from TAnswerKey";
		if (wherecondition == null && wherecondition.equals("")){
			hql += "order by answerkey desc"; 
		}
		if (wherecondition != null && !wherecondition.equals("")){
			hql += "order by answerkey desc"; 
		}
		
		List<TAnswerKey> list = bdao.selectByPage(hql, currentPage, pageSize);
		return list;
	}

	@Override
	public int getAnswerKeyAmount(String wherecondition) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from TAnswerKey";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition; 
		}
		return bdao.selectValue(hql);
	}

}
