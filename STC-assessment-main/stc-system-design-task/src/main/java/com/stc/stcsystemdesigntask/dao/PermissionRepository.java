package com.stc.stcsystemdesigntask.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stc.stcsystemdesigntask.model.Permission;
import com.stc.stcsystemdesigntask.model.enums.PermissionLevel;

public interface PermissionRepository extends JpaRepository<Permission, Long> {

	public Optional<Permission> findByUserEmailAndPermissionLevel(String userEmail, PermissionLevel permissionLevel);
	

	public Optional<Permission> findByPermissionGroupIdAndPermissionLevel(Long permissionGroupId, PermissionLevel permissionLevel);

}
