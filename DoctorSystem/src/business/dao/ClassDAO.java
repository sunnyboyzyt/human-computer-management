package business.dao;

import java.util.List;

import model.TClass;

/**
 * �༶ҵ��ӿ�
 * T_Class
 * @author Zhangyt
 * @version 2010-10-12
 */
public interface ClassDAO {
	/**
	 * ���һ���༶
	 * @param class1  �༶����
	 * @return ��ӳɹ�������Ӱ�������
	 */
	public int addClass(TClass class1);
	
	/**
	 * ɾ��һ���༶
	 * @param classid �༶����id
	 * @return �ɹ�����true��ʧ��flase
	 */
	public boolean deleteClass(int classid);
	
	/**
	 * �޸�һ���༶��Ϣ
	 * @param class1 �༶����
	 * @return �ɹ�����true��ʧ��flase
	 */
	public boolean modifyClass(TClass class1);
	
	/**
	 * ����������ȡ�༶�б�
	 * @param wherecondition ��ϲ�ѯ�����ַ���,�磺"userRole = '��������Ա' and userid = 'zhangjs'" 
	 * @param currentPage ����ҳ��ѯ�ĵ�ǰҳ
	 * @param pageSize ����ҳ��ѯ��ÿҳ����
	 * @return List
	 */
	public List<TClass> getClassList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * ����������ȡ�������������ߵ�����
	 * @param wherecondition �磺"userRole = '��������Ա' and userid = 'zhangjs'" 
	 * @return
	 */
	public int getClassAmount(String wherecondition);
}

	
