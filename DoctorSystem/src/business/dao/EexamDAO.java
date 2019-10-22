package business.dao;

import java.util.List;

import model.TEexam;

/**
 * 考试业务接口
 * T_Exam
 * @author Zhangyt
 * @version 2010-10-12
 */

public interface EexamDAO {

	/**
	 * 添加一条考试数据
	 * @param eexam 考试对象
	 * @return 添加成功返回受影响的行数
	 */
	public int addEexam(TEexam eexam);
	
	/**
	 * 删除一条考试数据
	 * @param examid 考试对象主键id
	 * @return 成功返回true，失败false
	 */
	public boolean deleteEexam(int examid);
	
	/**
	 * 修改一条考试数据
	 * @param eexam 考试对象
	 * @return 成功返回true，失败false
	 */
	public boolean modifyEexam(TEexam eexam);
	
	/**
	 * 根据条件获取考试列表
	 * @param wherecondtion 组合查询条件字符串
	 * @param currentpage 按分页查询的当前页
	 * @param pageSize 按分页查询的每页数量
	 * @return List
	 */
	public List<TEexam> getEexamList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * 根据条件获取符合条件的考试列表数量
	 * @param wherecondtion 组合查询条件字符串
	 * @return 
	 */
	public int getEexamAmount(String wherecondition);
	

}

