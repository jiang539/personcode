package com.xinxi11.module.core.orm.hibernate.listener;

import java.io.Serializable;

/**
 * Mark性质的接口，实现该接口的实体类表示需要审计日志
 */
public interface Historizable {
	public Serializable getId();
}
