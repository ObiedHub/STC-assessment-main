package com.stc.stcsystemdesigntask.service;

import com.stc.stcsystemdesigntask.dto.FileMetaDataDto;
import com.stc.stcsystemdesigntask.model.File;

public interface FileService {

	public File save(File file);

	public byte[] downloadFile(File file);
	
	
	public FileMetaDataDto getFileMetaData(Long fileId);
}
