package com.sda.practical.repository;

import com.sda.practical.model.FoundItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoundRepository extends JpaRepository<FoundItem,Long> {
}
