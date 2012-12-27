package com.term.business.service.shangpin.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.term.business.dto.KuCunDto;
import com.term.business.service.shangpin.IKuCunService;
import com.term.dbaccess.core.Pagination;
import com.term.dbaccess.dao.shangpin.IChuKuDao;
import com.term.dbaccess.dao.shangpin.IRuKuDao;
import com.term.dbaccess.dao.shangpin.IShangPinDao;
import com.term.dbaccess.querybean.ShangPinQueryBean;
import com.xinxi11.web.entity.term.ShangPin;

@Service("kuCunService")
public class KuCunServiceImpl implements IKuCunService {
	private IShangPinDao shangPinDao;
	private IRuKuDao ruKuDao;
	private IChuKuDao chuKuDao;

	@Autowired
	public void setShangPinDao(IShangPinDao shangPinDao) {
		this.shangPinDao = shangPinDao;
	}

	@Autowired
	public void setRuKuDao(IRuKuDao ruKuDao) {
		this.ruKuDao = ruKuDao;
	}

	@Autowired
	public void setChuKuDao(IChuKuDao chuKuDao) {
		this.chuKuDao = chuKuDao;
	}

	@Override
	public List<KuCunDto> findAll(Pagination page) {
		List<ShangPin> listShangPin = shangPinDao.findAll(page);
		List<KuCunDto> listKuCunDto = new ArrayList<KuCunDto>();
		for (ShangPin sPin : listShangPin) {
			listKuCunDto.add(getKuCunDto(sPin));
		}
		return listKuCunDto;
	}

	@Override
	public List<KuCunDto> findByQueryBean(ShangPinQueryBean queryBean,
			Pagination page) {
		if (queryBean.getSpId() == null) {
			return findAll(page);
		}
		List<KuCunDto> listDto = new ArrayList<KuCunDto>();
		ShangPin shangPin = shangPinDao.findById(queryBean.getSpId());
		if (shangPin != null) {
			listDto.add(getKuCunDto(shangPin));
		}
		return listDto;
	}

	private KuCunDto getKuCunDto(ShangPin shangPin) {
		KuCunDto kuCunDto = new KuCunDto();
		kuCunDto.setSpId(shangPin.getId());
		kuCunDto.setSpName(shangPin.getName());
		kuCunDto.setRuKunAmount(ruKuDao.findSumByShangPinId(shangPin.getId()));
		kuCunDto.setChuKuAmount(chuKuDao.findSumByShangPinId(shangPin.getId()));
		return kuCunDto;
	}

}
