package business.dao;

import java.util.List;

import model.TClass;

/**
 * 班级业务接口
 * T_Class
 * @author Zhangyt
 * @version 2010-10-12
 */
public interface ClassDAO {
	/**
	 * 添加一个班级
	 * @param class1  班级对象
	 * @return 添加成功返回受影响的行数
	 */
	public int addClass(TClass class1);
	
	/**
	 * 删除一个班级
	 * @param classid 班级主键id
	 * @return 成功返回true，失败flase
	 */
	public boolean deleteClass(int classid);
	
	/**
	 * 修改一条班级信息
	 * @param class1 班级对象
	 * @return 成功返回true，失败flase
	 */
	public boolean modifyClass(TClass class1);
	
	/**
	 * 根据条件获取班级列表
	 * @param wherecondition 组合查询条件字符串,如："userRole = '超级管理员' and userid = 'zhangjs'" 
	 * @param currentPage 按分页查询的当前页
	 * @param pageSize 按分页查询的每页数量
	 * @return List
	 */
	public List<TClass> getClassList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * 根据条件获取符合条件的主诉的数量
	 * @param wherecondition 如："userRole = '超级管理员' and userid = 'zhangjs'" 
	 * @return
	 */
	public int getClassAmount(String wherecondition);
}

	
