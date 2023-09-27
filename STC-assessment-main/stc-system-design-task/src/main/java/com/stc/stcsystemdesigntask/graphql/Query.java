package com.stc.stcsystemdesigntask.graphql;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.stc.stcsystemdesigntask.dto.FileMetaDataDto;
import com.stc.stcsystemdesigntask.service.FileService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class Query {

	
	private final FileService fileService;
	
	@QueryMapping
	public FileMetaDataDto getFileMetaData(@Argument("id") Long id) {
		return fileService.getFileMetaData(id);
	}
	
	
}
