package com.term.business.service.shangpin;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.term.business.dto.KuCunDto;
import com.term.dbaccess.core.Pagination;
import com.term.dbaccess.querybean.ShangPinQueryBean;

@Transactional(readOnly = true)
public interface IKuCunService {

	List<KuCunDto> findAll(Pagination page);

	List<KuCunDto> findByQueryBean(ShangPinQueryBean queryBean, Pagination page);

}
