package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import model.TQuestionType;
import model.TUser;
import business.basic.HibBaseDAOImpl;
import business.basic.iHibBaseDAO;
import business.dao.TQuestionTypeDAO;
/**
 * 用户数据业务实现类
 * @author sunst
 * @version 2019-10-12
 */
@Component("QuestionTypedao")
public class TQuestionTypeDAOImpl implements TQuestionTypeDAO {
	//连接数据库操作层接口,实现业务与数据的交换
	private iHibBaseDAO bdao= null; 
	
	public TQuestionTypeDAOImpl(){
		bdao = new HibBaseDAOImpl();
	}
	
	@Override
	public int addQuestionType(TQuestionType QuestionType) {
		return (Integer) bdao.insert(QuestionType);
	}

	@Override
	public boolean deleteQuestionType(int QuestionTypeid) {
		TQuestionType QuestionType = (TQuestionType) bdao.findById(TQuestionType.class, QuestionTypeid);
		return bdao.delete(QuestionType);
	}

	@Override
	public boolean modifyQuestionType(TQuestionType QuestionType) {
		return bdao.update(QuestionType);
	}

	@Override
	public List<TQuestionType> getQuestionTypeList(String wherecondition,
			int currentPage, int pageSize) {
		String hql = "from TQuestionType";
		if (wherecondition == null && wherecondition.equals("")){
			hql += "order by itemid desc"; 
		}
		if (wherecondition != null && !wherecondition.equals("")){
			hql += "order by itemid desc"; 
		}
		
		List<TQuestionType> list = bdao.selectByPage(hql, currentPage, pageSize);
		return list;
	}

	@Override
	public int getQuestionTypeAmount(String wherecondition) {
		String hql = "select count(*) from TQuestionType";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition; 
		}
		return bdao.selectValue(hql);
	}

}
