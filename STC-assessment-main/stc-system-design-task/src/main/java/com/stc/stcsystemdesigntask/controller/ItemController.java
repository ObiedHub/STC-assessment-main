package com.stc.stcsystemdesigntask.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stc.stcsystemdesigntask.dto.AppEntityResponse;
import com.stc.stcsystemdesigntask.dto.ItemDto;
import com.stc.stcsystemdesigntask.model.Item;
import com.stc.stcsystemdesigntask.service.ItemService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/item")
@RequiredArgsConstructor
public class ItemController {

	private final ItemService itemService;
	
	@PostMapping
	public ResponseEntity<AppEntityResponse<ItemDto>> save(@RequestBody Item item) {
		Item savedItem = itemService.save(item);
		ItemDto mapEntityToDto = ItemDto.mapEntityToDto(savedItem);
		return ResponseEntity.ok(new AppEntityResponse<>(mapEntityToDto));
	}
	
	@GetMapping("/file/{id}")
	public ResponseEntity<AppEntityResponse<Item>> getFileMetaData(@PathVariable Long id) {

		// get file meta data
		
		return ResponseEntity.ok(new AppEntityResponse<>(null));
	}
	
}
