package com.ingrid.blogapi.service;

import java.util.List;
import java.util.Optional;

import com.ingrid.blogapi.dto.RoleRequest;
import com.ingrid.blogapi.model.Role;

public interface IRoleService {
	 Role createRole(RoleRequest request);

	    List<Role> getAllRoles();

	    Optional<Role> getRolesById(Long id);

	    void deleteRole(Long id);
}
