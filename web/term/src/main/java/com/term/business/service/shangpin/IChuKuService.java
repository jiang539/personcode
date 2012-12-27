package com.term.business.service.shangpin;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.term.business.core.IBaseService;
import com.term.business.dto.ChuKuDto;
import com.term.dbaccess.core.Pagination;
import com.term.dbaccess.querybean.ShangPinQueryBean;

/**
 * 出库管理
 * 
 * @author 李国江
 * @date 2009-5-1 下午04:16:04
 */
@Transactional(readOnly = true)
public interface IChuKuService extends IBaseService<ChuKuDto> {

	List<ChuKuDto> findByQueryBean(ShangPinQueryBean queryBean, Pagination page);

}
