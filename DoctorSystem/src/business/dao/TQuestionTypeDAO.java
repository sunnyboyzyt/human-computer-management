package business.dao;

import java.util.List;

import model.TQuestionType;

/**
 * 答题项数据业务接口
 * @author sunst
 * @version 2019-10-12
 */
public interface TQuestionTypeDAO {
	/**
	 * 添加一个答题项
	 * @param QuestionType 答题项对象
	 * @return 添加成功返回受影响的行数
	 */
	public int addQuestionType(TQuestionType QuestionType);
	
	/**
	 * 删除一个答题项
	 * @param QuestionType 答题项对象
	 * @return 添加成功返回受影响的行数
	 */
	public boolean deleteQuestionType(int QuestionTypeid);
	
	/**
	 * 修改一个答题项
	 * @param QuestionType 需要修改的答题项
	 * @return
	 */
	public boolean modifyQuestionType(TQuestionType QuestionType);
	
	/**
	 * 根据条件获取答题项的列表
	 * @param wherecondition 组合查询条件字符串,如："QuestionTypeRole = '超级管理员' and QuestionTypeid = 'zhangjs'" 
	 * @param currentPage 按分页查询的当前页
	 * @param pageSize 按分页查询的每页数量
	 * @return List
	 */
	public List<TQuestionType> getQuestionTypeList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * 根据条件获取符合条件的答题项的数量
	 * @param wherecondition 如："QuestionTypeRole = '超级管理员' and QuestionTypeid = 'zhangjs'" 
	 * @return
	 */
	public int getQuestionTypeAmount(String wherecondition);
}
