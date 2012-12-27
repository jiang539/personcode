package com.term.dbaccess.dao.shangpin;

import java.util.List;

import com.term.dbaccess.core.IBaseDao;
import com.term.dbaccess.core.Pagination;
import com.term.dbaccess.querybean.ShangPinQueryBean;
import com.xinxi11.web.entity.term.ChuKu;

/**
 * 出库管理
 * 
 * @author 李国江
 * @date 2009-5-1 下午04:16:04
 */
public interface IChuKuDao extends IBaseDao<ChuKu> {

	/**
	 * 查询商品的出库量
	 * 
	 * @param shangPinId
	 *            商品id
	 * @return
	 */
	Long findSumByShangPinId(String shangPinId);

	List<ChuKu> findByQueryBean(ShangPinQueryBean queryBean, Pagination page);
}
