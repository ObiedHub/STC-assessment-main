package com.stc.stcsystemdesigntask.dto;

import com.stc.stcsystemdesigntask.model.Item;
import com.stc.stcsystemdesigntask.model.enums.ItemType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ItemDto {
	private Long id;
	private String name;
	private ItemType type;
    
    
    public static ItemDto mapEntityToDto(Item item) {
    	ItemDto dto = ItemDto.builder().id(item.getId())
    			.name(item.getName())
    			.type(item.getType()).build();
    	return dto;
    }
}
