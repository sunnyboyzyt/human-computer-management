package business.dao;
import java.util.List;
import model.TChiefComplaint;

/**
 * 主诉业务接口
 * T_ChiefComplaint
 * @author Zhangyt
 * @version 2010-10-12
 */
public interface ChiefComplaintDAO {
	/**
	 * 添加一条主诉
	 * @param chiefComplaint 主诉对象
	 * @return 添加成功返回受影响的行数
	 */
	public int addChiefComplaint(TChiefComplaint chiefComplaint);
	
	/**
	 * 删除一条主诉
	 * @param chiefComplaintid 主诉主键id
	 * @return 成功返回true，失败flase
	 */
	public boolean deleteChiefComplaint(int chiefComplaintid);
	
	/**
	 * 修改一条主诉
	 * @param chiefComplaint 主诉对象
	 * @return 成功返回true，失败flase
	 */
	public boolean modifyChiefComplaint(TChiefComplaint chiefComplaint);
	
	/**
	 * 根据条件获取主诉列表
	 * @param wherecondition 组合查询条件字符串,如："userRole = '超级管理员' and userid = 'zhangjs'" 
	 * @param currentPage 按分页查询的当前页
	 * @param pageSize 按分页查询的每页数量
	 * @return List
	 */
	public List<TChiefComplaint> getChiefComplaintList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * 根据条件获取符合条件的主诉的数量
	 * @param wherecondition 如："userRole = '超级管理员' and userid = 'zhangjs'" 
	 * @return
	 */
	public int getChiefComplaintAmount(String wherecondition);
}

	
