package com.stc.stcsystemdesigntask.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.stc.stcsystemdesigntask.model.enums.ItemType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "items")
public class Item  extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private ItemType type;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private PermissionGroup permissionGroup;
	
    @ManyToOne(fetch = FetchType.LAZY)
	private Item parentItem;
    
    // to simulate save file 
    @Transient
    private String base64File;
}
