package business.dao;
import java.util.List;
import model.TChiefComplaint;

/**
 * ����ҵ��ӿ�
 * T_ChiefComplaint
 * @author Zhangyt
 * @version 2010-10-12
 */
public interface ChiefComplaintDAO {
	/**
	 * ���һ������
	 * @param chiefComplaint ���߶���
	 * @return ��ӳɹ�������Ӱ�������
	 */
	public int addChiefComplaint(TChiefComplaint chiefComplaint);
	
	/**
	 * ɾ��һ������
	 * @param chiefComplaintid ��������id
	 * @return �ɹ�����true��ʧ��flase
	 */
	public boolean deleteChiefComplaint(int chiefComplaintid);
	
	/**
	 * �޸�һ������
	 * @param chiefComplaint ���߶���
	 * @return �ɹ�����true��ʧ��flase
	 */
	public boolean modifyChiefComplaint(TChiefComplaint chiefComplaint);
	
	/**
	 * ����������ȡ�����б�
	 * @param wherecondition ��ϲ�ѯ�����ַ���,�磺"userRole = '��������Ա' and userid = 'zhangjs'" 
	 * @param currentPage ����ҳ��ѯ�ĵ�ǰҳ
	 * @param pageSize ����ҳ��ѯ��ÿҳ����
	 * @return List
	 */
	public List<TChiefComplaint> getChiefComplaintList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * ����������ȡ�������������ߵ�����
	 * @param wherecondition �磺"userRole = '��������Ա' and userid = 'zhangjs'" 
	 * @return
	 */
	public int getChiefComplaintAmount(String wherecondition);
}

	
