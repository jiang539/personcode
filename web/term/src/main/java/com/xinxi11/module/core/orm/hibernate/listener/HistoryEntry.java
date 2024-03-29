package com.xinxi11.module.core.orm.hibernate.listener;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.xinxi11.module.core.entity.RecordSupport;

/**
 * 操作日志的条目
 * 
 * @author jeffrey
 */
@Entity
@NamedQueries( {
// 命名查询，根据实体查询与其关联的审计日志记录，注意这里审计日志和被审计实体并没有物理关联（数据库约束），即使实体被删除，仍然可以根据实体id访问审计日志。
@NamedQuery(name = "HistoryEntry.findByEntity", query = "select h from HistoryEntry h where entity = :entity and entityId = :entityId order by timestamp asc") })
public class HistoryEntry extends RecordSupport<String> implements Serializable {
	private static final long serialVersionUID = 9025279546306024660L;

	/* 操作的时间 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "hs_timestamp")
	private Date timestamp;

	/* 操作的类型（枚举型：新建、更新、删除） */
	private String operationType;

	/* 被操作的实体类型 */
	@SuppressWarnings("unchecked")
	private Class entity;

	/* 被操作实体的主键id */
	@Column(name = "entity_id")
	private Serializable entityId;

	/* 操作描述 */
	private String description;

	/* 被操作的属性 */
	private String property;

	/* 操作前的值 */
	private String previousValue;

	/* 更新值 */
	private String newValue;

	public HistoryEntry() {
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@SuppressWarnings("unchecked")
	public Class getEntity() {
		return entity;
	}

	@SuppressWarnings("unchecked")
	public void setEntity(Class entity) {
		this.entity = entity;
	}

	public Serializable getEntityId() {
		return entityId;
	}

	public void setEntityId(Serializable entityId) {
		this.entityId = entityId;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public String getPreviousValue() {
		return previousValue;
	}

	public void setPreviousValue(String previousValue) {
		this.previousValue = previousValue;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public void setHistorizableEntity(Historizable entity) {
		this.setEntity(entity.getClass());
		this.setEntityId(entity.getId());
		this.setDescription(entity.toString());
	}

	@Override
	public String toString() {
		return "History[" + DateFormat.getDateTimeInstance().format(timestamp) + ", "
				+ operationType + ", " + entity.getSimpleName() + "," + id + " " + property + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final HistoryEntry other = (HistoryEntry) obj;
		return this.getId().equals(other.getId());
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 47 * hash + id.hashCode();
		return hash;
	}
}
