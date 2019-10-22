package business.dao;

import java.util.List;

import model.TQuestionType;

/**
 * ����������ҵ��ӿ�
 * @author sunst
 * @version 2019-10-12
 */
public interface TQuestionTypeDAO {
	/**
	 * ���һ��������
	 * @param QuestionType ���������
	 * @return ��ӳɹ�������Ӱ�������
	 */
	public int addQuestionType(TQuestionType QuestionType);
	
	/**
	 * ɾ��һ��������
	 * @param QuestionType ���������
	 * @return ��ӳɹ�������Ӱ�������
	 */
	public boolean deleteQuestionType(int QuestionTypeid);
	
	/**
	 * �޸�һ��������
	 * @param QuestionType ��Ҫ�޸ĵĴ�����
	 * @return
	 */
	public boolean modifyQuestionType(TQuestionType QuestionType);
	
	/**
	 * ����������ȡ��������б�
	 * @param wherecondition ��ϲ�ѯ�����ַ���,�磺"QuestionTypeRole = '��������Ա' and QuestionTypeid = 'zhangjs'" 
	 * @param currentPage ����ҳ��ѯ�ĵ�ǰҳ
	 * @param pageSize ����ҳ��ѯ��ÿҳ����
	 * @return List
	 */
	public List<TQuestionType> getQuestionTypeList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * ����������ȡ���������Ĵ����������
	 * @param wherecondition �磺"QuestionTypeRole = '��������Ա' and QuestionTypeid = 'zhangjs'" 
	 * @return
	 */
	public int getQuestionTypeAmount(String wherecondition);
}
