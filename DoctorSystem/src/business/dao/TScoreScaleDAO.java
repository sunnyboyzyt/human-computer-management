package business.dao;

import java.util.List;

import model.TScoreScale;

/**
 * 各项得分占比数据业务接口
 * @author sunst
 * @version 2019-10-12
 */
public interface TScoreScaleDAO {
	/**
	 * 添加一个得分占比
	 * @param ScoreScale 得分占比对象
	 * @return 添加成功返回受影响的行数
	 */
	public int addScoreScale(TScoreScale ScoreScale);
	
	/**
	 * 删除一个得分占比
	 * @param ScoreScale 得分占比对象
	 * @return 添加成功返回受影响的行数
	 */
	public boolean deleteScoreScale(int ScoreScaleid);
	
	/**
	 * 修改一个得分占比
	 * @param ScoreScale 需要修改的得分占比
	 * @return
	 */
	public boolean modifyScoreScale(TScoreScale ScoreScale);
	
	/**
	 * 根据条件获取得分占比的列表
	 * @param wherecondition 组合查询条件字符串,如："ScoreScaleRole = '超级管理员' and ScoreScaleid = 'zhangjs'" 
	 * @param currentPage 按分页查询的当前页
	 * @param pageSize 按分页查询的每页数量
	 * @return List
	 */
	public List<TScoreScale> getScoreScaleList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * 根据条件获取符合条件的得分占比的数量
	 * @param wherecondition 如："ScoreScaleRole = '超级管理员' and ScoreScaleid = 'zhangjs'" 
	 * @return
	 */
	public int getScoreScaleAmount(String wherecondition);
}
