package business.dao;

import java.util.List;

import model.TEexam;

/**
 * ����ҵ��ӿ�
 * T_Exam
 * @author Zhangyt
 * @version 2010-10-12
 */

public interface EexamDAO {

	/**
	 * ���һ����������
	 * @param eexam ���Զ���
	 * @return ��ӳɹ�������Ӱ�������
	 */
	public int addEexam(TEexam eexam);
	
	/**
	 * ɾ��һ����������
	 * @param examid ���Զ�������id
	 * @return �ɹ�����true��ʧ��false
	 */
	public boolean deleteEexam(int examid);
	
	/**
	 * �޸�һ����������
	 * @param eexam ���Զ���
	 * @return �ɹ�����true��ʧ��false
	 */
	public boolean modifyEexam(TEexam eexam);
	
	/**
	 * ����������ȡ�����б�
	 * @param wherecondtion ��ϲ�ѯ�����ַ���
	 * @param currentpage ����ҳ��ѯ�ĵ�ǰҳ
	 * @param pageSize ����ҳ��ѯ��ÿҳ����
	 * @return List
	 */
	public List<TEexam> getEexamList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * ����������ȡ���������Ŀ����б�����
	 * @param wherecondtion ��ϲ�ѯ�����ַ���
	 * @return 
	 */
	public int getEexamAmount(String wherecondition);
	

}

