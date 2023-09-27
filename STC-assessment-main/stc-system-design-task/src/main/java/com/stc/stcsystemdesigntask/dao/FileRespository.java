package com.stc.stcsystemdesigntask.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stc.stcsystemdesigntask.dto.FileMetaDataDto;
import com.stc.stcsystemdesigntask.model.File;

public interface FileRespository extends JpaRepository<File, Long>  {

	
    @Query(value=""
    		+ "SELECT i.TYPE AS itemType, i.name AS fileName, "
    		+ "CASE WHEN i3.name IS NULL THEN NULL ELSE i2.name end as folderName, "
    		+ "CASE WHEN i3.name IS NULL THEN i2.name ELSE i3.name END AS spaceName "
    		+ "FROM files f "
    		+ "JOIN items i ON i.id = f.item_id "
    		+ "JOIN items i2 ON i2.id = i.parent_item_id "
    		+ "LEFT JOIN items i3 ON i3.id = i2.parent_item_id "
    		+ "WHERE f.id = :fileId"
    		, nativeQuery=true)
	Optional<FileMetaDataDto> getFileMetaData(Long fileId);
}
