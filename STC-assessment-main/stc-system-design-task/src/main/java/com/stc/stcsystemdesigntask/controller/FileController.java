package com.stc.stcsystemdesigntask.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stc.stcsystemdesigntask.dto.AppEntityResponse;
import com.stc.stcsystemdesigntask.dto.FileMetaDataDto;
import com.stc.stcsystemdesigntask.model.File;
import com.stc.stcsystemdesigntask.model.Item;
import com.stc.stcsystemdesigntask.service.FileService;
import com.stc.stcsystemdesigntask.service.ItemService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/file")
@RequiredArgsConstructor
public class FileController {

	private final FileService fileService;
	
	@PostMapping()
	public byte[] downloadFile(@RequestBody File file) {
		return fileService.downloadFile(file);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AppEntityResponse<FileMetaDataDto>> getFileMetaData(@PathVariable Long id) {
		FileMetaDataDto fileMetaData = fileService.getFileMetaData(id);
		return  ResponseEntity.ok(new AppEntityResponse<>(fileMetaData));
	}
	
}
