package com.ingrid.blogapi.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ingrid.blogapi.model.Permission;
@Repository

public interface IPermissionRepository extends JpaRepository<Permission, Long>{
	 Optional<Permission> findByName(String name);
}
