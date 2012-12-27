package com.cxkh.demo.esdsmo.dwr;

import java.util.List;

import com.cxkh.demo.esdsmo.beans.MeTempTespBigData;
import com.cxkh.demo.esdsmo.common.SpringContextHolder;
import com.cxkh.demo.esdsmo.service.IMeTempTespBigDataService;

public class MeTempTespBigDataDwr {

	public String newData() {
		getMeTempTespBigDataService().insertMeTempTespBigData(newEntity(1));
		getMeTempTespBigDataService().insertMeTempTespBigData(newEntity(2));
		getMeTempTespBigDataService().insertMeTempTespBigData(newEntity(3));

		return "ok";
	}

	public String findList() {
		System.out.println("--------  enter ----------");
		List<MeTempTespBigData> listEntity = getMeTempTespBigDataService()
				.findAll();
		if (listEntity == null) {
			return "no data";
		}
		return listEntity.size() + " -- 数据个数";
	}

	private IMeTempTespBigDataService getMeTempTespBigDataService() {
		return SpringContextHolder.getBean("meTempTespBigDataService");
	}

	private MeTempTespBigData newEntity(Integer id) {
		MeTempTespBigData data = new MeTempTespBigData();
		data.setId(id);
		data.setName("ttt");
		data.setC0("c0");
		data.setC1("c1");
		data.setC2("c2");
		data.setC3("c3");
		data.setC4("c4");
		data.setC5("c5");
		data.setC6("c6");
		data.setC7("c7");
		// data.setC8("c8");
		data.setC9("c9");

		return data;
	}

}
