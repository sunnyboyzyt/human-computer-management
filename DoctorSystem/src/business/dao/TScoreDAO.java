package business.dao;

import java.util.List;

import model.TScore;

/**
 * 成绩数据业务接口
 * @author sunst
 * @version 2019-10-12
 */
public interface TScoreDAO {
	/**
	 * 添加一个成绩
	 * @param user 成绩对象
	 * @return 添加成功返回受影响的行数
	 */
	public int addScore(TScore score);
	
	/**
	 * 删除一个成绩
	 * @param scoreid 成绩对象id
	 * @return 添加成功返回受影响的行数
	 */
	public boolean deleteScore(int scoreid);
	
	/**
	 * 修改一个成绩
	 * @param user 需要修改的成绩对象
	 * @return
	 */
	public boolean modifyScore(TScore score);
	
	/**
	 * 根据条件获取学生成绩的列表
	 * @param wherecondition 组合查询条件字符串,如："userRole = '超级管理员' and userid = 'zhangjs'" 
	 * @param currentPage 按分页查询的当前页
	 * @param pageSize 按分页查询的每页数量
	 * @return List
	 */
	public List<TScore> getScoreList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * 根据条件获取符合条件的学生成绩的数量
	 * @param wherecondition 如："userRole = '超级管理员' and userid = 'zhangjs'" 
	 * @return
	 */
	public int getScoreAmount(String wherecondition);
}
