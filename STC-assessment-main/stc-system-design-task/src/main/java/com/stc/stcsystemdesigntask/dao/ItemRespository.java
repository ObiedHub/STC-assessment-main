package com.stc.stcsystemdesigntask.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stc.stcsystemdesigntask.model.Item;

public interface ItemRespository extends JpaRepository<Item, Long>  {

}
