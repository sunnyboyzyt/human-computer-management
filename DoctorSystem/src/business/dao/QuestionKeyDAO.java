package business.dao;

import java.util.List;
import model.TQuestionKey;
/**
 * �ɼ�ҵ��ӿ�
 * @author CJJ
 * @version 2019-10-13
 */
public interface QuestionKeyDAO {
	
	/**
	 * ���һ���ɼ�
	 * @param QuestionKey �ɼ�����
	 * @return ��ӳɹ�������Ӱ�������
	 */
	public int addQuestionKey(TQuestionKey QuestionKey);
	
	/**
	 * ɾ��һ���ɼ�
	 * @param qkeyid �ɼ�id
	 * @return ��ӳɹ�������Ӱ�������
	 */
	public boolean deleteQuestionKey(int qkeyid);
	
	/**
	 * �޸�һ���ɼ�
	 * @param QuestionKey ��Ҫ�޸ĵĳɼ�
	 * @return
	 */
	public boolean modifyQuestionKey(TQuestionKey QuestionKey);
	
	/**
	 * ����������ȡ�ɼ����б�
	 * @param wherecondition ��ϲ�ѯ�����ַ���,�磺"qkey = '�ٵľͿ���' " 
	 * @param currentPage ����ҳ��ѯ�ĵ�ǰҳ
	 * @param pageSize ����ҳ��ѯ��ÿҳ����
	 * @return List
	 */
	public List<TQuestionKey> getTQuestionKeyList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * ����������ȡ���������ĳɼ�������
	 * @param wherecondition �磺"personalid = '��ʷid' " 
	 * @return
	 */
	public int getQuestionKeyAmount(String wherecondition);

}
