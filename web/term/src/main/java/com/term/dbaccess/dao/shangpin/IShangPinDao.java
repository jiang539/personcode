package com.term.dbaccess.dao.shangpin;

import java.util.List;

import com.term.dbaccess.core.IBaseDao;
import com.xinxi11.web.entity.term.ShangPin;

/**
 * 商品信息管理
 */
public interface IShangPinDao extends IBaseDao<ShangPin> {

	/**
	 * 查找所有的商品类型
	 * 
	 * @return
	 */
	List<String> findSpType();

}
