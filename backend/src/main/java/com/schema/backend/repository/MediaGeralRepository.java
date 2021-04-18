package com.schema.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

import com.schema.backend.entity.MediaGeralModel;

@Repository
public interface MediaGeralRepository extends JpaRepository<MediaGeralModel, Long> {
    List<MediaGeralModel> findAll();
}
