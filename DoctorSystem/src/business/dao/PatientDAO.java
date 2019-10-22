package business.dao;
import java.util.List;

import model.TPastSick;
import model.TPatient;
import model.TUser;


/**
 * ����ҵ��ӿ�
 * @author CJJ
 * @version 2019-10-13
 */
public interface PatientDAO {
	
	
	/**
	 * ���һ������
	 * @param Patient �������
	 * @return ��ӳɹ�������Ӱ�������
	 */
	public int addPatient(TPatient Patient);
	
	/**
	 * ɾ��һ������
	 * @param patientid �������id
	 * @return ��ӳɹ�������Ӱ�������
	 */
	public boolean deletePatient(int patientid);
	
	/**
	 * �޸�һ������
	 * @param Patient ��Ҫ�޸ĵ��������
	 * @return
	 */
	public boolean modifyPatient(TPatient Patient);
	
	/**
	 * ����������ȡ������б�
	 * @param wherecondition ��ϲ�ѯ�����ַ���,�磺"patientid = '����id' " 
	 * @param currentPage ����ҳ��ѯ�ĵ�ǰҳ
	 * @param pageSize ����ҳ��ѯ��ÿҳ����
	 * @return List
	 */
	public List<TPatient> getTPatientList(String wherecondition,int currentPage,int pageSize);
	
	/**
	 * ����������ȡ�������������������
	 * @param wherecondition �磺"patientid = '����id' " 
	 * @return
	 */
	public int getPatientAmount(String wherecondition);

}
