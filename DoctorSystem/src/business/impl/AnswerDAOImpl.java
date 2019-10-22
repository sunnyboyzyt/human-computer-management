package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import business.basic.HibBaseDAOImpl;
import business.basic.iHibBaseDAO;
import business.dao.AnswerDAO;
import model.TAnswer;

	/**
	 * 缁涙棃顣界粵鏃�攳娑撴艾濮熺�鐐靛箛缁拷
	 * @author zhangyt
	 * @version 2019-10-13
	 */
@Component("answerdao")
public class AnswerDAOImpl implements AnswerDAO {
	
	//鏉╃偞甯撮弫鐗堝祦鎼存挻鎼锋担婊冪湴閹恒儱褰�鐎圭偟骞囨稉姘娑撳孩鏆熼幑顔炬畱娴溿倖宕�
		private iHibBaseDAO bdao= null; 
		
		public AnswerDAOImpl(){
			bdao = new HibBaseDAOImpl();
		}
		
	@Override
	public int addAnswer(TAnswer answer) {
		// TODO Auto-generated method stub
		
		return (Integer) bdao.insert(answer);
	}

	@Override
	public boolean deleteAnswer(int answerid) {
		// TODO Auto-generated method stub
		TAnswer answer = (TAnswer) bdao.findById(TAnswer.class, answerid);
		return bdao.delete(answer);
	}

	@Override
	public boolean modifyAnswer(TAnswer answer) {
		// TODO Auto-generated method stub
		return bdao.update(answer);
	}

	@Override
	public List<TAnswer> getAnswersList(String wherecondition, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		String hql = "from TAnswer";
		if (wherecondition == null && wherecondition.equals("")){
			hql += "order by answer desc"; 
		}
		if (wherecondition != null && !wherecondition.equals("")){
			hql += "order by answer desc"; 
		}
		
		List<TAnswer> list = bdao.selectByPage(hql, currentPage, pageSize);
		return list;
	}

	@Override
	public int getAnswersAmount(String wherecondition) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from TAnswer";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition; 
		}
		return bdao.selectValue(hql);
	}

}
