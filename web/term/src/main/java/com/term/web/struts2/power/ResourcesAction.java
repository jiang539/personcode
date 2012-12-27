package com.term.web.struts2.power;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.term.business.dto.ResourcesDto;
import com.term.business.service.power.IResourcesService;
import com.term.web.core.BaseCrudActionSupport;
import com.term.web.core.CrudActionSupport;

@Results( { @Result(name = CrudActionSupport.RELOAD, location = "/power/resources.action", type = "redirect") })
public class ResourcesAction extends BaseCrudActionSupport<ResourcesDto> {

	private IResourcesService resourcesService;

	public void setResourcesService(IResourcesService resourcesService) {
		this.resourcesService = resourcesService;
		this.baseService = resourcesService;
		entity = new ResourcesDto();
	}

}
