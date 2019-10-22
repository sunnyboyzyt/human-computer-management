package business.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import model.TUser;
import business.basic.HibBaseDAOImpl;
import business.basic.iHibBaseDAO;
import business.dao.UserDAO;
/**
 * 用户数据业务实现类
 * @author sunst
 * @version 2019-10-12
 */
@Component("userdao")
public class UserDAOImpl implements UserDAO {
	//连接数据库操作层接口,实现业务与数据的交换
	private iHibBaseDAO bdao= null; 
	
	public UserDAOImpl(){
		bdao = new HibBaseDAOImpl();
	}
	
	@Override
	public int addUser(TUser user) {
		return (Integer) bdao.insert(user);
	}

	@Override
	public boolean deleteUser(int userid) {
		String sql = "update T_User set isdelete = 0 where userid = ?";
		Object[] para = {userid};
		System.out.println(sql);
		return bdao.update(sql, para);
		
	}

	@Override
	public boolean modifyUser(TUser user) {
		return bdao.update(user);
	}

	@Override
	public List<TUser> getUserList(String wherecondition, int currentPage,
			int pageSize) {
		String hql = "from TUser where isdelete = 1";
		if (wherecondition == null && wherecondition.equals("")){
			hql += "order by user desc"; 
		}
		if (wherecondition != null && !wherecondition.equals("")){
			hql += "order by user desc"; 
		}
		
		List<TUser> list = bdao.selectByPage(hql, currentPage, pageSize);
		return list;
	}

	@Override
	public int getUserAmount(String wherecondition) {
		String hql = "select count(*) from TUser";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition; 
		}
		return bdao.selectValue(hql);
	}

	@Override
	public List<TUser> loginuser(int userid, String pwd) {
		String hql ="from TUser where userid=? and pwd =? and isdelete = 1 ";
		Object[] para = {userid,pwd};
		//返回整个对象
		return bdao.select(hql, para);
	}

	@Override
	public boolean Upedtpwd(int userid, String pwd) {
		String sql = "update T_User set pwd = ? where userid = ?";
		Object[] para = {pwd,userid};
		System.out.println(sql);
		return bdao.update(sql, para);
	}
	
	@Override
	public TUser getUserById(int userid){
		return (TUser) bdao.findById(TUser.class, userid);
	}
}
