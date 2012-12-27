package com.term.dbaccess.core.entity;


/**
 * 如果要生成日志的对象必须实现该接口
 * 
 */
public interface Auditable {

	/**
	 * 获取该操作的用户id
	 * 
	 * @return
	 */
	String getOperateUserName();
	
	/**
	 * 得到当前entity的ID
	 * @return
	 */
	Integer getId();
	
	/**
	 * 是物理删除还是逻辑删除(逻辑删除为set Active)
	 * @return trun为逻辑删除 false为物理删除
	 */
	boolean getIsActiveDelete();
	
	/**
	 * 得到父Entity的ID 如果没有返回null
	 * @return
	 */
	String getParentId();
	
}
