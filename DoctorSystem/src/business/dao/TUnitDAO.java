package business.dao;

import java.util.List;

import model.TUnit;

/**
 * 科室/章节数据业务接口
 * @author sunst
 * @version 2019-10-12
 */
public interface TUnitDAO {
	/**
	 * 添加一个科室/章节
	 * @param unit 科室/章节对象
	 * @return 添加成功返回受影响的行数
	 */
	public int addTUnit(TUnit unit);
	
	/**
	 * 删除一个科室/章节
	 * @param unitid 科室/章节对象
	 * @return 添加成功返回受影响的行数
	 */
	public boolean deleteTUnit(int unitid);
	
	/**
	 * 修改一个科室/章节
	 * @param unit 需要修改的科室/章节对象
	 * @return
	 */
	public boolean modifyTUnit(TUnit unit);
	
	/**
	 * 根据条件获取科室/章节的列表
	 * @param wherecondition 组合查询条件字符串,如："userRole = '超级管理员' and userid = 'zhangjs'" 
	 * @param currentPage 按分页查询的当前页
	 * @param pageSize 按分页查询的每页数量
	 * @return List
	 */
	public List<TUnit> getTUnitList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * 根据条件获取符合条件的科室/章节的数量
	 * @param wherecondition 如："userRole = '超级管理员' and userid = 'zhangjs'" 
	 * @return
	 */
	public int getTUnitAmount(String wherecondition);
}
