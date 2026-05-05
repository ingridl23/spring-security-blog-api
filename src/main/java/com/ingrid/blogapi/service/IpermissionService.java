package com.ingrid.blogapi.service;

import java.util.List;

import com.ingrid.blogapi.dto.PermissionRequest;
import com.ingrid.blogapi.model.Permission;

public interface IpermissionService {
	 Permission createPermission(PermissionRequest request);

	    List<Permission> getAllPermissions();

	    Permission getPermissionById(Long id);

	    void deletePermission(Long id);
	    void updatePermission(Long id,String nombre);
}
