package com.schema.backend.repository;

import com.schema.backend.entity.Crawler;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CrawlerRepository extends JpaRepository<Crawler, Long> {

}
