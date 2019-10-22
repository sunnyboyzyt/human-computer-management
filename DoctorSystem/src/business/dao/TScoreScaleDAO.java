package business.dao;

import java.util.List;

import model.TScoreScale;

/**
 * ����÷�ռ������ҵ��ӿ�
 * @author sunst
 * @version 2019-10-12
 */
public interface TScoreScaleDAO {
	/**
	 * ���һ���÷�ռ��
	 * @param ScoreScale �÷�ռ�ȶ���
	 * @return ��ӳɹ�������Ӱ�������
	 */
	public int addScoreScale(TScoreScale ScoreScale);
	
	/**
	 * ɾ��һ���÷�ռ��
	 * @param ScoreScale �÷�ռ�ȶ���
	 * @return ��ӳɹ�������Ӱ�������
	 */
	public boolean deleteScoreScale(int ScoreScaleid);
	
	/**
	 * �޸�һ���÷�ռ��
	 * @param ScoreScale ��Ҫ�޸ĵĵ÷�ռ��
	 * @return
	 */
	public boolean modifyScoreScale(TScoreScale ScoreScale);
	
	/**
	 * ����������ȡ�÷�ռ�ȵ��б�
	 * @param wherecondition ��ϲ�ѯ�����ַ���,�磺"ScoreScaleRole = '��������Ա' and ScoreScaleid = 'zhangjs'" 
	 * @param currentPage ����ҳ��ѯ�ĵ�ǰҳ
	 * @param pageSize ����ҳ��ѯ��ÿҳ����
	 * @return List
	 */
	public List<TScoreScale> getScoreScaleList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * ����������ȡ���������ĵ÷�ռ�ȵ�����
	 * @param wherecondition �磺"ScoreScaleRole = '��������Ա' and ScoreScaleid = 'zhangjs'" 
	 * @return
	 */
	public int getScoreScaleAmount(String wherecondition);
}
