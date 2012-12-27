package com.xinxi11.web.qx.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.xinxi11.module.core.cache.LoginUserInfo;
import com.xinxi11.module.core.orm.Finder;
import com.xinxi11.module.core.orm.hibernate.IHibernateDao;
import com.xinxi11.module.core.service.impl.BaseServiceImpl;
import com.xinxi11.web.entity.qx.Department;
import com.xinxi11.web.qx.service.IDepartmentService;

/**
 * 请在此加入你的功能说明
 * 
 * @author 李国江
 * @date 2012-9-14
 */
public class DepartmentServiceImpl extends BaseServiceImpl implements IDepartmentService {

	@Autowired
	private IHibernateDao hibernateDao;

	@Override
	public String findTreeJsonData(String resourcesId) {
		LoginUserInfo loginUser = getLoginUserInfo();
		Set<Department> depaList = new HashSet<Department>();
		if (loginUser.getIsEmployee()) {
			Finder finder = new Finder("");
			finder.append("select department from UserDepartment where user.id=?");
			finder.addValues(loginUser.getId());
			depaList.add((Department) hibernateDao.queryForList(finder, null));
		} else {
			if (loginUser.getIsAdmin()) {
				Finder finder = new Finder("");
				finder.append("select role.department from RoleResources where resources.id=? and role.id in (select roleId from UserRole where userId=?)");
				finder.addValues(resourcesId);
				finder.addValues(loginUser.getId());
				depaList.add((Department) hibernateDao.queryForList(finder, null));
			}
			if (loginUser.getIsManager()) {
				Finder finder = new Finder("");
				finder.append("select department from UserDepartment where user.id=? and department.isManager='Y'");
				finder.addValues(loginUser.getId());
				depaList.add((Department) hibernateDao.queryForList(finder, null));
			}
		}

		return null;
	}

}
