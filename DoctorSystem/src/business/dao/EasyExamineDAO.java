package business.dao;
import java.util.List;

import model.TEasyExamine;

/**
 * 常规检查业务接口
 * T_EasyExamine
 * @author Zhangyt
 * @version 2010-10-12
 */
public interface EasyExamineDAO {
	

	/**
	 * 添加一条检查记录
	 * @param easyexamine 检查对象
	 * @return 添加成功返回受影响的行数
	 */
	public int addEasyExamine(TEasyExamine easyexamine);
	
	/**
	 * 删除一条检查记录
	 * @param easyexamineid 检查对象主键id
	 * @return 成功返回true，失败false
	 */
	public boolean deleteEasyExamine(int easyexamineid);
	
	/**
	 * 修改一条检查记录
	 * @param easyexamine 检查对象
	 * @return 成功返回true，失败false
	 */
	public boolean modifyEasyExamine(TEasyExamine easyexamine);
	
	/**
	 * 根据条件获取检查记录列表
	 * @param wherecondtion 组合查询条件字符串
	 * @param currentpage 按分页查询的当前页
	 * @param pageSize 按分页查询的每页数量
	 * @return List
	 */
	public List<TEasyExamine> getEasyExamineList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * 根据条件获取符合条件的检查数量
	 * @param wherecondtion 组合查询条件字符串
	 * @return 
	 */
	public int getEasyExamineAmount(String wherecondition);
	

}
