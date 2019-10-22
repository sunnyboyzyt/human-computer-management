package business.dao;

import java.util.List;

import model.TMentalSociety;

/**
 * 心理社会状况业务接口
 * T_MentalSociety
 * @author Zhangyt
 * @version 2010-10-12
 */
public interface MentalSocietyDAO {
	
	/**
	 * 添加一条心理社会状况数据
	 * @param mentalSociety答案对象
	 * @return 添加成功返回受影响的行数
	 */
	public int addMentalSociety(TMentalSociety mentalSociety);
	
	/**
	 * 删除一条心理社会状况数据
	 * @param mentalsocietyid 答案对象主键id
	 * @return 成功返回true，失败false
	 */
	public boolean deleteMentalSociety(int mentalsocietyid);
	
	/**
	 * 修改一条心理社会状况数据
	 * @param mentalSociety 心理社会状况对象
	 * @return 成功返回true，失败false
	 */
	public boolean modifyMentalSociety(TMentalSociety mentalSociety);
	
	/**
	 * 根据条件获取心理社会状况列表
	 * @param wherecondtion 组合查询条件字符串
	 * @param currentpage 按分页查询的当前页
	 * @param pageSize 按分页查询的每页数量
	 * @return List
	 */
	public List<TMentalSociety> getMentalSocietyList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * 根据条件获取符合条件的心理社会状况列表数量
	 * @param wherecondtion 组合查询条件字符串
	 * @return 
	 */
	public int getMentalSocietyAmount(String wherecondition);
	

}
