package com.stc.stcsystemdesigntask.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stc.stcsystemdesigntask.dao.FileRespository;
import com.stc.stcsystemdesigntask.dao.PermissionRepository;
import com.stc.stcsystemdesigntask.dto.FileMetaDataDto;
import com.stc.stcsystemdesigntask.exceptions.AppException;
import com.stc.stcsystemdesigntask.model.File;
import com.stc.stcsystemdesigntask.model.Permission;
import com.stc.stcsystemdesigntask.model.enums.PermissionLevel;
import com.stc.stcsystemdesigntask.service.FileService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

	private final FileRespository fileRespository;

	private final PermissionRepository permissionRepository;
	
	@Override
	public File save(File file) {
		return fileRespository.save(file);
	}

	@Override
	public byte[] downloadFile(File file) {
		Optional<File> dbFile = fileRespository.findById(file.getId());
		if(!dbFile.isPresent()) {
			throw new AppException("File Not Found");
		}
		
		Long permissoinID = dbFile.get().getItem().getPermissionGroup().getId();
		Optional<Permission> userPermission = permissionRepository.findByPermissionGroupIdAndPermissionLevel(permissoinID, PermissionLevel.DOWNLOAD);
		if (!userPermission.isPresent()) {
			throw new AppException("you do not have a permisson to download this file!");
		}
		
		return dbFile.get().getBinary();
	}

	@Override
	public FileMetaDataDto getFileMetaData(Long fileId) {
		Optional<FileMetaDataDto> fileMetaData = fileRespository.getFileMetaData(fileId);
		if (!fileMetaData.isPresent()) {
			throw new AppException("File Not Found");
		}
		
		return fileMetaData.get();
	}
	
	
}
