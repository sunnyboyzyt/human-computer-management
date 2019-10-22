package business.dao;

import java.util.List;

import model.TMentalSociety;

/**
 * �������״��ҵ��ӿ�
 * T_MentalSociety
 * @author Zhangyt
 * @version 2010-10-12
 */
public interface MentalSocietyDAO {
	
	/**
	 * ���һ���������״������
	 * @param mentalSociety�𰸶���
	 * @return ��ӳɹ�������Ӱ�������
	 */
	public int addMentalSociety(TMentalSociety mentalSociety);
	
	/**
	 * ɾ��һ���������״������
	 * @param mentalsocietyid �𰸶�������id
	 * @return �ɹ�����true��ʧ��false
	 */
	public boolean deleteMentalSociety(int mentalsocietyid);
	
	/**
	 * �޸�һ���������״������
	 * @param mentalSociety �������״������
	 * @return �ɹ�����true��ʧ��false
	 */
	public boolean modifyMentalSociety(TMentalSociety mentalSociety);
	
	/**
	 * ����������ȡ�������״���б�
	 * @param wherecondtion ��ϲ�ѯ�����ַ���
	 * @param currentpage ����ҳ��ѯ�ĵ�ǰҳ
	 * @param pageSize ����ҳ��ѯ��ÿҳ����
	 * @return List
	 */
	public List<TMentalSociety> getMentalSocietyList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * ����������ȡ�����������������״���б�����
	 * @param wherecondtion ��ϲ�ѯ�����ַ���
	 * @return 
	 */
	public int getMentalSocietyAmount(String wherecondition);
	

}
