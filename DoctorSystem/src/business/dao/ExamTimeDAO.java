package business.dao;

import java.util.List;

import model.TExamTime;

/**
 * ���Գ���ҵ��ӿ�
 * T_ExamTime
 * @author Zhangyt
 * @version 2010-10-12
 */
public interface ExamTimeDAO {

	/**
	 * ���һ�����Գ���
	 * @param examTime ���Գ��ζ���
	 * @return ��ӳɹ�������Ӱ�������
	 */
	public int addExamTime(TExamTime examTime);
	
	/**
	 * ɾ��һ�����Գ���
	 * @param examtimeid ���Գ��ζ�������id
	 * @return �ɹ�����true��ʧ��false
	 */
	public boolean deleteExamTime(int examtimeid);
	
	/**
	 * �޸�һ�����Գ�������
	 * @param examTime ���Գ��ζ���
	 * @return �ɹ�����true��ʧ��false
	 */
	public boolean modifyExamTime(TExamTime examTime);
	
	/**
	 * ����������ȡ���Գ����б�
	 * @param wherecondtion ��ϲ�ѯ�����ַ���
	 * @param currentpage ����ҳ��ѯ�ĵ�ǰҳ
	 * @param pageSize ����ҳ��ѯ��ÿҳ����
	 * @return List
	 */
	public List<TExamTime> getExamTimeList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * ����������ȡ���������Ŀ��Գ����б�����
	 * @param wherecondtion ��ϲ�ѯ�����ַ���
	 * @return 
	 */
	public int getExamTimeAmount(String wherecondition);
	

}

