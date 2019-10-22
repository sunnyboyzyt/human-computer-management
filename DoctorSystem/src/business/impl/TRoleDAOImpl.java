package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import model.TRole;
import model.TUser;
import business.basic.HibBaseDAOImpl;
import business.basic.iHibBaseDAO;
import business.dao.TRoleDAO;
/**
 * 角色数据业务实现类
 * @author sunst
 * @version 2019-10-12
 */
@Component("roledao")
public class TRoleDAOImpl implements TRoleDAO {
	//连接数据库操作层接口,实现业务与数据的交换
	private iHibBaseDAO bdao= null; 
	
	public TRoleDAOImpl(){
		bdao = new HibBaseDAOImpl();
	}
	
	@Override
	public int addRole(TRole role) {
		return (Integer) bdao.insert(role);
	}

	@Override
	public boolean deleteRole(int roleid) {
		TRole role = (TRole) bdao.findById(TRole.class, roleid);
		return bdao.delete(role);
	}

	@Override
	public boolean modifyRole(TRole role) {
		return bdao.update(role);
	}

	@Override
	public List<TRole> getRoleList(String wherecondition, int currentPage,
			int pageSize) {
		String hql = "from TRole";
		if (wherecondition == null && wherecondition.equals("")){
			hql += "order by roleid desc"; 
		}
		if (wherecondition != null && !wherecondition.equals("")){
			hql += "order by roleid desc"; 
		}
		
		List<TRole> list = bdao.selectByPage(hql, currentPage, pageSize);
		return list;
	}

	@Override
	public int getRoleAmount(String wherecondition) {
		String hql = "select count(*) from TRole";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition; 
		}
		return bdao.selectValue(hql);
	}

}
