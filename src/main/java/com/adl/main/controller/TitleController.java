package com.adl.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.adl.main.model.BonusModel;
import com.adl.main.model.TitleModel;
import com.adl.main.repository.BonusRepository;
import com.adl.main.repository.TitleRepository;

public class TitleController {

	@Autowired
	TitleRepository titleRepo;
	
	@GetMapping("/title")
	public List<TitleModel> getIdTitle(){
	List<TitleModel> lstTitle=titleRepo.findAll();
	return lstTitle;
	}
	
	@PostMapping("/title/saveAll")
	public List<TitleModel> setManyTitle(@RequestParam List<TitleModel> title){
		return titleRepo.saveAll(title);
	}
	
	@PatchMapping("/title/update")
	public TitleModel updateTitleModel(@RequestBody TitleModel title) {
		return titleRepo.save(title);
	}
	
	@DeleteMapping("/title/delete")
	public String deleteTitle(@RequestParam("id")int title) {
		titleRepo.deleteById(title);
		return "delete berhasil";
	
	}
}
