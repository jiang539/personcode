package com.term.utils;

import java.util.ArrayList;
import java.util.List;

import com.term.business.core.ListDto;

/**
 * Collection 转换
 * 
 * @author 李国江
 * @date 2009-5-6 下午05:49:27
 */
public class CollectionUtils {

	public static List<ListDto> getListDto(List<String> listObj) {
		List<ListDto> listDto = new ArrayList<ListDto>();
		for (String obj : listObj) {
			ListDto data = new ListDto();
			data.setKey(obj);
			data.setValue(obj);
			listDto.add(data);
		}
		return listDto;
	}

}
