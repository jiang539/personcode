package com.xinxi11.module.core.entity;

import java.io.Serializable;

/**
* 实体类要继承的接口
* 有其它用途
*/
public interface IEntity<PK> extends Serializable {

	PK getId();

	void setId(PK id);
}
