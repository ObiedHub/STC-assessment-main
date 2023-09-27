package com.stc.stcsystemdesigntask.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.stc.stcsystemdesigntask.model.PermissionGroup;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PermissionGroupDto  {

	private Long id;
	private String groupName;
	
	private List<PermissionDto> permissions = new ArrayList<>();
	
	
	public PermissionGroupDto(PermissionGroup group) {
		this.id =group.getId();
		this.groupName = group.getGroupName();
		this.permissions = PermissionDto.mapEntitiesToDtos(group.getPermissions());
	}
	
	public static List<PermissionGroupDto> mapEntitiesToDtos(List<PermissionGroup> groups) {
		return groups.stream()
				.map(PermissionGroupDto::new).collect(Collectors.toList());
	}
	
	
	
}
