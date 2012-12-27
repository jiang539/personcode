package com.term.business.service.shangpin;

import org.springframework.transaction.annotation.Transactional;

import com.term.business.core.IBaseService;
import com.term.business.dto.CompanyDto;

/**
 * 厂商管理
 */
@Transactional(readOnly = true)
public interface ICompanyService extends IBaseService<CompanyDto> {

}
