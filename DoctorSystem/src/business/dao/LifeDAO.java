package business.dao;

import java.util.List;

import model.TLife;

/**
 * �ճ�����״��ҵ��ӿ�
 * T_Life
 * @author Zhangyt
 * @version 2010-10-12
 */

public interface LifeDAO {
	/**
	 * ���һ���ճ����������¼
	 * @param life �ճ������������
	 * @return ��ӳɹ�������Ӱ�������
	 */
	public int addLife(TLife life);
	
	/**
	 * ɾ��һ���ճ������������
	 * @param lifeid �ճ����������������id
	 * @return �ɹ�����true��ʧ��false
	 */
	public boolean deleteLife(int lifeid);
	
	/**
	 * �޸�һ���ճ������������
	 * @param life �ճ������������
	 * @return �ɹ�����true��ʧ��false
	 */
	public boolean modifyLife(TLife life);
	
	/**
	 * ����������ȡ�ճ���������б�
	 * @param wherecondtion ��ϲ�ѯ�����ַ���
	 * @param currentpage ����ҳ��ѯ�ĵ�ǰҳ
	 * @param pageSize ����ҳ��ѯ��ÿҳ����
	 * @return List
	 */
	public List<TLife> getLifeList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * ����������ȡ�����������ճ���������б�����
	 * @param wherecondtion ��ϲ�ѯ�����ַ���
	 * @return 
	 */
	public int getLifeAmount(String wherecondition);
	

}
