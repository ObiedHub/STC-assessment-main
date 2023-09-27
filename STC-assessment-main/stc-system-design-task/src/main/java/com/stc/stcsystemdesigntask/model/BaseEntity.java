package com.stc.stcsystemdesigntask.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@NoArgsConstructor
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = 4648826521531988784L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

}

