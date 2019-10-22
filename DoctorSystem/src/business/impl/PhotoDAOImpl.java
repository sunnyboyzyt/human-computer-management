package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import model.TPersonal;
import model.TPhoto;
import model.TPhoto;
import business.basic.HibBaseDAOImpl;
import business.basic.iHibBaseDAO;
import business.dao.PhotoDAO;
@Component("photodao")
public class PhotoDAOImpl implements PhotoDAO {
	//连接数据库操作层接口,实现业务与数据的交换
			private iHibBaseDAO bdao= null; 
			
			public PhotoDAOImpl(){
				bdao = new HibBaseDAOImpl();
			}
	@Override
	public int addPhoto(TPhoto Photo) {
		return (Integer) bdao.insert(Photo);
	}

	@Override
	public boolean deletePhoto(int photoid) {
		TPhoto Photo = (TPhoto) bdao.findById(TPhoto.class, photoid);
		return bdao.delete(Photo);
	}

	@Override
	public boolean modifyPhoto(TPhoto Photo) {
		return bdao.update(Photo);
	}

	@Override
	public List<TPhoto> getTPhotoList(int photoid) {
		String hql = "from TPhoto";
		List<TPhoto> list = bdao.select(hql);
		return list;
	}

}
