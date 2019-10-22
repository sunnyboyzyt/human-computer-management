package business.dao;

import java.util.List;
import model.TPhoto;


/**
 * ͼƬҵ��ӿ�
 * @author CJJ
 * @version 2019-10-13
 */
public interface PhotoDAO {
	
	/**
	 * ���һ��ͼƬ
	 * @param Photo ͼƬ����
	 * @return ��ӳɹ�������Ӱ�������
	 */
	public int addPhoto(TPhoto Photo);
	
	/**
	 * ɾ��һ��ͼƬ
	 * @param photoid ͼƬid
	 * @return ��ӳɹ�������Ӱ�������
	 */
	public boolean deletePhoto(int photoid);
	
	/**
	 * �޸�һ��ͼƬ
	 * @param Photo ͼƬ����
	 * @return
	 */
	public boolean modifyPhoto(TPhoto Photo);
	
	/**
	 * ����������ȡͼƬ���б�
	 * @param photoid  ͼƬid
	 * @return List
	 */
	public List<TPhoto> getTPhotoList(int photoid);
	

}
