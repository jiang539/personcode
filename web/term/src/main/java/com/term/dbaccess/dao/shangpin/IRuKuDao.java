package com.term.dbaccess.dao.shangpin;

import java.util.List;

import com.term.dbaccess.core.IBaseDao;
import com.term.dbaccess.core.Pagination;
import com.term.dbaccess.querybean.ShangPinQueryBean;
import com.xinxi11.web.entity.term.RuKu;

/**
 * 入库管理
 */
public interface IRuKuDao extends IBaseDao<RuKu> {

	/**
	 * 查询商品的入库量
	 * 
	 * @param shangPinId
	 *            商品id
	 * @return
	 */
	Long findSumByShangPinId(String shangPinId);

	List<RuKu> findByQueryBean(ShangPinQueryBean queryBean, Pagination page);

}
