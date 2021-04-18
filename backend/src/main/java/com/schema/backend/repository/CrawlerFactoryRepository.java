package com.schema.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

import com.schema.backend.entity.CrawlerModel;

@Repository
public interface CrawlerFactoryRepository extends JpaRepository<CrawlerModel, Long> {
    List<CrawlerModel> findAll();
}