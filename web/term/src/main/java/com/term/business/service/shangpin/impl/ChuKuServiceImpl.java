package com.term.business.service.shangpin.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.term.business.core.BaseServiceImpl;
import com.term.business.dto.ChuKuDto;
import com.term.business.dto.ShangPinDto;
import com.term.business.dto.UserDto;
import com.term.business.service.shangpin.IChuKuService;
import com.term.dbaccess.core.Pagination;
import com.term.dbaccess.dao.shangpin.IChuKuDao;
import com.term.dbaccess.querybean.ShangPinQueryBean;
import com.xinxi11.web.entity.qx.User;
import com.xinxi11.web.entity.term.ChuKu;
import com.xinxi11.web.entity.term.ShangPin;

@Service("chuKuService")
public class ChuKuServiceImpl extends BaseServiceImpl<ChuKuDto, ChuKu>
		implements IChuKuService {

	private IChuKuDao chuKuDao;

	@Autowired
	public void setChuKuDao(IChuKuDao chuKuDao) {
		this.chuKuDao = chuKuDao;
		this.baseHibernateDao = chuKuDao;
	}

	@Override
	protected ChuKu dtoToEntity(ChuKuDto dto) {
		ChuKu chuKu = super.dtoToEntity(dto);

		User user = new User();
		user.setId(dto.getUserDto().getId());
		chuKu.setUser(user);

		ShangPin shangPin = new ShangPin();
		shangPin.setId(dto.getShangPinDto().getId());
		chuKu.setShangPin(shangPin);

		return chuKu;
	}

	@Override
	protected ChuKuDto entityToDto(ChuKu entity) {
		ChuKuDto chuDto = super.entityToDto(entity);

		UserDto userDto = new UserDto();
		userDto.setId(entity.getUser().getId());
		userDto.setName(entity.getUser().getName());
		chuDto.setUserDto(userDto);

		ShangPinDto shangPinDto = new ShangPinDto();
		shangPinDto.setId(entity.getShangPin().getId());
		shangPinDto.setName(entity.getShangPin().getName());
		chuDto.setShangPinDto(shangPinDto);

		return chuDto;
	}

	@Override
	public List<ChuKuDto> findByQueryBean(ShangPinQueryBean queryBean,
			Pagination page) {
		List<ChuKu> listEntity = chuKuDao.findByQueryBean(queryBean, page);
		return listEntityToDto(listEntity);
	}

}
