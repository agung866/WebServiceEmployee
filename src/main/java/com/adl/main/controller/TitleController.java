package com.adl.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adl.main.model.BonusModel;
import com.adl.main.model.TitleModel;
import com.adl.main.repository.BonusRepository;
import com.adl.main.repository.TitleRepository;


@RestController
@RequestMapping("title")
public class TitleController {

	@Autowired
	TitleRepository titleRepo;
	
	@GetMapping("/")
	public List<TitleModel> getIdTitle(){
	List<TitleModel> lstTitle=titleRepo.findAll();
	return lstTitle;
	}
	
	@PostMapping("/saveAll")
	public List<TitleModel> setManyTitle(@RequestParam List<TitleModel> title){
		return titleRepo.saveAll(title);
	}
	
	@PatchMapping("/update")
	public TitleModel updateTitleModel(@RequestBody TitleModel title) {
		return titleRepo.save(title);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteTitle(@PathVariable("id")int id) {
		titleRepo.deleteById(id);
		return "delete berhasil";
	
	}
}
