package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import model.TScoreScale;
import model.TUser;
import business.basic.HibBaseDAOImpl;
import business.basic.iHibBaseDAO;
import business.dao.TScoreScaleDAO;
/**
 * 各项得分占比数据业务实现类
 * @author sunst
 * @version 2019-10-12
 */
@Component("ScoreScaledao")
public class TScoreScaleDAOImpl implements TScoreScaleDAO {
	//连接数据库操作层接口,实现业务与数据的交换
	private iHibBaseDAO bdao= null; 
	
	public TScoreScaleDAOImpl(){
		bdao = new HibBaseDAOImpl();
	}
	
	@Override
	public int addScoreScale(TScoreScale ScoreScale) {
		return (Integer) bdao.insert(ScoreScale);
	}

	@Override
	public boolean deleteScoreScale(int ScoreScaleid) {
		TScoreScale ScoreScale = (TScoreScale) bdao.findById(TScoreScale.class, ScoreScaleid);
		return bdao.delete(ScoreScale);
	}

	@Override
	public boolean modifyScoreScale(TScoreScale ScoreScale) {
		return bdao.update(ScoreScale);
	}

	@Override
	public List<TScoreScale> getScoreScaleList(String wherecondition,
			int currentPage, int pageSize) {
		String hql = "from TScoreScale";
		if (wherecondition == null && wherecondition.equals("")){
			hql += "order by scorescale desc"; 
		}
		if (wherecondition != null && !wherecondition.equals("")){
			hql += "order by scorescale desc"; 
		}
		
		List<TScoreScale> list = bdao.selectByPage(hql, currentPage, pageSize);
		return list;
	}

	@Override
	public int getScoreScaleAmount(String wherecondition) {
		String hql = "select count(*) from TScoreScale";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition; 
		}
		return bdao.selectValue(hql);
	}

}
