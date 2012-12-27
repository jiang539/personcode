package com.cxkh.demo.esdsmo.service;

import java.util.List;

import com.cxkh.demo.esdsmo.beans.MeTempTespBigData;

public interface IMeTempTespBigDataService {

	void insertMeTempTespBigData(MeTempTespBigData meTempTespBigData);

	List<MeTempTespBigData> findAll();
}
