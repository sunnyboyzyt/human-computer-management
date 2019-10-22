package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import model.TUnit;
import model.TUser;
import business.basic.HibBaseDAOImpl;
import business.basic.iHibBaseDAO;
import business.dao.TUnitDAO;
/**
 * �½�/��������ҵ��ʵ����
 * @author sunst
 * @version 2019-10-12
 */
@Component("unitdao")
public class TUnitDAOImpl implements TUnitDAO {
	//�������ݿ������ӿ�,ʵ��ҵ�������ݵĽ���
	private iHibBaseDAO bdao= null; 
	
	public TUnitDAOImpl(){
		bdao = new HibBaseDAOImpl();
	}
		
	@Override
	public int addTUnit(TUnit unit) {
		return (Integer) bdao.insert(unit);
	}

	@Override
	public boolean deleteTUnit(int unitid) {
		TUnit unit = (TUnit) bdao.findById(TUnit.class, unitid);
		return bdao.delete(unit);
	}

	@Override
	public boolean modifyTUnit(TUnit unit) {
		return bdao.update(unit);
	}

	@Override
	public List<TUnit> getTUnitList(String wherecondition, int currentPage,
			int pageSize) {
		String hql = "from TUnit";
		if (wherecondition == null && wherecondition.equals("")){
			hql += "order by unitcode desc"; 
		}
		if (wherecondition != null && !wherecondition.equals("")){
			hql += "order by unitcode desc"; 
		}
		List<TUnit> list = bdao.selectByPage(hql, currentPage, pageSize);
		return list;
	}

	@Override
	public int getTUnitAmount(String wherecondition) {
		String hql = "select count(*) from TUnit";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition; 
		}
		return bdao.selectValue(hql);
	}

}
