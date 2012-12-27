package com.term.dbaccess.dao.power.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import com.term.dbaccess.core.BaseHibernateDaoImpl;
import com.term.dbaccess.dao.power.IUserDao;
import com.xinxi11.web.entity.qx.User;

/**
 * 请在此加入你的功能说明
 * 
 * @author 李国江
 * @date 2009-5-2 上午09:26:56
 */
@Service("userDao")
public class UserDaoImpl extends BaseHibernateDaoImpl<User> implements IUserDao {

	public UserDaoImpl() {
		super(User.class);
	}

	public UserDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory, User.class);
	}

	@Override
	public void update(User t) {
		if (t.getPassword() != null) {
			super.update(t);
		} else {
			// 不更新密码
			String hql = "update User set name=?,sex=?,email=?,phone=?,address=?,active=1,state=1 where id=?";
			Object[] values = new Object[] { t.getName(), t.getSex(),
					t.getEmail(), t.getPhone(), t.getAddress(), t.getId() };
			executeHql(hql, values);
		}
	}

	@Override
	public int updatePassword(String id, String oldPwd, String newPwd) {
		if (loginCheck(id, oldPwd)) {
			String hql = "update User set password=? where id=?";
			Object[] values = new Object[] { newPwd, id };
			return executeHql(hql, values);
		}
		return 0;
	}

	@Override
	public boolean loginCheck(String userid, String encoderByMd5For32Bit) {
		String hql = " select id from User where id=? and password=?";
		Object[] values = new Object[] { userid, encoderByMd5For32Bit };
		String id = (String) findForUnique(hql, values);
		if (id != null) {
			return true;
		}
		return false;
	}

}
