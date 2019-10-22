package util;
/**
 * 记录异常日志文件的工具类
 * @author zhangjs
 *
 */
public class LogUtil {
	/**
	 * 向log文件中写入一个错误日志到文件中
	 * @param title  信息标题
	 * @param e  异常对象
	 * @return String 写入日志文件的信息
	 */
	public static String err(String title,Throwable e){
		StackTraceElement[] s = e.getStackTrace();
		StringBuffer sb = new StringBuffer();
		sb.append("\r\n-----------------------error--------------\n");
		sb.append("\r\n出错位置：" + title + "\n");
		//从数组中取出异常信息，构建为一个字符串
		for(int i=0;i<s.length;i++){
			sb.append("\r\n");
			sb.append(s[i]);
		}
		return sb.toString();
	}
}
