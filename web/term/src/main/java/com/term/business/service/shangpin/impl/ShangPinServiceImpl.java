package com.term.business.service.shangpin.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.term.business.core.BaseServiceImpl;
import com.term.business.dto.CompanyDto;
import com.term.business.dto.ShangPinDto;
import com.term.business.service.shangpin.IShangPinService;
import com.term.dbaccess.dao.shangpin.IShangPinDao;
import com.xinxi11.web.entity.term.Company;
import com.xinxi11.web.entity.term.ShangPin;

@Service("shangPinService")
public class ShangPinServiceImpl extends BaseServiceImpl<ShangPinDto, ShangPin>
		implements IShangPinService {
	private IShangPinDao shangPinDao;

	@Autowired
	public void setShangPinDao(IShangPinDao shangPinDao) {
		this.shangPinDao = shangPinDao;
		this.baseHibernateDao = shangPinDao;
	}

	@Override
	protected ShangPin dtoToEntity(ShangPinDto dto) {
		ShangPin entity = super.dtoToEntity(dto);
		Company company = new Company();
		company.setId(dto.getCompanyDto().getId());
		entity.setCompany(company);
		return entity;
	}

	@Override
	protected ShangPinDto entityToDto(ShangPin entity) {
		ShangPinDto dto = super.entityToDto(entity);
		CompanyDto companyDto = new CompanyDto();
		companyDto.setId(entity.getCompany().getId());
		companyDto.setName(entity.getCompany().getName());
		dto.setCompanyDto(companyDto);
		return dto;
	}

	@Override
	public List<String> findSpType() {
		return shangPinDao.findSpType();
	}

}
