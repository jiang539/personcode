package com.cxkh.demo.esdsmo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cxkh.demo.esdsmo.beans.MeTempTespBigData;
import com.cxkh.demo.esdsmo.persistence.MeTempTespBigDataMapper;
import com.cxkh.demo.esdsmo.service.IMeTempTespBigDataService;

@Service("meTempTespBigDataService")
@Transactional
public class MeTempTespBigDataServiceImpl implements IMeTempTespBigDataService {
	@Autowired
	private MeTempTespBigDataMapper meTempTespBigDataMapper;

	@Transactional
	public void insertMeTempTespBigData(MeTempTespBigData meTempTespBigData) {
		meTempTespBigDataMapper.insertMeTempTespBigData(meTempTespBigData);
	}

	public List<MeTempTespBigData> findAll() {
		return meTempTespBigDataMapper.findAll();
	}

}
