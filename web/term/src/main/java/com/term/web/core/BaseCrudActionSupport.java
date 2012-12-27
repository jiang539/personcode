/**
 * 
 */

package com.term.web.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.term.business.core.IBaseService;
import com.term.dbaccess.core.Pagination;
import com.term.utils.ReflectUtil;
import com.term.utils.Utilities;

/**
 * 基本的CRUD操作的实现
 */
@SuppressWarnings( { "serial" })
@ParentPackage("default")
public class BaseCrudActionSupport<T> extends CrudActionSupport {

	protected IBaseService<T> baseService;

	protected T entity;
	protected List<T> listEntity = new ArrayList<T>();
	protected String entityIdName = "id";
	/**
	 * ajax验证的属性值
	 */
	protected String[] propertys = null;

	public List<T> getListEntity() {
		return listEntity;
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	@Override
	public String delete() throws Exception {
		baseService.delete(sid);
		return RELOAD;
	}

	@Override
	public String list() throws Exception {
		beforeList();
		page = new Pagination(pageIndex, pageSize);
		listEntity = baseService.findAll(page);
		return SUCCESS;
	}

	public String saveOrUpdateById() throws Exception {
		// 根据主键是否为空,判断是save 或者 update
		if (extractId(entity) == null) {
			return save();
		} else {
			return update();
		}
	}

	public String saveOrUpdate() throws Exception {
		// 根据主键是否为空,判断是save 或者 update
		beforeSaveOrUpdate();
		baseService.saveOrUpdate(entity);
		addActionMessage("操作成功");
		return RELOAD;
	}

	@Override
	public String save() throws Exception {
		// ReflectUtil.setFieldValue(entity, entityIdName, Utilities.getUUID());
		beforeSave();
		baseService.save(entity);
		addActionMessage("保存成功");
		return RELOAD;
	}

	@Override
	public String update() throws Exception {
		beforeUpdate();
		baseService.update(entity);
		addActionMessage("更新成功");
		return RELOAD;
	}

	@Override
	public String input() throws Exception {
		beforeInput();
		if (sid != null) {
			entity = baseService.findById(sid);
		}
		return INPUT;
	}

	public void beforeSave() throws Exception {

	}

	public void beforeUpdate() throws Exception {

	}

	public void beforeSaveOrUpdate() throws Exception {

	}

	public void beforeInput() throws Exception {

	}

	public void beforeList() throws Exception {

	}

	public String isExist() throws Exception {
		String[] value = getAjaxValidator();
		String result = "true";
		if (value != null) {
			if (!baseService.isExistByProperty(sid, value[0], value[1])) {
				result = "false";
			}
		}
		Struts2Utils.renderText(result);
		return null;
	}

	/**
	 * 获取对象的主键
	 * 
	 * @param model
	 * @return
	 */
	protected Serializable extractId(T model) {
		if (model == null || model instanceof Object) {
			return null;
		}
		return (Serializable) ReflectUtil.getFieldValue(model, entityIdName);
	}

	/**
	 * 设置对象的主键值
	 */
	protected void setEntityIdValue() {
		ReflectUtil.setFieldValue(entity, entityIdName, Utilities.getUUID());
	}

	protected String[] getSplitSparm() {
		if (StringUtils.isBlank(sparm)) {
			return null;
		}
		return sparm.split(";");
	}

	protected String[] getSplitSparm(Integer index) {
		String[] parms = getSplitSparm();
		if (parms == null) {
			return null;
		}
		String[] result = parms[index].split(":");
		Integer pi = null;
		try {
			pi = Integer.valueOf(result[0]);
		} catch (NumberFormatException e) {
			return null;
		}
		if (pi == null || pi < 0 || pi > propertys.length - 1
				|| StringUtils.isBlank(result[1].trim())) {
			return null;
		}
		result[0] = propertys[pi];
		return result;
	}

	/**
	 * 针对jquery formvalidator的AjaxValidator的传参方式写的方法
	 * 
	 * @return
	 */
	private String[] getAjaxValidator() {
		String name = Struts2Utils.getParameter("clientid");
		String value = Struts2Utils.getParameter(name);
		return new String[] { name, value };
	}

}
