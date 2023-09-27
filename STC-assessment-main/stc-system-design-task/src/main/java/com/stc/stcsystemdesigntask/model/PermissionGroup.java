package com.stc.stcsystemdesigntask.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class PermissionGroup  extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String groupName;
	
	@OneToMany(mappedBy = "permissionGroup", fetch = FetchType.LAZY)
	private List<Permission> permissions;
}
