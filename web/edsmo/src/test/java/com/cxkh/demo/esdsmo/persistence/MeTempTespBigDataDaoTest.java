package com.cxkh.demo.esdsmo.persistence;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.cxkh.demo.esdsmo.beans.MeTempTespBigData;
import com.cxkh.demo.esdsmo.common.SpringContextHolder;
import com.cxkh.demo.esdsmo.service.IMeTempTespBigDataService;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class MeTempTespBigDataDaoTest extends
		AbstractTransactionalJUnit4SpringContextTests {
	
	protected DataSource dataSource;

	@Override
	@Autowired
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
		this.dataSource = dataSource;
	}

	@Autowired
	private IMeTempTespBigDataService meTempTespBigDataService;

	@Test
	public void insertTest() {
		getMeTempTespBigDataService().insertMeTempTespBigData(newEntity(1));
		getMeTempTespBigDataService().insertMeTempTespBigData(newEntity(2));
		getMeTempTespBigDataService().insertMeTempTespBigData(newEntity(3));
	}

	@Test
	public void findAll() {
		List<MeTempTespBigData> list = meTempTespBigDataService.findAll();
		System.out.println(list.size());
	}
	
	MeTempTespBigData newEntity(Integer id){
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
	
	private IMeTempTespBigDataService getMeTempTespBigDataService() {
		return SpringContextHolder.getBean("meTempTespBigDataService");
	}
}
