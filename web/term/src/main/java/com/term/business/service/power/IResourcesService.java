package com.term.business.service.power;

import java.util.List;

import com.term.business.core.IBaseService;
import com.term.business.dto.ResourcesDto;

/**
 * 资源管理
 */
public interface IResourcesService extends IBaseService<ResourcesDto> {

	List<ResourcesDto> findByType(String type);

	String findByResourcesIdForString(String id);

}
