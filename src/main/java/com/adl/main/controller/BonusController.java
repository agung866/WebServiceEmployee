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
import com.adl.main.repository.BonusRepository;
import com.adl.main.repository.WorkerRepository;

public class BonusController {
	@Autowired
	BonusRepository bonusRepo;
	
	@GetMapping("/bonus")
	public List<BonusModel> getIdBonus(){
	List<BonusModel> lstbonus=bonusRepo.findAll();
	return lstbonus;
	}
	
	@PostMapping("/bonus/saveAll")
	public List<BonusModel> setManyBonus(@RequestParam List<BonusModel> bonus){
		return bonusRepo.saveAll(bonus);
	}
	
	@PatchMapping("/bonus/update")
	public BonusModel updateBonusModel(@RequestBody BonusModel bonus) {
		return bonusRepo.save(bonus);
	}
	
	@DeleteMapping("/bonus/delete")
	public String deleteBonus(@RequestParam("id")int bonus) {
		bonusRepo.deleteById(bonus);
		return "delete berhasil";
	
	}
}
