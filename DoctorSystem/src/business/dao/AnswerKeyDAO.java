package business.dao;

import java.util.List;

import model.TAnswerKey;

/**
 * �ο��𰸹ؼ���ҵ��ӿ�
 * T_AnswerKey
 * @author Zhangyt
 * @version 2010-10-12
 */

public interface AnswerKeyDAO {
	/**
	 * ���һ���ؼ��ֲο���
	 * @param tanswerkey �ؼ��ֶ���
	 * @return ��ӳɹ�������Ӱ�������
	 */
	public int addAnswerKey(TAnswerKey answerkey);
	
	/**
	 * ɾ��һ���ؼ��ֲο���
	 * @param akeyid �ؼ�������id
	 * @return �ɹ�����true��ʧ��flase
	 */
	public boolean deleteAnswerKey(int akeyid);
	
	/**
	 * �޸�һ���ؼ��ִ�
	 * @param answerkey ��Ҫ�ؼ��ִ𰸶���
	 * @return �ɹ�����true��ʧ��flase
	 */
	public boolean modifyAnswerKey(TAnswerKey answerkey);
	
	/**
	 * ����������ȡ�ؼ��ִ��б�
	 * @param wherecondition ��ϲ�ѯ�����ַ���,�磺"userRole = '��������Ա' and userid = 'zhangjs'" 
	 * @param currentPage ����ҳ��ѯ�ĵ�ǰҳ
	 * @param pageSize ����ҳ��ѯ��ÿҳ����
	 * @return List
	 */
	public List<TAnswerKey> getAnswerKeyList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * ����������ȡ���������Ĺؼ��ִ𰸵�����
	 * @param wherecondition �磺"userRole = '��������Ա' and userid = 'zhangjs'" 
	 * @return
	 */
	public int getAnswerKeyAmount(String wherecondition);
}

	
