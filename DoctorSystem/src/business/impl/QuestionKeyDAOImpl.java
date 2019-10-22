package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import model.TPersonal;
import model.TPhoto;
import model.TQuestionKey;
import business.basic.HibBaseDAOImpl;
import business.basic.iHibBaseDAO;
import business.dao.QuestionKeyDAO;
@Component("QuestionKeydao")
public class QuestionKeyDAOImpl implements QuestionKeyDAO {
	
	//连接数据库操作层接口,实现业务与数据的交换
	private iHibBaseDAO bdao= null; 
	
	public QuestionKeyDAOImpl(){
		bdao = new HibBaseDAOImpl();
	}

	@Override
	public int addQuestionKey(TQuestionKey QuestionKey) {
		return (Integer) bdao.insert(QuestionKey);
	}

	@Override
	public boolean deleteQuestionKey(int qkeyid) {
		TQuestionKey QuestionKey = (TQuestionKey) bdao.findById(TQuestionKey.class, qkeyid);
		return bdao.delete(QuestionKey);
	}

	@Override
	public boolean modifyQuestionKey(TQuestionKey QuestionKey) {
		return bdao.update(QuestionKey);
	}

	@Override
	public List<TQuestionKey> getTQuestionKeyList(String wherecondition,
			int currentPage, int pageSize) {
		String hql = "from TQuestionKey";
		if (wherecondition == null && wherecondition.equals("")){
			hql += "order by user desc"; 
		}
		if (wherecondition != null && !wherecondition.equals("")){
			hql += "order by user desc"; 
		}
		
		List<TQuestionKey> list = bdao.selectByPage(hql, currentPage, pageSize);
		return list;
	}

	@Override
	public int getQuestionKeyAmount(String wherecondition) {
		String hql = "select count(*) from TQuestionKey";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition; 
		}
		return bdao.selectValue(hql);
	}

}
