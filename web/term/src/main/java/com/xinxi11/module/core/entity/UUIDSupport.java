package com.xinxi11.module.core.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * 主键生成策略,32位UUID.需要hibernate支持
 * 
 * @author 李国江
 * @date 2010-1-12
 */
@MappedSuperclass
public class UUIDSupport implements IEntity<String>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3926418377486646886L;
	protected String id;

	@Id
	@Column(nullable = false, updatable = false, length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

}
