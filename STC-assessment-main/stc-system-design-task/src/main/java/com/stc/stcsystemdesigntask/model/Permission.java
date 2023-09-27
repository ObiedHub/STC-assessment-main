package com.stc.stcsystemdesigntask.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.stc.stcsystemdesigntask.model.enums.PermissionLevel;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "permissions")
public class Permission  extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userEmail;
	
	@Enumerated(EnumType.STRING)
	private PermissionLevel permissionLevel;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private PermissionGroup permissionGroup;
	
	
}
