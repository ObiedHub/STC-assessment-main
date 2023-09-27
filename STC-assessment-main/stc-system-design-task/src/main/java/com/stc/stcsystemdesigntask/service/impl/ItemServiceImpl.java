package com.stc.stcsystemdesigntask.service.impl;

import java.util.Base64;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stc.stcsystemdesigntask.dao.ItemRespository;
import com.stc.stcsystemdesigntask.dao.PermissionGroupRepository;
import com.stc.stcsystemdesigntask.dao.PermissionRepository;
import com.stc.stcsystemdesigntask.exceptions.AppException;
import com.stc.stcsystemdesigntask.model.File;
import com.stc.stcsystemdesigntask.model.Item;
import com.stc.stcsystemdesigntask.model.Permission;
import com.stc.stcsystemdesigntask.model.PermissionGroup;
import com.stc.stcsystemdesigntask.model.enums.ItemType;
import com.stc.stcsystemdesigntask.model.enums.PermissionLevel;
import com.stc.stcsystemdesigntask.service.ItemService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

	
	final private ItemRespository itemRespository;
	private final PermissionGroupRepository permissionGroupRepository;
	private final FileServiceImpl fileServiceImpl;
	private final PermissionRepository permissionRepository;
	
	@Override
	public Item save(Item item) { 
		// validation
		Optional<PermissionGroup> permissionGroup = permissionGroupRepository.findById(item.getPermissionGroup().getId());
		if(!permissionGroup.isPresent()) {
			throw new AppException("Permission Group Not Found !");
		}
		item.setPermissionGroup(permissionGroup.get());
		
		ItemType type = item.getType();
		
		switch(type) {
			case SPACE:
				return saveSpaceItem(item);
			case FOLDER:
				return saveFolderItem(item);
			case FILE:
				return saveFileItem(item);
			default: 
				throw new AppException("Item Type In Valid!");
		}
		
	}

	
	private Item saveSpaceItem(Item item) { 
		item.setParentItem(null); // prevent add parent to space type
		return itemRespository.save(item);
	}
	
	private Item saveFolderItem(Item item) { 
		
//		Optional<Permission> userPermission = permissionRepository.findByUserEmailAndPermissionLevel(item.getEmail(), PermissionLevel.EDIT);
//		if (!userPermission.isPresent()) {
//			throw new AppException("you do not have a permisson to create folder");
//		}
		
		if (item.getParentItem() == null) {
			throw new AppException("Parent Item Is required To Folder Type");
		}
		
		Optional<Item> parentItem = itemRespository.findById(item.getParentItem().getId());
		if (!parentItem.isPresent()) {
			throw new AppException("Invalid Parent Item");
		}
		
		Optional<Permission> userPermission = permissionRepository.findByPermissionGroupIdAndPermissionLevel(parentItem.get().getPermissionGroup().getId(), PermissionLevel.EDIT);
		if (!userPermission.isPresent()) {
			throw new AppException("you do not have a permisson to create folder in side this space");
		}
		
		item.setParentItem(parentItem.get());

		return itemRespository.save(item);
	}
	
	
	private Item saveFileItem(Item item) { 
		
		
//		Optional<Permission> userPermission = permissionRepository.findByUserEmailAndPermissionLevel(item.getEmail(), PermissionLevel.EDIT);
//		if (!userPermission.isPresent()) {
//			throw new AppException("you do not have a permisson to create file");
//		}
		
		if (item.getParentItem() == null) {
			throw new AppException("Parent Item Is required To File Type");
		}
		
		
		Optional<Item> parentItem = itemRespository.findById(item.getParentItem().getId());
		if (!parentItem.isPresent()) {
			throw new AppException("Invalid Parent Item");
		}
		
		Optional<Permission> userPermission = permissionRepository.findByPermissionGroupIdAndPermissionLevel(parentItem.get().getPermissionGroup().getId(), PermissionLevel.EDIT);
		if (!userPermission.isPresent()) {
			throw new AppException("you do not have a permisson to create folder in side this Folder");
		}
		
		
		item.setParentItem(parentItem.get());
		
		if (item.getBase64File() == null) {
			throw new AppException("base 64 file is required to add file type");
		}
		
		 Item savedItem = itemRespository.save(item);
		 
		 File file = new File();
		 file.setBinary(Base64.getDecoder().decode(item.getBase64File()));
		 file.setItem(savedItem);
		 fileServiceImpl.save(file);
		 
		 item.setBase64File(null);
		 return item;
	}
}

