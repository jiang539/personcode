package com.term.business.service.power;

import java.util.List;

import com.term.business.core.IBaseService;
import com.term.business.dto.RoleDto;

/**
 * 角色管理
 */
public interface IRoleService extends IBaseService<RoleDto> {

	List<RoleDto> findByUserIdForList(String userId);

}
