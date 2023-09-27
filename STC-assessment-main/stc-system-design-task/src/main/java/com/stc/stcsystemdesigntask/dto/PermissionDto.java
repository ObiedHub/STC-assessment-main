package com.stc.stcsystemdesigntask.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.stc.stcsystemdesigntask.model.Permission;
import com.stc.stcsystemdesigntask.model.PermissionGroup;
import com.stc.stcsystemdesigntask.model.enums.PermissionLevel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PermissionDto  {

	
	private Long id;
	private String userEmail;
	private PermissionLevel permissionLevel;
	private PermissionGroup permissionGroup;
	
	
	public static List<PermissionDto> mapEntitiesToDtos(List<Permission> permissions) {
		return permissions.stream()
		.map(PermissionDto::new).collect(Collectors.toList());
	}


	public PermissionDto(Permission permission) {
		super();
		this.userEmail = permission.getUserEmail();
		this.permissionLevel = permission.getPermissionLevel();
		this.id = permission.getId();
	}
	
}
