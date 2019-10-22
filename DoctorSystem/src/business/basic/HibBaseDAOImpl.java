package business.basic;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.LogUtil;

public class HibBaseDAOImpl implements iHibBaseDAO {
	private static final Log log = LogFactory.getLog(iHibBaseDAO.class);
	
	public  static  final  int  INSERT  =  1;  //代表添加操作
	public  static  final  int  UPDATE  =  2;  //代表修改操作 
	public  static  final  int  DELETE  =  3;  //代表删除操作
	
	@Override
	public Object insert(Object obj) {//obj必须是符合hibernate的pojo对象
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null;//创建一个事务
		try {
			tx  =  session.beginTransaction();  //开启一个事务 
			Serializable key = session.save(obj);
			tx.commit();//持久化数据
			session.close();
			return key;
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.err("Basic.HibBaseDAOImpl.insert", e);
			if(tx!=null) tx.rollback();//撤销事务
			if(session!=null) session.close();
		}
		return null;
	}

	@Override
	public boolean insert(List<Object> list) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null;//创建一个事务
		try {
			tx  =  session.beginTransaction();  //开启一个事务 
			for (Object obj : list) {
				session.save(obj);
			}
			tx.commit();//持久化数据
			session.close();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(tx!=null) tx.rollback();//撤销事务
			if(session!=null) session.close();
		}
		return false;
	}

	@Override
	public boolean delete(Class cls, Serializable id) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null;//创建一个事务
		try {
			tx  =  session.beginTransaction();  //开启一个事务 
			//先用cls和id查出要删除的对象
			session.delete(session.get(cls, id));
			tx.commit();//持久化数据
			session.close();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(tx!=null) tx.rollback();//撤销事务
			if(session!=null) session.close();
		}
		return false;
	}

	@Override
	public boolean delete(Object obj) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null;//创建一个事务
		try {
			tx  =  session.beginTransaction();  //开启一个事务 
			session.delete(obj);
			tx.commit();//持久化数据
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null) tx.rollback();//撤销事务
			if(session!=null) session.close();
		}
		return false;
	}

	@Override
	public boolean update(Object obj) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null;//创建一个事务
		try {
			tx  =  session.beginTransaction();  //开启一个事务 
			session.update(obj);
			tx.commit();//持久化数据
			session.close();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(tx!=null) tx.rollback();//撤销事务
			if(session!=null) session.close();
		}
		return false;
	}

	@Override
	public List select(String hql) {
		Session session = HibernateSessionFactory.getSession();
		try {
			Query query = session.createQuery(hql);
			List list = query.list();
			session.close();
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(session!=null) session.close();
		}
		return null;
	}

	@Override
	public List select(String hql, int startIndex, int length) {
		Session session = HibernateSessionFactory.getSession();
		try {
			Query query = session.createQuery(hql);
			query.setFirstResult(startIndex);//设置起始记录位置
			query.setMaxResults(length);//设置返回记录数
			List list = query.list();
			session.close();
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(session!=null) session.close();
		}
		return null;
	}

	@Override
	public List select(String hql, Object[] para) {
		Session session = HibernateSessionFactory.getSession();
		try {
			Query query = session.createQuery(hql);
			//根据para设置参数
			for (int i = 0; i < para.length; i++) {
				query.setParameter(i, para[i]);
			}
			List list = query.list();
			session.close();
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(session!=null) session.close();
		}
		return null;
	}

	@Override
	public List select(String hql, Object[] para, int startIndex, int length) {
		Session session = HibernateSessionFactory.getSession();
		try {
			Query query = session.createQuery(hql);
			//根据para设置参数
			for (int i = 0; i < para.length; i++) {
				query.setParameter(i, para[i]);
			}
			query.setFirstResult(startIndex);
			query.setMaxResults(length);
			List list = query.list();
			session.close();
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(session!=null) session.close();
		}
		return null;
	}

	@Override
	public int selectValue(String hql) {
		Session session = HibernateSessionFactory.getSession();
		try {
			Query query = session.createQuery(hql);
			Object obj = query.uniqueResult();
			session.close();
			if(obj instanceof Long)
				return ((Long)obj).intValue();
			else if (obj instanceof Integer)
				return ((Integer)obj).intValue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(session!=null) session.close();
		}
		return 0;
	}

	@Override
	public int selectValue(String hql, Object[] para) {
		Session session = HibernateSessionFactory.getSession();
		try {
			Query query = session.createQuery(hql);
			//根据para设置参数
			for (int i = 0; i < para.length; i++) {
				query.setParameter(i, para[i]);
			}
			Object obj = query.uniqueResult();
			session.close();
			if(obj instanceof Long)
				return ((Long)obj).intValue();
			else if (obj instanceof Integer)
				return ((Integer)obj).intValue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(session!=null) session.close();
		}
		return 0;
	}

	@Override
	public int selectPages(String hql, int pageSize) {
		Session session = HibernateSessionFactory.getSession();
		long pages_all = 0;
		try {
			Query query = session.createQuery(hql);
			List list = query.list();
			//获得查询记录总数
			long records = list.size();
			//计算分页数
			pages_all = records%pageSize==0?records/pageSize:records/pageSize + 1;//获得总页数
			session.close();
			return (int)pages_all;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(session!=null) session.close();
		}
		return 0;
	}

	@Override
	public int selectPages(String hql, Object[] para, int pageSize) {
		Session session = HibernateSessionFactory.getSession();
		//编程思想：先获得查询记录数，在使用算法来计算出分页的页数
		long pages_all = 0;
		try {
			Query query = session.createQuery(hql);
			//根据para设置参数
			for (int i = 0; i < para.length; i++) {
				query.setParameter(i, para[i]);
			}
			List list = query.list();
			//获得查询记录总数
			long records = list.size();
			//计算分页数
			pages_all = records%pageSize==0?records/pageSize:records/pageSize + 1;//获得总页数
			session.close();
			return (int)pages_all;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(session!=null) session.close();
		}
		return 0;
	}

	@Override
	public List selectByPage(String hql, int startPage, int pageSize) {
		Session session = HibernateSessionFactory.getSession();
		//编程思想：先获得查询记录数，在使用算法来计算出分页的页数
		List plist = null;
		int currentPage;
		try {
			Query query = session.createQuery(hql);
			//先求出按照pageSize得到的分页的页数
			List list = query.list();
			//获得查询记录总数
			long records = list.size();
			//获得总页数
			int pages_all = (int)(records%pageSize==0?records/pageSize:records/pageSize + 1);//获得总页数
			
			//设置类成员当前页面的操作页码
			if (startPage<=1) {
				currentPage = 1;
			}else if (startPage>=pages_all) {
				currentPage = pages_all;
			}else {
				currentPage = startPage;
			}
			
			Query query2 = session.createQuery(hql);
			query2.setFirstResult((currentPage - 1)*pageSize);//从第几条记录开始查询
			query2.setMaxResults(pageSize);//每页显示多少条记录
			
			plist=query2.list();
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(session!=null) session.close();
		}
		return plist;
	}

	@Override
	public List selectByPage(String hql, Object[] para, int startPage,
			int pageSize) {
		Session session = HibernateSessionFactory.getSession();
		List plist = null;
		int currentPage;
		try {
			Query query = session.createQuery(hql);
			//根据para设置参数
			for (int i = 0; i < para.length; i++) {
				query.setParameter(i, para[i]);
			}
			List list = query.list();
			//获得查询记录总数
			long records = list.size();
			//获得总页数
			int pages_all = (int)(records%pageSize==0?records/pageSize:records/pageSize + 1);//获得总页数
			
			//设置类成员当前页面的操作页码
			if (startPage<=1) {
				currentPage = 1;
			}else if (startPage>=pages_all) {
				currentPage = pages_all;
			}else {
				currentPage = startPage;
			}
			
			Query query2 = session.createQuery(hql);
			//根据para设置参数
			for (int i = 0; i < para.length; i++) {
				query2.setParameter(i, para[i]);
			}
			query2.setFirstResult((currentPage - 1)*pageSize);//从第几条记录开始查询
			query2.setMaxResults(pageSize);//每页显示多少条记录
			
			plist=query2.list();
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(session!=null) session.close();
		}
		return plist;
	}

	@Override
	public Object findById(Class cls, Serializable id) {
		Session session = HibernateSessionFactory.getSession();
		try {
			Object obj = session.get(cls, id);
			session.close();
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
			if(session!=null) session.close();
		}
		return null;
	}

	@Override
	public boolean update(String sql) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();//开启一个事务
			//将会话session对象转换成jdbc的connection
			Connection con = session.connection();
			PreparedStatement ptmt = con.prepareStatement(sql);
			int row = ptmt.executeUpdate();
			tx.commit();//持久化操作
			session.close();
			if(row > 0) 
				return true;
			else 
				return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(tx!=null) tx.rollback();//撤销事务
			if(session!=null) session.close();
		}
		return false;
	}

	@Override
	public boolean update(String sql, Object[] para) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();//开启一个事务
			//将会话session对象转换成jdbc的connection
			Connection con = session.connection();
			PreparedStatement ptmt = con.prepareStatement(sql);
			//根据para设置参数
			for (int i = 0; i < para.length; i++) {
				ptmt.setObject(i+1, para[i]);
			}
			int row = ptmt.executeUpdate();
			tx.commit();//持久化操作
			session.close();
			if(row > 0) 
				return true;
			else 
				return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(tx!=null) tx.rollback();//撤销事务
			if(session!=null) session.close();
		}
		return false;
	}

	@Override
	public boolean delete(String sql) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();//开启一个事务
			//将会话session对象转换成jdbc的connection
			Connection con = session.connection();
			PreparedStatement ptmt = con.prepareStatement(sql);
			int row = ptmt.executeUpdate();
			tx.commit();//持久化操作
			session.close();
			if(row > 0) 
				return true;
			else 
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null) tx.rollback();//撤销事务
			if(session!=null) session.close();
		}
		return false;
	}

	@Override
	public boolean delete(String sql, Object[] para) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();//开启一个事务
			//将会话session对象转换成jdbc的connection
			Connection con = session.connection();
			PreparedStatement ptmt = con.prepareStatement(sql);
			//根据para设置参数
			for (int i = 0; i < para.length; i++) {
				ptmt.setObject(i+1, para[i]);
			}
			int row = ptmt.executeUpdate();
			tx.commit();//持久化操作
			session.close();
			if(row > 0) 
				return true;
			else 
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null) tx.rollback();//撤销事务
			if(session!=null) session.close();
		}
		return false;
	}

	@Override
	public Object executeProduce(String procName) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();//开启一个事务
			//将会话session对象转换成jdbc的connection
			Connection conn = session.connection();
			CallableStatement ctmt = conn.prepareCall("{? = call" + procName + "}");
			ctmt.registerOutParameter(1, java.sql.Types.INTEGER);
			
			boolean type = ctmt.execute();
			tx.commit();//持久化
			if (type) {//为true表明存储过程是一个select语句
				ResultSet rs = ctmt.getResultSet();
				return rs;
			}else {//不是select，则获取返回值
				int isSuccess = ctmt.getInt(1);//获取返回值
				session.close();
				return new Integer(isSuccess);
			}
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null) tx.rollback();//撤销事务
			if(session!=null) session.close();
		}
		return null;
	}

	@Override
	public Object executeProduce(String procName, Object[] para) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();//开启一个事务
			//将会话session对象转换成jdbc的connection
			Connection conn = session.connection();
			CallableStatement ctmt = conn.prepareCall("{? = call " + procName + "}");
			ctmt.registerOutParameter(1, java.sql.Types.INTEGER);
			for (int i = 0; i < para.length; i++) {
				ctmt.setObject(i+2, para[i]);
			}
			
			boolean type = ctmt.execute();
			tx.commit();//持久化
			if (type) {//为true表明存储过程是一个select语句
				ResultSet rs = ctmt.getResultSet();
				return rs;
			}else {//不是select，则获取返回值
				int isSuccess = ctmt.getInt(1);//获取返回值
				session.close();
				return new Integer(isSuccess);
			}
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null) tx.rollback();//撤销事务
			if(session!=null) session.close();
		}
		return null;
	}

	@Override
	public boolean executeBatch(Object[] obj, int[] model) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			for (int i = 0; i < obj.length; i++) {
				if (model[i]==INSERT) 
					session.save(obj[i]);
				else if (model[i]==UPDATE)
					session.update(obj[i]);
				else if (model[i]==DELETE)
					session.delete(obj[i]);
			}
			tx.commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null) tx.rollback();//撤销事务
			if(session!=null) session.close();
		}
		return false;
	}

	@Override
	public boolean executeBatch(List<Object> list, List<Integer> models) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			for (int i = 0; i < list.size(); i++) {
				Object obj = list.get(i);
				Integer model = (Integer)models.get(i);
				if (model.intValue()==INSERT) {
					session.save(obj);
				}else if (model.intValue()==UPDATE){
					session.update(obj);
				}else if (model.intValue()==DELETE)
					session.delete(obj);
			}
			tx.commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null) tx.rollback();//撤销事务
			if(session!=null) session.close();
		}
		return false;
	}

}
