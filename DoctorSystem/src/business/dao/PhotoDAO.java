package business.dao;

import java.util.List;
import model.TPhoto;


/**
 * 图片业务接口
 * @author CJJ
 * @version 2019-10-13
 */
public interface PhotoDAO {
	
	/**
	 * 添加一个图片
	 * @param Photo 图片对象
	 * @return 添加成功返回受影响的行数
	 */
	public int addPhoto(TPhoto Photo);
	
	/**
	 * 删除一个图片
	 * @param photoid 图片id
	 * @return 添加成功返回受影响的行数
	 */
	public boolean deletePhoto(int photoid);
	
	/**
	 * 修改一个图片
	 * @param Photo 图片对象
	 * @return
	 */
	public boolean modifyPhoto(TPhoto Photo);
	
	/**
	 * 根据条件获取图片的列表
	 * @param photoid  图片id
	 * @return List
	 */
	public List<TPhoto> getTPhotoList(int photoid);
	

}
