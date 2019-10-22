package business.dao;

import java.util.List;
import model.TNowSick;

/**
	 * 现病史业务接口
	 * T_NowSick
	 * @author Zhangyt
	 * @version 2010-10-12
	 */
public interface NowSickDAO {
	
	/**
	 * 添加一条现病史数据
	 * @param nowsick 现病史对象
	 * @return 添加成功返回受影响的行数
	 */
	public int addNowSick(TNowSick nowsick);
	
	/**
	 * 删除一条现病史数据
	 * @param nowsicktid 现病史对象主键id
	 * @return 成功返回true，失败false
	 */
	public boolean deleteNowSick(int nowsicktid);
	
	/**
	 * 修改一条现病史数据
	 * @param nowsick 现病史对象
	 * @return 成功返回true，失败false
	 */
	public boolean modifyNowSick(TNowSick nowsick);
	
	/**
	 * 根据条件获取现病史列表
	 * @param wherecondtion 组合查询条件字符串
	 * @param currentpage 按分页查询的当前页
	 * @param pageSize 按分页查询的每页数量
	 * @return List
	 */
	public List<TNowSick> getNowSickList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * 根据条件获取符合条件的现病史列表数量
	 * @param wherecondtion 组合查询条件字符串
	 * @return 
	 */
	public int getNowSickAmount(String wherecondition);
	

}
