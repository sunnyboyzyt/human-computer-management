package business.dao;

import java.util.List;
import model.TPastSick;

/**
 * ������ʷҵ��ӿ�
 * @author CJJ
 * @version 2019-10-13
 */
public interface PastSickDAO {
	
	/**
	 * ���һ��������ʷ
	 * @param PastSick ������ʷ����
	 * @return ��ӳɹ�������Ӱ�������
	 */
	public int addPastSick(TPastSick PastSick);
	
	/**
	 * ɾ��һ��������ʷ
	 * @param pastsickid ��ʷ���
	 * @return ��ӳɹ�������Ӱ�������
	 */
	public boolean deletePastSick(int pastsickid);
	
	/**
	 * �޸�һ��������ʷ
	 * @param PastSick ��Ҫ�޸ĵļ�����ʷ����
	 * @return
	 */
	public boolean modifyPastSick(TPastSick PastSick);
	
	/**
	 * ����������ȡ������ʷ���б�
	 * @param wherecondition ��ϲ�ѯ�����ַ���,�磺"patientid = '����id' " 
	 * @param currentPage ����ҳ��ѯ�ĵ�ǰҳ
	 * @param pageSize ����ҳ��ѯ��ÿҳ����
	 * @return List
	 */
	public List<TPastSick> getTPastSickList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * ����������ȡ�������������������
	 * @param wherecondition �磺"patientid = '����id' " 
	 * @return
	 */
	public int getPastSickAmount(String wherecondition);

}
