package business.dao;

import java.util.List;

import model.TAnswerKey;

/**
 * 参考答案关键字业务接口
 * T_AnswerKey
 * @author Zhangyt
 * @version 2010-10-12
 */

public interface AnswerKeyDAO {
	/**
	 * 添加一条关键字参考答案
	 * @param tanswerkey 关键字对象
	 * @return 添加成功返回受影响的行数
	 */
	public int addAnswerKey(TAnswerKey answerkey);
	
	/**
	 * 删除一条关键字参考答案
	 * @param akeyid 关键字主键id
	 * @return 成功返回true，失败flase
	 */
	public boolean deleteAnswerKey(int akeyid);
	
	/**
	 * 修改一条关键字答案
	 * @param answerkey 需要关键字答案对象
	 * @return 成功返回true，失败flase
	 */
	public boolean modifyAnswerKey(TAnswerKey answerkey);
	
	/**
	 * 根据条件获取关键字答案列表
	 * @param wherecondition 组合查询条件字符串,如："userRole = '超级管理员' and userid = 'zhangjs'" 
	 * @param currentPage 按分页查询的当前页
	 * @param pageSize 按分页查询的每页数量
	 * @return List
	 */
	public List<TAnswerKey> getAnswerKeyList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * 根据条件获取符合条件的关键字答案的数量
	 * @param wherecondition 如："userRole = '超级管理员' and userid = 'zhangjs'" 
	 * @return
	 */
	public int getAnswerKeyAmount(String wherecondition);
}

	
