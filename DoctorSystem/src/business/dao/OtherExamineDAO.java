package business.dao;

import java.util.List;

import model.TOtherExamine;

/**
 * 辅助检查业务接口
 * T_OtherExamine
 * @author Zhangyt
 * @version 2010-10-12
 */
public interface OtherExamineDAO {
	/**
	 * 添加一条辅助检查数据
	 * @param ohExamine 辅助检查对象
	 * @return 添加成功返回受影响的行数
	 */
	public int addOtherExamine(TOtherExamine ohExamine);
	
	/**
	 * 删除一条辅助检查数据
	 * @param otherexamineid 辅助检查对象主键id
	 * @return 成功返回true，失败false
	 */
	public boolean deleteOtherExamine(int otherexamineid);
	
	/**
	 * 修改一条辅助检查数据
	 * @param ohExamine 辅助检查对象
	 * @return 成功返回true，失败false
	 */
	public boolean modifyOtherExamine(TOtherExamine ohExamine);
	
	/**
	 * 根据条件获取辅助检查列表
	 * @param wherecondtion 组合查询条件字符串
	 * @param currentpage 按分页查询的当前页
	 * @param pageSize 按分页查询的每页数量
	 * @return List
	 */
	public List<TOtherExamine> getOtherExamineList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * 根据条件获取符合条件的辅助检查列表数量
	 * @param wherecondtion 组合查询条件字符串
	 * @return 
	 */
	public int getOtherExamineAmount(String wherecondition);
	

}

