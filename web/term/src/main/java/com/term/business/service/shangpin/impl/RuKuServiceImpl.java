package com.term.business.service.shangpin.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.term.business.core.BaseServiceImpl;
import com.term.business.dto.RuKuDto;
import com.term.business.dto.ShangPinDto;
import com.term.business.dto.UserDto;
import com.term.business.service.shangpin.IRuKuService;
import com.term.dbaccess.core.Pagination;
import com.term.dbaccess.dao.shangpin.IRuKuDao;
import com.term.dbaccess.querybean.ShangPinQueryBean;
import com.xinxi11.web.entity.qx.User;
import com.xinxi11.web.entity.term.RuKu;
import com.xinxi11.web.entity.term.ShangPin;

@Service("ruKuService")
public class RuKuServiceImpl extends BaseServiceImpl<RuKuDto, RuKu> implements
		IRuKuService {
	private IRuKuDao ruKuDao;

	@Autowired
	public void setRuKuDao(IRuKuDao ruKuDao) {
		this.ruKuDao = ruKuDao;
		this.baseHibernateDao = ruKuDao;
	}

	@Override
	protected RuKu dtoToEntity(RuKuDto dto) {
		RuKu ruKu = super.dtoToEntity(dto);
		User user = new User();
		user.setId(dto.getUserDto().getId());
		ruKu.setUser(user);
		ShangPin shangPin = new ShangPin();
		shangPin.setId(dto.getShangPinDto().getId());
		ruKu.setShangPin(shangPin);
		return ruKu;
	}

	@Override
	protected RuKuDto entityToDto(RuKu entity) {
		RuKuDto ruKuDto = super.entityToDto(entity);

		UserDto userDto = new UserDto();
		userDto.setId(entity.getUser().getId());
		userDto.setName(entity.getUser().getName());
		ruKuDto.setUserDto(userDto);

		ShangPinDto shangPinDto = new ShangPinDto();
		shangPinDto.setId(entity.getShangPin().getId());
		shangPinDto.setName(entity.getShangPin().getName());
		ruKuDto.setShangPinDto(shangPinDto);

		return ruKuDto;
	}

	@Override
	public List<RuKuDto> findByQueryBean(ShangPinQueryBean queryBean,
			Pagination page) {
		List<RuKu> listEntity = ruKuDao.findByQueryBean(queryBean, page);
		return listEntityToDto(listEntity);
	}

}
