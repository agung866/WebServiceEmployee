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
import com.adl.main.repository.BonusRepository;
import com.adl.main.repository.JoiningModelWorker;
import com.adl.main.repository.WorkerRepository;


@RestController
@RequestMapping("bonus")
public class BonusController {
	@Autowired
	BonusRepository bonusRepo;
	
	@GetMapping("/")
	public List<BonusModel> getIdBonus(){
	List<BonusModel> lstbonus=bonusRepo.findAll();
	return lstbonus;
	}
	
	@GetMapping("/top")
	public List<JoiningModelWorker> getTopSalary(){
	return bonusRepo.getTopSalary();
	}
	
	@PostMapping("/saveAll")
	public List<BonusModel> setManyBonus(@RequestParam List<BonusModel> bonus){
		return bonusRepo.saveAll(bonus);
	}
	
	@PatchMapping("/update")
	public BonusModel updateBonusModel(@RequestBody BonusModel bonus) {
		return bonusRepo.save(bonus);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBonus(@PathVariable("id")int bonus) {
		bonusRepo.deleteById(bonus);
		return "delete berhasil";
	
	}
}
