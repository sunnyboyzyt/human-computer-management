package business.dao;

import java.util.List;

import model.TUser;

/**
 * �û�����ҵ��ӿ�
 * @author sunst
 * @version 2019-10-12
 */
public interface UserDAO {
	/**
	 * ���һ���û���ɫ
	 * @param user �û�����
	 * @return ��ӳɹ�������Ӱ�������
	 */
	public int addUser(TUser user);
	
	/**
	 * ɾ��һ���û���ɫ
	 * @param user �û�����
	 * @return ��ӳɹ�������Ӱ�������
	 */
	public boolean deleteUser(int userid);
	
	/**
	 * �޸�һ���û���ɫ
	 * @param user ��Ҫ�޸ĵ��û�����
	 * @return
	 */
	public boolean modifyUser(TUser user);
	
	/**
	 * ����������ȡ����Ա�û����б�
	 * @param wherecondition ��ϲ�ѯ�����ַ���,�磺"userRole = '��������Ա' and userid = 'zhangjs'" 
	 * @param currentPage ����ҳ��ѯ�ĵ�ǰҳ
	 * @param pageSize ����ҳ��ѯ��ÿҳ����
	 * @return List
	 */
	public List<TUser> getUserList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * ����������ȡ���������Ĺ���Ա�û�������
	 * @param wherecondition �磺"userRole = '��������Ա' and userid = 'zhangjs'" 
	 * @return
	 */
	public int getUserAmount(String wherecondition);
	
	
	/**
	 * �û���¼
	 * @param userid �û�id
	 * @param pwd ����
	 * @return �û�����
	 */
	public List<TUser> loginuser(int userid,String pwd);
	
	/**
	 * �����޸�
	 * @param userid �û�id
	 * @param pwd ����
	 * @return �û�����
	 */
	public boolean Upedtpwd(int userid,String pwd);
	
	/**
	 * ͨ��id��ѯ�û�
	 * @param user
	 * @return
	 */
	public TUser getUserById(int userid);
}
