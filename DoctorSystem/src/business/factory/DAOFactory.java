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
	 * 得到一个用于答题项业务操作的AnswerDAO实现类对象
	 * @return AnswerDAO
	 */
	public static AnswerDAO getAnswerDAO(){
		return (AnswerDAO)ctx.getBean("answerdao");
	}
	
	/**
	 * 得到一个用于答题关键字业务操作的AnswerKeyDAO实现类对象
	 * @return AnswerKeyDAO
	 */
	public static AnswerKeyDAO getAnswerKeyDAO(){
		return (AnswerKeyDAO)ctx.getBean("answerKeydao");
	}
	
	/**
	 * 得到一个用于主诉业务操作的ChiefComplaintDAO实现类对象
	 * @return ChiefComplaintDAO
	 */
	public static ChiefComplaintDAO getChiefComplaintDAO(){
		return (ChiefComplaintDAO)ctx.getBean("ChiefComplaintdao");
	}
	
	/**
	 * 得到一个班级业务操作的ClassDAO实现类对象
	 * @return ClassDAO
	 */
	public static ClassDAO getClassDAO(){
		return (ClassDAO)ctx.getBean("classdao");
	}
	
	/**
	 * 得到一个用于常规检查业务操作的EasyExamineDAO实现类对象
	 * @return EasyExamineDAO
	 */
	public static EasyExamineDAO getEasyExamineDAO(){
		return (EasyExamineDAO)ctx.getBean("EasyExaminedao");
	}
	
	/**
	 * 返回一个用于考试业务操作的EexamDAO对象
	 * @return EexamDAO
	 */
	public static EexamDAO getEexamDAO(){
		return (EexamDAO)ctx.getBean("examdao");
	}
	
	/**
	 * 返回一个用于操作考试场次的ExamTimeDAO对象
	 * @return ExamTimeDAO
	 */
	public static ExamTimeDAO getExamTimeDAO(){
		return (ExamTimeDAO)ctx.getBean("ExamTimedao");
	}
	
	/**
	 * 返回一个用于日常生活信息操作的LifeDAO对象
	 * @return LifeDAO
	 */
	public static LifeDAO getLifeDAO(){
		return (LifeDAO)ctx.getBean("lifedao");
	}
	
	/**
	 * 返回一个用于对心里社会状况信息操作的MentalSocietyDAO对象
	 * @return MentalSocietyDAO
	 */
	public static MentalSocietyDAO getMentalSocietyDAO(){
		return (MentalSocietyDAO)ctx.getBean("MentalSocietydao");
	}

	/**
	 * 返回一个用于现病史信息操作的NowSickDAO对象
	 * @return NowSickDAO
	 */
	public static NowSickDAO getNowSickDAO(){
		return (NowSickDAO)ctx.getBean("NowSickdao");
	}
	
	/**
	 * 返回一个用于辅助检查信息操作的OtherExamineDAO对象
	 * @return OtherExamineDAO
	 */
	public static OtherExamineDAO getOtherExamineDAO(){
		return (OtherExamineDAO)ctx.getBean("OtherExaminedao");
	}
	
	/**
	 * 返回一个用于既往病史信息操作的PastSickDAO对象
	 * @return PastSickDAO
	 */
	public static PastSickDAO getPastSickDAO(){
		return (PastSickDAO)ctx.getBean("PastSickdao");
	}
	
	/**
	 * 返回一个用于基本信息操作的PatientDAO对象
	 * @return PatientDAO
	 */
	public static PatientDAO getPatientDAO(){
		return (PatientDAO)ctx.getBean("patientdao");
	}
	
	/**
	 * 返回一个用于个人史信息操作的PersonalDAO对象
	 * @return PersonalDAO
	 */
	public static PersonalDAO getPersonalDAO(){
		return (PersonalDAO)ctx.getBean("personaldao");
	}
	
	/**
	 * 返回一个用于照片史信息操作的PhotoDAO对象
	 * @return PhotoDAO
	 */
	public static PhotoDAO getPhotoDAO(){
		return (PhotoDAO)ctx.getBean("photodao");
	}
	
	/**
	 * 返回一个用于问诊关键字信息操作的QuestionKeyDAO对象
	 * @return QuestionKeyDAO
	 */
	public static QuestionKeyDAO getQuestionKeyDAO(){
		return (QuestionKeyDAO)ctx.getBean("QuestionKeydao");
	}
	
	/**
	 * 返回一个用于答题项信息操作的TQuestionTypeDAO对象
	 * @return TQuestionTypeDAO
	 */
	public static TQuestionTypeDAO getTQuestionTypeDAO(){
		return (TQuestionTypeDAO)ctx.getBean("QuestionTypedao");
	}
	
	/**
	 * 返回一个用于角色信息操作的TRoleDAO对象
	 * @return TRoleDAO
	 */
	public static TRoleDAO getTRoleDAO(){
		return (TRoleDAO)ctx.getBean("roledao");
	}
	
	/**
	 * 返回一个用于成绩信息操作的TScoreDAO对象
	 * @return TScoreDAO
	 */
	public static TScoreDAO getTScoreDAO(){
		return (TScoreDAO)ctx.getBean("scoredao");
	}
	
	/**
	 * 返回一个用于各项得分占比信息操作的TScoreScaleDAO对象
	 * @return TScoreScaleDAO
	 */
	public static TScoreScaleDAO getTScoreScaleDAO(){
		return (TScoreScaleDAO)ctx.getBean("ScoreScaledao");
	}
	
	/**
	 * 返回一个用于章节/科室信息操作的TUnitDAO对象
	 * @return TUnitDAO
	 */
	public static TUnitDAO getTUnitDAO(){
		return (TUnitDAO)ctx.getBean("unitdao");
	}
	/**
	 * 返回一个用于用户信息操作的UserDAO对象
	 * @return UserDAO
	 */
	public static UserDAO getUserDAO(){
		return (UserDAO)ctx.getBean("userdao");
	}
	
	
}
