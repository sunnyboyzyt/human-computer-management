package business.dao;
import java.util.List;

import model.TPastSick;
import model.TPatient;
import model.TUser;


/**
 * 问诊业务接口
 * @author CJJ
 * @version 2019-10-13
 */
public interface PatientDAO {
	
	
	/**
	 * 添加一个问诊
	 * @param Patient 问诊对象
	 * @return 添加成功返回受影响的行数
	 */
	public int addPatient(TPatient Patient);
	
	/**
	 * 删除一个问诊
	 * @param patientid 问诊对象id
	 * @return 添加成功返回受影响的行数
	 */
	public boolean deletePatient(int patientid);
	
	/**
	 * 修改一个问诊
	 * @param Patient 需要修改的问诊对象
	 * @return
	 */
	public boolean modifyPatient(TPatient Patient);
	
	/**
	 * 根据条件获取问诊的列表
	 * @param wherecondition 组合查询条件字符串,如："patientid = '病人id' " 
	 * @param currentPage 按分页查询的当前页
	 * @param pageSize 按分页查询的每页数量
	 * @return List
	 */
	public List<TPatient> getTPatientList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * 根据条件获取符合条件的问诊的数量
	 * @param wherecondition 如："patientid = '病人id' " 
	 * @return
	 */
	public int getPatientAmount(String wherecondition);

}
