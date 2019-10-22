package business.dao;
import java.util.List;

import model.TEasyExamine;

/**
 * ������ҵ��ӿ�
 * T_EasyExamine
 * @author Zhangyt
 * @version 2010-10-12
 */
public interface EasyExamineDAO {
	

	/**
	 * ���һ������¼
	 * @param easyexamine ������
	 * @return ��ӳɹ�������Ӱ�������
	 */
	public int addEasyExamine(TEasyExamine easyexamine);
	
	/**
	 * ɾ��һ������¼
	 * @param easyexamineid ����������id
	 * @return �ɹ�����true��ʧ��false
	 */
	public boolean deleteEasyExamine(int easyexamineid);
	
	/**
	 * �޸�һ������¼
	 * @param easyexamine ������
	 * @return �ɹ�����true��ʧ��false
	 */
	public boolean modifyEasyExamine(TEasyExamine easyexamine);
	
	/**
	 * ����������ȡ����¼�б�
	 * @param wherecondtion ��ϲ�ѯ�����ַ���
	 * @param currentpage ����ҳ��ѯ�ĵ�ǰҳ
	 * @param pageSize ����ҳ��ѯ��ÿҳ����
	 * @return List
	 */
	public List<TEasyExamine> getEasyExamineList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * ����������ȡ���������ļ������
	 * @param wherecondtion ��ϲ�ѯ�����ַ���
	 * @return 
	 */
	public int getEasyExamineAmount(String wherecondition);
	

}
