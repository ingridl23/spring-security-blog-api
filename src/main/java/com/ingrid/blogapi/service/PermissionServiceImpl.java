package com.ingrid.blogapi.service;

import com.ingrid.blogapi.dto.PermissionRequest;
import com.ingrid.blogapi.model.Permission;
import com.ingrid.blogapi.repository.IPermissionRepository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements IpermissionService{
	
	private final IPermissionRepository permissionRepository;

	@Override
	public Permission createPermission(PermissionRequest request) {
		 Permission permission = Permission.builder()
	                .name(request.getName())
	                .build();

	        return permissionRepository.save(permission);
	}

	@Override
	public List<Permission> getAllPermissions() {
		 return permissionRepository.findAll();
	}

	@Override
	public Permission getPermissionById(Long id) {
		 return permissionRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Permission not found"));
	}

	@Override
	public void deletePermission(Long id) {
		  permissionRepository.deleteById(id);
		
	}

	
	@Override
	public void updatePermission(Long id, String nuevoNombre) {
	    
	    Permission permission = permissionRepository.findById(id)
	        .orElseThrow(() -> new RuntimeException("Permission no encontrado"));

	    permission.setName(nuevoNombre);

	    permissionRepository.save(permission);
	}

  
	
}
