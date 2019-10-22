package business.dao;

import java.util.List;
import model.TQuestionKey;
/**
 * 成绩业务接口
 * @author CJJ
 * @version 2019-10-13
 */
public interface QuestionKeyDAO {
	
	/**
	 * 添加一个成绩
	 * @param QuestionKey 成绩对象
	 * @return 添加成功返回受影响的行数
	 */
	public int addQuestionKey(TQuestionKey QuestionKey);
	
	/**
	 * 删除一个成绩
	 * @param qkeyid 成绩id
	 * @return 添加成功返回受影响的行数
	 */
	public boolean deleteQuestionKey(int qkeyid);
	
	/**
	 * 修改一个成绩
	 * @param QuestionKey 需要修改的成绩
	 * @return
	 */
	public boolean modifyQuestionKey(TQuestionKey QuestionKey);
	
	/**
	 * 根据条件获取成绩的列表
	 * @param wherecondition 组合查询条件字符串,如："qkey = '假的就卡死' " 
	 * @param currentPage 按分页查询的当前页
	 * @param pageSize 按分页查询的每页数量
	 * @return List
	 */
	public List<TQuestionKey> getTQuestionKeyList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * 根据条件获取符合条件的成绩的数量
	 * @param wherecondition 如："personalid = '病史id' " 
	 * @return
	 */
	public int getQuestionKeyAmount(String wherecondition);

}
