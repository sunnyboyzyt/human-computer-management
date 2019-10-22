package business.dao;

import java.util.List;

import model.TExamTime;

/**
 * 考试场次业务接口
 * T_ExamTime
 * @author Zhangyt
 * @version 2010-10-12
 */
public interface ExamTimeDAO {

	/**
	 * 添加一条考试场次
	 * @param examTime 考试场次对象
	 * @return 添加成功返回受影响的行数
	 */
	public int addExamTime(TExamTime examTime);
	
	/**
	 * 删除一条考试场次
	 * @param examtimeid 考试场次对象主键id
	 * @return 成功返回true，失败false
	 */
	public boolean deleteExamTime(int examtimeid);
	
	/**
	 * 修改一条考试场次数据
	 * @param examTime 考试场次对象
	 * @return 成功返回true，失败false
	 */
	public boolean modifyExamTime(TExamTime examTime);
	
	/**
	 * 根据条件获取考试场次列表
	 * @param wherecondtion 组合查询条件字符串
	 * @param currentpage 按分页查询的当前页
	 * @param pageSize 按分页查询的每页数量
	 * @return List
	 */
	public List<TExamTime> getExamTimeList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * 根据条件获取符合条件的考试场次列表数量
	 * @param wherecondtion 组合查询条件字符串
	 * @return 
	 */
	public int getExamTimeAmount(String wherecondition);
	

}

