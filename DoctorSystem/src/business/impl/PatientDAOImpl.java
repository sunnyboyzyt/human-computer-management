package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import model.TPastSick;
import model.TPatient;
import model.TUser;
import business.basic.HibBaseDAOImpl;
import business.basic.iHibBaseDAO;
import business.dao.PatientDAO;
@Component("patientdao")
public class PatientDAOImpl implements PatientDAO {
	//连接数据库操作层接口,实现业务与数据的交换
			private iHibBaseDAO bdao= null; 
			
			public PatientDAOImpl(){
				bdao = new HibBaseDAOImpl();
			}

	@Override
	public int addPatient(TPatient Patient) {
		return (Integer) bdao.insert(Patient);
	}

	@Override
	public boolean deletePatient(int patientid) {
		TPatient Patient = (TPatient) bdao.findById(TPatient.class, patientid);
		return bdao.delete(Patient);
	}

	@Override
	public boolean modifyPatient(TPatient Patient) {
		return bdao.update(Patient);
	}

	@Override
	public List<TPatient> getTPatientList(String wherecondition,
			int currentPage, int pageSize) {
		String hql = "from TPatient";
		if (wherecondition == null && wherecondition.equals("")){
			hql += "order by user desc"; 
		}
		if (wherecondition != null && !wherecondition.equals("")){
			hql += "order by user desc"; 
		}
		
		List<TPatient> list = bdao.selectByPage(hql, currentPage, pageSize);
		return list;
	}

	@Override
	public int getPatientAmount(String wherecondition) {
		String hql = "select count(*) from TPatient";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition; 
		}
		return bdao.selectValue(hql);
	}

}
