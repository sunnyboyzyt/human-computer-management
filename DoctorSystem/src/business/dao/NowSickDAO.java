package business.dao;

import java.util.List;
import model.TNowSick;

/**
	 * �ֲ�ʷҵ��ӿ�
	 * T_NowSick
	 * @author Zhangyt
	 * @version 2010-10-12
	 */
public interface NowSickDAO {
	
	/**
	 * ���һ���ֲ�ʷ����
	 * @param nowsick �ֲ�ʷ����
	 * @return ��ӳɹ�������Ӱ�������
	 */
	public int addNowSick(TNowSick nowsick);
	
	/**
	 * ɾ��һ���ֲ�ʷ����
	 * @param nowsicktid �ֲ�ʷ��������id
	 * @return �ɹ�����true��ʧ��false
	 */
	public boolean deleteNowSick(int nowsicktid);
	
	/**
	 * �޸�һ���ֲ�ʷ����
	 * @param nowsick �ֲ�ʷ����
	 * @return �ɹ�����true��ʧ��false
	 */
	public boolean modifyNowSick(TNowSick nowsick);
	
	/**
	 * ����������ȡ�ֲ�ʷ�б�
	 * @param wherecondtion ��ϲ�ѯ�����ַ���
	 * @param currentpage ����ҳ��ѯ�ĵ�ǰҳ
	 * @param pageSize ����ҳ��ѯ��ÿҳ����
	 * @return List
	 */
	public List<TNowSick> getNowSickList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * ����������ȡ�����������ֲ�ʷ�б�����
	 * @param wherecondtion ��ϲ�ѯ�����ַ���
	 * @return 
	 */
	public int getNowSickAmount(String wherecondition);
	

}
