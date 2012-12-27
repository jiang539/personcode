package com.cxkh.demo.esdsmo.persistence;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cxkh.demo.esdsmo.beans.MeTempTespBigData;

public interface MeTempTespBigDataMapper {

	@Transactional
	void insertMeTempTespBigData(MeTempTespBigData meTempTespBigData);

	List<MeTempTespBigData> findAll();
}
