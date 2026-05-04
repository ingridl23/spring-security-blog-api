package com.ingrid.blogapi.service;

import java.util.List;
import java.util.Optional;
import com.ingrid.blogapi.dto.RoleRequest;
import com.ingrid.blogapi.model.Role;
import com.ingrid.blogapi.repository.IRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor

public class RoleServiceImpl  implements IRoleService{

	private final IRoleRepository roleRepository ;
	@Override
	public Role createRole(RoleRequest request) {
		 Role rol = Role.builder()
	                .name(request.getRolename())
	                .build();
	   
	        return roleRepository.save(rol);
	}

	@Override
	public List<Role> getAllRoles() {
	return roleRepository.findAll();
	}

	@Override
	public Optional<Role> getRolesById(Long id) {
		return roleRepository.findById(id);
	}

	@Override
	public void deleteRole(Long id) {
	 roleRepository.deleteById(id);
		
	}

}
