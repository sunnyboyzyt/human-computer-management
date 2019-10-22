package business.dao;

import java.util.List;
import model.TPastSick;

/**
 * 既往病史业务接口
 * @author CJJ
 * @version 2019-10-13
 */
public interface PastSickDAO {
	
	/**
	 * 添加一个既往病史
	 * @param PastSick 既往病史对象
	 * @return 添加成功返回受影响的行数
	 */
	public int addPastSick(TPastSick PastSick);
	
	/**
	 * 删除一个既往病史
	 * @param pastsickid 病史编号
	 * @return 添加成功返回受影响的行数
	 */
	public boolean deletePastSick(int pastsickid);
	
	/**
	 * 修改一个既往病史
	 * @param PastSick 需要修改的既往病史对象
	 * @return
	 */
	public boolean modifyPastSick(TPastSick PastSick);
	
	/**
	 * 根据条件获取既往病史的列表
	 * @param wherecondition 组合查询条件字符串,如："patientid = '病人id' " 
	 * @param currentPage 按分页查询的当前页
	 * @param pageSize 按分页查询的每页数量
	 * @return List
	 */
	public List<TPastSick> getTPastSickList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * 根据条件获取符合条件的问诊的数量
	 * @param wherecondition 如："patientid = '病人id' " 
	 * @return
	 */
	public int getPastSickAmount(String wherecondition);

}
