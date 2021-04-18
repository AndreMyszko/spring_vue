package com.schema.backend.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.schema.backend.entity.Crawler;
import com.schema.backend.entity.CrawlerModel;
import com.schema.backend.entity.MediaGeralModel;
import com.schema.backend.repository.CrawlerFactoryRepository;
import com.schema.backend.repository.CrawlerRepository;
import com.schema.backend.repository.MediaGeralRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/crawler")
@CrossOrigin
public class CrawlerDataController {

	@Autowired
	private CrawlerRepository crawlerRepository;

	@Autowired
	private CrawlerFactoryRepository crawlerFactoryRepository;

	@Autowired
	private MediaGeralRepository mediaGeralRepository;

	private List<CrawlerModel> refactoryCrawler;

	@PostMapping("/save")
	public List<CrawlerModel> save() throws ParseException{
		crawlerFactoryRepository.deleteAll();
		refactoryCrawler = refactoryCrawler(crawlerRepository.findAll());
		mediaCrawler(refactoryCrawler);
		return refactoryCrawler;
	}

	@GetMapping("/listAll")
	public List<CrawlerModel> listAll(){
		return crawlerFactoryRepository.findAll();
	}


	//LETS GET IT

	public List<CrawlerModel> refactoryCrawler(List<Crawler> list) throws ParseException{
		crawlerRepository.deleteAll();
		List<CrawlerModel> listCrawler = new ArrayList<>();
		for(int i = 0; i < list.size(); i++){
			CrawlerModel crawlerModel = new CrawlerModel();
			String confirmado100k = list.get(i).getConfirmado100k();
			if(confirmado100k.isEmpty() == false){
				String suporte = list.get(i).getConfirmado100k().replace(",", ".");
				String suporte1 = "";
				if(suporte.length() < 3){
					suporte1 = suporte;
				}
				else{
				suporte1 = suporte.substring(0, suporte.length() - 3);
				}
				suporte1 = suporte.substring(0, suporte.length() - 3);
				String suporte2 = suporte1.replace(".", "");
				String finalmente = "";
				if(suporte.length() < 3){
					finalmente = suporte;
				}
				else
				{
					finalmente = suporte2 + suporte.substring(suporte.length() - 3, suporte.length());
				}
				Float a = Float.parseFloat(finalmente);
				crawlerModel.setConfirmado100k(a);
			}else{
				crawlerModel.setLetalitade("0");
			}



			String confirmado = list.get(i).getConfirmado();
			if(confirmado.isEmpty() == false){
				String suporte = list.get(i).getConfirmado().replace(",", ".");
				String suporte1 = "";
				if(suporte.length() < 3){
					suporte1 = suporte;
				}
				else{
					suporte1 = suporte.substring(0, suporte.length() - 3);
				}
				String suporte2 = suporte1.replace(".", "");
				String finalmente = "";
				if(suporte.length() < 3){
					finalmente = suporte;
				}
				else
				{
					finalmente = suporte2 + suporte.substring(suporte.length() - 3, suporte.length());
				}
				Float a = Float.parseFloat(finalmente);
				crawlerModel.setConfirmado(a);
			}else{
				crawlerModel.setLetalitade("0");
			}

			String obito = list.get(i).getObito();
			if(obito.isEmpty() == false){
				String suporte = list.get(i).getObito().replace(",", ".");
				String suporte1 = "";
				if(suporte.length() < 3){
					suporte1 = suporte;
				}else{
				suporte1 = suporte.substring(0, suporte.length() - 3);
				}
				String suporte2 = suporte1.replace(".", "");
				String finalmente = "";
				if(suporte.length() < 3){
					finalmente = suporte;
				}
				else
				{
					finalmente = suporte2 + suporte.substring(suporte.length() - 3, suporte.length());
				}
				Float a = Float.parseFloat(finalmente);
				crawlerModel.setObito(a);
			}else{
				crawlerModel.setLetalitade("0");
			}

			String obito100k = list.get(i).getObito100k();
			if(obito100k.isEmpty() == false){
				String suporte = list.get(i).getObito100k().replace(",", ".");
				String suporte1 = "";
				if(suporte.length() < 3){
					suporte1 = suporte;
				}
				else{
					suporte1 = suporte.substring(0, suporte.length() - 3);
					}
				String suporte2 = suporte1.replace(".", "");
				String finalmente = suporte2 + suporte.substring(suporte.length() - 3, suporte.length());
				Float a = Float.parseFloat(finalmente);
				crawlerModel.setObito100k(a);
			}else{
				crawlerModel.setLetalitade("0");
			}

			String cidade = list.get(i).getCidade();
			if(cidade.isEmpty() == false){
				crawlerModel.setCidade(cidade);
			}else{
				crawlerModel.setLetalitade("0");
			}

			String letalitade = list.get(i).getLetalitade();
			if(letalitade.isEmpty() == false){
				crawlerModel.setLetalitade(list.get(i).getLetalitade());
			}else{
				crawlerModel.setLetalitade("0");
			}
			crawlerModel.setData(java.sql.Date.valueOf(LocalDate.now()));
			crawlerFactoryRepository.save(crawlerModel);
			listCrawler.add(crawlerModel);
		}
		return listCrawler;
	}

	//MEDIA GERAL
	public MediaGeralModel mediaCrawler(List<CrawlerModel> list) throws ParseException{
		Float obito100k = 0f;
		Float obito = 0f;
		Float confirmado = 0f;
		Float confirmado100k = 0f;
		MediaGeralModel mediaGeral = new MediaGeralModel();
		//SOMA
		for(int i = 0; i < list.size(); i++){
			obito100k = obito100k + list.get(i).getObito();
			obito = obito + list.get(i).getObito();
			confirmado100k = confirmado100k + list.get(i).getConfirmado100k();
			confirmado = confirmado + list.get(i).getConfirmado();
		}
		//DIVIDE PELA QUANTIDADE
		Float o100k = obito100k / list.size();
		Float o = obito / list.size();
		Float c100k = confirmado100k / list.size();
		Float c = confirmado / list.size();

		mediaGeral.setObito(o);
		mediaGeral.setObito100k(o100k);
		mediaGeral.setConfirmado(c);
		mediaGeral.setConfirmado100k(c100k);
		mediaGeral.setData(java.sql.Date.valueOf(LocalDate.now()));
		mediaGeralRepository.save(mediaGeral);
		return mediaGeral;
	}
}
