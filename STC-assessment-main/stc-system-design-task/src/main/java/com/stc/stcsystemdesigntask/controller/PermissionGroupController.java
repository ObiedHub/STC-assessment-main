package com.stc.stcsystemdesigntask.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stc.stcsystemdesigntask.dao.PermissionGroupRepository;
import com.stc.stcsystemdesigntask.dto.AppEntityResponse;
import com.stc.stcsystemdesigntask.dto.PermissionGroupDto;
import com.stc.stcsystemdesigntask.model.PermissionGroup;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/permission-group")
@RequiredArgsConstructor
public class PermissionGroupController {

	private final PermissionGroupRepository repo;
	
	@GetMapping
	public ResponseEntity<AppEntityResponse<List<PermissionGroupDto>>> getAllPermissionGroups() {
		List<PermissionGroup> allPermissionGroups = repo.findAll();
		return ResponseEntity.ok(new AppEntityResponse<>(PermissionGroupDto.mapEntitiesToDtos(allPermissionGroups)));
	}
	
}
