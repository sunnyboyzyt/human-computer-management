package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import model.TPersonal;
import model.TUser;
import business.basic.HibBaseDAOImpl;
import business.basic.iHibBaseDAO;
import business.dao.PersonalDAO;
@Component("personaldao")
public class PersonalDAOImpl implements PersonalDAO {
	//连接数据库操作层接口,实现业务与数据的交换
		private iHibBaseDAO bdao= null; 
		
		public PersonalDAOImpl(){
			bdao = new HibBaseDAOImpl();
		}

	@Override
	public int addPersonal(TPersonal Personal) {
		return (Integer) bdao.insert(Personal);
	}

	@Override
	public boolean deletePersonal(int personalid) {
		TPersonal Personal = (TPersonal) bdao.findById(TPersonal.class, personalid);
		return bdao.delete(Personal);
	}

	@Override
	public boolean modifyPersonal(TPersonal Personal) {
		return bdao.update(Personal);
	}

	@Override
	public List<TPersonal> getTPersonalList(String wherecondition,
			int currentPage, int pageSize) {
		String hql = "from TPersonal";
		if (wherecondition == null && wherecondition.equals("")){
			hql += "order by user desc"; 
		}
		if (wherecondition != null && !wherecondition.equals("")){
			hql += "order by user desc"; 
		}
		
		List<TPersonal> list = bdao.selectByPage(hql, currentPage, pageSize);
		return list;
	}

	@Override
	public int getPersonalAmount(String wherecondition) {
		String hql = "select count(*) from TPersonal";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition; 
		}
		return bdao.selectValue(hql);
	}

}
