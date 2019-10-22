package business.dao;
import java.util.List;
import model.TAnswer;

/**
	 * �����ҵ��ӿ�
	 * T_Answer
	 * @author Zhangyt
	 * @version 2010-10-12
	 */

public interface AnswerDAO {

	/**
	 * ���һ��������
	 * @param tanswer �𰸶���
	 * @return ��ӳɹ�������Ӱ�������
	 */
	public int addAnswer(TAnswer answer);
	
	/**
	 * ɾ��һ��������
	 * @param answerid �𰸶�������id
	 * @return �ɹ�����true��ʧ��false
	 */
	public boolean deleteAnswer(int answerid);
	
	/**
	 * �޸�һ��������
	 * @param tanswer �𰸶���
	 * @return �ɹ�����true��ʧ��false
	 */
	public boolean modifyAnswer(TAnswer answer);
	
	/**
	 * ����������ȡ���б�
	 * @param wherecondtion ��ϲ�ѯ�����ַ���
	 * @param currentpage ����ҳ��ѯ�ĵ�ǰҳ
	 * @param pageSize ����ҳ��ѯ��ÿҳ����
	 * @return List
	 */
	public List<TAnswer> getAnswersList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * ����������ȡ���������Ĵ��б�����
	 * @param wherecondtion ��ϲ�ѯ�����ַ���
	 * @return 
	 */
	public int getAnswersAmount(String wherecondition);
	

}
