package business.dao;

import java.util.List;

import model.TOtherExamine;

/**
 * �������ҵ��ӿ�
 * T_OtherExamine
 * @author Zhangyt
 * @version 2010-10-12
 */
public interface OtherExamineDAO {
	/**
	 * ���һ�������������
	 * @param ohExamine ����������
	 * @return ��ӳɹ�������Ӱ�������
	 */
	public int addOtherExamine(TOtherExamine ohExamine);
	
	/**
	 * ɾ��һ�������������
	 * @param otherexamineid ��������������id
	 * @return �ɹ�����true��ʧ��false
	 */
	public boolean deleteOtherExamine(int otherexamineid);
	
	/**
	 * �޸�һ�������������
	 * @param ohExamine ����������
	 * @return �ɹ�����true��ʧ��false
	 */
	public boolean modifyOtherExamine(TOtherExamine ohExamine);
	
	/**
	 * ����������ȡ��������б�
	 * @param wherecondtion ��ϲ�ѯ�����ַ���
	 * @param currentpage ����ҳ��ѯ�ĵ�ǰҳ
	 * @param pageSize ����ҳ��ѯ��ÿҳ����
	 * @return List
	 */
	public List<TOtherExamine> getOtherExamineList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * ����������ȡ���������ĸ�������б�����
	 * @param wherecondtion ��ϲ�ѯ�����ַ���
	 * @return 
	 */
	public int getOtherExamineAmount(String wherecondition);
	

}

