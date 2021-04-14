package com.schema.backend.controller;

import java.util.List;

import com.schema.backend.entity.Crawler;
import com.schema.backend.repository.CrawlerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crawler")
@CrossOrigin
public class CrawlerDataController {

	@Autowired
	private CrawlerRepository crawlerRepository;

	@GetMapping("/listAll")
	public List<Crawler> listAll(){
		return crawlerRepository.findAll();
	}
}
