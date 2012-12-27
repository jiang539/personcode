package com.term.business.service.shangpin;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.term.business.core.IBaseService;
import com.term.business.dto.RuKuDto;
import com.term.dbaccess.core.Pagination;
import com.term.dbaccess.querybean.ShangPinQueryBean;

/**
 * 入库管理
 */
@Transactional(readOnly = true)
public interface IRuKuService extends IBaseService<RuKuDto> {

	List<RuKuDto> findByQueryBean(ShangPinQueryBean queryBean, Pagination page);

}
