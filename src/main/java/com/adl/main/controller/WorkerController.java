package com.adl.main.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.adl.main.model.WorkerModel;
import com.adl.main.repository.ResponseDepartementWorker;
import com.adl.main.repository.WorkerRepository;

@RestController
@RequestMapping("worker")
public class WorkerController {
	
	@Autowired
	WorkerRepository workerRepo;
	
	@GetMapping("/")

	public List<WorkerModel> getIdWorker(){
	List<WorkerModel> lstWorker=workerRepo.findAll();
	return lstWorker;
	}
	
	@PostMapping("/saveAll")
	public List<WorkerModel> setManyWorker(@RequestParam List<WorkerModel> worker){
		return workerRepo.saveAll(worker);
	}
	
	@PatchMapping("/update")
	public WorkerModel updateWorkerModel(@RequestBody WorkerModel worker) {
		return workerRepo.save(worker);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteWorker(@PathVariable("id")int id) {
		workerRepo.deleteById(id);
		return "delete berhasil";
	
	}
	
	
	@GetMapping("/salarySame")
	public List<WorkerModel> getGroubBySameSalary(){
		return workerRepo.getGroubBySameSalary();
	}
	@GetMapping("/numberOfDepartement")
	public List<ResponseDepartementWorker> list(){
		
		return workerRepo.getGroubByDepartement();
	}
	
	
}
