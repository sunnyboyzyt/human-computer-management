package business.dao;

import java.util.List;

import model.TRole;

/**
 * 角色数据业务接口
 * @author sunst
 * @version 2019-10-12
 */
public interface TRoleDAO {
	/**
	 * 添加一个角色
	 * @param role 角色对象
	 * @return 添加成功返回受影响的行数
	 */
	public int addRole(TRole role);
	
	/**
	 * 删除一个角色
	 * @param roleid 角色编号
	 * @return 添加成功返回受影响的行数
	 */
	public boolean deleteRole(int roleid);
	
	/**
	 * 修改一个角色
	 * @param user 需要修改的用户对象
	 * @return
	 */
	public boolean modifyRole(TRole role);
	
	/**
	 * 根据条件获取角色的列表
	 * @param wherecondition 组合查询条件字符串,如："userRole = '超级管理员' and userid = 'zhangjs'" 
	 * @param currentPage 按分页查询的当前页
	 * @param pageSize 按分页查询的每页数量
	 * @return List
	 */
	public List<TRole> getRoleList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * 根据条件获取符合条件的角色的数量
	 * @param wherecondition 如："userRole = '超级管理员' and userid = 'zhangjs'" 
	 * @return
	 */
	public int getRoleAmount(String wherecondition);
}
