package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import business.basic.HibBaseDAOImpl;
import business.basic.iHibBaseDAO;
import business.dao.LifeDAO;
import model.TLife;

/**
 * 閺冦儱鐖堕悽鐔告た閻樿泛鍠屾稉姘鐎圭偟骞囩猾锟� * @author zhangyt
 * @version 2019-10-13
 */
@Component("lifedao")
public class LifeDAOImpl implements LifeDAO {

	//鏉╃偞甯撮弫鐗堝祦鎼存挻鎼锋担婊冪湴閹恒儱褰�鐎圭偟骞囨稉姘娑撳孩鏆熼幑顔炬畱娴溿倖宕�
			private iHibBaseDAO bdao= null; 
			
			public LifeDAOImpl(){
				bdao = new HibBaseDAOImpl();
			}
			
	@Override
	public int addLife(TLife life) {
		// TODO Auto-generated method stub
		
		return (Integer) bdao.insert(life);
	}

	@Override
	public boolean deleteLife(int lifeid) {
		// TODO Auto-generated method stub
		TLife life = (TLife) bdao.findById(TLife.class, lifeid);
		return bdao.delete(life);
	}

	@Override
	public boolean modifyLife(TLife life) {
		// TODO Auto-generated method stub
		return bdao.update(life);
	}

	@Override
	public List<TLife> getLifeList(String wherecondition, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		String hql = "from TLife";
		if (wherecondition == null && wherecondition.equals("")){
			hql += "order by lifeid desc"; 
		}
		if (wherecondition != null && !wherecondition.equals("")){
			hql += "order by lifeid desc"; 
		}
		
		List<TLife> list = bdao.selectByPage(hql, currentPage, pageSize);
		return list;
	}

	@Override
	public int getLifeAmount(String wherecondition) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from TLife";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition; 
		}
		return bdao.selectValue(hql);
	}

}
