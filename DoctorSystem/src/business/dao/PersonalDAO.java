package business.dao;
import java.util.List;

import model.TPatient;
import model.TPersonal;


/**
 * 个人史业务接口
 * @author CJJ
 * @version 2019-10-13
 */
public interface PersonalDAO {
	
	/**
	 * 添加一个个人史
	 * @param Personal 个人史对象
	 * @return 添加成功返回受影响的行数
	 */
	public int addPersonal(TPersonal Personal);
	
	/**
	 * 删除一个个人史
	 * @param personalid 个人史对象id
	 * @return 添加成功返回受影响的行数
	 */
	public boolean deletePersonal(int personalid);
	
	/**
	 * 修改一个个人史
	 * @param Personal 需要修改的个人史
	 * @return
	 */
	public boolean modifyPersonal(TPersonal Personal);
	
	/**
	 * 根据条件获取问诊的列表
	 * @param wherecondition 组合查询条件字符串,如："personalid = '病史id' " 
	 * @param currentPage 按分页查询的当前页
	 * @param pageSize 按分页查询的每页数量
	 * @return List
	 */
	public List<TPersonal> getTPersonalList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * 根据条件获取符合条件的问诊的数量
	 * @param wherecondition 如："personalid = '病史id' " 
	 * @return
	 */
	public int getPersonalAmount(String wherecondition);

}
