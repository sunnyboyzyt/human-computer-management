package business.dao;

import java.util.List;

import model.TUnit;

/**
 * ����/�½�����ҵ��ӿ�
 * @author sunst
 * @version 2019-10-12
 */
public interface TUnitDAO {
	/**
	 * ���һ������/�½�
	 * @param unit ����/�½ڶ���
	 * @return ��ӳɹ�������Ӱ�������
	 */
	public int addTUnit(TUnit unit);
	
	/**
	 * ɾ��һ������/�½�
	 * @param unitid ����/�½ڶ���
	 * @return ��ӳɹ�������Ӱ�������
	 */
	public boolean deleteTUnit(int unitid);
	
	/**
	 * �޸�һ������/�½�
	 * @param unit ��Ҫ�޸ĵĿ���/�½ڶ���
	 * @return
	 */
	public boolean modifyTUnit(TUnit unit);
	
	/**
	 * ����������ȡ����/�½ڵ��б�
	 * @param wherecondition ��ϲ�ѯ�����ַ���,�磺"userRole = '��������Ա' and userid = 'zhangjs'" 
	 * @param currentPage ����ҳ��ѯ�ĵ�ǰҳ
	 * @param pageSize ����ҳ��ѯ��ÿҳ����
	 * @return List
	 */
	public List<TUnit> getTUnitList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * ����������ȡ���������Ŀ���/�½ڵ�����
	 * @param wherecondition �磺"userRole = '��������Ա' and userid = 'zhangjs'" 
	 * @return
	 */
	public int getTUnitAmount(String wherecondition);
}
