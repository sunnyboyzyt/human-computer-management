package business.dao;

import java.util.List;

import model.TUser;

/**
 * 用户数据业务接口
 * @author sunst
 * @version 2019-10-12
 */
public interface UserDAO {
	/**
	 * 添加一个用户角色
	 * @param user 用户对象
	 * @return 添加成功返回受影响的行数
	 */
	public int addUser(TUser user);
	
	/**
	 * 删除一个用户角色
	 * @param user 用户对象
	 * @return 添加成功返回受影响的行数
	 */
	public boolean deleteUser(int userid);
	
	/**
	 * 修改一个用户角色
	 * @param user 需要修改的用户对象
	 * @return
	 */
	public boolean modifyUser(TUser user);
	
	/**
	 * 根据条件获取管理员用户的列表
	 * @param wherecondition 组合查询条件字符串,如："userRole = '超级管理员' and userid = 'zhangjs'" 
	 * @param currentPage 按分页查询的当前页
	 * @param pageSize 按分页查询的每页数量
	 * @return List
	 */
	public List<TUser> getUserList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * 根据条件获取符合条件的管理员用户的数量
	 * @param wherecondition 如："userRole = '超级管理员' and userid = 'zhangjs'" 
	 * @return
	 */
	public int getUserAmount(String wherecondition);
	
	
	/**
	 * 用户登录
	 * @param userid 用户id
	 * @param pwd 密码
	 * @return 用户对象
	 */
	public List<TUser> loginuser(int userid,String pwd);
	
	/**
	 * 密码修改
	 * @param userid 用户id
	 * @param pwd 密码
	 * @return 用户对象
	 */
	public boolean Upedtpwd(int userid,String pwd);
	
	/**
	 * 通过id查询用户
	 * @param user
	 * @return
	 */
	public TUser getUserById(int userid);
}
