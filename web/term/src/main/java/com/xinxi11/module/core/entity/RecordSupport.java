package com.xinxi11.module.core.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

/**
 * 数据记录信息,记录创建人,创建时间,修改人,修改时间,数据删除状态<br>
 * id(类型传入),remark,creator,createDate,editor,editDate,active
 * 
 * @author 李国江
 * @date 2010-1-12
 */
@MappedSuperclass
public abstract class RecordSupport<PK extends Serializable> implements IEntity<PK>, Serializable {

	private static final long serialVersionUID = 9001168848486553502L;
	/** 主键ID */
	protected PK id;
	/** 备注 */
	protected String remark = null;
	/** 创建人 */
	protected String createPerson = null;
	/** 创建时间 */
	protected Date createTime = null;
	/** 修改人 */
	protected String updatePerson = null;
	/** 修改时间 */
	protected Date updateTime = null;
	/** 记录删除状态 0:活动状态 ;1:删除状态 */
	protected Integer active = 0;

	//  UUID设置
	//	@Id
	//	@Column(nullable = false, updatable = false, length = 32)
	//	@GeneratedValue(generator = "system-uuid")
	//	@GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerato")

	//  自增ID设置
	//	@Id
	//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//	@Column(unique = true, nullable = false)

	/**
	 * 子类必须覆盖此方法,否则是无效主键
	 */
	@Transient
	public PK getId() {
		return id;
	}

	public void setId(PK id) {
		this.id = id;
	}

	@Column(name = "remark", length = 500)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(updatable = false)
	public String getCreatePerson() {
		return createPerson;
	}

	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}

	@Column(insertable = false)
	public String getUpdatePerson() {
		return updatePerson;
	}

	public void setUpdatePerson(String updatePerson) {
		this.updatePerson = updatePerson;
	}

	@Column(updatable = false)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(insertable = false)
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "active")
	public Integer getActive() {
		return this.active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

}
