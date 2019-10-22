package business.dao;
import java.util.List;
import model.TAnswer;

/**
	 * 答题答案业务接口
	 * T_Answer
	 * @author Zhangyt
	 * @version 2010-10-12
	 */

public interface AnswerDAO {

	/**
	 * 添加一条答案数据
	 * @param tanswer 答案对象
	 * @return 添加成功返回受影响的行数
	 */
	public int addAnswer(TAnswer answer);
	
	/**
	 * 删除一条答案数据
	 * @param answerid 答案对象主键id
	 * @return 成功返回true，失败false
	 */
	public boolean deleteAnswer(int answerid);
	
	/**
	 * 修改一条答案数据
	 * @param tanswer 答案对象
	 * @return 成功返回true，失败false
	 */
	public boolean modifyAnswer(TAnswer answer);
	
	/**
	 * 根据条件获取答案列表
	 * @param wherecondtion 组合查询条件字符串
	 * @param currentpage 按分页查询的当前页
	 * @param pageSize 按分页查询的每页数量
	 * @return List
	 */
	public List<TAnswer> getAnswersList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * 根据条件获取符合条件的答案列表数量
	 * @param wherecondtion 组合查询条件字符串
	 * @return 
	 */
	public int getAnswersAmount(String wherecondition);
	

}
