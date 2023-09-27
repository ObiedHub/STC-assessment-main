package com.stc.stcsystemdesigntask.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AppEntityResponse<T> extends BaseResponse<T> {

	private T data;
}
