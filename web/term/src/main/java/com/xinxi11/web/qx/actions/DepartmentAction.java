package com.xinxi11.web.qx.actions;

import org.springframework.beans.factory.annotation.Autowired;

import com.xinxi11.module.core.web.struts2.BaseActionSupport;
import com.xinxi11.module.core.web.struts2.Struts2Utils;
import com.xinxi11.web.entity.qx.Department;
import com.xinxi11.web.qx.service.IDepartmentService;

/**
 * 请在此加入你的功能说明
 * 
 * @author 李国江
 * @date 2012-9-14
 */
public class DepartmentAction extends BaseActionSupport<Department> {

	private static final long serialVersionUID = 6991256971048952964L;
	private IDepartmentService departmentService;

	@Autowired
	public void setDepartmentService(IDepartmentService departmentService) {
		this.departmentService = departmentService;
		this.dto = new Department();
		this.querybean = null;
	}

	@Override
	public String execute() throws Exception {
		return LIST;
	}

	public String ajaxDepartmentTree() {
		String resourcesId = Struts2Utils.getRequest().getParameter("resourcesId");
		return departmentService.findTreeJsonData(resourcesId);
	}

}
