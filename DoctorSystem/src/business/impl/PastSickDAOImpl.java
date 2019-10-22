package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import model.TPastSick;
import model.TUser;
import business.basic.HibBaseDAOImpl;
import business.basic.iHibBaseDAO;
import business.dao.PastSickDAO;
@Component("PastSickdao")
public class PastSickDAOImpl implements PastSickDAO {
	//�������ݿ������ӿ�,ʵ��ҵ�������ݵĽ���
		private iHibBaseDAO bdao= null; 
		
		public PastSickDAOImpl(){
			bdao = new HibBaseDAOImpl();
		}

	@Override
	public int addPastSick(TPastSick PastSick) {
		return (Integer) bdao.insert(PastSick);
	}

	@Override
	public boolean deletePastSick(int pastsickid) {
		TPastSick PastSick = (TPastSick) bdao.findById(TPastSick.class, pastsickid);
		return bdao.delete(PastSick);
	}

	@Override
	public boolean modifyPastSick(TPastSick PastSick) {
		return bdao.update(PastSick);
	}

	@Override
	public List<TPastSick> getTPastSickList(String wherecondition,
			int currentPage, int pageSize) {
		String hql = "from TPastSick";
		if (wherecondition == null && wherecondition.equals("")){
			hql += "order by user desc"; 
		}
		if (wherecondition != null && !wherecondition.equals("")){
			hql += "order by user desc"; 
		}
		
		List<TPastSick> list = bdao.selectByPage(hql, currentPage, pageSize);
		return list;
	}

	@Override
	public int getPastSickAmount(String wherecondition) {
		String hql = "select count(*) from TPastSick";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition; 
		}
		return bdao.selectValue(hql);
	}

}
