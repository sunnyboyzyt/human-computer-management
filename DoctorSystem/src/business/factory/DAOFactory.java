package business.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import business.dao.AnswerDAO;
import business.dao.AnswerKeyDAO;
import business.dao.ChiefComplaintDAO;
import business.dao.ClassDAO;
import business.dao.EasyExamineDAO;
import business.dao.EexamDAO;
import business.dao.ExamTimeDAO;
import business.dao.LifeDAO;
import business.dao.MentalSocietyDAO;
import business.dao.NowSickDAO;
import business.dao.OtherExamineDAO;
import business.dao.PastSickDAO;
import business.dao.PatientDAO;
import business.dao.PersonalDAO;
import business.dao.PhotoDAO;
import business.dao.QuestionKeyDAO;
import business.dao.TQuestionTypeDAO;
import business.dao.TRoleDAO;
import business.dao.TScoreDAO;
import business.dao.TScoreScaleDAO;
import business.dao.TUnitDAO;
import business.dao.*;

public class DAOFactory {
	private static ApplicationContext ctx = null;
			
	static{
		ctx = new ClassPathXmlApplicationContext("springmvc-servlet.xml");
	}
	
	/**
	 * �õ�һ�����ڴ�����ҵ�������AnswerDAOʵ�������
	 * @return AnswerDAO
	 */
	public static AnswerDAO getAnswerDAO(){
		return (AnswerDAO)ctx.getBean("answerdao");
	}
	
	/**
	 * �õ�һ�����ڴ���ؼ���ҵ�������AnswerKeyDAOʵ�������
	 * @return AnswerKeyDAO
	 */
	public static AnswerKeyDAO getAnswerKeyDAO(){
		return (AnswerKeyDAO)ctx.getBean("answerKeydao");
	}
	
	/**
	 * �õ�һ����������ҵ�������ChiefComplaintDAOʵ�������
	 * @return ChiefComplaintDAO
	 */
	public static ChiefComplaintDAO getChiefComplaintDAO(){
		return (ChiefComplaintDAO)ctx.getBean("ChiefComplaintdao");
	}
	
	/**
	 * �õ�һ���༶ҵ�������ClassDAOʵ�������
	 * @return ClassDAO
	 */
	public static ClassDAO getClassDAO(){
		return (ClassDAO)ctx.getBean("classdao");
	}
	
	/**
	 * �õ�һ�����ڳ�����ҵ�������EasyExamineDAOʵ�������
	 * @return EasyExamineDAO
	 */
	public static EasyExamineDAO getEasyExamineDAO(){
		return (EasyExamineDAO)ctx.getBean("EasyExaminedao");
	}
	
	/**
	 * ����һ�����ڿ���ҵ�������EexamDAO����
	 * @return EexamDAO
	 */
	public static EexamDAO getEexamDAO(){
		return (EexamDAO)ctx.getBean("examdao");
	}
	
	/**
	 * ����һ�����ڲ������Գ��ε�ExamTimeDAO����
	 * @return ExamTimeDAO
	 */
	public static ExamTimeDAO getExamTimeDAO(){
		return (ExamTimeDAO)ctx.getBean("ExamTimedao");
	}
	
	/**
	 * ����һ�������ճ�������Ϣ������LifeDAO����
	 * @return LifeDAO
	 */
	public static LifeDAO getLifeDAO(){
		return (LifeDAO)ctx.getBean("lifedao");
	}
	
	/**
	 * ����һ�����ڶ��������״����Ϣ������MentalSocietyDAO����
	 * @return MentalSocietyDAO
	 */
	public static MentalSocietyDAO getMentalSocietyDAO(){
		return (MentalSocietyDAO)ctx.getBean("MentalSocietydao");
	}

	/**
	 * ����һ�������ֲ�ʷ��Ϣ������NowSickDAO����
	 * @return NowSickDAO
	 */
	public static NowSickDAO getNowSickDAO(){
		return (NowSickDAO)ctx.getBean("NowSickdao");
	}
	
	/**
	 * ����һ�����ڸ��������Ϣ������OtherExamineDAO����
	 * @return OtherExamineDAO
	 */
	public static OtherExamineDAO getOtherExamineDAO(){
		return (OtherExamineDAO)ctx.getBean("OtherExaminedao");
	}
	
	/**
	 * ����һ�����ڼ�����ʷ��Ϣ������PastSickDAO����
	 * @return PastSickDAO
	 */
	public static PastSickDAO getPastSickDAO(){
		return (PastSickDAO)ctx.getBean("PastSickdao");
	}
	
	/**
	 * ����һ�����ڻ�����Ϣ������PatientDAO����
	 * @return PatientDAO
	 */
	public static PatientDAO getPatientDAO(){
		return (PatientDAO)ctx.getBean("patientdao");
	}
	
	/**
	 * ����һ�����ڸ���ʷ��Ϣ������PersonalDAO����
	 * @return PersonalDAO
	 */
	public static PersonalDAO getPersonalDAO(){
		return (PersonalDAO)ctx.getBean("personaldao");
	}
	
	/**
	 * ����һ��������Ƭʷ��Ϣ������PhotoDAO����
	 * @return PhotoDAO
	 */
	public static PhotoDAO getPhotoDAO(){
		return (PhotoDAO)ctx.getBean("photodao");
	}
	
	/**
	 * ����һ����������ؼ�����Ϣ������QuestionKeyDAO����
	 * @return QuestionKeyDAO
	 */
	public static QuestionKeyDAO getQuestionKeyDAO(){
		return (QuestionKeyDAO)ctx.getBean("QuestionKeydao");
	}
	
	/**
	 * ����һ�����ڴ�������Ϣ������TQuestionTypeDAO����
	 * @return TQuestionTypeDAO
	 */
	public static TQuestionTypeDAO getTQuestionTypeDAO(){
		return (TQuestionTypeDAO)ctx.getBean("QuestionTypedao");
	}
	
	/**
	 * ����һ�����ڽ�ɫ��Ϣ������TRoleDAO����
	 * @return TRoleDAO
	 */
	public static TRoleDAO getTRoleDAO(){
		return (TRoleDAO)ctx.getBean("roledao");
	}
	
	/**
	 * ����һ�����ڳɼ���Ϣ������TScoreDAO����
	 * @return TScoreDAO
	 */
	public static TScoreDAO getTScoreDAO(){
		return (TScoreDAO)ctx.getBean("scoredao");
	}
	
	/**
	 * ����һ�����ڸ���÷�ռ����Ϣ������TScoreScaleDAO����
	 * @return TScoreScaleDAO
	 */
	public static TScoreScaleDAO getTScoreScaleDAO(){
		return (TScoreScaleDAO)ctx.getBean("ScoreScaledao");
	}
	
	/**
	 * ����һ�������½�/������Ϣ������TUnitDAO����
	 * @return TUnitDAO
	 */
	public static TUnitDAO getTUnitDAO(){
		return (TUnitDAO)ctx.getBean("unitdao");
	}
	/**
	 * ����һ�������û���Ϣ������UserDAO����
	 * @return UserDAO
	 */
	public static UserDAO getUserDAO(){
		return (UserDAO)ctx.getBean("userdao");
	}
	
	
}
