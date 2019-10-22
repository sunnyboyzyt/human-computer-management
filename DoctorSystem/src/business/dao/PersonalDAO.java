package business.dao;
import java.util.List;

import model.TPatient;
import model.TPersonal;


/**
 * ����ʷҵ��ӿ�
 * @author CJJ
 * @version 2019-10-13
 */
public interface PersonalDAO {
	
	/**
	 * ���һ������ʷ
	 * @param Personal ����ʷ����
	 * @return ��ӳɹ�������Ӱ�������
	 */
	public int addPersonal(TPersonal Personal);
	
	/**
	 * ɾ��һ������ʷ
	 * @param personalid ����ʷ����id
	 * @return ��ӳɹ�������Ӱ�������
	 */
	public boolean deletePersonal(int personalid);
	
	/**
	 * �޸�һ������ʷ
	 * @param Personal ��Ҫ�޸ĵĸ���ʷ
	 * @return
	 */
	public boolean modifyPersonal(TPersonal Personal);
	
	/**
	 * ����������ȡ������б�
	 * @param wherecondition ��ϲ�ѯ�����ַ���,�磺"personalid = '��ʷid' " 
	 * @param currentPage ����ҳ��ѯ�ĵ�ǰҳ
	 * @param pageSize ����ҳ��ѯ��ÿҳ����
	 * @return List
	 */
	public List<TPersonal> getTPersonalList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * ����������ȡ�������������������
	 * @param wherecondition �磺"personalid = '��ʷid' " 
	 * @return
	 */
	public int getPersonalAmount(String wherecondition);

}
