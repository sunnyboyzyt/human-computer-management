package business.dao;

import java.util.List;

import model.TLife;

/**
 * 日常生活状况业务接口
 * T_Life
 * @author Zhangyt
 * @version 2010-10-12
 */

public interface LifeDAO {
	/**
	 * 添加一条日常生活情况记录
	 * @param life 日常生活情况对象
	 * @return 添加成功返回受影响的行数
	 */
	public int addLife(TLife life);
	
	/**
	 * 删除一条日常生活情况数据
	 * @param lifeid 日常生活情况对象主键id
	 * @return 成功返回true，失败false
	 */
	public boolean deleteLife(int lifeid);
	
	/**
	 * 修改一条日常生活情况数据
	 * @param life 日常生活情况对象
	 * @return 成功返回true，失败false
	 */
	public boolean modifyLife(TLife life);
	
	/**
	 * 根据条件获取日常生活情况列表
	 * @param wherecondtion 组合查询条件字符串
	 * @param currentpage 按分页查询的当前页
	 * @param pageSize 按分页查询的每页数量
	 * @return List
	 */
	public List<TLife> getLifeList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * 根据条件获取符合条件的日常生活情况列表数量
	 * @param wherecondtion 组合查询条件字符串
	 * @return 
	 */
	public int getLifeAmount(String wherecondition);
	

}
