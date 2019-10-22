package business.dao;

import java.util.List;

import model.TRole;

/**
 * ��ɫ����ҵ��ӿ�
 * @author sunst
 * @version 2019-10-12
 */
public interface TRoleDAO {
	/**
	 * ���һ����ɫ
	 * @param role ��ɫ����
	 * @return ��ӳɹ�������Ӱ�������
	 */
	public int addRole(TRole role);
	
	/**
	 * ɾ��һ����ɫ
	 * @param roleid ��ɫ���
	 * @return ��ӳɹ�������Ӱ�������
	 */
	public boolean deleteRole(int roleid);
	
	/**
	 * �޸�һ����ɫ
	 * @param user ��Ҫ�޸ĵ��û�����
	 * @return
	 */
	public boolean modifyRole(TRole role);
	
	/**
	 * ����������ȡ��ɫ���б�
	 * @param wherecondition ��ϲ�ѯ�����ַ���,�磺"userRole = '��������Ա' and userid = 'zhangjs'" 
	 * @param currentPage ����ҳ��ѯ�ĵ�ǰҳ
	 * @param pageSize ����ҳ��ѯ��ÿҳ����
	 * @return List
	 */
	public List<TRole> getRoleList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * ����������ȡ���������Ľ�ɫ������
	 * @param wherecondition �磺"userRole = '��������Ա' and userid = 'zhangjs'" 
	 * @return
	 */
	public int getRoleAmount(String wherecondition);
}
