package util;
/**
 * ��¼�쳣��־�ļ��Ĺ�����
 * @author zhangjs
 *
 */
public class LogUtil {
	/**
	 * ��log�ļ���д��һ��������־���ļ���
	 * @param title  ��Ϣ����
	 * @param e  �쳣����
	 * @return String д����־�ļ�����Ϣ
	 */
	public static String err(String title,Throwable e){
		StackTraceElement[] s = e.getStackTrace();
		StringBuffer sb = new StringBuffer();
		sb.append("\r\n-----------------------error--------------\n");
		sb.append("\r\n����λ�ã�" + title + "\n");
		//��������ȡ���쳣��Ϣ������Ϊһ���ַ���
		for(int i=0;i<s.length;i++){
			sb.append("\r\n");
			sb.append(s[i]);
		}
		return sb.toString();
	}
}
