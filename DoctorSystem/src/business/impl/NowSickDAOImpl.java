package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import business.basic.HibBaseDAOImpl;
import business.basic.iHibBaseDAO;
import business.dao.NowSickDAO;
import model.TNowSick;

/**
 * 现病史业务实现类
 * @author zhangyt
 * @version 2019-10-13
 */
@Component("NowSickdao")
public class NowSickDAOImpl implements NowSickDAO {

	//连接数据库操作层接口,实现业务与数据的交换
			private iHibBaseDAO bdao= null; 
			
			public NowSickDAOImpl(){
				bdao = new HibBaseDAOImpl();
			}
			
	@Override
	public int addNowSick(TNowSick nowsick) {
		// TODO Auto-generated method stub
		return (Integer) bdao.insert(nowsick);
	}

	@Override
	public boolean deleteNowSick(int nowsicktid) {
		// TODO Auto-generated method stub
		TNowSick nowsick = (TNowSick) bdao.findById(TNowSick.class, nowsicktid);
		return bdao.delete(nowsick);
	}

	@Override
	public boolean modifyNowSick(TNowSick nowsick) {
		// TODO Auto-generated method stub
		
		return bdao.update(nowsick);
	}

	@Override
	public List<TNowSick> getNowSickList(String wherecondition, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		String hql = "from TNowSick";
		if (wherecondition == null && wherecondition.equals("")){
			hql += "order by sicksituation desc"; 
		}
		if (wherecondition != null && !wherecondition.equals("")){
			hql += "order by sicksituation desc"; 
		}
		
		List<TNowSick> list = bdao.selectByPage(hql, currentPage, pageSize);
		return list;
	}

	@Override
	public int getNowSickAmount(String wherecondition) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from TNowSick";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition; 
		}
		return bdao.selectValue(hql);
	}

}
