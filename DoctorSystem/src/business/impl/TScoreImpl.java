package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import model.TScore;
import model.TUser;
import business.basic.HibBaseDAOImpl;
import business.basic.iHibBaseDAO;
import business.dao.TScoreDAO;
/**
 * 成绩数据业务实现类
 * @author sunst
 * @version 2019-10-12
 */
@Component("scoredao")
public class TScoreImpl implements TScoreDAO {
	//连接数据库操作层接口,实现业务与数据的交换
	private iHibBaseDAO bdao= null; 
	
	public TScoreImpl(){
		bdao = new HibBaseDAOImpl();
	}
	
	@Override
	public int addScore(TScore score) {
		return (Integer) bdao.insert(score);
	}

	@Override
	public boolean deleteScore(int scoreid) {
		TScore score = (TScore) bdao.findById(TScore.class, scoreid);
		return bdao.delete(score);
	}

	@Override
	public boolean modifyScore(TScore score) {
		return bdao.update(score);
	}

	@Override
	public List<TScore> getScoreList(String wherecondition, int currentPage,
			int pageSize) {
		String hql = "from TScore";
		if (wherecondition == null && wherecondition.equals("")){
			hql += "order by allscore desc"; 
		}
		if (wherecondition != null && !wherecondition.equals("")){
			hql += "order by allscore desc"; 
		}
		
		List<TScore> list = bdao.selectByPage(hql, currentPage, pageSize);
		return list;
	}

	@Override
	public int getScoreAmount(String wherecondition) {
		String hql = "select count(*) from TScore";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition; 
		}
		return bdao.selectValue(hql);
	}

}
