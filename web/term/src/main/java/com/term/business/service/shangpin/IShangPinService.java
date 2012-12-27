package com.term.business.service.shangpin;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.term.business.core.IBaseService;
import com.term.business.dto.ShangPinDto;

/**
 * 商品信息管理
 */
@Transactional(readOnly = true)
public interface IShangPinService extends IBaseService<ShangPinDto> {

	/**
	 * 查找所有的商品类型
	 * 
	 * @return
	 */
	List<String> findSpType();

}
