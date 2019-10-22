package business.dao;

import java.util.List;

import model.TScore;

/**
 * �ɼ�����ҵ��ӿ�
 * @author sunst
 * @version 2019-10-12
 */
public interface TScoreDAO {
	/**
	 * ���һ���ɼ�
	 * @param user �ɼ�����
	 * @return ��ӳɹ�������Ӱ�������
	 */
	public int addScore(TScore score);
	
	/**
	 * ɾ��һ���ɼ�
	 * @param scoreid �ɼ�����id
	 * @return ��ӳɹ�������Ӱ�������
	 */
	public boolean deleteScore(int scoreid);
	
	/**
	 * �޸�һ���ɼ�
	 * @param user ��Ҫ�޸ĵĳɼ�����
	 * @return
	 */
	public boolean modifyScore(TScore score);
	
	/**
	 * ����������ȡѧ���ɼ����б�
	 * @param wherecondition ��ϲ�ѯ�����ַ���,�磺"userRole = '��������Ա' and userid = 'zhangjs'" 
	 * @param currentPage ����ҳ��ѯ�ĵ�ǰҳ
	 * @param pageSize ����ҳ��ѯ��ÿҳ����
	 * @return List
	 */
	public List<TScore> getScoreList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * ����������ȡ����������ѧ���ɼ�������
	 * @param wherecondition �磺"userRole = '��������Ա' and userid = 'zhangjs'" 
	 * @return
	 */
	public int getScoreAmount(String wherecondition);
}
