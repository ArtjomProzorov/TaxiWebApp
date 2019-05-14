package com.sda.practical.repository;

import com.sda.practical.model.LostItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LostRepository extends JpaRepository<LostItem, Long> {


}
